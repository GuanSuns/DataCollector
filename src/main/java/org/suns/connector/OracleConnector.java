package org.suns.connector;

import org.suns.config.OracleConnectorConfig;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by guanl on 6/29/2017.
 */
public class OracleConnector {

    private static Connection connection = null;

    private static void initConnection(String user
            , String password, String host
            , int port, String sid) throws Exception{

        Driver driver = (Driver)Class.forName(OracleConnectorConfig.getDriver()).newInstance();

        String dbURL = OracleConnectorConfig.getUrl()
                + host + ":"
                + port + ":"
                + sid;

        Properties props = new Properties();
        props.put("user", user);
        props.put("password", password);

        System.out.println(dbURL);
        System.out.println("user: " + user + ", password: " + password);

        connection = driver.connect(dbURL, props);
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
