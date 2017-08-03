package org.suns.data.collector.connector;

import com.jcraft.jsch.*;
import org.suns.data.collector.config.HostConnectorConfig;
import org.suns.inspection.logger.InspectionLogger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

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
}
