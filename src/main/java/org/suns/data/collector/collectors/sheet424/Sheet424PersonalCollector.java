package org.suns.data.collector.collectors.sheet424;

import org.suns.data.collector.config.sheet424.Sheet424PersonalConfig;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.controller.Sheet424Controller;
import org.suns.database.utils.model.Sheet424PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424PersonalCollector {

    public static void inspect() throws Exception{
        Sheet424PersonalModel sheet424Model = new Sheet424PersonalModel();
        doInspect(sheet424Model);
        sheet424Model.setDate((new Timestamp(new Date().getTime())));

        if(!Sheet424Controller.addPersonal(sheet424Model)){
            throw new Exception("Fail to add Sheet 424 personal model to database");
        }

    }

    private static void doInspect(Sheet424PersonalModel sheet424Model) throws Exception{
        final String[] inspectedHosts = Sheet424PersonalConfig.getInspectedHosts();
        final String[] users = Sheet424PersonalConfig.getUsers();
        final String[] passwords = Sheet424PersonalConfig.getPasswords();
        final int[] ports = Sheet424PersonalConfig.getPorts();
        final String[] sid = Sheet424PersonalConfig.getSid();

        for(int i=0; i<inspectedHosts.length; i++){
            inspectHost(users[i], passwords[i], inspectedHosts[i]
                    , ports[i], sid[i], sheet424Model);
        }
    }

    private static void inspectHost(String user
            , String password, String host
            , int port, String sid
            , Sheet424PersonalModel sheet424Model) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet424PersonalConfig.getInspectTimeSQL());

        final String[] fieldNames = Sheet424PersonalConfig.getFieldNamesTime();
        while (resultSet.next()){
            Timestamp lastTime = resultSet.getTimestamp(fieldNames[0]);
            sheet424Model.setInspectTime2(lastTime);
        }

        Statement statementTemp = connection.createStatement();
        ResultSet resultSetTemp = statementTemp.executeQuery(Sheet424PersonalConfig.getTempStatSQL());

        final String[] fieldNamesTemp = Sheet424PersonalConfig.getFieldNamesStat();
        while (resultSetTemp.next()){
            String strStat = resultSetTemp.getString(fieldNamesTemp[0]);
            sheet424Model.setStatus2(strStat);
        }

        OracleConnector.closeConnection();
    }
}
