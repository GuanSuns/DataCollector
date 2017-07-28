package org.suns.data.collector.collectors.sheet429;

import org.suns.data.collector.collectors.AbstractDBCollector;
import org.suns.data.collector.collectors.AbstractDataCollector;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.model.Sheet428CoreModel;
import org.suns.database.utils.model.Sheet428PersonalModel;
import org.suns.database.utils.model.Sheet429CoreModel;
import org.suns.database.utils.model.Sheet429PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractSheet429Collector extends AbstractDBCollector {

    protected abstract String getInspectSQL();
    protected abstract String[] getFieldNames();

    protected void inspectHostById(HostsId hostsId
            , Sheet429PersonalModel sheet429Model) throws Exception{
        final String[] inspectedHosts = getInspectHosts(hostsId);
        final String[] users = getUsers(hostsId);
        final String[] passwords = getPasswords(hostsId);
        final int[] ports = getPorts(hostsId);
        final String[] sid = getSids(hostsId);

        for(int i=0; i<inspectedHosts.length; i++){
            String strResult = inspectHost(users[i]
                    , passwords[i]
                    , inspectedHosts[i]
                    , ports[i]
                    , sid[i]);

            setHeartBeatById(hostsId, strResult, sheet429Model);
        }
    }

    protected void setHeartBeatById(HostsId hostsId, String strResult
            , Sheet429PersonalModel sheet429Model){
        switch (hostsId){
            case HOST1:
                sheet429Model.setHeartBeat1(strResult);
                break;
            case HOST2:
                Sheet429CoreModel coreModel = (Sheet429CoreModel)sheet429Model;
                coreModel.setHeartBeat2(strResult);
                break;
            case HOST3:
                coreModel = (Sheet429CoreModel)sheet429Model;
                coreModel.setHeartBeat3(strResult);
                break;
            default:
                break;
        }
    }

    protected String inspectHost(String user
            , String password, String host
            , int port, String sid) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getInspectSQL());

        final String[] fieldNames = getFieldNames();
        String strResult = "";
        while (resultSet.next()){
            String instID = resultSet.getString(fieldNames[0]);
            String btime = resultSet.getString(fieldNames[1]);
            String intSize = resultSet.getString(fieldNames[2]);
            String metricName = resultSet.getString(fieldNames[3]);
            String val = resultSet.getString(fieldNames[4]);
            String minVal = resultSet.getString(fieldNames[5]);
            String maxVal = resultSet.getString(fieldNames[6]);
            String avg = resultSet.getString(fieldNames[7]);
            String std = resultSet.getString(fieldNames[8]);
            String sumSquare = resultSet.getString(fieldNames[9]);

            strResult = strResult + " " + instID + " " + btime
                    + " " + intSize + " " + metricName + " " + val
                    + " " + minVal + " " + maxVal + " " + avg
                    + " " + std + " " +sumSquare + "\n";
        }

        OracleConnector.closeConnection();
        return strResult;
    }
}
