package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.config.daily.DBInspectionConfig;
import org.suns.host.config.AppHost;

public class DBTableSpaceMonitor {
    public static int monitorTableSpace(AppHost host) throws Exception{

        String strResult = SimpleSQLExecutor.getStringBySimpleSQL(host.getUser()
                , host.getPassword(), host.getIp()
                , host.getPort(), host.getSid()
                , DBInspectionConfig.getTableSpaceUsageSQL()
                , DBInspectionConfig.getTableSpaceUsageField());

        if(strResult.equals("")){
            throw new Exception("Empty value from table " +
                    "space monitoring SQL");
        }

        if(strResult.equals(DBInspectionConfig.getDescriptionHasState())){
            return 1;
        }else{
            return 0;
        }
    }
}
