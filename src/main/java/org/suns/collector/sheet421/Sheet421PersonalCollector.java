package org.suns.collector.sheet421;

import org.suns.config.DBConfig;
import org.suns.config.DFFormat;
import org.suns.config.Sheet421Config;
import org.suns.config.sheet411.Sheet411PersonalConfig;
import org.suns.config.sheet412.Sheet421PersonalConfig;
import org.suns.connector.HostConnector;
import org.suns.controller.Sheet411Controller;
import org.suns.controller.Sheet421Controller;
import org.suns.model.Sheet411PersonalModel;
import org.suns.model.Sheet421PersonalModel;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421PersonalCollector {

    public static void inspect() throws Exception{
        Sheet421PersonalModel sheet421Model = new Sheet421PersonalModel();
        inspect2(sheet421Model);
        inspect3(sheet421Model);
        sheet421Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet421Controller.addPersonal(sheet421Model)){
            throw new Exception("Fail to add Sheet 421 personal model to database");
        }
    }

    //个税核心库 2
    private static void inspect2(Sheet421PersonalModel sheet421Model) throws Exception{
        final String[] inspectedHosts = Sheet421PersonalConfig.getInspectedHosts2();
        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> goldengateUsage = new PriorityQueue<>(comparator);

        for(String host : inspectedHosts){
            inspectAllDirectory(host, rootUsage, u01Usage, goldengateUsage);
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

    //个税查询库 3
    private static void inspect3(Sheet421PersonalModel sheet421Model) throws Exception{
        final String[] inspectedHosts = Sheet421PersonalConfig.getInspectedHosts3();
        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);

        for(String host : inspectedHosts){
            inspectUsageAndU01(host, rootUsage, u01Usage);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet421Model.setUsage3(maxRootUsage);
        }else{
            sheet421Model.setUsage3((float) DBConfig.getDefaultNumericNullValue());
        }

        if(!u01Usage.isEmpty()){
            Float maxU01Usage = u01Usage.poll();
            sheet421Model.setU01Usage3(maxU01Usage);
        }else{
            sheet421Model.setU01Usage3((float) DBConfig.getDefaultNumericNullValue());
        }
    }

    private static void inspectUsageAndU01(String host
            , PriorityQueue<Float> rootUsage
            , PriorityQueue<Float> u01Usage) throws Exception{

        HostConnector.connect(Sheet421PersonalConfig.getUser()
                , Sheet421PersonalConfig.getPassword()
                , host, Sheet421PersonalConfig.getPort());

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
            if(sysNames[i].equals(Sheet421PersonalConfig.getRootDirectory())){
                rootUsage.add(usages[i]);
            }else if(sysNames[i].equals(Sheet421PersonalConfig.getSoftwareDirectory())){
                u01Usage.add(usages[i]);
            }
        }
    }

    private static void inspectAllDirectory(String host
            , PriorityQueue<Float> rootUsage
            , PriorityQueue<Float> u01Usage
            , PriorityQueue<Float> goldenUsage) throws Exception{

        HostConnector.connect(Sheet421PersonalConfig.getUser()
                , Sheet421PersonalConfig.getPassword()
                , host, Sheet421PersonalConfig.getPort());

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
            if(sysNames[i].equals(Sheet421PersonalConfig.getRootDirectory())){
                rootUsage.add(usages[i]);
            }else if(sysNames[i].equals(Sheet421PersonalConfig.getSoftwareDirectory())){
                u01Usage.add(usages[i]);
            }else if(sysNames[i].equals(Sheet421PersonalConfig.getSoftwareGgsDirectory())){
                goldenUsage.add(usages[i]);
            }
        }
    }

    private static String[] parseSysNames(String strSysNames){
        String[] sysNames = strSysNames.split("\n");
        return Arrays.copyOfRange(sysNames, 1, sysNames.length);
    }

    private static Float[] parseUsages(String strUsage){
        String[] strUsages = strUsage.split("[%\n]+");
        if(strUsages.length <= 1){
            return new Float[0];
        }

        Float[] usages = new Float[strUsages.length-1];

        for(int i=0; i<strUsages.length - 1; i++){
            usages[i] = Float.valueOf(strUsages[i+1]);
        }
        return usages;
    }

    private static Comparator<Float> comparator = new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return (int)(o2-o1);
        }
    };
}
