package org.suns.data.collector.collectors.sheet422;


import org.suns.data.collector.collectors.daily.monitor.DBTableSpaceMonitor;
import org.suns.host.config.AppHost;

public class AbstractDBSheet422Collector {
    protected int hasOverloadedTableSpace(String host, int port
            , String user, String password, String sid) throws Exception{

        AppHost appHost = new AppHost();
        appHost.setIp(host);
        appHost.setPassword(password);
        appHost.setUser(user);
        appHost.setPort(port);
        appHost.setSid(sid);

        return DBTableSpaceMonitor.monitorTableSpace(appHost);
    }

}
