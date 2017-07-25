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

public class Sheet421CoreCollector extends AbstractSheet421Collector{

    @Override
    protected String getRootDirectory() {
        return Sheet421CoreConfig.getRootDirectory();
    }

    @Override
    protected String getSoftwareDirectory() {
        return Sheet421CoreConfig.getSoftwareDirectory();
    }

    @Override
    protected String getSoftwareGgsDirectory() {
        return Sheet421CoreConfig.getSoftwareGgsDirectory();
    }

    public void inspect() throws Exception{
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
    @Override
    protected String[] getInspectHosts2() {
        return Sheet421CoreConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet421CoreConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet421CoreConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet421CoreConfig.getPorts2();
    }

    //个税查询库 3 以及 分发库 5
    private void inspect35(Sheet421CoreModel sheet421Model) throws Exception{
        final String[] inspectedHosts = Sheet421CoreConfig.getInspectedHosts35();
        final String[] users = Sheet421CoreConfig.getUsers35();
        final String[] passwords = Sheet421CoreConfig.getPasswords35();
        final int[] ports = Sheet421CoreConfig.getPorts35();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectOSRootAndSoftware(inspectedHosts[i], rootUsage, u01Usage
                    , users[i], passwords[i], ports[i]);
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
    private void inspect4(Sheet421CoreModel sheet421Model) throws Exception{
        final String[] inspectedHosts = Sheet421CoreConfig.getInspectedHosts4();
        final String[] users = Sheet421CoreConfig.getUsers4();
        final String[] passwords = Sheet421CoreConfig.getPasswords4();
        final int[] ports = Sheet421CoreConfig.getPorts4();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> goldengateUsage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectAllDirectory(inspectedHosts[i], rootUsage, u01Usage
                    , goldengateUsage, users[i], passwords[i], ports[i]);
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
}
