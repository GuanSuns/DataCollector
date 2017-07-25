package org.suns.data.collector.collectors.sheet429;

import org.suns.data.collector.config.sheet429.Sheet429CoreConfig;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.controller.Sheet429Controller;
import org.suns.database.utils.model.Sheet429CoreModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429CoreCollector {

    public static void inspect() throws Exception{
        Sheet429CoreModel sheet429Model = new Sheet429CoreModel();

        inspect1(sheet429Model);
        inspect2(sheet429Model);
        inspect3(sheet429Model);

        sheet429Model.setInspectTime(new Timestamp(new Date().getTime()));

        if(!Sheet429Controller.addCore(sheet429Model)){
            throw new Exception("Fail to add Sheet 429 Core model to database");
        }
    }

    private static void inspect1(Sheet429CoreModel sheet429Model) throws Exception{
        final String[] inspectedHosts = Sheet429CoreConfig.getInspectedHosts1();
        final String[] users = Sheet429CoreConfig.getUsers1();
        final String[] passwords = Sheet429CoreConfig.getPasswords1();
        final int[] ports = Sheet429CoreConfig.getPorts1();
        final String[] sid = Sheet429CoreConfig.getSid1();

        for(int i=0; i<inspectedHosts.length; i++){
            String strResult = inspectHost(users[i]
                    , passwords[i]
                    , inspectedHosts[i]
                    , ports[i]
                    , sid[i]);

            sheet429Model.setHeartBeat1(strResult);
        }
    }

    private static void inspect2(Sheet429CoreModel sheet429Model) throws Exception{
        final String[] inspectedHosts = Sheet429CoreConfig.getInspectedHosts2();
        final String[] users = Sheet429CoreConfig.getUsers2();
        final String[] passwords = Sheet429CoreConfig.getPasswords2();
        final int[] ports = Sheet429CoreConfig.getPorts2();
        final String[] sid = Sheet429CoreConfig.getSid2();

        for(int i=0; i<inspectedHosts.length; i++){
            String strResult = inspectHost(users[i]
                    , passwords[i]
                    , inspectedHosts[i]
                    , ports[i]
                    , sid[i]);

            sheet429Model.setHeartBeat2(strResult);
        }
    }

    private static void inspect3(Sheet429CoreModel sheet429Model) throws Exception{
        final String[] inspectedHosts = Sheet429CoreConfig.getInspectedHosts3();
        final String[] users = Sheet429CoreConfig.getUsers3();
        final String[] passwords = Sheet429CoreConfig.getPasswords3();
        final int[] ports = Sheet429CoreConfig.getPorts3();
        final String[] sid = Sheet429CoreConfig.getSid3();

        for(int i=0; i<inspectedHosts.length; i++){
            String strResult = inspectHost(users[i]
                    , passwords[i]
                    , inspectedHosts[i]
                    , ports[i]
                    , sid[i]);

            sheet429Model.setHeartBeat3(strResult);
        }
    }

    private static String inspectHost(String user
            , String password, String host
            , int port, String sid) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet429CoreConfig.getInspectSQL());

        final String[] fieldNames = Sheet429CoreConfig.getFieldNames();
        String strResult = "";
        while (resultSet.next()){
            String instID = resultSet.getString(fieldNames[0]);
            String btime = resultSet.getString(fieldNames[1]);
            String intSize = resultSet.getString(fieldNames[2]);
            String metricName = resultSet.getString(fieldNames[3]);
            String val = resultSet.getString(fieldNames[4]);
            String minVal = resultSet.getString(fieldNames[5]);
            String maxVal = resultSet.getString(fieldNames[6]);
            String avg = resultSet.getString(fieldNames[7]);
            String std = resultSet.getString(fieldNames[8]);
            String sumSquare = resultSet.getString(fieldNames[9]);

            strResult = strResult + " " + instID + " " + btime
                    + " " + intSize + " " + metricName + " " + val
                    + " " + minVal + " " + maxVal + " " + avg
                    + " " + std + " " +sumSquare + "\n";
        }

        OracleConnector.closeConnection();

        return strResult;
    }
    
}
