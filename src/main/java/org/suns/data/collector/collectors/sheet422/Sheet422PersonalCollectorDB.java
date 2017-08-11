package org.suns.data.collector.collectors.sheet422;

import org.suns.data.collector.config.sheet422.Sheet422CoreConfig;
import org.suns.data.collector.config.sheet422.Sheet422PersonalConfig;
import org.suns.database.utils.controller.Sheet422Controller;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.database.utils.model.Sheet422PersonalModel;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/** 表空间使用率检查 **/
public class Sheet422PersonalCollectorDB extends AbstractDBSheet422Collector {


    public void inspect() throws Exception{
        Sheet422PersonalModel sheet422Model = new Sheet422PersonalModel();
        inspect2(sheet422Model);
        
        Timestamp inspectTime = new Timestamp(new Date().getTime());
        sheet422Model.setDate(inspectTime);
        

        InspectionLogger.debug("Finish inspecting personal 422 - ");

        Sheet422Controller.addPersonal(sheet422Model);
    }

    private void inspect2(Sheet422PersonalModel sheet422Model) throws Exception{
        String[] hosts = Sheet422PersonalConfig.getInspectedHosts();
        String[] passwords = Sheet422PersonalConfig.getPasswords();
        String[] users = Sheet422PersonalConfig.getUsers();
        int[] ports = Sheet422PersonalConfig.getPorts();

        sheet422Model.setUsage2((float)hasOverloadedTableSpace(hosts[0]
                , ports[0], passwords[0], users[0]));
    }
}
