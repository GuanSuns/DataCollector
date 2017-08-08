package org.suns.data.collector.config.daily;

import org.suns.host.config.WebLogicServerConfig;

import java.util.ArrayList;

public class AppPersonalConfig {
    private static ArrayList<WebLogicServerConfig> webLogicServers
            = new ArrayList<>(0);

    public static ArrayList<WebLogicServerConfig> getWebLogicServers() {
        return webLogicServers;
    }

    public static void setWebLogicServers(ArrayList<WebLogicServerConfig> webLogicServers) {
        AppPersonalConfig.webLogicServers = webLogicServers;
    }
}
