package org.suns.data.collector.collectors.sheet422;

import org.suns.data.collector.config.sheet422.Sheet422CoreConfig;
import org.suns.database.utils.controller.Sheet422Controller;
import org.suns.database.utils.model.AbstractDataModel;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.database.utils.model.Sheet422CoreModel;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/** 表空间使用率检查 **/
public class Sheet422CoreCollector extends AbstractDBSheet422Collector {
    
    public void inspect() throws Exception{
        Sheet422CoreModel dataModel = new Sheet422CoreModel();

        inspect2(dataModel);
        inspect3(dataModel);
        inspect4(dataModel);
        Timestamp inspectTime = new Timestamp(new Date().getTime());
        dataModel.setDate(inspectTime);

        InspectionLogger.debug("Finish inspecting core 422 - ");

        Sheet422Controller.addCore(dataModel);
    }

    private void inspect2(Sheet422CoreModel dataModel) throws Exception{
        String[] hosts = Sheet422CoreConfig.getInspectedHosts2();
        String[] passwords = Sheet422CoreConfig.getPasswords2();
        String[] users = Sheet422CoreConfig.getUsers2(); 
        int[] ports = Sheet422CoreConfig.getPorts2();
        
        dataModel.setUsage2((float)hasOverloadedTableSpace(hosts[0]
                , ports[0], passwords[0], users[0]));
    }

    private void inspect3(Sheet422CoreModel dataModel) throws Exception{
        String[] hosts = Sheet422CoreConfig.getInspectedHosts3();
        String[] passwords = Sheet422CoreConfig.getPasswords3();
        String[] users = Sheet422CoreConfig.getUsers3();
        int[] ports = Sheet422CoreConfig.getPorts3();

        dataModel.setUsage3((float)hasOverloadedTableSpace(hosts[0]
                , ports[0], passwords[0], users[0]));
    }

    private void inspect4(Sheet422CoreModel dataModel) throws Exception{
        String[] hosts = Sheet422CoreConfig.getInspectedHosts4();
        String[] passwords = Sheet422CoreConfig.getPasswords4();
        String[] users = Sheet422CoreConfig.getUsers4();
        int[] ports = Sheet422CoreConfig.getPorts4();

        dataModel.setUsage4((float)hasOverloadedTableSpace(hosts[0]
                , ports[0], passwords[0], users[0]));
    }
}
