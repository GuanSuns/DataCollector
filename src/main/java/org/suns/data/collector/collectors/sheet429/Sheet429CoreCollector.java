package org.suns.data.collector.collectors.sheet429;

import org.suns.data.collector.config.sheet429.Sheet429CoreConfig;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.controller.Sheet429Controller;
import org.suns.database.utils.model.Sheet429CoreModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429CoreCollector extends AbstractSheet429Collector{

    @Override
    protected String getInspectSQL() {
        return Sheet429CoreConfig.getInspectSQL();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet429CoreConfig.getFieldNames();
    }

    public void inspect() throws Exception{
        Sheet429CoreModel sheet429Model = new Sheet429CoreModel();

        inspect1(sheet429Model);
        inspect2(sheet429Model);
        inspect3(sheet429Model);

        sheet429Model.setInspectTime(new Timestamp(new Date().getTime()));

        if(!Sheet429Controller.addCore(sheet429Model)){
            throw new Exception("Fail to add Sheet 429 Core model to database");
        }
    }

    private void inspect1(Sheet429CoreModel sheet429Model) throws Exception{
        inspectHostById(HostsId.HOST1, sheet429Model);
    }

    private void inspect2(Sheet429CoreModel sheet429Model) throws Exception{
        inspectHostById(HostsId.HOST2, sheet429Model);
    }

    private void inspect3(Sheet429CoreModel sheet429Model) throws Exception{
        inspectHostById(HostsId.HOST3, sheet429Model);
    }

    @Override
    protected String[] getSids1() {
        return Sheet429CoreConfig.getSid1();
    }

    @Override
    protected String[] getInspectHosts1() {
        return Sheet429CoreConfig.getInspectedHosts1();
    }

    @Override
    protected String[] getPasswords1() {
        return Sheet429CoreConfig.getPasswords1();
    }

    @Override
    protected String[] getUsers1() {
        return Sheet429CoreConfig.getUsers1();
    }

    @Override
    protected int[] getPorts1() {
        return Sheet429CoreConfig.getPorts1();
    }

    @Override
    protected String[] getSids2() {
        return Sheet429CoreConfig.getSid2();
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet429CoreConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet429CoreConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet429CoreConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet429CoreConfig.getPorts2();
    }

    @Override
    protected String[] getSids3() {
        return Sheet429CoreConfig.getSid3();
    }

    @Override
    protected String[] getInspectHosts3() {
        return Sheet429CoreConfig.getInspectedHosts3();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet429CoreConfig.getPasswords3();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet429CoreConfig.getUsers3();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet429CoreConfig.getPorts3();
    }
    
}
