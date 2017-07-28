package org.suns.data.collector.collectors.sheet429;

import org.suns.data.collector.config.sheet429.Sheet429PersonalConfig;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.controller.Sheet429Controller;
import org.suns.database.utils.model.Sheet429PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */

public class Sheet429PersonalCollector extends AbstractSheet429Collector{
    @Override
    protected String getInspectSQL() {
        return Sheet429PersonalConfig.getInspectSQL();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet429PersonalConfig.getFieldNames();
    }

    public void inspect() throws Exception{
        Sheet429PersonalModel sheet429Model = new Sheet429PersonalModel();
        inspect1(sheet429Model);

        sheet429Model.setInspectTime(new Timestamp(new Date().getTime()));

        if(!Sheet429Controller.addPersonal(sheet429Model)){
                throw new Exception("Fail to add Sheet 429 personal model to database");
        }
    }

    private void inspect1(Sheet429PersonalModel sheet429Model) throws Exception{
        inspectHostById(HostsId.HOST1, sheet429Model);
    }

    @Override
    protected String[] getSids1() {
        return Sheet429PersonalConfig.getSid();
    }

    @Override
    protected String[] getInspectHosts1() {
        return Sheet429PersonalConfig.getInspectedHosts();
    }

    @Override
    protected String[] getPasswords1() {
        return Sheet429PersonalConfig.getPasswords();
    }

    @Override
    protected String[] getUsers1() {
        return Sheet429PersonalConfig.getUsers();
    }

    @Override
    protected int[] getPorts1() {
        return Sheet429PersonalConfig.getPorts();
    }
}
