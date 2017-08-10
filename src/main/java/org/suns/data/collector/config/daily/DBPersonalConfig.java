package org.suns.data.collector.config.daily;

import org.suns.host.config.AppCluster;
import org.suns.host.config.WebLogicServer;

import java.util.ArrayList;

public class DBPersonalConfig {
    private static ArrayList<AppCluster> clusters
            = new ArrayList<>(0);

    public static ArrayList<AppCluster> getClusters() {
        return clusters;
    }

    public static void setClusters(ArrayList<AppCluster> clusters) {
        DBPersonalConfig.clusters = clusters;
    }
}
