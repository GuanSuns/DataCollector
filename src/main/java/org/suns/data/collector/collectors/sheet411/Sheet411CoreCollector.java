package org.suns.data.collector.collectors.sheet411;

import org.suns.database.utils.config.DBConfig;
import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.config.sheet411.Sheet411CoreConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.controller.Sheet411Controller;
import org.suns.database.utils.model.Sheet411CoreModel;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet411CoreCollector {
    public static void inspect() throws Exception{
        Sheet411CoreModel sheet411Model = new Sheet411CoreModel();
        inspect2(sheet411Model);
        inspect3(sheet411Model);
        inspect4(sheet411Model);
        inspect5(sheet411Model);
        inspect6(sheet411Model);
        inspect8(sheet411Model);
        sheet411Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet411Controller.addCore(sheet411Model)){
            throw new Exception("Fail to add Sheet 411 Core model to database");
        }
    }

    //核心前端 2
    private static void inspect2(Sheet411CoreModel sheet411Model) throws Exception{
        final String[] inspectedHosts = Sheet411CoreConfig.getInspectedHosts2();
        final String[] users = Sheet411CoreConfig.getUsers2();
        final String[] passwords = Sheet411CoreConfig.getPasswords2();
        final int[] ports = Sheet411CoreConfig.getPorts2();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectHost(inspectedHosts[i], rootUsage, webLogicUsage
                    , users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet411Model.setUsage2(maxRootUsage);
        }else{
            sheet411Model.setUsage2((float)DBConfig.getDefaultNumericNullValue());
        }

        if(!webLogicUsage.isEmpty()){
            Float maxWebLogicUsage = webLogicUsage.poll();
            sheet411Model.setWeblogicUsage2(maxWebLogicUsage);
        }else{
            sheet411Model.setWeblogicUsage2((float)DBConfig.getDefaultNumericNullValue());
        }
    }

    //核心后端 3
    private static void inspect3(Sheet411CoreModel sheet411Model) throws Exception{
        final String[] inspectedHosts = Sheet411CoreConfig.getInspectedHosts3();
        final String[] users = Sheet411CoreConfig.getUsers3();
        final String[] passwords = Sheet411CoreConfig.getPasswords3();
        final int[] ports = Sheet411CoreConfig.getPorts3();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectHost(inspectedHosts[i], rootUsage, webLogicUsage
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

    //通用查询 4
    private static void inspect4(Sheet411CoreModel sheet411Model) throws Exception{
        final String[] inspectedHosts = Sheet411CoreConfig.getInspectedHosts4();
        final String[] users = Sheet411CoreConfig.getUsers4();
        final String[] passwords = Sheet411CoreConfig.getPasswords4();
        final int[] ports = Sheet411CoreConfig.getPorts4();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectHost(inspectedHosts[i], rootUsage, webLogicUsage
                    , users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet411Model.setUsage4(maxRootUsage);
        }else{
            sheet411Model.setUsage4((float)DBConfig.getDefaultNumericNullValue());
        }

        if(!webLogicUsage.isEmpty()){
            Float maxWebLogicUsage = webLogicUsage.poll();
            sheet411Model.setWeblogicUsage4(maxWebLogicUsage);
        }else{
            sheet411Model.setWeblogicUsage4((float)DBConfig.getDefaultNumericNullValue());
        }
    }

    //web门户 5
    private static void inspect5(Sheet411CoreModel sheet411Model) throws Exception{
        final String[] inspectedHosts = Sheet411CoreConfig.getInspectedHosts5();
        final String[] users = Sheet411CoreConfig.getUsers5();
        final String[] passwords = Sheet411CoreConfig.getPasswords5();
        final int[] ports = Sheet411CoreConfig.getPorts5();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectHost(inspectedHosts[i], rootUsage, webLogicUsage
                    , users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet411Model.setUsage5(maxRootUsage);
        }else{
            sheet411Model.setUsage5((float)DBConfig.getDefaultNumericNullValue());
        }

        if(!webLogicUsage.isEmpty()){
            Float maxWebLogicUsage = webLogicUsage.poll();
            sheet411Model.setWeblogicUsage5(maxWebLogicUsage);
        }else{
            sheet411Model.setWeblogicUsage5((float)DBConfig.getDefaultNumericNullValue());
        }
    }

    //核心工作 6
    private static void inspect6(Sheet411CoreModel sheet411Model) throws Exception{
        final String[] inspectedHosts = Sheet411CoreConfig.getInspectedHosts6();
        final String[] users = Sheet411CoreConfig.getUsers6();
        final String[] passwords = Sheet411CoreConfig.getPasswords6();
        final int[] ports = Sheet411CoreConfig.getPorts6();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectHost(inspectedHosts[i], rootUsage, webLogicUsage
                    , users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet411Model.setUsage6(maxRootUsage);
        }else{
            sheet411Model.setUsage6((float) DBConfig.getDefaultNumericNullValue());
        }

        if(!webLogicUsage.isEmpty()){
            Float maxWebLogicUsage = webLogicUsage.poll();
            sheet411Model.setWeblogicUsage6(maxWebLogicUsage);
        }else{
            sheet411Model.setWeblogicUsage6((float)DBConfig.getDefaultNumericNullValue());
        }
    }

    //跨层平台 8
    private static void inspect8(Sheet411CoreModel sheet411Model) throws Exception{
        final String[] inspectedHosts = Sheet411CoreConfig.getInspectedHosts8();
        final String[] users = Sheet411CoreConfig.getUsers8();
        final String[] passwords = Sheet411CoreConfig.getPasswords8();
        final int[] ports = Sheet411CoreConfig.getPorts8();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> webLogicUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectHost(inspectedHosts[i], rootUsage, webLogicUsage
                    , users[i], passwords[i], ports[i]);
        }

        if(!rootUsage.isEmpty()){
            Float maxRootUsage = rootUsage.poll();
            sheet411Model.setUsage8(maxRootUsage);
        }else{
            sheet411Model.setUsage8((float)DBConfig.getDefaultNumericNullValue());
        }

        if(!webLogicUsage.isEmpty()){
            Float maxWebLogicUsage = webLogicUsage.poll();
            sheet411Model.setWeblogicUsage8(maxWebLogicUsage);
        }else{
            sheet411Model.setWeblogicUsage8((float)DBConfig.getDefaultNumericNullValue());
        }
    }

    private static void inspectHost(String host, PriorityQueue<Float> rootUsage
            , PriorityQueue<Float> webLogicUsage, String user
            , String password, int port) throws Exception{

        HostConnector.connect(user, password, host, port);

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
            if(sysNames[i].equals(Sheet411CoreConfig.getRootDirectory())){
                rootUsage.add(usages[i]);
            }else if(sysNames[i].equals(Sheet411CoreConfig.getSoftwareDirectory())){
                webLogicUsage.add(usages[i]);
            }
        }

        HostConnector.disconnect();
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

        for(int i=0; i < strUsages.length-1; i++){
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
