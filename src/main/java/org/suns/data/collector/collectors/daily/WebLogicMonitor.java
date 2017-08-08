package org.suns.data.collector.collectors.daily;

import org.suns.data.collector.config.WebLogicConnectorConfig;
import org.suns.data.collector.connector.WebLogicConnector;
import org.suns.database.utils.model.DailyAppInspectionModel;
import org.suns.host.config.AppCluster;
import org.suns.host.config.WebLogicServerConfig;
import org.suns.inspection.logger.InspectionLogger;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.HashMap;

public class WebLogicMonitor {
    private static MBeanServerConnection connection;

    public static void monitorWebLogicServer(WebLogicServerConfig webLogicServer
            , ArrayList<DailyAppInspectionModel> dailyAppModels) throws Exception {
        if (webLogicServer == null || dailyAppModels == null) {
            throw new Exception("Uninitialized Arguments");
        }

        initConnection(webLogicServer);
        ObjectName[] serverRTs = WebLogicConnector.getServerRuntimes();

        ArrayList<AppCluster> clusters = webLogicServer.getClusters();

        for (AppCluster cluster : clusters) {
            DailyAppInspectionModel dailyAppModel = new DailyAppInspectionModel();
            dailyAppModel.setName(cluster.getName());
            ArrayList<String> servers = cluster.getServers();

            System.out.println("Monitoring Cluster "
                    + cluster.getName() + " Svr State");
            inspectSvrState(serverRTs, servers, dailyAppModel);

            System.out.println("Monitoring Cluster "
                    + cluster.getName() + " Hogging Thread Count");
            inspectHoggingThreadCnt(serverRTs, servers, dailyAppModel);

            System.out.println("Monitoring Cluster "
                    + cluster.getName() + " JDBC State");
            inspectClusterJDBCState(serverRTs, servers, dailyAppModel);

            System.out.println("Monitoring Cluster "
                    + cluster.getName() + " JDBC Current Connection Count");
            inspectClusterJDBCCnt(serverRTs, servers, dailyAppModel);

            InspectionLogger.debug(dailyAppModel.toString());
            dailyAppModels.add(dailyAppModel);
        }


        WebLogicConnector.closeConnector();
    }

    private static void initConnection(WebLogicServerConfig webLogicServer) throws Exception{
        String user = webLogicServer.getUser();
        String password = webLogicServer.getPassword();
        int port = webLogicServer.getPort();
        String ip = webLogicServer.getIp();

        InspectionLogger.debug("Connecting to WebLogic Server " + ip
                + ":" + port  + " , " + user + " , " + password );
        connection = WebLogicConnector.initConnection(ip, port, user, password);
    }

    private static void inspectClusterJDBCCnt(ObjectName[] serverRTs
            , ArrayList<String> servers
            , DailyAppInspectionModel dailyAppModel) throws Exception{
        HashMap<String, ObjectName> serverJDBCMap = getServerJDBCMap(serverRTs);

        Float totalConnectionCnt = 0f;
        int cntServer = 0;

        for(String server : servers){
            CntJDBCConnection cntJDBCConnection = inspectServerJDBCCnt(server
                    , serverJDBCMap);

            totalConnectionCnt = totalConnectionCnt
                    + cntJDBCConnection.totalConnection;
            cntServer = cntServer + cntJDBCConnection.cntServers;
        }

        if(cntServer == 0){
            dailyAppModel.setDataSourceConnectionCount(0f);
        }else{
            dailyAppModel.setDataSourceConnectionCount(totalConnectionCnt/cntServer);
        }
    }

    private static CntJDBCConnection inspectServerJDBCCnt(String server
            , HashMap<String, ObjectName> serverJDBCMap) throws Exception{
        CntJDBCConnection cntJDBCConnection = new CntJDBCConnection();

        if(serverJDBCMap.containsKey(server)){
            ObjectName jdbcSR = serverJDBCMap.get(server);

            ObjectName[] jdbcDSRM = (ObjectName[])connection.getAttribute(
                    jdbcSR, "JDBCDataSourceRuntimeMBeans");

            int jdbcDRMLength = jdbcDSRM.length;
            for (int i = 0; i < jdbcDRMLength; i++) {
                String cntConnection = (String)connection.getAttribute(jdbcDSRM[i], "ActiveConnectionsCurrentCount");
                cntJDBCConnection.cntServers++;
                cntJDBCConnection.totalConnection = cntJDBCConnection.totalConnection
                        + Integer.valueOf(cntConnection);
            }
        }

        return cntJDBCConnection;
    }

