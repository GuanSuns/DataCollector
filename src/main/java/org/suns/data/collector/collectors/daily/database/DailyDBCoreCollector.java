package org.suns.data.collector.collectors.daily.database;


import org.suns.data.collector.config.daily.DBCoreConfig;
import org.suns.database.utils.controller.DailyDBController;
import org.suns.database.utils.model.DailyDBInspectionModel;
import org.suns.host.config.AppCluster;

import java.util.ArrayList;

public class DailyDBCoreCollector extends AbstractDailyDBCollector{

    @Override
    protected ArrayList<AppCluster> getClusters() {
        return DBCoreConfig.getClusters();
    }

    @Override
    protected void saveToDB(DailyDBInspectionModel dailyDBInspectionModel) throws Exception {
        DailyDBController.addCore(dailyDBInspectionModel);
    }
}
