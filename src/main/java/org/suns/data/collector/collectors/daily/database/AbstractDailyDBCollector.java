package org.suns.data.collector.collectors.daily.database;

import org.suns.data.collector.collectors.daily.monitor.*;
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

            System.out.println(cluster.getPrintedName()
                    + " CPU 使用率检查");
            inspectUsageCPU(dailyDBModel, cluster);

            System.out.println(cluster.getPrintedName()
                    + " 内存使用率检查");
            inspectUsageMemory(dailyDBModel, cluster);

            System.out.println(cluster.getPrintedName()
                    + " 磁盘繁忙程度检查");
            //inspectDiskBusy(dailyDBModel, cluster);

            System.out.println(cluster.getPrintedName()
                    + " 归档空间使用率检查");
            //inspectArchiveSpace(dailyDBModel, cluster);

            System.out.println(cluster.getPrintedName()
                    + " 数据库长时间锁检查");
            //inspectLongTermLock(dailyDBModel, cluster);

            System.out.println(cluster.getPrintedName()
                    + " 表空间使用率检查");
            inspectTableSpace(dailyDBModel, cluster);

            System.out.println(cluster.getPrintedName()
                    + " alert日志检查");
            inspectLogErrorInfo(dailyDBModel, cluster);

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

    protected void inspectArchiveSpace(DailyDBInspectionModel dailyDBModels
            , AppCluster cluster) throws Exception{

        ArrayList<AppHost> dbHosts = cluster.getHosts();
        Float archiveSpaceUsage = ArchiveSpaceMonitor.monitorArchiveSpace(dbHosts.get(0));
        dailyDBModels.setUsageArchiveSpace(archiveSpaceUsage);
    }


    protected void inspectLongTermLock(DailyDBInspectionModel dailyDBModels
            , AppCluster cluster) throws Exception{

        ArrayList<AppHost> dbHosts = cluster.getHosts();
        int hasLongTermLock = DBLongTermLockMonitor.monitorLongTermLock(dbHosts.get(0));
        dailyDBModels.setHasLongTermLock(hasLongTermLock);
    }

    protected void inspectTableSpace(DailyDBInspectionModel dailyDBModels
            , AppCluster cluster) throws Exception{

        ArrayList<AppHost> dbHosts = cluster.getHosts();
        int hasOverloadedTableSpace = DBTableSpaceMonitor.monitorTableSpace(dbHosts.get(0));
        dailyDBModels.setHasOverloadTableSpace(hasOverloadedTableSpace);
    }

    protected void inspectLogErrorInfo(DailyDBInspectionModel dailyDBModels
            , AppCluster cluster) throws Exception{

        int hasLogErrorInfo = LogErrorInfoMonitor.inspectLogErrorInfo(cluster);
        dailyDBModels.setHasErrorInLog(hasLogErrorInfo);
    }
}
