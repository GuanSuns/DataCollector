package org.suns.data.collector.collectors.sheet422;

import org.suns.data.collector.config.sheet422.Sheet422PersonalConfig;
import org.suns.database.utils.controller.Sheet422Controller;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.database.utils.model.Sheet422PersonalModel;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/** 表空间使用率检查 **/
public class Sheet422PersonalCollector extends AbstractSheet422Collector {

    @Override
    protected String getSQLCmd() {
        return Sheet422PersonalConfig.getInspectSQL();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet422PersonalConfig.getFieldNames();
    }

    public void inspect() throws Exception{
        ArrayList<AbstractUsageModel> sheet422Models = new ArrayList<>();
        inspect2(sheet422Models);
        Timestamp inspectTime = new Timestamp(new Date().getTime());

        InspectionLogger.debug("Finish inspecting personal 422 - ");

        for(AbstractUsageModel sheet422Model : sheet422Models){
            Sheet422PersonalModel sheet422PersonalModel = (Sheet422PersonalModel)sheet422Model;
            sheet422PersonalModel.setDate(inspectTime);
            InspectionLogger.debug(sheet422Model.toString());

            if(!Sheet422Controller.addPersonal(sheet422PersonalModel)){
                throw new Exception("Fail to add Sheet 422 personal model to database");
            }
        }
    }

    private void inspect2(ArrayList<AbstractUsageModel> sheet422Models) throws Exception{
        inspectHostsByHostsId(HostsId.HOST2, ModelType.PERSONAL, sheet422Models);
    }

    @Override
    protected String[] getSids2() {
        return Sheet422PersonalConfig.getSid();
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet422PersonalConfig.getInspectedHosts();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet422PersonalConfig.getPasswords();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet422PersonalConfig.getUsers();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet422PersonalConfig.getPorts();
    }
}
