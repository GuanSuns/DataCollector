package org.suns.data.collector.collectors.sheet428;

import org.suns.data.collector.collectors.sheet429.Sheet429PersonalCollector;
import org.suns.data.collector.config.sheet428.Sheet428CoreConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.controller.Sheet428Controller;
import org.suns.database.utils.model.Sheet428CoreModel;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.suns.data.collector.collectors.sheet428.Sheet428PersonalCollector.getTimeFromHost;

/**
 * Created by guanl on 7/1/2017.
 */
public class Sheet428CoreCollector {
    public static void inspect() throws Exception{
        Sheet428CoreModel sheet428Model = new Sheet428CoreModel();

        String strTime = getTimeFromHost(Sheet428CoreConfig.getTimeServer()
                , Sheet428CoreConfig.getPortsTimeServer()[0]
                , Sheet428CoreConfig.getUsersTimeServer()[0]
                , Sheet428CoreConfig.getPasswordsTimeServer()[0]);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        Date hostTime = df.parse(strTime);

        long timeServerDiff = Math.abs(currentTime.getTime() - hostTime.getTime());

        inspect1(sheet428Model, timeServerDiff);
        inspect2(sheet428Model, timeServerDiff);
        inspect34(sheet428Model, timeServerDiff);
        sheet428Model.setStatus5("");
        sheet428Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet428Controller.addCore(sheet428Model)){
            throw new Exception("Fail to add Sheet 428 Core model to database");
        }
    }

    private static void inspect1(Sheet428CoreModel sheet428
            , long timeServerDiff) throws Exception{
        final String[] hosts = Sheet428CoreConfig.getInspectedHosts1();
        final String[] users = Sheet428CoreConfig.getUsers1();
        final String[] passwords = Sheet428CoreConfig.getPasswords1();
        final int[] ports = Sheet428CoreConfig.getPorts1();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = "";
        for(int i=0; i<hosts.length; i++){
            String strTime = getTimeFromHost(hosts[i], ports[i]
                    , users[i], passwords[i]);

            Date currentTime = new Date();
            Date hostTime = df.parse(strTime);

            long diff = Math.abs(currentTime.getTime() - hostTime.getTime());
            long diffWithTimeServer = Math.abs(timeServerDiff - diff);
            long diffMinute = (diffWithTimeServer/1000)/60;

            if(diffWithTimeServer > Sheet428CoreConfig.getDiffTolerance()){
                result = result + hosts[i] + " 与时间服务器相差 "
                        + diffMinute + "分钟\n";
            }
        }

        if(result.equals("")){
            result = Sheet428CoreConfig.getCorrectReport();
        }

        sheet428.setStatus1(result);
    }

    private static void inspect2(Sheet428CoreModel sheet428
            , long timeServerDiff) throws Exception{
        final String[] hosts = Sheet428CoreConfig.getInspectedHosts2();
        final String[] users = Sheet428CoreConfig.getUsers2();
        final String[] passwords = Sheet428CoreConfig.getPasswords2();
        final int[] ports = Sheet428CoreConfig.getPorts2();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = "";
        for(int i=0; i<hosts.length; i++){
            String strTime = getTimeFromHost(hosts[i], ports[i]
                    , users[i], passwords[i]);

            Date currentTime = new Date();
            Date hostTime = df.parse(strTime);

            long diff = Math.abs(currentTime.getTime() - hostTime.getTime());
            long diffWithTimeServer = Math.abs(timeServerDiff - diff);
            long diffMinute = (diffWithTimeServer/1000)/60;

            if(diffWithTimeServer > Sheet428CoreConfig.getDiffTolerance()){
                result = result + hosts[i] + " 与时间服务器相差 "
                        + diffMinute + "分钟\n";
            }
        }

        if(result.equals("")){
            result = Sheet428CoreConfig.getCorrectReport();
        }

        sheet428.setStatus2(result);
    }

    private static void inspect34(Sheet428CoreModel sheet428
            , long timeServerDiff) throws Exception{
        final String[] hosts = Sheet428CoreConfig.getInspectedHosts34();
        final String[] users = Sheet428CoreConfig.getUsers34();
        final String[] passwords = Sheet428CoreConfig.getPasswords34();
        final int[] ports = Sheet428CoreConfig.getPorts34();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = "";
        for(int i=0; i<hosts.length; i++){
            String strTime = getTimeFromHost(hosts[i], ports[i]
                    , users[i], passwords[i]);

            Date currentTime = new Date();
            Date hostTime = df.parse(strTime);

            long diff = Math.abs(currentTime.getTime() - hostTime.getTime());
            long diffWithTimeServer = Math.abs(timeServerDiff - diff);
            long diffMinute = (diffWithTimeServer/1000)/60;

            if(diffWithTimeServer > Sheet428CoreConfig.getDiffTolerance()){
                result = result + hosts[i]
                        + " 与时间服务器相差 " + diffMinute + "分钟\n";
            }
        }

        if(result.equals("")){
            result = Sheet428CoreConfig.getCorrectReport();
        }

        sheet428.setStatus3(result);
        sheet428.setStatus4(result);
    }
}
