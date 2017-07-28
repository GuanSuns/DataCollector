package org.suns.data.collector.collectors.sheet426;

import org.suns.data.collector.collectors.AbstractDataCollector;
import org.suns.data.collector.config.sheet426.Sheet426CoreConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.controller.Sheet426Controller;
import org.suns.database.utils.model.Sheet426CoreModel;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426CoreCollector extends AbstractSheet426Collector{

    @Override
    protected String[] getLogPaths(HostsId hostsId) {
        switch (hostsId){
            case HOST2:
                return Sheet426CoreConfig.getLogPath2();
            case HOST3:
                return Sheet426CoreConfig.getLogPath3();
            case HOST4:
                return Sheet426CoreConfig.getLogPath4();
            default:
                return new String[0];
        }
    }

    @Override
    protected String getORACmdByLogPath(String logPath) {
        return Sheet426CoreConfig.getORADetectionCmd(logPath);
    }

    @Override
    protected String getLogCmdByLogPath(String logPath) {
        return Sheet426CoreConfig.getLogCmd(logPath);
    }

    public void inspect() throws Exception{
        Sheet426CoreModel sheet426Model = new Sheet426CoreModel();
        inspect2(sheet426Model);
        inspect3(sheet426Model);
        inspect4(sheet426Model);
        sheet426Model.setDate((new Timestamp(new Date().getTime())));

        if(!Sheet426Controller.addCore(sheet426Model)){
            throw new Exception("Fail to add Sheet 426 Core model to database");
        }

    }

    private void inspect2(Sheet426CoreModel sheet426Model) throws Exception{
        inspectHostById(HostsId.HOST2, LogType.LOG20, sheet426Model);
        inspectHostById(HostsId.HOST2, LogType.LOG21, sheet426Model);
    }

    private void inspect3(Sheet426CoreModel sheet426Model) throws Exception{
        inspectHostById(HostsId.HOST3, LogType.LOG3, sheet426Model);
    }

    private void inspect4(Sheet426CoreModel sheet426Model) throws Exception{
        inspectHostById(HostsId.HOST4, LogType.LOG40, sheet426Model);
        inspectHostById(HostsId.HOST4, LogType.LOG41, sheet426Model);
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet426CoreConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet426CoreConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet426CoreConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet426CoreConfig.getPorts2();
    }

    @Override
    protected String[] getInspectHosts3() {
        return Sheet426CoreConfig.getInspectedHosts3();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet426CoreConfig.getPasswords3();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet426CoreConfig.getUsers3();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet426CoreConfig.getPorts3();
    }

    @Override
    protected String[] getInspectHosts4() {
        return Sheet426CoreConfig.getInspectedHosts4();
    }

    @Override
    protected String[] getPasswords4() {
        return Sheet426CoreConfig.getPasswords4();
    }

    @Override
    protected String[] getUsers4() {
        return Sheet426CoreConfig.getUsers4();
    }

    @Override
    protected int[] getPorts4() {
        return Sheet426CoreConfig.getPorts4();
    }
}
