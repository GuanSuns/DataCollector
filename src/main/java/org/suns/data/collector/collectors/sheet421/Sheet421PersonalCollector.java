package org.suns.data.collector.collectors.sheet421;

import org.suns.database.utils.config.DBConfig;
import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.config.sheet412.Sheet421PersonalConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.controller.Sheet421Controller;
import org.suns.database.utils.model.Sheet421PersonalModel;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421PersonalCollector extends AbstractSheet421Collector{

    @Override
    protected String getRootDirectory() {
        return Sheet421PersonalConfig.getRootDirectory();
    }

    @Override
    protected String getSoftwareDirectory() {
        return Sheet421PersonalConfig.getSoftwareDirectory();
    }

    @Override
    protected String getSoftwareGgsDirectory() {
        return Sheet421PersonalConfig.getSoftwareGgsDirectory();
    }

    public void inspect() throws Exception{
        Sheet421PersonalModel sheet421Model = new Sheet421PersonalModel();
        inspect2(sheet421Model);
        inspect3(sheet421Model);
        sheet421Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet421Controller.addPersonal(sheet421Model)){
            throw new Exception("Fail to add Sheet 421 personal model to database");
        }
    }

    //个税核心库 2
    @Override
    protected String[] getInspectHosts2() {
        return Sheet421PersonalConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet421PersonalConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet421PersonalConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet421PersonalConfig.getPorts2();
    }

    //个税查询库 3
    private void inspect3(Sheet421PersonalModel sheet421Model) throws Exception{
        final String[] inspectedHosts = Sheet421PersonalConfig.getInspectedHosts3();
        final String[] users = Sheet421PersonalConfig.getUsers3();
        final String[] passwords = Sheet421PersonalConfig.getPasswords3();
        final int[] ports = Sheet421PersonalConfig.getPorts3();

        PriorityQueue<Float> rootUsage = new PriorityQueue<>(comparator);
        PriorityQueue<Float> u01Usage = new PriorityQueue<>(comparator);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectOSRootAndSoftware(inspectedHosts[i], rootUsage, u01Usage
                    , users[i], passwords[i], ports[i]);
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

    
}