    private static void inspectClusterJDBCState(ObjectName[] serverRTs
            , ArrayList<String> servers
            , DailyAppInspectionModel dailyAppModel) throws Exception{
        HashMap<String, ObjectName> serverJDBCMap = getServerJDBCMap(serverRTs);
        for(String server : servers){
            if(!inspectServerJDBCState(server, serverJDBCMap)){
                dailyAppModel.setDataSourceState(0);
                return;
            }
        }

        dailyAppModel.setDataSourceState(1);
    }

    private static boolean inspectServerJDBCState(String server
            , HashMap<String, ObjectName> serverJDBCMap) throws Exception{

        if(serverJDBCMap.containsKey(server)){
            ObjectName jdbcSR = serverJDBCMap.get(server);

            ObjectName[] jdbcDSRM = (ObjectName[])connection.getAttribute(
                    jdbcSR, "JDBCDataSourceRuntimeMBeans");

            int jdbcDRMLength = jdbcDSRM.length;
            for (int i = 0; i < jdbcDRMLength; i++) {
                String jdbcState = (String)connection.getAttribute(jdbcDSRM[i], "State");

                if(!jdbcState.equals(WebLogicConnectorConfig.getJdbcRunningState())){
                    return false;
                }
            }
        }

        return true;
    }

    private static HashMap<String, ObjectName> getServerJDBCMap(ObjectName[] serverRTs) throws Exception{
        HashMap<String, ObjectName> serverJDBCMap = new HashMap<>();

        int length = serverRTs.length;
        for (int i = 0; i < length; i++) {
            ObjectName jdbcSR = (ObjectName) connection.getAttribute(
                    serverRTs[i], "JDBCServiceRuntime");
            String name = (String) connection.getAttribute(serverRTs[i],
                    "Name");

            serverJDBCMap.put(name, jdbcSR);
        }
        return serverJDBCMap;
    }

    private static void inspectSvrState(ObjectName[] serverRTs
            , ArrayList<String> servers
            , DailyAppInspectionModel dailyAppModel) throws Exception{

        HashMap<String, String> nameStateMap = getNameStateMap(serverRTs);
        for(String server: servers) {
            if (!nameStateMap.containsKey(server)
                    || !nameStateMap.get(server).equals(WebLogicConnectorConfig.getServerRunningState())) {
                dailyAppModel.setSvrState(0);
                return;
            }
        }
        dailyAppModel.setSvrState(1);
    }

    private static HashMap<String, String> getNameStateMap(ObjectName[] serverRTs) throws Exception{
        HashMap<String, String> nameStateMap = new HashMap<>();

        int length = serverRTs.length;
        for (int i = 0; i < length; i++) {
            String name = (String) connection.getAttribute(serverRTs[i],
                    "Name");
            String state = (String) connection.getAttribute(serverRTs[i],
                    "State");
            nameStateMap.put(name, state);
        }
        return nameStateMap;
    }

    private static void inspectHoggingThreadCnt(ObjectName[] serverRTs
            , ArrayList<String> servers
            , DailyAppInspectionModel dailyAppModel) throws Exception{

        Float hoggingThreadCnt = 0f;
        int cntServer = 0;

        HashMap<String, Integer> nameHoggingCntMap = getNameHoggingThreadCntMap(serverRTs);
        for(String server: servers) {
            if(nameHoggingCntMap.containsKey(server)){
                hoggingThreadCnt = hoggingThreadCnt + nameHoggingCntMap.get(server);
                cntServer++;
            }
        }

        if(cntServer == 0){
            dailyAppModel.setHoggingCount(0f);
        }else{
            dailyAppModel.setHoggingCount(hoggingThreadCnt/cntServer);
        }
    }

    private static HashMap<String, Integer> getNameHoggingThreadCntMap(ObjectName[] serverRTs) throws Exception{
        HashMap<String, Integer> nameCntMap = new HashMap<>();

        int length = serverRTs.length;
        for (int i = 0; i < length; i++) {
            ObjectName tpRT = (ObjectName) connection.getAttribute(
                    serverRTs[i], "ThreadPoolRuntime");
            String name = (String) connection.getAttribute(serverRTs[i],
                    "Name");
            String strHoggingCnt = (String)connection.getAttribute(tpRT
                    , "HoggingThreadCount");

            nameCntMap.put(name, Integer.valueOf(strHoggingCnt));
        }

        return nameCntMap;
    }

    private static class CntJDBCConnection{
        public int cntServers;
        public int totalConnection;

        public CntJDBCConnection() {
            this.cntServers = 0;
            this.totalConnection = 0;
        }
    }
}
