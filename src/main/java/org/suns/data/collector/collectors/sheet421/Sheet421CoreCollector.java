package org.suns.data.collector.collectors.sheet421;

import org.suns.database.utils.config.DBConfig;
import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.config.sheet412.Sheet421CoreConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.controller.Sheet421Controller;
import org.suns.database.utils.model.Sheet421CoreModel;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * Created by guanl on 6/29/2017.
 */

public class Sheet421CoreCollector {
    
    public static void inspect() throws Exception{
        Sheet421CoreModel sheet421Model = new Sheet421CoreModel();
        inspect2(sheet421Model);
        inspect35(sheet421Model);
        inspect4(sheet421Model);

        sheet421Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet421Controller.addCore(sheet421Model)){
            throw new Exception("Fail to add Sheet 421 Core model to database");
        }
    }

    //个税核心库 2
    private static void inspect2(Sheet421CoreModel sheet421Model) throws Exception{
        final String[] inspectedHosts = Sheet421CoreConfig.getInspectedHosts2();
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

    //个税查询库 3 以及 分发库 5
    private static void inspect35(Sheet421CoreModel sheet421Model) throws Exception{
        final String[] inspectedHosts = Sheet421CoreConfig.getInspectedHosts35();
        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);

        for(String host : inspectedHosts){
            inspectUsageAndU01(host, rootUsage, u01Usage);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet421Model.setUsage3(maxRootUsage);
            sheet421Model.setUsage5(maxRootUsage);
        }else{
            sheet421Model.setUsage3((float) DBConfig.getDefaultNumericNullValue());
            sheet421Model.setUsage5((float) DBConfig.getDefaultNumericNullValue());
        }

        if(!u01Usage.isEmpty()){
            Float maxU01Usage = u01Usage.poll();
            sheet421Model.setU01Usage3(maxU01Usage);
            sheet421Model.setU01Usage5(maxU01Usage);
        }else{
            sheet421Model.setU01Usage3((float) DBConfig.getDefaultNumericNullValue());
            sheet421Model.setU01Usage5((float) DBConfig.getDefaultNumericNullValue());
        }
    }

    //集成平台库 4
    private static void inspect4(Sheet421CoreModel sheet421Model) throws Exception{
        final String[] inspectedHosts = Sheet421CoreConfig.getInspectedHosts4();
        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> goldengateUsage = new PriorityQueue<>(comparator);

        for(String host : inspectedHosts){
            inspectAllDirectory(host, rootUsage, u01Usage, goldengateUsage);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet421Model.setUsage4(maxRootUsage);
        }else{
            sheet421Model.setUsage4((float) DBConfig.getDefaultNumericNullValue());
        }

        if(!u01Usage.isEmpty()){
            Float maxU01Usage = u01Usage.poll();
            sheet421Model.setU01Usage4(maxU01Usage);
        }else{
            sheet421Model.setU01Usage4((float) DBConfig.getDefaultNumericNullValue());
        }

        if(!goldengateUsage.isEmpty()){
            Float maxGoldenUsage = goldengateUsage.poll();
            sheet421Model.setGoldUsage4(maxGoldenUsage);
        }else{
            sheet421Model.setGoldUsage4((float) DBConfig.getDefaultNumericNullValue());
        }
    }

    private static void inspectUsageAndU01(String host
            , PriorityQueue<Float> rootUsage
            , PriorityQueue<Float> u01Usage) throws Exception{

        HostConnector.connect(Sheet421CoreConfig.getUser()
                , Sheet421CoreConfig.getPassword()
                , host, Sheet421CoreConfig.getPort());

        String mountedSysCmd = DFFormat.getMountedSysCmd();
        String usageCmd = DFFormat.getUsageCmd();
        String strSysNames = HostConnector.executeCommand(mountedSysCmd);
        String strUsages = HostConnector.executeCommand(usageCmd);

        String[] sysNames = parseSysNames(strSysNames);
        Float[] usages = parseUsages(strUsages);
        if(sysNames.length != usages.length){
            HostConnector.disconnect();
            throw new Exception("Unexpected result of parsing df -h");
        }

        for(int i=0; i<sysNames.length; i++){
            if(sysNames[i].equals(Sheet421CoreConfig.getRootDirectory())){
                rootUsage.add(usages[i]);
            }else if(sysNames[i].equals(Sheet421CoreConfig.getSoftwareDirectory())){
                u01Usage.add(usages[i]);
            }
        }

        HostConnector.disconnect();
    }

    private static void inspectAllDirectory(String host
            , PriorityQueue<Float> rootUsage
            , PriorityQueue<Float> u01Usage
            , PriorityQueue<Float> goldenUsage) throws Exception{

        HostConnector.connect(Sheet421CoreConfig.getUser()
                , Sheet421CoreConfig.getPassword()
                , host, Sheet421CoreConfig.getPort());

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
            if(sysNames[i].equals(Sheet421CoreConfig.getRootDirectory())){
                rootUsage.add(usages[i]);
            }else if(sysNames[i].equals(Sheet421CoreConfig.getSoftwareDirectory())){
                u01Usage.add(usages[i]);
            }else if(sysNames[i].equals(Sheet421CoreConfig.getSoftwareGgsDirectory())){
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
