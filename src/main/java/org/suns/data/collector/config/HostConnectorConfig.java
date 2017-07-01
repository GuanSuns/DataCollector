package org.suns.data.collector.config;

/**
 * Created by guanl on 6/28/2017.
 */
public class HostConnectorConfig {
    private static int sessionTimeout = 1500;

    public static int getSessionTimeout() {
        return sessionTimeout;
    }

    public static void setSessionTimeout(int sessionTimeout) {
        HostConnectorConfig.sessionTimeout = sessionTimeout;
    }
}
