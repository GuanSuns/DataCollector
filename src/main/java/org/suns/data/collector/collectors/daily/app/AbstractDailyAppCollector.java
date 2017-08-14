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
        System.out.println("\n日巡检: 应用检查");

        webLogicServers = getWebLogicServers();

        for(WebLogicServer webLogicServer: webLogicServers){

            initClusterHostsMap(webLogicServer);
            ArrayList<DailyAppInspectionModel> dailyAppModels = new ArrayList<>();

            System.out.println("\n- - WebLogicServer \'" + webLogicServer.getIp()
                    + "\' WebLogic Server 检查");
            inspectWebLogicServer(webLogicServer, dailyAppModels);

            System.out.println("\n- - WebLogicServer \'" + webLogicServer.getIp()
                    + "\' CPU 使用率检查");
            //inspectCPU(dailyAppModels);

            System.out.println("\n- - WebLogicServer \'" + webLogicServer.getIp()
                    + "\' 内存使用率检查");
            //inspectMemory(dailyAppModels);

            System.out.println("\n- - WebLogicServer \'" + webLogicServer.getIp()
                    + "\' 常用文件系统使用率检查");
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
            System.out.println("- - - - 集群 \'"
                    + dailyAppModel.getName() + "\' 内存使用情况检查");

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
            System.out.println("- - - - 集群 \'"
                    + dailyAppModel.getName() + "\' Software目录使用率检查");

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
            System.out.println("- - - - 集群 \'"
                    + dailyAppModel.getName() + "\' CPU使用率检查");

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
        HashMap<String, ArrayList<AppHost>> mClusterOSInspectHostsMap = new HashMap<>();

        ArrayList<AppCluster> clusters = webLogicServer.getClusters();
        for(AppCluster cluster : clusters){
            mClusterOSInspectHostsMap.put(cluster.getName(), cluster.getHosts());
        }

        clusterHostsMap = mClusterOSInspectHostsMap;
    }
}
