package org.suns.data.collector.collectors.daily.monitor;

import org.suns.database.utils.config.DBConfig;
import org.suns.host.config.AppHost;

import java.util.ArrayList;

public class DiskBusyMonitor {
    public static Float monitorDiskBusy(ArrayList<AppHost> hosts) throws Exception{
        Float totalDiskBusy = 0f;
        int cntHosts = hosts.size();

        for(AppHost host: hosts){
            Float cpuUsage = ScriptExecutor.getFloatFromPercentageByAixScript(host.getUser()
                    , host.getPassword(), host.getRootPassword()
                    , host.getIp(), host.getPort()
                    , ScriptExecutor.getScriptCmd(host.getScriptDiskPath()));

            if(cpuUsage == null){
                throw new Exception("Fail to get Disk Busy from host " + host.getIp()
                        + ":" + host.getPort() + ", " + host.getUser()
                        + ", " + host.getPassword());
            }

            totalDiskBusy = totalDiskBusy + cpuUsage;
        }

        if(cntHosts == 0){
            return (float) DBConfig.getDefaultNumericNullValue();
        }else{
            return totalDiskBusy/cntHosts;
        }
    }
}
