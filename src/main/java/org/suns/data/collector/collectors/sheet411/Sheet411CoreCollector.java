package org.suns.data.collector.collectors.sheet411;

import org.suns.database.utils.config.DBConfig;
import org.suns.data.collector.config.sheet411.Sheet411CoreConfig;
import org.suns.database.utils.controller.Sheet411Controller;
import org.suns.database.utils.model.Sheet411CoreModel;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Timestamp;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet411CoreCollector extends AbstractSheet411Collector{
    public void inspect() throws Exception{
        Sheet411CoreModel sheet411Model = new Sheet411CoreModel();
        inspect2(sheet411Model);
        inspect3(sheet411Model);
        inspect4(sheet411Model);
        inspect5(sheet411Model);
        inspect6(sheet411Model);
        inspect8(sheet411Model);
        sheet411Model.setDate(new Timestamp(new Date().getTime()));

        InspectionLogger.debug(" Finish inspecting core Sheet 411 - " + sheet411Model.toString());

        if(!Sheet411Controller.addCore(sheet411Model)){
            throw new Exception("Fail to add Sheet 411 Core model to database");
        }
    }

    @Override
    protected String getRootDirectory() {
        return Sheet411CoreConfig.getRootDirectory();
    }

    @Override
    protected String getSoftwareDirectory() {
        return Sheet411CoreConfig.getSoftwareDirectory();
    }

    //核心前端 2
    private void inspect2(Sheet411CoreModel sheet411Model) throws Exception{
        inspectHostID(sheet411Model, HostsId.HOST2);
    }
    
    @Override
    protected String[] getInspectHosts2() {
        return Sheet411CoreConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet411CoreConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet411CoreConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet411CoreConfig.getPorts2();
    }

    //核心后端 3
    private void inspect3(Sheet411CoreModel sheet411Model) throws Exception{
        inspectHostID(sheet411Model, HostsId.HOST3);
    }
    
    @Override
    protected String[] getInspectHosts3() {
        return Sheet411CoreConfig.getInspectedHosts3();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet411CoreConfig.getPasswords3();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet411CoreConfig.getUsers3();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet411CoreConfig.getPorts3();
    }

    //通用查询 4
    private void inspect4(Sheet411CoreModel sheet411Model) throws Exception{
        inspectHostID(sheet411Model, HostsId.HOST4);
    }

    @Override
    protected String[] getInspectHosts4() {
        return Sheet411CoreConfig.getInspectedHosts4();
    }

    @Override
    protected String[] getPasswords4() {
        return Sheet411CoreConfig.getPasswords4();
    }

    @Override
    protected String[] getUsers4() {
        return Sheet411CoreConfig.getUsers4();
    }

    @Override
    protected int[] getPorts4() {
        return Sheet411CoreConfig.getPorts4();
    }

    //web门户 5
    private void inspect5(Sheet411CoreModel sheet411Model) throws Exception{
        inspectHostID(sheet411Model, HostsId.HOST5);
    }

    @Override
    protected String[] getInspectHosts5() {
        return Sheet411CoreConfig.getInspectedHosts5();
    }

    @Override
    protected String[] getPasswords5() {
        return Sheet411CoreConfig.getPasswords5();
    }

    @Override
    protected String[] getUsers5() {
        return Sheet411CoreConfig.getUsers5();
    }

    @Override
    protected int[] getPorts5() {
        return Sheet411CoreConfig.getPorts5();
    }

    //核心工作 6
    private void inspect6(Sheet411CoreModel sheet411Model) throws Exception{
        inspectHostID(sheet411Model, HostsId.HOST6);
    }

    @Override
    protected String[] getInspectHosts6() {
        return Sheet411CoreConfig.getInspectedHosts6();
    }

    @Override
    protected String[] getPasswords6() {
        return Sheet411CoreConfig.getPasswords6();
    }

    @Override
    protected String[] getUsers6() {
        return Sheet411CoreConfig.getUsers6();
    }

    @Override
    protected int[] getPorts6() {
        return Sheet411CoreConfig.getPorts6();
    }

    //跨层平台 8
    private void inspect8(Sheet411CoreModel sheet411Model) throws Exception{
        inspectHostID(sheet411Model, HostsId.HOST8);
    }

    @Override
    protected String[] getInspectHosts8() {
        return Sheet411CoreConfig.getInspectedHosts8();
    }

    @Override
    protected String[] getPasswords8() {
        return Sheet411CoreConfig.getPasswords8();
    }

    @Override
    protected String[] getUsers8() {
        return Sheet411CoreConfig.getUsers8();
    }

    @Override
    protected int[] getPorts8() {
        return Sheet411CoreConfig.getPorts8();
    }
}
