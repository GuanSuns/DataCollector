package org.suns.data.collector.collectors.daily.app;

import org.suns.data.collector.collectors.daily.monitor.UsageCPUMonitor;
import org.suns.data.collector.collectors.daily.monitor.UsageMemoryMonitor;
import org.suns.data.collector.collectors.daily.monitor.UsageSoftwareDirectoryMonitor;
import org.suns.data.collector.collectors.daily.monitor.WebLogicMonitor;
import org.suns.database.utils.model.DailyAppInspectionModel;
import org.suns.host.config.AppCluster;
import org.suns.host.config.AppHost;
import org.suns.host.config.WebLogicServer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public abstract class AbstractDailyAppCollector {

    protected abstract ArrayList<WebLogicServer> getWebLogicServers();
    protected abstract void saveToDB(DailyAppInspectionModel dailyAppInspectionModel) throws Exception;
    protected ArrayList<WebLogicServer> webLogicServers;
    protected HashMap<String, ArrayList<AppHost>> clusterHostsMap;

    public void inspect() throws Exception{
        webLogicServers = getWebLogicServers();

        for(WebLogicServer webLogicServer: webLogicServers){
            initClusterHostsMap(webLogicServer);
            ArrayList<DailyAppInspectionModel> dailyAppModels = new ArrayList<>();

            inspectWebLogicServer(webLogicServer, dailyAppModels);
            inspectCPU(dailyAppModels);
            inspectMemory(dailyAppModels);
            inspectSoftwareDirectoryUsage(dailyAppModels);

            for(DailyAppInspectionModel appModel : dailyAppModels){
                appModel.setInspectTime(new Timestamp(new Date().getTime()));
                saveToDB(appModel);
            }
        }
    }

    protected void inspectWebLogicServer(WebLogicServer webLogicServer
            , ArrayList<DailyAppInspectionModel> dailyAppModels) throws Exception{
        WebLogicMonitor.monitorWebLogicServer(webLogicServer, dailyAppModels);
    }

    protected void inspectMemory(ArrayList<DailyAppInspectionModel> dailyAppModels) throws Exception{
        for(DailyAppInspectionModel dailyAppModel : dailyAppModels){
            String clusterName = dailyAppModel.getName();

            if(!clusterHostsMap.containsKey(clusterName)){
                throw new Exception("Memory Monitor: Unexpected cluster name \'" + clusterName + '\'');
            }
            ArrayList<AppHost> hosts = clusterHostsMap.get(clusterName);
            Float avgMemoryUsage = UsageMemoryMonitor.monitorMemoryUsage(hosts);
            dailyAppModel.setUsageMemory(avgMemoryUsage);
        }
    }

    protected void inspectSoftwareDirectoryUsage(ArrayList<DailyAppInspectionModel> dailyAppModels) throws Exception{
        for(DailyAppInspectionModel dailyAppModel : dailyAppModels){
            String clusterName = dailyAppModel.getName();

            if(!clusterHostsMap.containsKey(clusterName)){
                throw new Exception("Software Directory Monitor: Unexpected cluster name \'" + clusterName + '\'');
            }
            ArrayList<AppHost> hosts = clusterHostsMap.get(clusterName);
            Float avgSoftwareUsage = UsageSoftwareDirectoryMonitor.monitorSoftwareDirectoryUsage(hosts);
            dailyAppModel.setFileSysUsage(avgSoftwareUsage);
        }
    }

    protected void inspectCPU(ArrayList<DailyAppInspectionModel> dailyAppModels) throws Exception{
        for(DailyAppInspectionModel dailyAppModel : dailyAppModels){
            String clusterName = dailyAppModel.getName();

            if(!clusterHostsMap.containsKey(clusterName)){
                throw new Exception("CPU Monitor: Unexpected cluster name \'" + clusterName + '\'');
            }
            ArrayList<AppHost> hosts = clusterHostsMap.get(clusterName);
            Float avgCPUUsage = UsageCPUMonitor.monitorCPUUsage(hosts);
            dailyAppModel.setUsageCPU(avgCPUUsage);
        }
    }

    protected void initClusterHostsMap(WebLogicServer webLogicServer){
        HashMap<String, ArrayList<AppHost>> mClusterHostsMap = new HashMap<>();

        ArrayList<AppCluster> clusters = webLogicServer.getClusters();
        for(AppCluster cluster : clusters){
            mClusterHostsMap.put(cluster.getName(), cluster.getHosts());
        }

        clusterHostsMap = mClusterHostsMap;
    }
}
