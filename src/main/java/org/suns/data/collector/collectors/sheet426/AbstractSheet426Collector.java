package org.suns.data.collector.collectors.sheet426;

import org.suns.data.collector.collectors.AbstractDataCollector;
import org.suns.data.collector.config.sheet426.Sheet426Config;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.model.Sheet426CoreModel;
import org.suns.database.utils.model.Sheet426PersonalModel;
import org.suns.inspection.logger.InspectionLogger;

public abstract class AbstractSheet426Collector extends AbstractDataCollector{
    protected abstract String[] getLogPaths(HostsId hostsId);

    protected String getORACmdByLogPath(String logPath) {
        return Sheet426Config.getORADetectionCmd(logPath);
    }

    protected String getLogCmdByLogPath(String logPath) {
        return Sheet426Config.getLogCmd(logPath);
    }

    protected enum LogType{
        LOG20,
        LOG21,
        LOG3,
        LOG40,
        LOG41
    }

    protected void inspectHostById(HostsId hostsId, LogType logType
            , Sheet426PersonalModel sheet426Model) throws Exception{

        final String[] hosts = getInspectHosts(hostsId);
        final String[] logPaths = getLogPaths(hostsId);
        final String[] users = getUsers(hostsId);
        final String[] passwords = getPasswords(hostsId);
        final int[] ports = getPorts(hostsId);

        int cntError = isHostsLogHasErrorInfo(hosts, ports
                , users, passwords, logPaths);
        setErrorInfo(logType, sheet426Model, cntError);
    }

    public int isHostsLogHasErrorInfo(String[] hosts, int[] ports
            , String[] users, String[] passwords
            , String[] logPaths) throws Exception{

        for(int i=0; i<hosts.length; i++){
            HostConnector.connect(users[i], passwords[i]
                    , hosts[i], ports[i]);

            String inspectCmd = getORACmdByLogPath(logPaths[i]);
            String strORA = HostConnector.executeCommand(inspectCmd);

            InspectionLogger.debug("Cmd: " + inspectCmd + ", Result: " + strORA.trim());

            HostConnector.disconnect();

            int cntError = Integer.valueOf(strORA.trim());
            if(cntError>0){
                return 1;
            }
        }
        return 0;
    }

    protected void setErrorInfo(LogType logType
            , Sheet426PersonalModel sheet426Model, int cntError){
        int errorInfo = cntError>0 ? 1:0;
        switch (logType){
            case LOG20:
                sheet426Model.setErrorInfo20(errorInfo);
                break;
            case LOG21:
                sheet426Model.setErrorInfo21(errorInfo);
                break;
            case LOG3:
                Sheet426CoreModel coreModel = (Sheet426CoreModel)sheet426Model;
                coreModel.setErrorInfo3(errorInfo);
                break;
            case LOG40:
                coreModel = (Sheet426CoreModel)sheet426Model;
                coreModel.setErrorInfo40(errorInfo);
                break;
            case LOG41:
                coreModel = (Sheet426CoreModel)sheet426Model;
                coreModel.setErrorInfo41(errorInfo);
                break;
            default:
                break;
        }
    }

    protected void setLog(LogType logType
            , Sheet426PersonalModel sheet426Model, String logInfo){
        switch (logType){
            case LOG20:
                sheet426Model.setLog20(logInfo);
                break;
            case LOG21:
                sheet426Model.setLog21(logInfo);
                break;
            case LOG3:
                Sheet426CoreModel coreModel = (Sheet426CoreModel)sheet426Model;
                coreModel.setLog3(logInfo);
                break;
            case LOG40:
                coreModel = (Sheet426CoreModel)sheet426Model;
                coreModel.setLog40(logInfo);
                break;
            case LOG41:
                coreModel = (Sheet426CoreModel)sheet426Model;
                coreModel.setLog41(logInfo);
                break;
            default:
                break;
        }
    }

    protected int logTypeEnumToIndex(LogType logType){
        switch (logType){
            case LOG20:
                return 0;
            case LOG21:
                return 1;
            case LOG3:
                return 0;
            case LOG40:
                return 0;
            case LOG41:
                return 1;
            default:
                return 0;
        }
    }
}
