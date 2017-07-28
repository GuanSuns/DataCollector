package org.suns.data.collector.collectors.sheet428;

import org.suns.data.collector.config.sheet428.Sheet428CoreConfig;
import org.suns.database.utils.controller.Sheet428Controller;
import org.suns.database.utils.model.Sheet428CoreModel;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 7/1/2017.
 */
public class Sheet428CoreCollector extends AbstractSheet428Collector{

    @Override
    protected String getObtainTimeCmd() {
        return Sheet428CoreConfig.getTimeCmd();
    }

    @Override
    protected long getTimeDiffTolerance() {
        return Sheet428CoreConfig.getDiffTolerance();
    }

    @Override
    protected String getCorrectReport() {
        return Sheet428CoreConfig.getCorrectReport();
    }
    
    public void inspect() throws Exception{
        Sheet428CoreModel sheet428Model = new Sheet428CoreModel();

        long timeServerDiff = getHostTimeDiff(Sheet428CoreConfig.getTimeServer()
                , Sheet428CoreConfig.getUsersTimeServer()[0]
                , Sheet428CoreConfig.getPasswordsTimeServer()[0]
                , Sheet428CoreConfig.getPortsTimeServer()[0]);

        inspect1(sheet428Model, timeServerDiff);
        inspect2(sheet428Model, timeServerDiff);
        inspect34(sheet428Model, timeServerDiff);
        sheet428Model.setStatus5("");
        sheet428Model.setDate(new Timestamp(new Date().getTime()));

        if(!Sheet428Controller.addCore(sheet428Model)){
            throw new Exception("Fail to add Sheet 428 Core model to database");
        }
    }

    private void inspect1(Sheet428CoreModel sheet428
            , long timeServerDiff) throws Exception{

        inspectHostById(HostsId.HOST1, timeServerDiff, sheet428);
    }

    private void inspect2(Sheet428CoreModel sheet428
            , long timeServerDiff) throws Exception{

        inspectHostById(HostsId.HOST2, timeServerDiff, sheet428);
    }

    private void inspect34(Sheet428CoreModel sheet428
            , long timeServerDiff) throws Exception{

        inspectHostById(HostsId.HOST3, timeServerDiff, sheet428);
        setStatusById(HostsId.HOST4, sheet428, sheet428.getStatus3());
    }

    @Override
    protected String[] getInspectHosts1() {
        return Sheet428CoreConfig.getInspectedHosts1();
    }

    @Override
    protected String[] getPasswords1() {
        return Sheet428CoreConfig.getPasswords1();
    }

    @Override
    protected String[] getUsers1() {
        return Sheet428CoreConfig.getUsers1();
    }

    @Override
    protected int[] getPorts1() {
        return Sheet428CoreConfig.getPorts1();
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet428CoreConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet428CoreConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet428CoreConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet428CoreConfig.getPorts2();
    }

    @Override
    protected String[] getInspectHosts3() {
        return Sheet428CoreConfig.getInspectedHosts34();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet428CoreConfig.getPasswords34();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet428CoreConfig.getUsers34();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet428CoreConfig.getPorts34();
    }

    @Override
    protected String[] getInspectHosts4() {
        return Sheet428CoreConfig.getInspectedHosts34();
    }

    @Override
    protected String[] getPasswords4() {
        return Sheet428CoreConfig.getPasswords34();
    }

    @Override
    protected String[] getUsers4() {
        return Sheet428CoreConfig.getUsers34();
    }

    @Override
    protected int[] getPorts4() {
        return Sheet428CoreConfig.getPorts34();
    }
}
