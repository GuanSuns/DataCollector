package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.config.daily.AppInspectionConfig;
import org.suns.host.config.AppHost;

import java.util.ArrayList;

public class UsageCPUMonitor {
    public static Float monitorCPUUsage(ArrayList<AppHost> hosts) throws Exception{
        Float totalCPUUsage = 0f;
        int cntHosts = hosts.size();

        for(AppHost host: hosts){
            Float cpuUsage = ScriptExecutor.getFloatFromPercentageByScript(host.getUser()
                    , host.getPassword()
                    , host.getIp(), host.getPort()
                    , AppInspectionConfig.getScriptCmd(host.getScriptCPUPath()));

            if(cpuUsage == null){
                throw new Exception("Fail to get CPU Usage from host " + host.getIp()
                        + ":" + host.getPort() + ", " + host.getUser()
                        + ", " + host.getPassword());
            }

            totalCPUUsage = totalCPUUsage + cpuUsage;
        }
        return totalCPUUsage/cntHosts;
    }
}
