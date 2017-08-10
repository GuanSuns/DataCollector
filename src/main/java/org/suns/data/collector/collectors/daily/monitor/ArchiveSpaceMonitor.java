package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.config.daily.DBInspectionConfig;
import org.suns.host.config.AppHost;


public class ArchiveSpaceMonitor {
    public static Float monitorArchiveSpace(AppHost host) throws Exception{

        String strResult = SimpleSQLExecutor.getStringBySimpleSQL(host.getUser()
                , host.getPassword(), host.getIp()
                , host.getPort(), host.getSid()
                , DBInspectionConfig.getArchiveSpaceSQL()
                , DBInspectionConfig.getArchiveSpaceSQLField());

        if(strResult.equals("")){
            throw new Exception("Empty value from archive monitoring SQL");
        }

        return Float.valueOf(strResult);
    }
}
