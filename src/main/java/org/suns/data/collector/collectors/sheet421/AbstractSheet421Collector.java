package org.suns.data.collector.collectors.sheet421;

import org.suns.data.collector.collectors.AbstractOSInspectionCollector;
import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.model.Sheet421PersonalModel;

import java.util.PriorityQueue;

public abstract class AbstractSheet421Collector extends AbstractOSInspectionCollector{
    protected abstract String getSoftwareGgsDirectory();

    protected abstract String[] getInspectHosts2();
    protected abstract String[] getPasswords2();
    protected abstract String[] getUsers2();
    protected abstract int[] getPorts2();

    protected void inspect2(Sheet421PersonalModel sheet421Model) throws Exception{
        final String[] inspectedHosts = getInspectHosts2();
        final String[] users =getUsers2();
        final String[] passwords = getPasswords2();
        final int[] ports = getPorts2();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> goldengateUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectAllDirectory(inspectedHosts[i], rootUsage, u01Usage
                    , goldengateUsage, users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet421Model.setUsage2(maxRootUsage);
        }else{
            sheet421Model.setUsage2((float) DBConfig.getDefaultNumericNullValue());
        }

        if(!goldengateUsage.isEmpty()){
            Float maxGoldengateUsage = goldengateUsage.poll();
            sheet421Model.setGoldUsage2(maxGoldengateUsage);
        }else{
            sheet421Model.setGoldUsage2((float) DBConfig.getDefaultNumericNullValue());
        }

        if(!u01Usage.isEmpty()){
            Float maxU01Usage = u01Usage.poll();
            sheet421Model.setU01Usage2(maxU01Usage);
        }else{
            sheet421Model.setU01Usage2((float) DBConfig.getDefaultNumericNullValue());
        }
    }

    protected void inspectAllDirectory(String host
            , PriorityQueue<Float> rootUsage
            , PriorityQueue<Float> u01Usage
            , PriorityQueue<Float> goldenUsage
            , String user, String password, int port) throws Exception{

        HostConnector.connect(user, password, host, port);

        String mountedSysCmd = DFFormat.getMountedSysCmd();
        String usageCmd = DFFormat.getUsageCmd();
        String strSysNames = HostConnector.executeCommand(mountedSysCmd);
        String strUsages = HostConnector.executeCommand(usageCmd);

        String[] sysNames = parseSysNames(strSysNames);
        Float[] usages = parseUsages(strUsages);
        if(sysNames.length != usages.length){
            throw new Exception("Unexpected result of parsing df -h");
        }

        for(int i=0; i<sysNames.length; i++){
            if(sysNames[i].equals(getRootDirectory())){
                rootUsage.add(usages[i]);
            }else if(sysNames[i].equals(getSoftwareDirectory())){
                u01Usage.add(usages[i]);
            }else if(sysNames[i].equals(getSoftwareGgsDirectory())){
                goldenUsage.add(usages[i]);
            }
        }
    }
}
