package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.config.daily.DBInspectionConfig;
import org.suns.host.config.AppHost;

public class DBLongTermLockMonitor {
    public static int monitorLongTermLock(AppHost host) throws Exception{

        String strResult = SimpleSQLExecutor.getStringBySimpleSQL(host.getUser()
                , host.getPassword(), host.getIp()
                , host.getPort(), host.getSid()
                , DBInspectionConfig.getDbLongTermLockSQL()
                , DBInspectionConfig.getDbLongTermLockField());

        if(strResult.equals("")){
            throw new Exception("Empty value from archive monitoring SQL");
        }

        if(strResult.equals(DBInspectionConfig.getHasLongTermLockState())){
            return 1;
        }else{
            return 0;
        }
    }
}
