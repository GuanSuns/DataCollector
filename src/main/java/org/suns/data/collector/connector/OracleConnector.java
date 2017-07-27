package org.suns.data.collector.connector;

import org.suns.data.collector.config.OracleConnectorConfig;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by guanl on 6/29/2017.
 */
public class OracleConnector {

    private static Connection connection = null;

    private static void initConnection(String user
            , String password, String host
            , int port, String sid) throws Exception{

        String dbURL = OracleConnectorConfig.getUrl()
                + host + ":"
                + port + ":"
                + sid;

        try{
            Class.forName(OracleConnectorConfig.getDriver());
            connection = DriverManager.getConnection(dbURL
                    , user, password);
        }catch (Exception e){
            throw new Exception("Fail to connect to Database"
                    + dbURL + "; " + e.toString());
        }

    }

    public static Connection getConnection(String user
            , String password, String host
            , int port, String sid) throws Exception{
        if(connection == null){
            initConnection(user, password, host, port, sid);
        }
        return connection;
    }

    public static void closeConnection() throws Exception{
        if(connection != null){
            connection.close();
            connection = null;
        }
    }

}
