package org.suns.data.collector.collectors.daily;

import org.suns.data.collector.connector.WebLogicConnector;
import org.suns.database.utils.config.DailyAppInspectionConfig;
import org.suns.database.utils.model.DailyAppInspectionModel;
import org.suns.host.config.AppCluster;
import org.suns.host.config.WebLogicServerConfig;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import java.util.ArrayList;
import java.util.HashMap;

import static org.suns.data.collector.connector.WebLogicConnector.getServerRuntimes;

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

        }


        WebLogicConnector.closeConnector();
    }

    private static void initConnection(WebLogicServerConfig webLogicServer) throws Exception{
        String user = webLogicServer.getUser();
        String password = webLogicServer.getPassword();
        int port = webLogicServer.getPort();
        String ip = webLogicServer.getIp();

        connection = WebLogicConnector.initConnection(ip, port, user, password);
    }

    private static void inspectSvrState(ObjectName[] serverRTs
            , ArrayList<String> servers
            , DailyAppInspectionModel dailyAppModel) throws Exception{


    }

    private static HashMap<String, String> getNameStateMap(ObjectName[] serverRTs) throws Exception{
        return null;
    }
}
