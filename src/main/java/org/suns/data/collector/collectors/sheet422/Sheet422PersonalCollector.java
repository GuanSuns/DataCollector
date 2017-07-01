package org.suns.data.collector.collectors.sheet422;

import org.suns.data.collector.config.sheet422.Sheet422PersonalConfig;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.controller.Sheet422Controller;
import org.suns.database.utils.model.Sheet422PersonalModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422PersonalCollector {
    
    public static void inspect() throws Exception{
        ArrayList<Sheet422PersonalModel> sheet422Models = new ArrayList<>();
        inspect2(sheet422Models);

        for(Sheet422PersonalModel sheet422Model : sheet422Models){
            if(!Sheet422Controller.addPersonal(sheet422Model)){
                throw new Exception("Fail to add Sheet 422 personal model to database");
            }
        }
    }

    private static void inspect2(ArrayList<Sheet422PersonalModel> sheet422Models) throws Exception{
        final String[] inspectedHosts = Sheet422PersonalConfig.getInspectedHosts();

        for(String host : inspectedHosts){
            inspectHost2(Sheet422PersonalConfig.getUser()
                    , Sheet422PersonalConfig.getPassword()
                    , host
                    , Sheet422PersonalConfig.getPort()
                    , Sheet422PersonalConfig.getSid()
                    , sheet422Models);
        }
    }

    private static void inspectHost2(String user
            , String password, String host
            , int port, String sid
            , ArrayList<Sheet422PersonalModel> sheet422Models) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet422PersonalConfig.getInspectSQL());

        final String[] fieldNames = Sheet422PersonalConfig.getFieldNames();
        while (resultSet.next()){
            String tsName = resultSet.getString(fieldNames[0]);
            Float totalSpace = resultSet.getFloat(fieldNames[1]);
            Float usedSpace = resultSet.getFloat(fieldNames[2]);
            Float usage = resultSet.getFloat(fieldNames[3]);

            Sheet422PersonalModel sheet422PersonalModel = new Sheet422PersonalModel();
            sheet422PersonalModel.setTsName2(tsName);
            sheet422PersonalModel.setTsUsedSpace2(usedSpace);
            sheet422PersonalModel.setTsUsage2(usage);
            sheet422PersonalModel.setTsTotalSpace2(totalSpace);
            sheet422PersonalModel.setDate((new Timestamp(new Date().getTime())));

            sheet422Models.add(sheet422PersonalModel);
        }

        OracleConnector.closeConnection();
    }
}
