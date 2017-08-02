package org.suns.data.collector.collectors.sheet421;

import org.suns.data.collector.config.sheet412.Sheet421CoreConfig;
import org.suns.database.utils.controller.Sheet421Controller;
import org.suns.database.utils.model.Sheet421CoreModel;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Timestamp;
import java.util.Date;

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

        InspectionLogger.debug("Finish inspecting core 421 - " + sheet421Model.toString());

        if(!Sheet421Controller.addCore(sheet421Model)){
            throw new Exception("Fail to add Sheet 421 Core model to database");
        }
    }

    //个税核心库 2
    private void inspect2(Sheet421CoreModel sheet421Model) throws Exception{
        inspectAllDirectoryByHostID(sheet421Model, HostsId.HOST2);
    }
        
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
        inspectRootAndSoftwareDirectoryByHostId(sheet421Model, HostsId.HOST3);
        setUsage(sheet421Model, HostsId.HOST5, sheet421Model.getUsage3());
        setU01Usage(sheet421Model, HostsId.HOST5, sheet421Model.getU01Usage3());
    }

    @Override
    protected String[] getInspectHosts3() {
        return Sheet421CoreConfig.getInspectedHosts35();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet421CoreConfig.getPasswords35();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet421CoreConfig.getUsers35();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet421CoreConfig.getPorts35();
    }

    @Override
    protected String[] getInspectHosts5() {
        return Sheet421CoreConfig.getInspectedHosts35();
    }

    @Override
    protected String[] getPasswords5() {
        return Sheet421CoreConfig.getPasswords35();
    }

    @Override
    protected String[] getUsers5() {
        return Sheet421CoreConfig.getUsers35();
    }

    @Override
    protected int[] getPorts5() {
        return Sheet421CoreConfig.getPorts35();
    }

    //集成平台库 4
    private void inspect4(Sheet421CoreModel sheet421Model) throws Exception{
        inspectAllDirectoryByHostID(sheet421Model, HostsId.HOST4);
    }

    @Override
    protected String[] getInspectHosts4() {
        return Sheet421CoreConfig.getInspectedHosts4();
    }

    @Override
    protected String[] getPasswords4() {
        return Sheet421CoreConfig.getPasswords4();
    }

    @Override
    protected String[] getUsers4() {
        return Sheet421CoreConfig.getUsers4();
    }

    @Override
    protected int[] getPorts4() {
        return Sheet421CoreConfig.getPorts4();
    }
}
