package org.suns.data.collector.collectors.sheet411;

import org.suns.data.collector.collectors.AbstractOSInspectionCollector;
import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.model.Sheet411PersonalModel;

import java.util.PriorityQueue;

public abstract class AbstractSheet411Collector extends AbstractOSInspectionCollector{

    protected abstract String[] getInspectHosts2();
    protected abstract String[] getPasswords2();
    protected abstract String[] getUsers2();
    protected abstract int[] getPorts2();

    protected void inspect2(Sheet411PersonalModel sheet411Model) throws Exception{
        final String[] inspectedHosts = getInspectHosts2();
        final String[] users = getUsers2();
        final String[] passwords = getPasswords2();
        final int[] ports = getPorts2();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectOSRootAndSoftware(inspectedHosts[i], rootUsage, webLogicUsage
                    , users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet411Model.setUsage2(maxRootUsage);
        }else{
            sheet411Model.setUsage2((float) DBConfig.getDefaultNumericNullValue());
        }

        if(!webLogicUsage.isEmpty()){
            Float maxWebLogicUsage = webLogicUsage.poll();
            sheet411Model.setWeblogicUsage2(maxWebLogicUsage);
        }else{
            sheet411Model.setWeblogicUsage2((float)DBConfig.getDefaultNumericNullValue());
        }
    }

    protected abstract String[] getInspectHosts3();
    protected abstract String[] getPasswords3();
    protected abstract String[] getUsers3();
    protected abstract int[] getPorts3();

    protected void inspect3(Sheet411PersonalModel sheet411Model) throws Exception{
        final String[] inspectedHosts = getInspectHosts3();
        final String[] users = getUsers3();
        final String[] passwords = getPasswords3();
        final int[] ports = getPorts3();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectOSRootAndSoftware(inspectedHosts[i], rootUsage, webLogicUsage
                    , users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet411Model.setUsage3(maxRootUsage);
        }else{
            sheet411Model.setUsage3((float)DBConfig.getDefaultNumericNullValue());
        }

        if(!webLogicUsage.isEmpty()){
            Float maxWebLogicUsage = webLogicUsage.poll();
            sheet411Model.setWeblogicUsage3(maxWebLogicUsage);
        }else{
            sheet411Model.setWeblogicUsage3((float)DBConfig.getDefaultNumericNullValue());
        }
    }
}
