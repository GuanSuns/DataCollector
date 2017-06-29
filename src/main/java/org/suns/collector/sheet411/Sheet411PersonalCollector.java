package org.suns.collector.sheet411;

import org.suns.config.DBConfig;
import org.suns.config.DFFormat;
import org.suns.config.sheet411.Sheet411PersonalConfig;
import org.suns.connector.HostConnector;
import org.suns.controller.Sheet411Controller;
import org.suns.model.Sheet411PersonalModel;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411PersonalCollector {

    public static void inspect() throws Exception{
        Sheet411PersonalModel sheet411Model = new Sheet411PersonalModel();
        inspect2(sheet411Model);
        inspect3(sheet411Model);
        inspect45(sheet411Model);
        sheet411Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet411Controller.addPersonal(sheet411Model)){
            throw new Exception("Fail to add Sheet 411 personal model to database");
        }
    }

    //个税大厅 2
    private static void inspect2(Sheet411PersonalModel sheet411Model) throws Exception{
        final String[] inspectedHosts = Sheet411PersonalConfig.getInspectedHosts2();
        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(String host : inspectedHosts){
            inspectHost(host, rootUsage, webLogicUsage);
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

    //个税核心 3
    private static void inspect3(Sheet411PersonalModel sheet411Model) throws Exception{
        final String[] inspectedHosts = Sheet411PersonalConfig.getInspectedHosts3();
        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(String host : inspectedHosts){
            inspectHost(host, rootUsage, webLogicUsage);
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

    //个税查询统计 4 以及 个税工作流 5
    private static void inspect45(Sheet411PersonalModel sheet411Model) throws Exception{
        final String[] inspectedHosts = Sheet411PersonalConfig.getInspectedHosts45();
        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(String host : inspectedHosts){
            inspectHost(host, rootUsage, webLogicUsage);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            //Fill two cells with identical content
            sheet411Model.setUsage4(maxRootUsage);
            sheet411Model.setUsage5(maxRootUsage);
        }else{
            sheet411Model.setUsage4((float) DBConfig.getDefaultNumericNullValue());
            sheet411Model.setUsage5((float)DBConfig.getDefaultNumericNullValue());
        }

        if(!webLogicUsage.isEmpty()){
            Float maxWebLogicUsage = webLogicUsage.poll();
            //Fill two cells with identical content
            sheet411Model.setWeblogicUsage4(maxWebLogicUsage);
            sheet411Model.setWeblogicUsage5(maxWebLogicUsage);
        }else{
            sheet411Model.setWeblogicUsage4((float)DBConfig.getDefaultNumericNullValue());
            sheet411Model.setWeblogicUsage5((float)DBConfig.getDefaultNumericNullValue());
        }
    }

    private static void inspectHost(String host, PriorityQueue<Float> rootUsage
            , PriorityQueue<Float> webLogicUsage) throws Exception{

        HostConnector.connect(Sheet411PersonalConfig.getUser()
                , Sheet411PersonalConfig.getPassword()
                , host, Sheet411PersonalConfig.getPort());

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
            if(sysNames[i].equals(Sheet411PersonalConfig.getRootDirectory())){
                rootUsage.add(usages[i]);
            }else if(sysNames[i].equals(Sheet411PersonalConfig.getSoftwareDirectory())){
                webLogicUsage.add(usages[i]);
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
