package org.suns.data.collector.collectors.daily.app;

import org.suns.data.collector.config.daily.AppCoreConfig;
import org.suns.data.collector.config.daily.AppPersonalConfig;
import org.suns.database.utils.controller.DailyAppController;
import org.suns.database.utils.model.DailyAppInspectionModel;
import org.suns.host.config.WebLogicServer;

import java.util.ArrayList;

public class DailyAppPersonalCollector extends AbstractDailyAppCollector{
    @Override
    protected ArrayList<WebLogicServer> getWebLogicServers() {
        return AppPersonalConfig.getWebLogicServers();
    }

    @Override
    protected void saveToDB(DailyAppInspectionModel dailyAppInspectionModel) throws Exception {
        DailyAppController.addPersonal(dailyAppInspectionModel);
    }
}
