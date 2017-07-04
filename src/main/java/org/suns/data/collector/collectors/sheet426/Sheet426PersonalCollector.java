package org.suns.data.collector.collectors.sheet426;

import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.config.sheet426.Sheet426PersonalConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.config.Sheet426Config;
import org.suns.database.utils.controller.Sheet426Controller;
import org.suns.database.utils.model.Sheet426PersonalModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426PersonalCollector {

    public static void inspect() throws Exception{
        Sheet426PersonalModel sheet426Model = new Sheet426PersonalModel();
        inspect2(sheet426Model);
        sheet426Model.setDate((new Timestamp(new Date().getTime())));

        if(!Sheet426Controller.addPersonal(sheet426Model)){
            throw new Exception("Fail to add Sheet 426 personal model to database");
        }

    }

    private static void inspect2(Sheet426PersonalModel sheet426Model) throws Exception{
        inspectHost20(sheet426Model);
        inspectHost21(sheet426Model);
    }

    private static void inspectHost20(Sheet426PersonalModel sheet426Model) throws Exception{

        final String[] hosts = Sheet426PersonalConfig.getInspectedHosts2();
        final String[] logPaths = Sheet426PersonalConfig.getLogPath2();

        HostConnector.connect(Sheet426PersonalConfig.getUser()
                , Sheet426PersonalConfig.getPassword()
                , hosts[0]
                , Sheet426PersonalConfig.getPort());

        String inspectCmd = Sheet426PersonalConfig.getORADetectionCmd(logPaths[0]);
        String strORA = HostConnector.executeCommand(inspectCmd);
        int cntError = Integer.valueOf(strORA.trim());

        if(cntError > 0){
            sheet426Model.setErrorInfo20(1);
        }

        String getLogCmd = Sheet426PersonalConfig.getLogCmd(logPaths[0]);
        String strLog = HostConnector.executeCommand(getLogCmd);
        sheet426Model.setLog20(strLog);

        HostConnector.disconnect();
    }

    private static void inspectHost21(Sheet426PersonalModel sheet426Model) throws Exception{

        final String[] hosts = Sheet426PersonalConfig.getInspectedHosts2();
        final String[] logPaths = Sheet426PersonalConfig.getLogPath2();

        HostConnector.connect(Sheet426PersonalConfig.getUser()
                , Sheet426PersonalConfig.getPassword()
                , hosts[1]
                , Sheet426PersonalConfig.getPort());

        String inspectCmd = Sheet426PersonalConfig.getORADetectionCmd(logPaths[1]);
        String strORA = HostConnector.executeCommand(inspectCmd);
        int cntError = Integer.valueOf(strORA.trim());

        if(cntError > 0){
            sheet426Model.setErrorInfo21(1);
        }else{
            sheet426Model.setErrorInfo21(0);
        }

        String getLogCmd = Sheet426PersonalConfig.getLogCmd(logPaths[1]);
        String strLog = HostConnector.executeCommand(getLogCmd);
        sheet426Model.setLog21(strLog);

        HostConnector.disconnect();
    }
    
}
