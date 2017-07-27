package org.suns.data.collector.collectors.sheet411;

import org.suns.data.collector.config.sheet411.Sheet411CoreConfig;
import org.suns.database.utils.config.DBConfig;
import org.suns.data.collector.config.sheet411.Sheet411PersonalConfig;
import org.suns.database.utils.controller.Sheet411Controller;
import org.suns.database.utils.model.Sheet411PersonalModel;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411PersonalCollector extends AbstractSheet411Collector{

    public void inspect() throws Exception{
        Sheet411PersonalModel sheet411Model = new Sheet411PersonalModel();
        inspect2(sheet411Model);
        inspect3(sheet411Model);
        inspect45(sheet411Model);
        sheet411Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet411Controller.addPersonal(sheet411Model)){
            throw new Exception("Fail to add Sheet 411 personal model to database");
        }
    }

    @Override
    protected String getRootDirectory() {
        return Sheet411PersonalConfig.getRootDirectory();
    }

    @Override
    protected String getSoftwareDirectory() {
        return Sheet411CoreConfig.getSoftwareDirectory();
    }

    //个税大厅 2
    private void inspect2(Sheet411PersonalModel sheet411Model) throws Exception{
        inspectHostID(sheet411Model, HostsId.HOST2);
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet411PersonalConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet411PersonalConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet411PersonalConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet411PersonalConfig.getPorts2();
    }

    //个税核心 3
    private void inspect3(Sheet411PersonalModel sheet411Model) throws Exception{
        inspectHostID(sheet411Model, HostsId.HOST3);
    }
    
    @Override
    protected String[] getInspectHosts3() {
        return Sheet411PersonalConfig.getInspectedHosts3();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet411PersonalConfig.getPasswords3();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet411PersonalConfig.getUsers3();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet411PersonalConfig.getPorts3();
    }

    //个税查询统计 4 以及 个税工作流 5
    private void inspect45(Sheet411PersonalModel sheet411Model) throws Exception{
        inspectHostID(sheet411Model, HostsId.HOST4);
        setUsage(sheet411Model, HostsId.HOST5, sheet411Model.getUsage4());
        setWeblogicUsage(sheet411Model, HostsId.HOST5, sheet411Model.getWeblogicUsage4());
    }

    @Override
    protected String[] getInspectHosts4() {
        return Sheet411PersonalConfig.getInspectedHosts45();
    }

    @Override
    protected String[] getPasswords4() {
        return Sheet411PersonalConfig.getPasswords45();
    }

    @Override
    protected String[] getUsers4() {
        return Sheet411PersonalConfig.getUsers45();
    }

    @Override
    protected int[] getPorts4() {
        return Sheet411PersonalConfig.getPorts45();
    }

    @Override
    protected String[] getInspectHosts5() {
        return Sheet411PersonalConfig.getInspectedHosts45();
    }

    @Override
    protected String[] getPasswords5() {
        return Sheet411PersonalConfig.getPasswords45();
    }

    @Override
    protected String[] getUsers5() {
        return Sheet411PersonalConfig.getUsers45();
    }

    @Override
    protected int[] getPorts5() {
        return Sheet411PersonalConfig.getPorts45();
    }
}
