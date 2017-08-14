package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.config.WebLogicConnectorConfig;
import org.suns.data.collector.connector.WebLogicConnector;
import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.model.DailyAppInspectionModel;
import org.suns.host.config.AppCluster;
import org.suns.host.config.WebLogicServer;
import org.suns.inspection.logger.InspectionLogger;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.HashMap;

public class WebLogicMonitor {
    private static MBeanServerConnection connection;
    private static ObjectName[] serverRTs;
    private static HashMap<String, ObjectName> serverJDBCMap;
    private static HashMap<String, String> nameStateMap;
    private static HashMap<String, Integer> nameHoggingCntMap;

    public static void monitorWebLogicServer(WebLogicServer webLogicServer
            , ArrayList<DailyAppInspectionModel> dailyAppModels) throws Exception {
        if (webLogicServer == null || dailyAppModels == null) {
            throw new Exception("Uninitialized Arguments");
        }

        initConnection(webLogicServer);
        serverRTs = WebLogicConnector.getServerRuntimes();
        serverJDBCMap = getServerJDBCMap();
        nameStateMap = getNameStateMap();
        nameHoggingCntMap = getNameHoggingThreadCntMap();

        ArrayList<AppCluster> clusters = webLogicServer.getClusters();

        for (AppCluster cluster : clusters) {
            DailyAppInspectionModel dailyAppModel = new DailyAppInspectionModel();
            dailyAppModel.setName(cluster.getName());

            ArrayList<String> servers = cluster.getServers();

            System.out.println("\n- - - - 集群 \'"
                    + cluster.getName() + "\' Svr State 检查");
            inspectSvrState(servers, dailyAppModel);

            System.out.println("- - - - 集群 \'"
                    + cluster.getName() + "\' Hogging线程平均计数检查");
            inspectHoggingThreadCnt(servers, dailyAppModel);

            System.out.println("- - - - 集群 \'"
                    + cluster.getName() + "\' JDBC运行State检查");
            inspectClusterJDBCState(servers, dailyAppModel);

            System.out.println("- - - - 集群 \'"
                    + cluster.getName() + "\' JDBC数据源活动连接计数检查");
            inspectClusterJDBCCnt(servers, dailyAppModel);

            InspectionLogger.debug(dailyAppModel.toString());
            dailyAppModels.add(dailyAppModel);
        }


        WebLogicConnector.closeConnector();
        serverRTs = null;
        serverJDBCMap = null;
        nameStateMap = null;
        nameHoggingCntMap = null;
    }

    private static void initConnection(WebLogicServer webLogicServer) throws Exception{
        String user = webLogicServer.getUser();
        String password = webLogicServer.getPassword();
        int port = webLogicServer.getPort();
        String ip = webLogicServer.getIp();

        InspectionLogger.info("Connecting to WebLogic Server " + ip
                + ":" + port  + " , " + user + " , " + password );
        connection = WebLogicConnector.initConnection(ip, port, user, password);
    }

    private static void inspectClusterJDBCCnt(ArrayList<String> servers
            , DailyAppInspectionModel dailyAppModel) throws Exception{

        Float totalConnectionCnt = 0f;
        int cntServer = 0;

        for(String server : servers){
            CntJDBCConnection cntJDBCConnection = inspectServerJDBCCnt(server);

            totalConnectionCnt = totalConnectionCnt
                    + cntJDBCConnection.totalConnection;
            cntServer = cntServer + cntJDBCConnection.cntServers;
        }

        if(cntServer == 0){
            dailyAppModel.setDataSourceConnectionCount((float)DBConfig.getDefaultNumericNullValue());
        }else{
            dailyAppModel.setDataSourceConnectionCount(totalConnectionCnt/cntServer);
        }
    }

