package org.suns.collector.sheet429;

import org.suns.config.sheet429.Sheet429CoreConfig;
import org.suns.connector.OracleConnector;
import org.suns.controller.Sheet429Controller;
import org.suns.model.Sheet429CoreModel;

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
        inspect2(sheet429Model);

        sheet429Model.setInspectTime(new Timestamp(new Date().getTime()));

        if(!Sheet429Controller.addCore(sheet429Model)){
            throw new Exception("Fail to add Sheet 429 Core model to database");
        }
    }

    private static void inspect1(Sheet429CoreModel sheet429Model) throws Exception{
        final String[] inspectedHosts = Sheet429CoreConfig.getInspectedHosts1();

        for(String host : inspectedHosts){
            String strResult = inspectHost(Sheet429CoreConfig.getUser()
                    , Sheet429CoreConfig.getPassword()
                    , host
                    , Sheet429CoreConfig.getPort()
                    , Sheet429CoreConfig.getSid());

            sheet429Model.setHeartBeat1(strResult);
        }
    }

    private static void inspect2(Sheet429CoreModel sheet429Model) throws Exception{
        final String[] inspectedHosts = Sheet429CoreConfig.getInspectedHosts2();

        for(String host : inspectedHosts){
            String strResult = inspectHost(Sheet429CoreConfig.getUser()
                    , Sheet429CoreConfig.getPassword()
                    , host
                    , Sheet429CoreConfig.getPort()
                    , Sheet429CoreConfig.getSid());

            sheet429Model.setHeartBeat2(strResult);
        }
    }

    private static void inspect3(Sheet429CoreModel sheet429Model) throws Exception{
        final String[] inspectedHosts = Sheet429CoreConfig.getInspectedHosts3();

        for(String host : inspectedHosts){
            String strResult = inspectHost(Sheet429CoreConfig.getUser()
                    , Sheet429CoreConfig.getPassword()
                    , host
                    , Sheet429CoreConfig.getPort()
                    , Sheet429CoreConfig.getSid());

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

            strResult = strResult + instID + btime
                    + intSize + metricName + val
                    + minVal + maxVal + avg
                    + std +sumSquare + "\n";
        }

        OracleConnector.closeConnection();

        return strResult;
    }
    
}
