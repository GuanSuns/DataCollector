package org.suns.data.collector.connector;

import com.jcraft.jsch.*;
import org.suns.data.collector.config.HostConnectorConfig;
import org.suns.inspection.logger.InspectionLogger;

import java.io.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by guanl on 6/28/2017.
 */
public class HostConnector {
    private static JSch jsch;
    private static Session session;

    public static void connect(String user, String password, String host, int port) throws Exception {

        if(session != null && session.isConnected()){
            session.disconnect();
        }

        jsch = new JSch();
        session = jsch.getSession(user, host, port);
        session.setPassword(password);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(HostConnectorConfig.getSessionTimeout());

        InspectionLogger.debug("Connecting to " + host + ":"
                + port + "  user: " + user
                + " ,password: " + password );

        try{
            session.connect();
        }catch (Exception e){
            throw new Exception("Fail to connect to host " + host + ":"
                    + port + "  user: " + user
                    + " ,password: " + password
                    + "  -  " + e.toString());
        }

    }

    public static void disconnect(){
        if(session != null && session.isConnected()){
            session.disconnect();
            session = null;
        }
    }

    public static String executeCommand(String command) throws Exception{
        BufferedReader reader = null;
        Channel channel = null;
        StringBuffer stringBuffer = new StringBuffer();
        String errorInfo = "";

        try {
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            channel.connect();

            InputStream in = channel.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));

            String buf;
            while ((buf = reader.readLine()) != null) {
                stringBuffer.append(buf);
                stringBuffer.append('\n');
            }

        }catch (Exception e){
            errorInfo = "Host connector failing in executing " + command;
        } finally {
            try{
                if(reader!=null){
                    reader.close();
                }
            }catch (Exception eReader){
                errorInfo = errorInfo + " - Host connector failing in closing reader";
            }

            if(channel != null){
                channel.disconnect();
            }
        }

        if(!errorInfo.equals("")){
            throw new Exception(errorInfo);
        }

        return stringBuffer.toString();
    }

    public static String executeSuCommand(String command, String rootPassword) throws Exception{
        BufferedReader reader = null;
        ChannelShell  channel = null;
        String errorInfo = "";
        String result = "";

        try {
            channel = (ChannelShell) session.openChannel("shell");
            channel.connect();

            OutputStream out = channel.getOutputStream();
            InputStream in = channel.getInputStream();

            String suCMD = "su -u\n";
            out.write(suCMD.getBytes());
            out.flush();

            String suResult = getInputStreamResult(in);

            int waitSuCnt = 0;
            while(!suResult.contains("Password") && waitSuCnt < 90){
                Thread.sleep(1000);
                suResult = getInputStreamResult(in);
                waitSuCnt++;
            }

            String password = rootPassword + "\n";
            out.write(password.getBytes());
            out.flush();

            String executedCmd = command + ";exit;\n";
            out.write(executedCmd.getBytes());
            out.flush();

            result = getInputStreamResult(in);
            String rex = "\\d+(\\.\\d+)?%";
            Pattern pattern = Pattern.compile(rex);
            Matcher matcher = pattern.matcher(result);
            int cntSleep = 0;
            while(!matcher.find() && cntSleep < 90){

                InspectionLogger.debug("Waiting for script result: " + result);

                Thread.sleep(1000);
                result = getInputStreamResult(in);
                matcher = pattern.matcher(result);
                cntSleep++;
            }

            InspectionLogger.debug(result);
            out.close();

        }catch (Exception e){
            errorInfo = "Host connector failing in executing " + command;
        } finally {
            try{
                if(reader!=null){
                    reader.close();
                }
            }catch (Exception eReader){
                errorInfo = errorInfo + " - Host connector failing in closing reader";
            }

            if(channel != null){
                channel.disconnect();
            }
        }

        if(!errorInfo.equals("")){
            throw new Exception(errorInfo);
        }

        String rex = "\\d+(\\.\\d+)?%";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(result);

        if(!matcher.find()){
            return "";
        }else{
            return matcher.group();
        }
    }

    private static String getInputStreamResult(InputStream in) throws Exception{
        if (in.available() > 0) {
            byte[] data = new byte[in.available()];
            int nLen = in.read(data);

            if (nLen < 0) {
                throw new Exception("network error.");
            }

            String temp = new String(data, 0, nLen);
            return temp;
        }else {
            return "";
        }
    }
}
