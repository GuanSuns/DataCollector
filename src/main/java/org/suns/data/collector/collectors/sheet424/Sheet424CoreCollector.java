package org.suns.data.collector.collectors.sheet424;

import org.suns.data.collector.config.sheet424.Sheet424CoreConfig;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.controller.Sheet424Controller;
import org.suns.database.utils.model.Sheet424CoreModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424CoreCollector {

    public static void inspect() throws Exception{
        Sheet424CoreModel sheet424Model = new Sheet424CoreModel();
        inspect2(sheet424Model);
        inspect3(sheet424Model);
        inspect4(sheet424Model);
        sheet424Model.setDate((new Timestamp(new Date().getTime())));

        if(!Sheet424Controller.addCore(sheet424Model)){
            throw new Exception("Fail to add Sheet 424 Core model to database");
        }

    }

    private static void inspect2(Sheet424CoreModel sheet424Model) throws Exception{
        final String[] inspectedHosts = Sheet424CoreConfig.getInspectedHosts2();

        for(String host : inspectedHosts){
            inspectHost2(Sheet424CoreConfig.getUser()
                    , Sheet424CoreConfig.getPassword()
                    , host
                    , Sheet424CoreConfig.getPort()
                    , Sheet424CoreConfig.getSid()
                    , sheet424Model);
        }
    }

    private static void inspect3(Sheet424CoreModel sheet424Model) throws Exception{
        final String[] inspectedHosts = Sheet424CoreConfig.getInspectedHosts3();

        for(String host : inspectedHosts){
            inspectHost3(Sheet424CoreConfig.getUser()
                    , Sheet424CoreConfig.getPassword()
                    , host
                    , Sheet424CoreConfig.getPort()
                    , Sheet424CoreConfig.getSid()
                    , sheet424Model);
        }
    }

    private static void inspect4(Sheet424CoreModel sheet424Model) throws Exception{
        final String[] inspectedHosts = Sheet424CoreConfig.getInspectedHosts4();

        for(String host : inspectedHosts){
            inspectHost4(Sheet424CoreConfig.getUser()
                    , Sheet424CoreConfig.getPassword()
                    , host
                    , Sheet424CoreConfig.getPort()
                    , Sheet424CoreConfig.getSid()
                    , sheet424Model);
        }
    }

    private static void inspectHost2(String user
            , String password, String host
            , int port, String sid
            , Sheet424CoreModel sheet424Model) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet424CoreConfig.getInspectTimeSQL());

        final String[] fieldNames = Sheet424CoreConfig.getFieldNamesTime();
        while (resultSet.next()){
            Timestamp lastTime = resultSet.getTimestamp(fieldNames[0]);
            sheet424Model.setInspectTime2(lastTime);
        }

        Statement statementTemp = connection.createStatement();
        ResultSet resultSetTemp = statementTemp.executeQuery(Sheet424CoreConfig.getTempStatSQL());

        final String[] fieldNamesTemp = Sheet424CoreConfig.getFieldNamesStat();
        while (resultSetTemp.next()){
            String strStat = resultSetTemp.getString(fieldNamesTemp[0]);
            sheet424Model.setStatus2(strStat);
        }

        OracleConnector.closeConnection();
    }

    private static void inspectHost3(String user
            , String password, String host
            , int port, String sid
            , Sheet424CoreModel sheet424Model) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet424CoreConfig.getInspectTimeSQL());

        final String[] fieldNames = Sheet424CoreConfig.getFieldNamesTime();
        while (resultSet.next()){
            Timestamp lastTime = resultSet.getTimestamp(fieldNames[0]);
            sheet424Model.setInspectTime3(lastTime);
        }

        Statement statementTemp = connection.createStatement();
        ResultSet resultSetTemp = statementTemp.executeQuery(Sheet424CoreConfig.getTempStatSQL());

        final String[] fieldNamesTemp = Sheet424CoreConfig.getFieldNamesStat();
        while (resultSetTemp.next()){
            String strStat = resultSetTemp.getString(fieldNamesTemp[0]);
            sheet424Model.setStatus3(strStat);
        }

        OracleConnector.closeConnection();
    }

    private static void inspectHost4(String user
            , String password, String host
            , int port, String sid
            , Sheet424CoreModel sheet424Model) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet424CoreConfig.getInspectTimeSQL());

        final String[] fieldNames = Sheet424CoreConfig.getFieldNamesTime();
        while (resultSet.next()){
            Timestamp lastTime = resultSet.getTimestamp(fieldNames[0]);
            sheet424Model.setInspectTime4(lastTime);
        }

        Statement statementTemp = connection.createStatement();
        ResultSet resultSetTemp = statementTemp.executeQuery(Sheet424CoreConfig.getTempStatSQL());

        final String[] fieldNamesTemp = Sheet424CoreConfig.getFieldNamesStat();
        while (resultSetTemp.next()){
            String strStat = resultSetTemp.getString(fieldNamesTemp[0]);
            sheet424Model.setStatus4(strStat);
        }

        OracleConnector.closeConnection();
    }
    
}
