package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.collectors.AbstractOSInspectionCollector;
import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.config.daily.AppInspectionConfig;
import org.suns.database.utils.config.DBConfig;
import org.suns.host.config.AppHost;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class UsageSoftwareDirectoryMonitor extends AbstractOSInspectionCollector{

    private static UsageSoftwareDirectoryMonitor softwareDirectoryMonitor = null;

    private static void initMonitor(){
        softwareDirectoryMonitor = new UsageSoftwareDirectoryMonitor();
    }

    @Override
    protected String getRootDirectory() {
        return "";
    }

    @Override
    protected String getSoftwareDirectory() {
        return AppInspectionConfig.getSoftwareDirectory();
    }

    @Override
    protected String getSoftwareGgsDirectory() {
        return null;
    }

    public static Float monitorSoftwareDirectoryUsage(ArrayList<AppHost> hosts)
            throws Exception{

        if(softwareDirectoryMonitor == null){
            initMonitor();
        }

        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>();
        for(AppHost host : hosts){
            softwareDirectoryMonitor.inspectSoftware(DFFormat.InspectionSysType.LINUX
                    , host.getIp(), host.getUser()
                    , host.getPassword(), host.getPort(), webLogicUsage);
        }

        Float totalSoftwareUsage = 0f;
        int cntHosts = 0;
        for(Float usage : webLogicUsage){
            totalSoftwareUsage = totalSoftwareUsage + usage;
            cntHosts++;
        }

        if(cntHosts == 0){
            return (float)DBConfig.getDefaultNumericNullValue();
        }else{
            return (totalSoftwareUsage)/cntHosts;
        }
    }
}
