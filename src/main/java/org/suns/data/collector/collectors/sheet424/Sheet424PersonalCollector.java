package org.suns.data.collector.collectors.sheet424;

import org.suns.data.collector.config.sheet424.Sheet424PersonalConfig;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.controller.Sheet424Controller;
import org.suns.database.utils.model.Sheet424PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424PersonalCollector extends AbstractSheet424Collector{

    @Override
    protected String getInspectTimeSQL() {
        return Sheet424PersonalConfig.getInspectTimeSQL();
    }

    @Override
    protected String getTempStatSQL() {
        return Sheet424PersonalConfig.getTempStatSQL();
    }

    @Override
    protected String[] getFieldNamesTime() {
        return Sheet424PersonalConfig.getFieldNamesTime();
    }

    @Override
    protected String[] getFieldNamesStat() {
        return Sheet424PersonalConfig.getFieldNamesStat();
    }

    public void inspect() throws Exception{
        Sheet424PersonalModel sheet424Model = new Sheet424PersonalModel();
        inspect2(sheet424Model);
        sheet424Model.setDate((new Timestamp(new Date().getTime())));

        if(!Sheet424Controller.addPersonal(sheet424Model)){
            throw new Exception("Fail to add Sheet 424 personal model to database");
        }
    }

    private void inspect2(Sheet424PersonalModel sheet424PersonalModel) throws Exception{
        inspectHostsById(HostsId.HOST2, sheet424PersonalModel);
    }

    @Override
    protected String[] getSids2() {
        return Sheet424PersonalConfig.getSid();
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet424PersonalConfig.getInspectedHosts();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet424PersonalConfig.getPasswords();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet424PersonalConfig.getUsers();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet424PersonalConfig.getPorts();
    }
}
