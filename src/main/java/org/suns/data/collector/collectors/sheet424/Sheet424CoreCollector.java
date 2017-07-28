package org.suns.data.collector.collectors.sheet424;

import org.suns.data.collector.config.sheet424.Sheet424CoreConfig;
import org.suns.database.utils.controller.Sheet424Controller;
import org.suns.database.utils.model.Sheet424CoreModel;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424CoreCollector extends AbstractSheet424Collector{
    @Override
    protected String getInspectTimeSQL() {
        return Sheet424CoreConfig.getInspectTimeSQL();
    }

    @Override
    protected String getTempStatSQL() {
        return Sheet424CoreConfig.getTempStatSQL();
    }

    @Override
    protected String[] getFieldNamesTime() {
        return Sheet424CoreConfig.getFieldNamesTime();
    }

    @Override
    protected String[] getFieldNamesStat() {
        return Sheet424CoreConfig.getFieldNamesStat();
    }

    public void inspect() throws Exception{
        Sheet424CoreModel sheet424Model = new Sheet424CoreModel();
        inspect2(sheet424Model);
        inspect3(sheet424Model);
        inspect4(sheet424Model);
        sheet424Model.setDate((new Timestamp(new Date().getTime())));

        if(!Sheet424Controller.addCore(sheet424Model)){
            throw new Exception("Fail to add Sheet 424 Core model to database");
        }

    }

    private void inspect2(Sheet424CoreModel sheet424Model) throws Exception{
        inspectHostsById(HostsId.HOST2, sheet424Model);
    }

    private void inspect3(Sheet424CoreModel sheet424Model) throws Exception{
        inspectHostsById(HostsId.HOST3, sheet424Model);
    }

    private void inspect4(Sheet424CoreModel sheet424Model) throws Exception{
        inspectHostsById(HostsId.HOST4, sheet424Model);
    }

    @Override
    protected String[] getSids2() {
        return Sheet424CoreConfig.getSid2();
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet424CoreConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet424CoreConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet424CoreConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet424CoreConfig.getPorts2();
    }

    @Override
    protected String[] getSids3() {
        return Sheet424CoreConfig.getSid3();
    }

    @Override
    protected String[] getInspectHosts3() {
        return Sheet424CoreConfig.getInspectedHosts3();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet424CoreConfig.getPasswords3();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet424CoreConfig.getUsers3();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet424CoreConfig.getPorts3();
    }

    @Override
    protected String[] getSids4() {
        return Sheet424CoreConfig.getSid4();
    }

    @Override
    protected String[] getInspectHosts4() {
        return Sheet424CoreConfig.getInspectedHosts4();
    }

    @Override
    protected String[] getPasswords4() {
        return Sheet424CoreConfig.getPasswords4();
    }

    @Override
    protected String[] getUsers4() {
        return Sheet424CoreConfig.getUsers4();
    }

    @Override
    protected int[] getPorts4() {
        return Sheet424CoreConfig.getPorts4();
    }
}
