package org.suns.data.collector.collectors.sheet421;

import org.suns.data.collector.config.sheet421.Sheet421PersonalConfig;
import org.suns.database.utils.controller.Sheet421Controller;
import org.suns.database.utils.model.Sheet421PersonalModel;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Timestamp;
import java.util.Date;

/** 数据库OS文件系统目录使用率 **/
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

        InspectionLogger.debug("Finish inspecting personal 421 - " + sheet421Model.toString());


        if(!Sheet421Controller.addPersonal(sheet421Model)){
            throw new Exception("Fail to add Sheet 421 personal model to database");
        }
    }

    //个税核心库 2
    private void inspect2(Sheet421PersonalModel sheet421Model) throws Exception{
        inspectAllDirectoryByHostID(sheet421Model, HostsId.HOST2);
    }

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
        inspectRootAndSoftwareDirectoryByHostId(sheet421Model, HostsId.HOST3);
    }

    @Override
    protected String[] getInspectHosts3() {
        return Sheet421PersonalConfig.getInspectedHosts3();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet421PersonalConfig.getPasswords3();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet421PersonalConfig.getUsers3();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet421PersonalConfig.getPorts3();
    }
}
