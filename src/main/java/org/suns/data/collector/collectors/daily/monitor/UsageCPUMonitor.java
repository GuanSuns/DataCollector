package org.suns.data.collector.collectors.daily.monitor;

import org.suns.database.utils.config.DBConfig;
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
                    , ScriptExecutor.getScriptCmd(host.getScriptCPUPath()));

            if(cpuUsage == null){
                throw new Exception("Fail to get CPU Usage from host " + host.getIp()
                        + ":" + host.getPort() + ", " + host.getUser()
                        + ", " + host.getPassword());
            }

            totalCPUUsage = totalCPUUsage + cpuUsage;
        }

        if(cntHosts == 0){
            return (float) DBConfig.getDefaultNumericNullValue();
        }else{
            return totalCPUUsage/cntHosts;
        }
    }

    public static Float  monitorAixCPUUsage(ArrayList<AppHost> hosts) throws Exception{
        Float totalCPUUsage = 0f;
        int cntHosts = hosts.size();

        for(AppHost host: hosts){
            Float cpuUsage = ScriptExecutor.getFloatFromPercentageByAixScript(host.getUser()
                    , host.getPassword(), host.getRootPassword()
                    , host.getIp(), host.getPort()
                    , ScriptExecutor.getScriptCmd(host.getScriptCPUPath()));

            if(cpuUsage == null){
                throw new Exception("Fail to get CPU Usage from host " + host.getIp()
                        + ":" + host.getPort() + ", " + host.getUser()
                        + ", " + host.getPassword());
            }

            totalCPUUsage = totalCPUUsage + cpuUsage;
        }

        if(cntHosts == 0){
            return (float) DBConfig.getDefaultNumericNullValue();
        }else{
            return totalCPUUsage/cntHosts;
        }
    }
}
