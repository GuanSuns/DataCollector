package org.suns.data.collector.collectors;

import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.config.DBConfig;
import org.suns.inspection.logger.InspectionLogger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public abstract class AbstractOSInspectionCollector extends AbstractDataCollector{
    protected abstract String getRootDirectory();
    protected abstract String getSoftwareDirectory();
    protected abstract String getSoftwareGgsDirectory();

    protected void inspectSoftware(DFFormat.InspectionSysType sysType
            , String host, String user
            , String password, int port
            , PriorityQueue<Float> webLogicUsage) throws Exception{

        HostConnector.connect(user, password, host, port);

        String mountedSysCmd = DFFormat.getMountedSysCmd(sysType);
        String usageCmd = DFFormat.getUsageCmd(sysType);

        String strSysNames = HostConnector.executeCommand(mountedSysCmd);
        String strUsages = HostConnector.executeCommand(usageCmd);

        String[] sysNames = parseSysNames(strSysNames);
        Float[] usages = parseUsages(strUsages);
        if(sysNames.length != usages.length){
            HostConnector.disconnect();
            throw new Exception("Unexpected result of parsing df -h");
        }

        for(int i=0; i<sysNames.length; i++){
            if(sysNames[i].equals(getSoftwareDirectory())){
                webLogicUsage.add(usages[i]);
            }
        }

        HostConnector.disconnect();
    }

    protected void inspectOSRootAndSoftware(DFFormat.InspectionSysType sysType, String host
            , PriorityQueue<Float> rootUsage
            , PriorityQueue<Float> webLogicUsage, String user
            , String password, int port) throws Exception{

        HostConnector.connect(user, password, host, port);

        String mountedSysCmd = DFFormat.getMountedSysCmd(sysType);
        String usageCmd = DFFormat.getUsageCmd(sysType);

        String strSysNames = HostConnector.executeCommand(mountedSysCmd);
        String strUsages = HostConnector.executeCommand(usageCmd);

        String[] sysNames = parseSysNames(strSysNames);
        Float[] usages = parseUsages(strUsages);
        if(sysNames.length != usages.length){
            HostConnector.disconnect();
            throw new Exception("Unexpected result of parsing df -h");
        }

        for(int i=0; i<sysNames.length; i++){
            if(sysNames[i].equals(getRootDirectory())){
                rootUsage.add(usages[i]);
            }else if(sysNames[i].equals(getSoftwareDirectory())){
                webLogicUsage.add(usages[i]);
            }
        }

        HostConnector.disconnect();
    }

    protected void inspectAllDirectory(DFFormat.InspectionSysType sysType, String host
            , PriorityQueue<Float> rootUsage
            , PriorityQueue<Float> u01Usage
            , PriorityQueue<Float> goldenUsage
            , String user, String password, int port) throws Exception{

        HostConnector.connect(user, password, host, port);

        String mountedSysCmd = DFFormat.getMountedSysCmd(sysType);
        String usageCmd = DFFormat.getUsageCmd(sysType);

        String strSysNames = HostConnector.executeCommand(mountedSysCmd);
        String strUsages = HostConnector.executeCommand(usageCmd);

        String[] sysNames = parseSysNames(strSysNames);
        Float[] usages = parseUsages(strUsages);
        if(sysNames.length != usages.length){
            HostConnector.disconnect();
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

        HostConnector.disconnect();
    }

    protected String[] parseSysNames(String strSysNames){
        String[] sysNames = strSysNames.split("\n");
        return Arrays.copyOfRange(sysNames, 1, sysNames.length);
    }

    protected Float[] parseUsages(String strUsage){
        String[] strUsages = strUsage.split("[%\n]+");
        if(strUsages.length <= 1){
            return new Float[0];
        }

        Float[] usages = new Float[strUsages.length-1];

        for(int i=0; i < strUsages.length-1; i++){
            if(strUsages[i+1].equals("-")){
                usages[i] = (float)DBConfig.getDefaultNumericNullValue();
            }else{
                usages[i] = Float.valueOf(strUsages[i+1]);
            }
        }
        return usages;
    }

    protected static Comparator<Float> comparator = new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return (int)(o2-o1);
        }
    };
}
