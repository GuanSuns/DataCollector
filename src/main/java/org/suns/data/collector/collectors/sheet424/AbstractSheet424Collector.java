package org.suns.data.collector.collectors.sheet424;

import org.suns.data.collector.collectors.AbstractDBCollector;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.model.Sheet424CoreModel;
import org.suns.database.utils.model.Sheet424PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public abstract class AbstractSheet424Collector extends AbstractDBCollector {
    protected abstract String getInspectTimeSQL();
    protected abstract String getTempStatSQL();
    protected abstract String[] getFieldNamesTime();
    protected abstract String[] getFieldNamesStat();

    protected void inspectHostsById(HostsId hostsId
            , Sheet424PersonalModel sheet424Model) throws Exception{
        final String[] inspectedHosts = getInspectHosts(hostsId);
        final String[] users = getUsers(hostsId);
        final String[] passwords = getPasswords(hostsId);
        final int[] ports = getPorts(hostsId);
        final String[] sid = getSids(hostsId);

        for(int i=0; i<inspectedHosts.length; i++){
            inspectHost(hostsId, users[i], passwords[i], inspectedHosts[i]
                    , ports[i], sid[i], sheet424Model);
        }
    }

    protected void inspectHost(HostsId hostsId, String user
            , String password, String host
            , int port, String sid
            , Sheet424PersonalModel sheet424Model) throws Exception{
        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getInspectTimeSQL());

        final String[] fieldNames = getFieldNamesTime();
        while (resultSet.next()){
            Timestamp lastTime = resultSet.getTimestamp(fieldNames[0]);
            setInspectTimeById(hostsId, lastTime, sheet424Model);
        }

        Statement statementTemp = connection.createStatement();
        ResultSet resultSetTemp = statementTemp.executeQuery(getTempStatSQL());

        final String[] fieldNamesTemp = getFieldNamesStat();
        while (resultSetTemp.next()){
            String strStat = resultSetTemp.getString(fieldNamesTemp[0]);
            setStatusById(hostsId, strStat, sheet424Model);
        }

        OracleConnector.closeConnection();
    }
    
    protected void setStatusById(HostsId hostsId, String strStat
            , Sheet424PersonalModel sheet424Model) throws Exception{
        switch (hostsId){
            case HOST2:
                sheet424Model.setStatus2(strStat);
                break;
            case HOST3:
                Sheet424CoreModel coreModel = (Sheet424CoreModel)sheet424Model;
                coreModel.setStatus3(strStat);
                break;
            case HOST4:
                coreModel = (Sheet424CoreModel)sheet424Model;
                coreModel.setStatus4(strStat);
                break;
            default:
                break;
        }
    }

    protected void setInspectTimeById(HostsId hostsId, Timestamp inspectTime
            , Sheet424PersonalModel sheet424Model) throws Exception{
        switch (hostsId){
            case HOST2:
                sheet424Model.setInspectTime2(inspectTime);
                break;
            case HOST3:
                Sheet424CoreModel coreModel = (Sheet424CoreModel)sheet424Model;
                coreModel.setInspectTime3(inspectTime);
                break;
            case HOST4:
                coreModel = (Sheet424CoreModel)sheet424Model;
                coreModel.setInspectTime4(inspectTime);
                break;
            default:
                break;
        }
    }
}
