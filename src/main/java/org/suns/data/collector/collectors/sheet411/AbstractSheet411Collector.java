package org.suns.data.collector.collectors.sheet411;

import org.suns.data.collector.collectors.AbstractOSInspectionCollector;
import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.model.Sheet411CoreModel;
import org.suns.database.utils.model.Sheet411PersonalModel;

import java.util.PriorityQueue;

public abstract class AbstractSheet411Collector extends AbstractOSInspectionCollector{
    @Override
    protected String getSoftwareGgsDirectory() {
        return null;
    }

    protected void inspectHostID(Sheet411PersonalModel sheet411Model
            , HostsId hostsId) throws Exception{
        final String[] inspectedHosts = getInspectHosts(hostsId);
        final String[] users = getUsers(hostsId);
        final String[] passwords = getPasswords(hostsId);
        final int[] ports = getPorts(hostsId);

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectOSRootAndSoftware(inspectedHosts[i], rootUsage, webLogicUsage
                    , users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            setUsage(sheet411Model, hostsId, maxRootUsage);
        }else{
            setUsage(sheet411Model, hostsId, (float)DBConfig.getDefaultNumericNullValue());
        }

        if(!webLogicUsage.isEmpty()){
            Float maxWebLogicUsage = webLogicUsage.poll();
            setWeblogicUsage(sheet411Model, hostsId, maxWebLogicUsage);
        }else{
            setWeblogicUsage(sheet411Model, hostsId
                    , (float)DBConfig.getDefaultNumericNullValue());
        }
    }

    protected void setUsage(Sheet411PersonalModel sheet411Model
            , HostsId hostsId, Float usage){
        switch (hostsId){
            case HOST1:
                return;
            case HOST2:
                sheet411Model.setUsage2(usage);
                return;
            case HOST3:
                sheet411Model.setUsage3(usage);
                return;
            case HOST4:
                sheet411Model.setUsage4(usage);
                return;
            case HOST5:
                sheet411Model.setUsage5(usage);
                return;
            case HOST6:
                sheet411Model.setUsage6(usage);
            case HOST7:
                sheet411Model.setUsage7(usage);
                return;
            case HOST8:
                Sheet411CoreModel sheet411CoreModel = (Sheet411CoreModel)sheet411Model;
                sheet411CoreModel.setUsage8(usage);
                return;
            default:
                return;
        }
    }

    protected void setWeblogicUsage(Sheet411PersonalModel sheet411Model
            , HostsId hostsId, Float webLogicUsage){
        switch (hostsId){
            case HOST1:
                return;
            case HOST2:
                sheet411Model.setWeblogicUsage2(webLogicUsage);
                return;
            case HOST3:
                sheet411Model.setWeblogicUsage3(webLogicUsage);
                return;
            case HOST4:
                sheet411Model.setWeblogicUsage4(webLogicUsage);
                return;
            case HOST5:
                sheet411Model.setWeblogicUsage5(webLogicUsage);
                return;
            case HOST6:
                sheet411Model.setWeblogicUsage6(webLogicUsage);
            case HOST7:
                sheet411Model.setWeblogicUsage7(webLogicUsage);
                return;
            case HOST8:
                Sheet411CoreModel sheet411CoreModel = (Sheet411CoreModel)sheet411Model;
                sheet411CoreModel.setWeblogicUsage8(webLogicUsage);
                return;
            default:
                return;
        }
    }
}
