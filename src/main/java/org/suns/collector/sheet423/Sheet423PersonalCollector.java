package org.suns.collector.sheet423;

import org.suns.config.sheet423.Sheet423PersonalConfig;
import org.suns.connector.OracleConnector;
import org.suns.controller.Sheet423Controller;
import org.suns.model.Sheet423PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423PersonalCollector {

    public static void inspect() throws Exception{
        ArrayList<Sheet423PersonalModel> sheet423Models = new ArrayList<>();
        doInspect(sheet423Models);

        for(Sheet423PersonalModel sheet423Model : sheet423Models){
            if(!Sheet423Controller.addPersonal(sheet423Model)){
                throw new Exception("Fail to add Sheet 423 personal model to database");
            }
        }
    }

    private static void doInspect(ArrayList<Sheet423PersonalModel> sheet423Models) throws Exception{
        final String[] inspectedHosts = Sheet423PersonalConfig.getInspectedHosts();

        for(String host : inspectedHosts){
            inspectHost(Sheet423PersonalConfig.getUser()
                    , Sheet423PersonalConfig.getPassword()
                    , host
                    , Sheet423PersonalConfig.getPort()
                    , Sheet423PersonalConfig.getSid()
                    , sheet423Models);
        }
    }

    private static void inspectHost(String user
            , String password, String host
            , int port, String sid
            , ArrayList<Sheet423PersonalModel> sheet423Models) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet423PersonalConfig.getInspectSQL());

        final String[] fieldNames = Sheet423PersonalConfig.getFieldNames();
        while (resultSet.next()){
            String asmName = resultSet.getString(fieldNames[0]);
            Integer totalSpace = resultSet.getInt(fieldNames[1]);
            Integer remainSpace = resultSet.getInt(fieldNames[2]);
            Float usage = resultSet.getFloat(fieldNames[3]);

            Sheet423PersonalModel sheet423PersonalModel = new Sheet423PersonalModel();
            sheet423PersonalModel.setAsmName2(asmName);
            sheet423PersonalModel.setTotalSpace2(totalSpace);
            sheet423PersonalModel.setRemainSpace2(remainSpace);
            sheet423PersonalModel.setUsage2(usage);
            sheet423PersonalModel.setDate((new Timestamp(new Date().getTime())));

            sheet423Models.add(sheet423PersonalModel);
        }

        OracleConnector.closeConnection();
    }
}
