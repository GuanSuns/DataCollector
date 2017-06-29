package org.suns.config;

/**
 * Created by guanl on 6/29/2017.
 */
public class OracleConnectorConfig {
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@";

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        OracleConnectorConfig.url = url;
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        OracleConnectorConfig.driver = driver;
    }
}
