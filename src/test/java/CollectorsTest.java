import org.junit.Test;
import org.suns.data.collector.collectors.daily.monitor.ArchiveSpaceMonitor;
import org.suns.data.collector.collectors.daily.monitor.DBLongTermLockMonitor;
import org.suns.data.collector.collectors.daily.monitor.UsageSoftwareDirectoryMonitor;
import org.suns.data.collector.collectors.daily.monitor.WebLogicMonitor;
import org.suns.data.collector.collectors.sheet422.Sheet422PersonalCollectorDB;
import org.suns.data.collector.config.sheet426.Sheet426Config;
import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.model.DailyAppInspectionModel;
import org.suns.host.config.AppCluster;
import org.suns.host.config.AppHost;
import org.suns.host.config.WebLogicServer;
import org.suns.inspection.logger.InspectionLogger;

import java.util.ArrayList;

/**
 * Created by guanl on 6/28/2017.
 */

public class CollectorsTest {

    @Test
    public void test_all_sheets(){
        try{
            String cmd = Sheet426Config.getORADetectionCmd("test.log");
            System.out.println(cmd);

            InspectionLogger.turnOnDebug();
            DBConfig.setConfigToMySQL();
            ArrayList<DailyAppInspectionModel> dailyAppModels = new ArrayList<>();
            WebLogicServer webLogicServer = new WebLogicServer();

            String server = "AdminServer";
            ArrayList<String> servers = new ArrayList<>();
            servers.add(server);

            ArrayList<AppHost> hosts = new ArrayList<>();
            AppHost host = new AppHost();
            host.setServers(servers);
            host.setIp("119.29.201.188");
            host.setPort(22);
            host.setUser("root");
            host.setPassword("whiteglcap25");
            host.setScriptCPUPath("/script/lc.sh");
            host.setScriptMemoryPath("/script/lm.sh");
            hosts.add(host);

            AppCluster cluster = new AppCluster();
            cluster.setHosts(hosts);
            cluster.setName("Test Cluster");
            ArrayList<AppCluster> clusters = new ArrayList<>();
            clusters.add(cluster);

            webLogicServer.setClusters(clusters);
            webLogicServer.setPort(7001);
            webLogicServer.setIp("192.168.14.90");
            webLogicServer.setPassword("123456789");
            webLogicServer.setUser("weblogic");

            //WebLogicMonitor.monitorWebLogicServer(webLogicServer, dailyAppModels);
            //System.out.println(UsageSoftwareDirectoryMonitor.monitorSoftwareDirectoryUsage(hosts));

            AppHost appHost = new AppHost();
            appHost.setSid("ggjs");
            appHost.setUser("dev_01");
            appHost.setIp("192.168.14.82");
            appHost.setPassword("a");
            appHost.setPort(1521);
            System.out.println(DBLongTermLockMonitor.monitorLongTermLock(appHost));
/*
            Sheet411PersonalCollector sheet411PersonalCollector
                    = new Sheet411PersonalCollector();
            sheet411PersonalCollector.inspect();

            Sheet411CoreCollector sheet411CoreCollector
                    = new Sheet411CoreCollector();
            sheet411CoreCollector.inspect();

            Sheet421CoreCollector sheet421CoreCollector 
                    = new Sheet421CoreCollector();
            sheet421CoreCollector.inspect();
            
            Sheet421PersonalCollector sheet421PersonalCollector
                    = new Sheet421PersonalCollector();
            sheet421PersonalCollector.inspect();
            
            Sheet422PersonalCollectorDB sheet422PersonalCollector
                    = new Sheet422PersonalCollectorDB();
            sheet422PersonalCollector.inspect();

            Sheet422CoreCollectorDB sheet422CoreCollector
                    = new Sheet422CoreCollectorDB();
            sheet422CoreCollector.inspect();

            Sheet423CoreCollectorDB sheet423CoreCollector
                    = new Sheet423CoreCollectorDB();
            sheet423CoreCollector.inspect();

            Sheet423PersonalCollectorDB sheet423PersonalCollector
                    = new Sheet423PersonalCollectorDB();
            sheet423PersonalCollector.inspect();

            Sheet424PersonalCollector sheet424PersonalCollector
                    = new Sheet424PersonalCollector();
            sheet424PersonalCollector.inspect();

            Sheet424CoreCollector sheet424CoreCollector
                    = new Sheet424CoreCollector();
            sheet424CoreCollector.inspect();

            Sheet429CoreCollector sheet429CoreCollector
                    = new Sheet429CoreCollector();
            sheet429CoreCollector.inspect();

            Sheet429PersonalCollector sheet429PersonalCollector
                    = new Sheet429PersonalCollector();
            sheet429PersonalCollector.inspect();

            Sheet426CoreCollector sheet426CoreCollector
                    = new Sheet426CoreCollector();
            sheet426CoreCollector.inspect();

            Sheet426PersonalCollector sheet426PersonalCollector
                    = new Sheet426PersonalCollector();
            sheet426PersonalCollector.inspect();

            Sheet428CoreCollector sheet428CoreCollector
                    = new Sheet428CoreCollector();
            sheet428CoreCollector.inspect();

            Sheet428PersonalCollector sheet428PersonalCollector
                    = new Sheet428PersonalCollector();
            sheet428PersonalCollector.inspect();
*/
        }catch (Exception e){
            e.printStackTrace();
        }

        return;
    }
}
