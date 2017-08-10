package org.suns.data.collector.collectors.sheet423;

import org.suns.data.collector.config.sheet423.Sheet423PersonalConfig;
import org.suns.database.utils.controller.Sheet423Controller;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.database.utils.model.Sheet423PersonalModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/** ASM共享磁盘检查 **/
public class Sheet423PersonalCollectorDB extends AbstractDBSheet423Collector {
    @Override
    protected String getSQLCmd() {
        return Sheet423PersonalConfig.getInspectSQL();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet423PersonalConfig.getFieldNames();
    }

    public void inspect() throws Exception{
        ArrayList<AbstractUsageModel> sheet423Models = new ArrayList<>();
        inspect2(sheet423Models);
        Timestamp inspectTime = new Timestamp(new Date().getTime());

        for(AbstractUsageModel sheet423Model : sheet423Models){
            Sheet423PersonalModel sheet423PersonalModel =
                    (Sheet423PersonalModel)sheet423Model;
            sheet423PersonalModel.setDate(inspectTime);
            if(!Sheet423Controller.addPersonal(sheet423PersonalModel)){
                throw new Exception("Fail to add Sheet 423 personal model to database");
            }
        }
    }

    private void inspect2(ArrayList<AbstractUsageModel> sheet423Models) throws Exception{
        inspectHostsByHostsId(HostsId.HOST2, ModelType.PERSONAL, sheet423Models);
    }

    @Override
    protected String[] getInspectHosts2() {
        return Sheet423PersonalConfig.getInspectedHosts();
    }

    @Override
    protected String[] getSids2() {
        return Sheet423PersonalConfig.getSid();
    }

    @Override
    protected String[] getPasswords2() {
        return Sheet423PersonalConfig.getPasswords();
    }

    @Override
    protected String[] getUsers2() {
        return Sheet423PersonalConfig.getUsers();
    }

    @Override
    protected int[] getPorts2() {
        return Sheet423PersonalConfig.getPorts();
    }
}
