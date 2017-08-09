package org.suns.data.collector.config;

public class WebLogicConnectorConfig {
    private static String serviceObjectName = "com.bea:Name=DomainRuntimeService" +
            ",Type=weblogic.management" +
            ".mbeanservers.domainruntime" +
            ".DomainRuntimeServiceMBean";

    private static String protocol = "t3";
    private static String jndiRoot = "/jndi/";
    private static String mServer = "weblogic.management.mbeanservers.domainruntime";

    private static String protocolProviderPackage = "weblogic.management.remote";

    private static String serverRunningState = "RUNNING";
    private static String jdbcRunningState = "Running";

    public static String getJdbcRunningState() {
        return jdbcRunningState;
    }

    public static void setJdbcRunningState(String jdbcRunningState) {
        WebLogicConnectorConfig.jdbcRunningState = jdbcRunningState;
    }

    public static String getServerRunningState() {
        return serverRunningState;
    }

    public static void setServerRunningState(String serverRunningState) {
        WebLogicConnectorConfig.serverRunningState = serverRunningState;
    }

    public static String getProtocolProviderPackage() {
        return protocolProviderPackage;
    }

    public static void setProtocolProviderPackage(String protocolProviderPackage) {
        WebLogicConnectorConfig.protocolProviderPackage = protocolProviderPackage;
    }

    public static String getServiceObjectName() {
        return serviceObjectName;
    }

    public static void setServiceObjectName(String serviceObjectName) {
        WebLogicConnectorConfig.serviceObjectName = serviceObjectName;
    }

    public static String getProtocol() {
        return protocol;
    }

    public static void setProtocol(String protocol) {
        WebLogicConnectorConfig.protocol = protocol;
    }

    public static String getJndiRoot() {
        return jndiRoot;
    }

    public static void setJndiRoot(String jndiRoot) {
        WebLogicConnectorConfig.jndiRoot = jndiRoot;
    }

    public static String getmServer() {
        return mServer;
    }

    public static void setmServer(String mServer) {
        WebLogicConnectorConfig.mServer = mServer;
    }
}
