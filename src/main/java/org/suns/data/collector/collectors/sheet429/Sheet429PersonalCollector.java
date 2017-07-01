package org.suns.data.collector.collectors.sheet429;

import org.suns.data.collector.config.sheet429.Sheet429PersonalConfig;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.controller.Sheet429Controller;
import org.suns.database.utils.model.Sheet429PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */

public class Sheet429PersonalCollector {
    public static void inspect() throws Exception{
        Sheet429PersonalModel sheet429Model = new Sheet429PersonalModel();
        doInspect(sheet429Model);

        sheet429Model.setInspectTime(new Timestamp(new Date().getTime()));

        if(!Sheet429Controller.addPersonal(sheet429Model)){
                throw new Exception("Fail to add Sheet 429 personal model to database");
        }
    }

    private static void doInspect(Sheet429PersonalModel sheet429Model) throws Exception{
        final String[] inspectedHosts = Sheet429PersonalConfig.getInspectedHosts();

        for(String host : inspectedHosts){
            inspectHost(Sheet429PersonalConfig.getUser()
                    , Sheet429PersonalConfig.getPassword()
                    , host
                    , Sheet429PersonalConfig.getPort()
                    , Sheet429PersonalConfig.getSid()
                    , sheet429Model);
        }
    }

    private static void inspectHost(String user
            , String password, String host
            , int port, String sid
            , Sheet429PersonalModel sheet429Model) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet429PersonalConfig.getInspectSQL());

        final String[] fieldNames = Sheet429PersonalConfig.getFieldNames();
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

        sheet429Model.setHeartBeat1(strResult);

        OracleConnector.closeConnection();
    }
}
