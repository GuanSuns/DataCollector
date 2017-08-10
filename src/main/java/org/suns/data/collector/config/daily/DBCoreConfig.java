package org.suns.data.collector.config.daily;

import org.suns.host.config.AppCluster;

import java.util.ArrayList;

public class DBCoreConfig {
    private static ArrayList<AppCluster> clusters
            = new ArrayList<>(0);

    public static ArrayList<AppCluster> getClusters() {
        return clusters;
    }

    public static void setClusters(ArrayList<AppCluster> clusters) {
        DBCoreConfig.clusters = clusters;
    }
}
