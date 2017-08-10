package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.collectors.sheet426.AbstractSheet426Collector;
import org.suns.database.utils.model.DailyDBInspectionModel;
import org.suns.host.config.AppCluster;
import org.suns.host.config.AppHost;

import java.util.ArrayList;

public class LogErrorInfoMonitor extends AbstractSheet426Collector{
    @Override
    protected String[] getLogPaths(HostsId hostsId) {
        return new String[0];
    }

    private static LogErrorInfoMonitor logErrorInfoMonitor = null;

    private static void initLogErrorInfoMonitor(){
        logErrorInfoMonitor = new LogErrorInfoMonitor();
    }

    public static int inspectLogErrorInfo(AppCluster cluster) throws Exception{

        final int clusterSize = cluster.getOSInspectionHosts().size();
        String[] hosts = new String[clusterSize];
        String[] logPaths = new String[clusterSize];
        String[] users = new String[clusterSize];
        String[] passwords = new String[clusterSize];
        int[] ports = new int[clusterSize];

        getHostsInfoArray(cluster, hosts, logPaths, users, passwords, ports);

        if(logErrorInfoMonitor == null){
            initLogErrorInfoMonitor();
        }

        int hasErrorInfo = logErrorInfoMonitor.isHostsLogHasErrorInfo(hosts
                , ports, users,passwords, logPaths);

        return hasErrorInfo;
    }

    private static void getHostsInfoArray(AppCluster cluster, String[] hosts
            , String[] logPaths, String[] users
            , String[] passwords, int[] ports){

        ArrayList<AppHost> dbOSHosts = cluster.getOSInspectionHosts();
        for(int i=0; i<dbOSHosts.size(); i++){
            hosts[i] = dbOSHosts.get(i).getIp();
            logPaths[i] = dbOSHosts.get(i).getLogPath();
            passwords[i] = dbOSHosts.get(i).getPassword();
            users[i] = dbOSHosts.get(i).getUser();
            ports[i] = dbOSHosts.get(i).getPort();
        }
    }
}