    private static CntJDBCConnection inspectServerJDBCCnt(String server) throws Exception{
        CntJDBCConnection cntJDBCConnection = new CntJDBCConnection();

        if(serverJDBCMap.containsKey(server)){
            ObjectName jdbcSR = serverJDBCMap.get(server);

            ObjectName[] jdbcDSRM = (ObjectName[])connection.getAttribute(
                    jdbcSR, "JDBCDataSourceRuntimeMBeans");

            int jdbcDRMLength = jdbcDSRM.length;
            for (int i = 0; i < jdbcDRMLength; i++) {
                Integer cntConnection = (Integer)connection.getAttribute(jdbcDSRM[i], "ActiveConnectionsCurrentCount");
                cntJDBCConnection.cntServers++;
                cntJDBCConnection.totalConnection = cntJDBCConnection.totalConnection
                        + cntConnection;
            }
        }

        return cntJDBCConnection;
    }

    private static void inspectClusterJDBCState(ArrayList<String> servers
            , DailyAppInspectionModel dailyAppModel) throws Exception{

        for(String server : servers){
            if(!inspectServerJDBCState(server)){
                dailyAppModel.setDataSourceState(0);
                return;
            }
        }

        dailyAppModel.setDataSourceState(1);
    }

    private static boolean inspectServerJDBCState(String server) throws Exception{

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
            return true;
        }

        return true;
    }

    private static HashMap<String, ObjectName> getServerJDBCMap() throws Exception{
        HashMap<String, ObjectName> mServerJDBCMap = new HashMap<>();

        int length = serverRTs.length;
        for (int i = 0; i < length; i++) {
            ObjectName jdbcSR = (ObjectName) connection.getAttribute(
                    serverRTs[i], "JDBCServiceRuntime");
            String name = (String) connection.getAttribute(serverRTs[i],
                    "Name");

            mServerJDBCMap.put(name, jdbcSR);
        }
        return mServerJDBCMap;
    }

    private static void inspectSvrState(ArrayList<String> servers
            , DailyAppInspectionModel dailyAppModel) throws Exception{

        for(String server: servers) {
            if (!nameStateMap.containsKey(server)
                    || !nameStateMap.get(server).equals(WebLogicConnectorConfig.getServerRunningState())) {
                dailyAppModel.setSvrState(0);
                return;
            }
        }
        dailyAppModel.setSvrState(1);
    }

    private static HashMap<String, String> getNameStateMap() throws Exception{
        HashMap<String, String> mNameStateMap = new HashMap<>();

        int length = serverRTs.length;
        for (int i = 0; i < length; i++) {
            String name = (String) connection.getAttribute(serverRTs[i],
                    "Name");
            String state = (String) connection.getAttribute(serverRTs[i],
                    "State");
            mNameStateMap.put(name, state);
        }
        return mNameStateMap;
    }

    private static void inspectHoggingThreadCnt(ArrayList<String> servers
            , DailyAppInspectionModel dailyAppModel) throws Exception{

        Float hoggingThreadCnt = 0f;
        int cntServer = 0;

        for(String server: servers) {
            if(nameHoggingCntMap.containsKey(server)){
                hoggingThreadCnt = hoggingThreadCnt + nameHoggingCntMap.get(server);
                cntServer++;
            }
        }

        if(cntServer == 0){
            dailyAppModel.setHoggingCount((float)DBConfig.getDefaultNumericNullValue());
        }else{
            dailyAppModel.setHoggingCount(hoggingThreadCnt/cntServer);
        }
    }

    private static HashMap<String, Integer> getNameHoggingThreadCntMap() throws Exception{
        HashMap<String, Integer> nameCntMap = new HashMap<>();

        int length = serverRTs.length;
        for (int i = 0; i < length; i++) {
            ObjectName tpRT = (ObjectName) connection.getAttribute(
                    serverRTs[i], "ThreadPoolRuntime");
            String name = (String) connection.getAttribute(serverRTs[i],
                    "Name");
            Integer hoggingCnt = (Integer)connection.getAttribute(tpRT
                    , "HoggingThreadCount");

            nameCntMap.put(name, hoggingCnt);
        }

        return nameCntMap;
    }

    private static class CntJDBCConnection{
        int cntServers;
        int totalConnection;

        CntJDBCConnection() {
            this.cntServers = 0;
            this.totalConnection = 0;
        }
    }
}
