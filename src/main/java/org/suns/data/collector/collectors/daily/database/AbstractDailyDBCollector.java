package org.suns.data.collector.collectors.daily.database;

import org.suns.data.collector.collectors.daily.monitor.DiskBusyMonitor;
import org.suns.data.collector.collectors.daily.monitor.UsageCPUMonitor;
import org.suns.data.collector.collectors.daily.monitor.UsageMemoryMonitor;
import org.suns.database.utils.model.DailyDBInspectionModel;
import org.suns.host.config.AppCluster;
import org.suns.host.config.AppHost;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public abstract class AbstractDailyDBCollector {
    protected abstract ArrayList<AppCluster> getClusters();
    protected abstract void saveToDB(DailyDBInspectionModel dailyDBInspectionModel) throws Exception;
   
    protected ArrayList<AppCluster> clusters = null;

    public void inspect() throws Exception{
        clusters = getClusters();

        for(AppCluster cluster : clusters){
            DailyDBInspectionModel dailyDBModel = new DailyDBInspectionModel();
            dailyDBModel.setName(cluster.getName());

            inspectUsageCPU(dailyDBModel, cluster);
            inspectUsageMemory(dailyDBModel, cluster);
            inspectDiskBusy(dailyDBModel, cluster);



            dailyDBModel.setInspectTime(new Timestamp(new Date().getTime()));
            saveToDB(dailyDBModel);
        }
    }

    protected void inspectUsageCPU(DailyDBInspectionModel dailyDBModels
            , AppCluster cluster) throws Exception{

        ArrayList<AppHost> dbOSInspectionHosts = cluster.getOSInspectionHosts();
        Float avgCPUUsage = UsageCPUMonitor.monitorCPUUsage(dbOSInspectionHosts);
        dailyDBModels.setUsageCPU(avgCPUUsage);
    }

    protected void inspectUsageMemory(DailyDBInspectionModel dailyDBModels
            , AppCluster cluster) throws Exception{

        ArrayList<AppHost> dbOSInspectionHosts = cluster.getOSInspectionHosts();
        Float avgMemoryUsage = UsageMemoryMonitor.monitorMemoryUsage(dbOSInspectionHosts);
        dailyDBModels.setUsageMemory(avgMemoryUsage);
    }

    protected void inspectDiskBusy(DailyDBInspectionModel dailyDBModels
            , AppCluster cluster) throws Exception{

        ArrayList<AppHost> dbOSInspectionHosts = cluster.getOSInspectionHosts();
        Float avgDiskBusy = DiskBusyMonitor.monitorDiskBusy(dbOSInspectionHosts);
        dailyDBModels.setDiskBusy(avgDiskBusy);
    }
}
