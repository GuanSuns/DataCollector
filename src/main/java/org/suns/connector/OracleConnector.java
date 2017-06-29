package org.suns.connector;

import org.suns.config.OracleConnectorConfig;

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
        Class.forName(OracleConnectorConfig.getDriver());

        String dbURL = OracleConnectorConfig.getUrl()
                + host + ":"
                + port + ":"
                + sid;
        connection = DriverManager.getConnection(dbURL
                , user, password);
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
