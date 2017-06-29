package org.suns.connector;

import com.jcraft.jsch.*;
import org.suns.config.HostConnectorConfig;

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

    public static void connect(String user, String password, String host, int port) throws JSchException {

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
        session.connect();
    }

    public static void disconnect(){
        if(session != null && session.isConnected()){
            session.disconnect();
            session = null;
        }
    }

    public static String executeCommand(String command){
        BufferedReader reader = null;
        Channel channel = null;
        StringBuffer stringBuffer = new StringBuffer();

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
            e.printStackTrace();
        } finally {
            try{
                if(reader!=null){
                    reader.close();
                }
            }catch (Exception eReader){
                eReader.printStackTrace();
            }

            if(channel != null){
                channel.disconnect();
            }
        }

        return stringBuffer.toString();
    }
}
