package org.suns.data.collector.collectors.sheet428;

import org.suns.data.collector.config.sheet428.Sheet428PersonalConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.controller.Sheet428Controller;
import org.suns.database.utils.model.Sheet428PersonalModel;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 时钟同步检查 **/
public class Sheet428PersonalCollector extends AbstractSheet428Collector{

    @Override
    protected String getObtainTimeCmd() {
        return Sheet428PersonalConfig.getTimeCmd();
    }

    @Override
    protected long getTimeDiffTolerance() {
        return Sheet428PersonalConfig.getDiffTolerance();
    }

    @Override
    protected String getCorrectReport() {
        return Sheet428PersonalConfig.getCorrectReport();
    }

    public void inspect() throws Exception{
        Sheet428PersonalModel sheet428Model = new Sheet428PersonalModel();

        long timeServerDiff = getHostTimeDiff(Sheet428PersonalConfig.getTimeServer()
                , Sheet428PersonalConfig.getUsersTimeServer()[0]
                , Sheet428PersonalConfig.getPasswordsTimeServer()[0]
                , Sheet428PersonalConfig.getPortsTimeServer()[0]);

        inspect1(sheet428Model, timeServerDiff);
        inspect2(sheet428Model, timeServerDiff);
        inspect3(sheet428Model, timeServerDiff);
        inspect4(sheet428Model, timeServerDiff);
        sheet428Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet428Controller.addPersonal(sheet428Model)){
            throw new Exception("Fail to add Sheet 428 personal model to database");
        }
    }

    private void inspect1(Sheet428PersonalModel sheet428
            , long timeServerDiff) throws Exception{
        inspectHostById(HostsId.HOST1, timeServerDiff, sheet428);
    }

    private void inspect2(Sheet428PersonalModel sheet428
            , long timeServerDiff) throws Exception{
        inspectHostById(HostsId.HOST2, timeServerDiff, sheet428);
    }

    private void inspect3(Sheet428PersonalModel sheet428
            , long timeServerDiff) throws Exception{
        inspectHostById(HostsId.HOST3, timeServerDiff, sheet428);
    }

    private void inspect4(Sheet428PersonalModel sheet428
            , long timeServerDiff) throws Exception{
        inspectHostById(HostsId.HOST4, timeServerDiff, sheet428);
    }

    @Override
    protected String[] getInspectHosts1() {
        return Sheet428PersonalConfig.getInspectedHosts1();
    }

    @Override
    protected String[] getPasswords1() {
        return Sheet428PersonalConfig.getPasswords1();
    }

    @Override
    protected String[] getUsers1() {
        return Sheet428PersonalConfig.getUsers1();
    }

    @Override
    protected int[] getPorts1() {
        return Sheet428PersonalConfig.getPorts1();
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet428PersonalConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet428PersonalConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet428PersonalConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet428PersonalConfig.getPorts2();
    }

    @Override
    protected String[] getInspectHosts3() {
        return Sheet428PersonalConfig.getInspectedHosts3();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet428PersonalConfig.getPasswords3();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet428PersonalConfig.getUsers3();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet428PersonalConfig.getPorts3();
    }

    @Override
    protected String[] getInspectHosts4() {
        return Sheet428PersonalConfig.getInspectedHosts4();
    }

    @Override
    protected String[] getPasswords4() {
        return Sheet428PersonalConfig.getPasswords4();
    }

    @Override
    protected String[] getUsers4() {
        return Sheet428PersonalConfig.getUsers4();
    }

    @Override
    protected int[] getPorts4() {
        return Sheet428PersonalConfig.getPorts4();
    }
}
