package org.suns.data.collector.collectors.sheet423;

import org.suns.data.collector.config.sheet423.Sheet423CoreConfig;
import org.suns.database.utils.controller.Sheet423Controller;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.database.utils.model.Sheet423CoreModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/** ASM共享磁盘检查 **/
public class Sheet423CoreCollector extends AbstractSheet423Collector{

    @Override
    protected String getSQLCmd() {
        return Sheet423CoreConfig.getInspectSQL();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet423CoreConfig.getFieldNames();
    }

    public void inspect() throws Exception{
        ArrayList<AbstractUsageModel> result2 = new ArrayList<>();
        ArrayList<AbstractUsageModel> result3 = new ArrayList<>();
        ArrayList<AbstractUsageModel> result4 = new ArrayList<>();
        ArrayList<Sheet423CoreModel> totalResult = new ArrayList<>();

        inspect2(result2);
        inspect3(result3);
        inspect4(result4);

        mergeAllResults(totalResult, result2, result3, result4);

        for(Sheet423CoreModel sheet423Model : totalResult){
            if(!Sheet423Controller.addCore(sheet423Model)){
                System.out.println(sheet423Model.toString());
                throw new Exception("Fail to add Sheet 423 Core model to database");
            }
        }
    }

    private void mergeAllResults(ArrayList<Sheet423CoreModel> totalResult
            , ArrayList<AbstractUsageModel> result2
            , ArrayList<AbstractUsageModel> result3
            , ArrayList<AbstractUsageModel> result4) throws Exception{

        int size2 = result2.size();
        int size3 = result3.size();
        int size4 = result4.size();
        int maxIndex = Math.max(Math.max(size2, size3), size4);

        for(int i=0; i<maxIndex; i++){
            Sheet423CoreModel sheet423CoreModel = new Sheet423CoreModel();
            sheet423CoreModel.setDate(new Timestamp(new Date().getTime()));

            setModelByIndex(HostsId.HOST2, size2, i, result2, sheet423CoreModel);
            setModelByIndex(HostsId.HOST3, size3, i, result3, sheet423CoreModel);
            setModelByIndex(HostsId.HOST4, size4, i, result4, sheet423CoreModel);

            totalResult.add(sheet423CoreModel);
        }
    }

    private void setModelByIndex(HostsId hostsId, int size, int index
            , ArrayList<AbstractUsageModel> from, Sheet423CoreModel to) throws Exception{
        if(index >= size){
            setModelToNull(hostsId, to);
        }else{
            Sheet423CoreModel fromModel = (Sheet423CoreModel)from.get(index);
            setModel(hostsId, fromModel, to);
        }
    }

    private void inspect2(ArrayList<AbstractUsageModel> sheet423Models) throws Exception{
        inspectHostsByHostsId(HostsId.HOST2, ModelType.CORE, sheet423Models);
    }

    private void inspect3(ArrayList<AbstractUsageModel> sheet423Models) throws Exception{
        inspectHostsByHostsId(HostsId.HOST3, ModelType.CORE, sheet423Models);
    }

    private void inspect4(ArrayList<AbstractUsageModel> sheet423Models) throws Exception{
        inspectHostsByHostsId(HostsId.HOST4, ModelType.CORE, sheet423Models);
    }

    @Override
    protected String[] getSids2() {
        return Sheet423CoreConfig.getSid2();
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet423CoreConfig.getInspectedHosts2();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet423CoreConfig.getPasswords2();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet423CoreConfig.getUsers2();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet423CoreConfig.getPorts2();
    }

    @Override
    protected String[] getSids3() {
        return Sheet423CoreConfig.getSid3();
    }

    @Override
    protected String[] getInspectHosts3() {
        return Sheet423CoreConfig.getInspectedHosts3();
    }

    @Override
    protected String[] getPasswords3() {
        return Sheet423CoreConfig.getPasswords3();
    }

    @Override
    protected String[] getUsers3() {
        return Sheet423CoreConfig.getUsers3();
    }

    @Override
    protected int[] getPorts3() {
        return Sheet423CoreConfig.getPorts3();
    }

    @Override
    protected String[] getSids4() {
        return Sheet423CoreConfig.getSid4();
    }

    @Override
    protected String[] getInspectHosts4() {
        return Sheet423CoreConfig.getInspectedHosts4();
    }

    @Override
    protected String[] getPasswords4() {
        return Sheet423CoreConfig.getPasswords4();
    }

    @Override
    protected String[] getUsers4() {
        return Sheet423CoreConfig.getUsers4();
    }

    @Override
    protected int[] getPorts4() {
        return Sheet423CoreConfig.getPorts4();
    }
}
