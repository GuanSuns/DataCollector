package org.suns.data.collector.collectors.sheet428;

import org.suns.data.collector.config.sheet428.Sheet428PersonalConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.controller.Sheet428Controller;
import org.suns.database.utils.model.Sheet428PersonalModel;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by guanl on 7/1/2017.
 */
public class Sheet428PersonalCollector {
    public static void inspect() throws Exception{
        Sheet428PersonalModel sheet428Model = new Sheet428PersonalModel();
        inspect1(sheet428Model);
        inspect2(sheet428Model);
        inspect3(sheet428Model);
        inspect4(sheet428Model);
        sheet428Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet428Controller.addPersonal(sheet428Model)){
            throw new Exception("Fail to add Sheet 428 personal model to database");
        }
    }

    private static void inspect1(Sheet428PersonalModel sheet428) throws Exception{
        final String[] hosts = Sheet428PersonalConfig.getInspectedHosts1();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = "";
        for(String host: hosts){
            String strTime = getTimeFromHost(host
                    , Sheet428PersonalConfig.getPort()
                    , Sheet428PersonalConfig.getUser()
                    , Sheet428PersonalConfig.getPassword());

            Date currentTime = new Date();
            Date hostTime = df.parse(strTime);

            long diff = Math.abs(currentTime.getTime() - hostTime.getTime());
            long diffMinute = (diff/1000)/60;

            System.out.println(diff);

            if(diff > Sheet428PersonalConfig.getDiffTolerance()){
                result = result + host + " 与时间服务器相差 " + diffMinute + "分钟\n";
            }
        }

        if(result.equals("")){
            result = Sheet428PersonalConfig.getCorrectReport();
        }

        sheet428.setStatus1(result);
    }

    private static void inspect2(Sheet428PersonalModel sheet428) throws Exception{
        final String[] hosts = Sheet428PersonalConfig.getInspectedHosts2();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = "";
        for(String host: hosts){
            String strTime = getTimeFromHost(host
                    , Sheet428PersonalConfig.getPort()
                    , Sheet428PersonalConfig.getUser()
                    , Sheet428PersonalConfig.getPassword());

            Date currentTime = new Date();
            Date hostTime = df.parse(strTime);

            long diff = Math.abs(currentTime.getTime() - hostTime.getTime());
            long diffMinute = (diff/1000)/60;

            if(diff > Sheet428PersonalConfig.getDiffTolerance()){
                result = result + host + " 与时间服务器相差 " + diffMinute + "分钟\n";
            }
        }

        if(result.equals("")){
            result = Sheet428PersonalConfig.getCorrectReport();
        }

        sheet428.setStatus2(result);
    }

    private static void inspect3(Sheet428PersonalModel sheet428) throws Exception{
        final String[] hosts = Sheet428PersonalConfig.getInspectedHosts3();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = "";
        for(String host: hosts){
            String strTime = getTimeFromHost(host
                    , Sheet428PersonalConfig.getPort()
                    , Sheet428PersonalConfig.getUser()
                    , Sheet428PersonalConfig.getPassword());

            Date currentTime = new Date();
            Date hostTime = df.parse(strTime);

            long diff = Math.abs(currentTime.getTime() - hostTime.getTime());
            long diffMinute = (diff/1000)/60;

            if(diff > Sheet428PersonalConfig.getDiffTolerance()){
                result = result + host + " 与时间服务器相差 " + diffMinute + "分钟\n";
            }
        }

        if(result.equals("")){
            result = Sheet428PersonalConfig.getCorrectReport();
        }

        sheet428.setStatus3(result);
    }

    private static void inspect4(Sheet428PersonalModel sheet428) throws Exception{
        final String[] hosts = Sheet428PersonalConfig.getInspectedHosts4();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = "";
        for(String host: hosts){
            String strTime = getTimeFromHost(host
                    , Sheet428PersonalConfig.getPort()
                    , Sheet428PersonalConfig.getUser()
                    , Sheet428PersonalConfig.getPassword());

            Date currentTime = new Date();
            Date hostTime = df.parse(strTime);

            long diff = Math.abs(currentTime.getTime() - hostTime.getTime());
            long diffMinute = (diff/1000)/60;

            if(diff > Sheet428PersonalConfig.getDiffTolerance()){
                result = result + host + " 与时间服务器相差 " + diffMinute + "分钟\n";
            }
        }

        if(result.equals("")){
            result = Sheet428PersonalConfig.getCorrectReport();
        }

        sheet428.setStatus4(result);
    }

    public static String getTimeFromHost(String host, int port
            , String user, String password) throws Exception{

        HostConnector.connect(user
                , password
                , host, port);

        final String queryCmd = Sheet428PersonalConfig.getTimeCmd();
        String strTime = HostConnector.executeCommand(queryCmd);

        HostConnector.disconnect();

        return strTime;
    }
}
