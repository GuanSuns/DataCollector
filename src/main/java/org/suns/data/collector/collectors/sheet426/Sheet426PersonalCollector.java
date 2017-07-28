package org.suns.data.collector.collectors.sheet426;

import org.suns.data.collector.collectors.AbstractDataCollector;
import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.config.sheet426.Sheet426PersonalConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.config.Sheet426Config;
import org.suns.database.utils.controller.Sheet426Controller;
import org.suns.database.utils.model.Sheet426PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426PersonalCollector extends AbstractSheet426Collector{
    @Override
    protected String[] getLogPaths(HostsId hostsId) {
        switch (hostsId){
            case HOST2:
                return Sheet426PersonalConfig.getLogPath2();
            default:
                return new String[0];
        }
    }

    @Override
    protected String getORACmdByLogPath(String logPath) {
        return Sheet426PersonalConfig.getORADetectionCmd(logPath);
    }

    @Override
    protected String getLogCmdByLogPath(String logPath) {
        return Sheet426PersonalConfig.getLogCmd(logPath);
    }

    public void inspect() throws Exception{
        Sheet426PersonalModel sheet426Model = new Sheet426PersonalModel();
        inspect2(sheet426Model);
        sheet426Model.setDate((new Timestamp(new Date().getTime())));

        if(!Sheet426Controller.addPersonal(sheet426Model)){
            throw new Exception("Fail to add Sheet 426 personal model to database");
        }

    }

    private void inspect2(Sheet426PersonalModel sheet426Model) throws Exception{
        inspectHostById(HostsId.HOST2, LogType.LOG20, sheet426Model);
        inspectHostById(HostsId.HOST2, LogType.LOG21, sheet426Model);
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet426PersonalConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet426PersonalConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet426PersonalConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet426PersonalConfig.getPorts2();
    }
}
