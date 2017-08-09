package org.suns.data.collector.config.daily;

import org.suns.host.config.WebLogicServer;

import java.util.ArrayList;

public class AppCoreConfig {
    private static ArrayList<WebLogicServer> webLogicServers
            = new ArrayList<>(0);

    public static ArrayList<WebLogicServer> getWebLogicServers() {
        return webLogicServers;
    }

    public static void setWebLogicServers(ArrayList<WebLogicServer> webLogicServers) {
        AppCoreConfig.webLogicServers = webLogicServers;
    }
}
