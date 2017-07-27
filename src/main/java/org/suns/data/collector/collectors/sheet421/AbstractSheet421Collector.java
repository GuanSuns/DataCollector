package org.suns.data.collector.collectors.sheet421;

import org.suns.data.collector.collectors.AbstractOSInspectionCollector;
import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.model.Sheet421CoreModel;
import org.suns.database.utils.model.Sheet421PersonalModel;

import java.util.PriorityQueue;

public abstract class AbstractSheet421Collector extends AbstractOSInspectionCollector{

    protected void inspectAllDirectoryByHostID(Sheet421PersonalModel sheet421Model
            , HostsId hostsId) throws Exception{
        final String[] inspectedHosts = getInspectHosts(hostsId);
        final String[] users = getUsers(hostsId);
        final String[] passwords = getPasswords(hostsId);
        final int[] ports = getPorts(hostsId);

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> goldengateUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectAllDirectory(inspectedHosts[i], rootUsage, u01Usage
                    , goldengateUsage, users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            setUsage(sheet421Model, hostsId, maxRootUsage);
        }else{
            setUsage(sheet421Model, hostsId
                    , (float) DBConfig.getDefaultNumericNullValue());
        }

        if(!goldengateUsage.isEmpty()){
            Float maxGoldengateUsage = goldengateUsage.poll();
            setGoldUsage(sheet421Model, hostsId, maxGoldengateUsage);
        }else{
            setGoldUsage(sheet421Model, hostsId
                    , (float) DBConfig.getDefaultNumericNullValue());
        }

        if(!u01Usage.isEmpty()){
            Float maxU01Usage = u01Usage.poll();
            setU01Usage(sheet421Model, hostsId, maxU01Usage);
        }else{
            setU01Usage(sheet421Model, hostsId
                    , (float) DBConfig.getDefaultNumericNullValue());
        }
    }

    protected void inspectRootAndSoftwareDirectoryByHostId(Sheet421PersonalModel sheet421Model
            , HostsId hostsId) throws Exception{
        final String[] inspectedHosts = getInspectHosts(hostsId);
        final String[] users = getUsers(hostsId);
        final String[] passwords = getPasswords(hostsId);
        final int[] ports = getPorts(hostsId);

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectOSRootAndSoftware(inspectedHosts[i], rootUsage, u01Usage
                    , users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            setUsage(sheet421Model, hostsId, maxRootUsage);
        }else{
            setUsage(sheet421Model, hostsId
                    , (float) DBConfig.getDefaultNumericNullValue());
        }

        if(!u01Usage.isEmpty()){
            Float maxU01Usage = u01Usage.poll();
            setU01Usage(sheet421Model, hostsId, maxU01Usage);
        }else{
            setU01Usage(sheet421Model, hostsId
                    , (float) DBConfig.getDefaultNumericNullValue());
        }
    }

    protected void setUsage(Sheet421PersonalModel sheet421Model
            , HostsId hostsId, Float usage){
        switch (hostsId){
            case HOST2:
                sheet421Model.setUsage2(usage);
                return;
            case HOST3:
                sheet421Model.setUsage3(usage);
                return;
            case HOST4:
                sheet421Model.setUsage4(usage);
                return;
            case HOST5:
                Sheet421CoreModel sheet421CoreModel = (Sheet421CoreModel)sheet421Model;
                sheet421CoreModel.setUsage5(usage);
                return;
            default:
                return;
        }
    }

    protected void setU01Usage(Sheet421PersonalModel sheet421Model
            , HostsId hostsId, Float u01U01Usage){
        switch (hostsId){
            case HOST2:
                sheet421Model.setU01Usage2(u01U01Usage);
                return;
            case HOST3:
                sheet421Model.setU01Usage3(u01U01Usage);
                return;
            case HOST4:
                sheet421Model.setU01Usage4(u01U01Usage);
                return;
            case HOST5:
                Sheet421CoreModel sheet421CoreModel = (Sheet421CoreModel)sheet421Model;
                sheet421CoreModel.setU01Usage5(u01U01Usage);
                return;
            default:
                return;
        }
    }

    protected void setGoldUsage(Sheet421PersonalModel sheet421Model
            , HostsId hostsId, Float usage){
        switch (hostsId){
            case HOST2:
                sheet421Model.setGoldUsage2(usage);
                return;
            case HOST3:
                sheet421Model.setGoldUsage3(usage);
                return;
            case HOST4:
                sheet421Model.setGoldUsage4(usage);
                return;
            case HOST5:
                Sheet421CoreModel sheet421CoreModel = (Sheet421CoreModel)sheet421Model;
                sheet421CoreModel.setGoldUsage5(usage);
                return;
            default:
                return;
        }
    }


}
