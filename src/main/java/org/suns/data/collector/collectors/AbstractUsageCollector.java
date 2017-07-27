package org.suns.data.collector.collectors;

import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.database.utils.model.Sheet422PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class AbstractUsageCollector extends AbstractDBCollector {
    
    protected abstract String getSQLCmd();
    protected abstract String[] getFieldNames();
    protected abstract  AbstractUsageModel getNewModel(ModelType modelType);

    protected enum ModelType{
        PERSONAL,
        CORE
    }

    protected void inspectHostsByHostsId(HostsId hostsId, ModelType modelType
            , ArrayList<AbstractUsageModel> sheetUsageModels) throws Exception{
        final String[] inspectedHosts = getInspectHosts(hostsId);
        final String[] users = getUsers(hostsId);
        final String[] passwords = getPasswords(hostsId);
        final int[] ports = getPorts(hostsId);
        final String[] sid = getSids(hostsId);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectHostByHostsId(hostsId, users[i], passwords[i], inspectedHosts[i]
                    , ports[i], sid[i], modelType, sheetUsageModels);
        }
    }
    
    protected void inspectHostByHostsId(HostsId hostsId, String user
            , String password, String host
            , int port, String sid, ModelType modelType
            , ArrayList<AbstractUsageModel> sheetUsageModels) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getSQLCmd());

        final String[] fieldNames = getFieldNames();
        while (resultSet.next()){
            String tsName = resultSet.getString(fieldNames[0]);
            Float totalSpace = resultSet.getFloat(fieldNames[1]);
            Float usedSpace = resultSet.getFloat(fieldNames[2]);
            Float usage = resultSet.getFloat(fieldNames[3]);

            AbstractUsageModel sheetUsageModel = getNewModel(modelType);
            setModel(hostsId, tsName, usedSpace, usage, totalSpace, sheetUsageModel);
            sheetUsageModels.add(sheetUsageModel);
        }

        OracleConnector.closeConnection();
    }
    
    protected void setModel(HostsId hostsId
            , String tsName, Float usedSpace
            , Float usage, Float totalSpace, AbstractUsageModel to) throws Exception{
        switch (hostsId) {
            case HOST2:
                to.setName2(tsName);
                to.setTotalSpace2(totalSpace);
                to.setUsage2(usage);
                to.setUsedOrRemainSpace2(usedSpace);
                return;
            case HOST3:
                to.setName3(tsName);
                to.setTotalSpace3(totalSpace);
                to.setUsage3(usage);
                to.setUsedOrRemainSpace3(usedSpace);
                return;
            case HOST4:
                to.setName4(tsName);
                to.setTotalSpace4(totalSpace);
                to.setUsage4(usage);
                to.setUsedOrRemainSpace4(usedSpace);
                return;
            default:
                return;
        }
    }

    protected void setModel(HostsId hostsId, AbstractUsageModel from
            , AbstractUsageModel to) throws Exception{
        switch (hostsId) {
            case HOST2:
                to.setName2(from.getName2());
                to.setTotalSpace2(from.getTotalSpace2());
                to.setUsage2(from.getUsage2());
                to.setUsedOrRemainSpace2(from.getUsedOrRemainSpace2());
                return;
            case HOST3:
                to.setName3(from.getName3());
                to.setTotalSpace3(from.getTotalSpace3());
                to.setUsage3(from.getUsage3());
                to.setUsedOrRemainSpace3(from.getUsedOrRemainSpace3());
                return;
            case HOST4:
                to.setName4(from.getName4());
                to.setTotalSpace4(from.getTotalSpace4());
                to.setUsage4(from.getUsage4());
                to.setUsedOrRemainSpace4(from.getUsedOrRemainSpace4());
                return;
            default:
                return;
        }
    }

    protected void setModelToNull(HostsId hostsId, Sheet422PersonalModel to) throws Exception{

        float nullValue = DBConfig.getDefaultNumericNullValue();

        switch (hostsId) {
            case HOST2:
                to.setName2("");
                to.setTotalSpace2(nullValue);
                to.setUsage2(nullValue);
                to.setUsedOrRemainSpace2(nullValue);
                return;
            case HOST3:
                to.setName3("");
                to.setTotalSpace3(nullValue);
                to.setUsage3(nullValue);
                to.setUsedOrRemainSpace3(nullValue);
                return;
            case HOST4:
                to.setName4("");
                to.setTotalSpace4(nullValue);
                to.setUsage4(nullValue);
                to.setUsedOrRemainSpace4(nullValue);
                return;
            default:
                return;
        }
    }
    
    
}
