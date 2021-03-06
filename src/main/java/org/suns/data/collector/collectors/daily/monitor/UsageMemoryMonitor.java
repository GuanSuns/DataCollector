package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.config.daily.AppInspectionConfig;
import org.suns.database.utils.config.DBConfig;
import org.suns.host.config.AppHost;

import java.util.ArrayList;

public class UsageMemoryMonitor {
    public static Float monitorMemoryUsage(ArrayList<AppHost> hosts) throws Exception{
        Float totalMemoryUsage = 0f;
        int cntHosts = hosts.size();

        for(AppHost host: hosts){
            Float memoryUsage = ScriptExecutor.getFloatFromPercentageByScript(host.getUser()
                    , host.getPassword()
                    , host.getIp(), host.getPort()
                    , ScriptExecutor.getScriptCmd(host.getScriptMemoryPath()));

            if(memoryUsage == null){
                throw new Exception("Fail to get Memory Usage from host " + host.getIp()
                        + ":" + host.getPort() + ", " + host.getUser()
                        + ", " + host.getPassword());
            }

            totalMemoryUsage = totalMemoryUsage + memoryUsage;
        }

        if(cntHosts == 0){
            return (float)DBConfig.getDefaultNumericNullValue();
        }else{
            return totalMemoryUsage/cntHosts;
        }
    }
}
