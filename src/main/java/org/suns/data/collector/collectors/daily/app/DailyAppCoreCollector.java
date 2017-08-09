package org.suns.data.collector.collectors.daily.app;

import org.suns.data.collector.config.daily.AppCoreConfig;
import org.suns.database.utils.controller.DailyAppController;
import org.suns.database.utils.model.DailyAppInspectionModel;
import org.suns.host.config.WebLogicServer;

import java.util.ArrayList;

public class DailyAppCoreCollector extends AbstractDailyAppCollector{
    @Override
    protected ArrayList<WebLogicServer> getWebLogicServers() {
        return AppCoreConfig.getWebLogicServers();
    }

    @Override
    protected void saveToDB(DailyAppInspectionModel dailyAppInspectionModel) throws Exception {
        DailyAppController.addCore(dailyAppInspectionModel);
    }
}
