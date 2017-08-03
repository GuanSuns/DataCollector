package org.suns.data.collector.collectors.sheet422;

import org.suns.data.collector.config.sheet422.Sheet422CoreConfig;
import org.suns.database.utils.controller.Sheet422Controller;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.database.utils.model.Sheet422CoreModel;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/** 表空间使用率检查 **/
public class Sheet422CoreCollector extends AbstractSheet422Collector {

    @Override
    protected String getSQLCmd() {
        return Sheet422CoreConfig.getInspectSQL();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet422CoreConfig.getFieldNames();
    }

    public void inspect() throws Exception{
        ArrayList<Sheet422CoreModel> totalResult = new ArrayList<>();
        ArrayList<AbstractUsageModel> result2 = new ArrayList<>();
        ArrayList<AbstractUsageModel> result3 = new ArrayList<>();
        ArrayList<AbstractUsageModel> result4 = new ArrayList<>();

        inspect2(result2);
        inspect3(result3);
        inspect4(result4);

        mergeAllResults(totalResult, result2, result3, result4);
        Timestamp inspectTime = new Timestamp(new Date().getTime());

        InspectionLogger.debug("Finish inspecting core 422 - ");

        for(Sheet422CoreModel sheet422Model : totalResult){
            sheet422Model.setDate(inspectTime);
            InspectionLogger.debug(sheet422Model.toString());

            if(!Sheet422Controller.addCore(sheet422Model)){
                throw new Exception("Fail to add Sheet 422 Core model to database");
            }
        }
    }

    private void inspect2(ArrayList<AbstractUsageModel> sheet422Models) throws Exception{
        inspectHostsByHostsId(HostsId.HOST2, ModelType.CORE, sheet422Models);
    }

    private void inspect3(ArrayList<AbstractUsageModel> sheet422Models) throws Exception{
        inspectHostsByHostsId(HostsId.HOST3, ModelType.CORE, sheet422Models);
    }

    private void inspect4(ArrayList<AbstractUsageModel> sheet422Models) throws Exception{
        inspectHostsByHostsId(HostsId.HOST4, ModelType.CORE, sheet422Models);
    }

    private void mergeAllResults(ArrayList<Sheet422CoreModel> totalResult
            , ArrayList<AbstractUsageModel> result2
            , ArrayList<AbstractUsageModel> result3
            , ArrayList<AbstractUsageModel> result4) throws Exception{
        
        int size2 = result2.size();
        int size3 = result3.size();
        int size4 = result4.size();
        int maxIndex = Math.max(Math.max(size2, size3), size4);
        
        for(int i=0; i<maxIndex; i++){
            Sheet422CoreModel sheet422CoreModel = new Sheet422CoreModel();
            sheet422CoreModel.setDate(new Timestamp(new Date().getTime()));

            setModelByIndex(HostsId.HOST2, size2, i, result2, sheet422CoreModel);
            setModelByIndex(HostsId.HOST3, size3, i, result3, sheet422CoreModel);
            setModelByIndex(HostsId.HOST4, size4, i, result4, sheet422CoreModel);

            totalResult.add(sheet422CoreModel);
        }
    }

    private void setModelByIndex(HostsId hostsId, int size, int index
            , ArrayList<AbstractUsageModel> from, Sheet422CoreModel to) throws Exception{
        if(index >= size){
            setModelToNull(hostsId, to);
        }else{
            Sheet422CoreModel fromModel = (Sheet422CoreModel)from.get(index);
            setModel(hostsId, fromModel, to);
        }
    }

    @Override
    protected String[] getSids2() {
        return Sheet422CoreConfig.getSid2();
    }

    @Override
    protected String[] getSids3() {
        return Sheet422CoreConfig.getSid3();
    }

    @Override
    protected String[] getSids4() {
        return Sheet422CoreConfig.getSid4();
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet422CoreConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet422CoreConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet422CoreConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet422CoreConfig.getPorts2();
    }

    @Override
    protected String[] getInspectHosts3() {
        return Sheet422CoreConfig.getInspectedHosts3();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet422CoreConfig.getPasswords3();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet422CoreConfig.getUsers3();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet422CoreConfig.getPorts3();
    }

    @Override
    protected String[] getInspectHosts4() {
        return Sheet422CoreConfig.getInspectedHosts4();
    }

    @Override
    protected String[] getPasswords4() {
        return Sheet422CoreConfig.getPasswords4();
    }

    @Override
    protected String[] getUsers4() {
        return Sheet422CoreConfig.getUsers4();
    }

    @Override
    protected int[] getPorts4() {
        return Sheet422CoreConfig.getPorts4();
    }
}
