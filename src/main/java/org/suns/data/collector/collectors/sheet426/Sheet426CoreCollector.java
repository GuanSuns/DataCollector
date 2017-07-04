package org.suns.data.collector.collectors.sheet426;

import org.suns.data.collector.config.sheet426.Sheet426CoreConfig;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.controller.Sheet426Controller;
import org.suns.database.utils.model.Sheet426CoreModel;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426CoreCollector {

    public static void inspect() throws Exception{
        Sheet426CoreModel sheet426Model = new Sheet426CoreModel();
        inspect2(sheet426Model);
        inspect3(sheet426Model);
        inspect4(sheet426Model);
        sheet426Model.setDate((new Timestamp(new Date().getTime())));

        if(!Sheet426Controller.addCore(sheet426Model)){
            throw new Exception("Fail to add Sheet 426 Core model to database");
        }

    }

    private static void inspect2(Sheet426CoreModel sheet426Model) throws Exception{
        inspectHost20(sheet426Model);
        inspectHost21(sheet426Model);
    }

    private static void inspectHost20(Sheet426CoreModel sheet426Model) throws Exception{

        final String[] hosts = Sheet426CoreConfig.getInspectedHosts2();
        final String[] logPaths = Sheet426CoreConfig.getLogPath2();

        HostConnector.connect(Sheet426CoreConfig.getUser()
                , Sheet426CoreConfig.getPassword()
                , hosts[0]
                , Sheet426CoreConfig.getPort());

        String inspectCmd = Sheet426CoreConfig.getORADetectionCmd(logPaths[0]);
        String strORA = HostConnector.executeCommand(inspectCmd);
        int cntError = Integer.valueOf(strORA.trim());

        if(cntError > 0){
            sheet426Model.setErrorInfo20(1);
        }else{
            sheet426Model.setErrorInfo20(0);
        }

        String getLogCmd = Sheet426CoreConfig.getLogCmd(logPaths[0]);
        String strLog = HostConnector.executeCommand(getLogCmd);
        sheet426Model.setLog20(strLog);

        HostConnector.disconnect();
    }

    private static void inspectHost21(Sheet426CoreModel sheet426Model) throws Exception{

        final String[] hosts = Sheet426CoreConfig.getInspectedHosts2();
        final String[] logPaths = Sheet426CoreConfig.getLogPath2();

        HostConnector.connect(Sheet426CoreConfig.getUser()
                , Sheet426CoreConfig.getPassword()
                , hosts[1]
                , Sheet426CoreConfig.getPort());

        String inspectCmd = Sheet426CoreConfig.getORADetectionCmd(logPaths[1]);
        String strORA = HostConnector.executeCommand(inspectCmd);
        int cntError = Integer.valueOf(strORA.trim());

        if(cntError > 0){
            sheet426Model.setErrorInfo21(1);
        }else{
            sheet426Model.setErrorInfo21(0);
        }

        String getLogCmd = Sheet426CoreConfig.getLogCmd(logPaths[1]);
        String strLog = HostConnector.executeCommand(getLogCmd);
        sheet426Model.setLog21(strLog);

        HostConnector.disconnect();
    }

    private static void inspect3(Sheet426CoreModel sheet426Model) throws Exception{

        final String[] hosts = Sheet426CoreConfig.getInspectedHosts3();
        final String[] logPaths = Sheet426CoreConfig.getLogPath3();

        HostConnector.connect(Sheet426CoreConfig.getUser()
                , Sheet426CoreConfig.getPassword()
                , hosts[0]
                , Sheet426CoreConfig.getPort());

        String inspectCmd = Sheet426CoreConfig.getORADetectionCmd(logPaths[0]);
        String strORA = HostConnector.executeCommand(inspectCmd);
        int cntError = Integer.valueOf(strORA.trim());

        if(cntError > 0){
            sheet426Model.setErrorInfo3(1);
        }else{
            sheet426Model.setErrorInfo3(0);
        }

        String getLogCmd = Sheet426CoreConfig.getLogCmd(logPaths[0]);
        String strLog = HostConnector.executeCommand(getLogCmd);
        sheet426Model.setLog3(strLog);

        HostConnector.disconnect();
    }

    private static void inspect4(Sheet426CoreModel sheet426Model) throws Exception{
        inspectHost40(sheet426Model);
        inspectHost41(sheet426Model);
    }

    private static void inspectHost40(Sheet426CoreModel sheet426Model) throws Exception{

        final String[] hosts = Sheet426CoreConfig.getInspectedHosts4();
        final String[] logPaths = Sheet426CoreConfig.getLogPath4();

        HostConnector.connect(Sheet426CoreConfig.getUser()
                , Sheet426CoreConfig.getPassword()
                , hosts[0]
                , Sheet426CoreConfig.getPort());

        String inspectCmd = Sheet426CoreConfig.getORADetectionCmd(logPaths[0]);
        String strORA = HostConnector.executeCommand(inspectCmd);
        int cntError = Integer.valueOf(strORA.trim());

        if(cntError > 0){
            sheet426Model.setErrorInfo40(1);
        }else{
            sheet426Model.setErrorInfo40(0);
        }

        String getLogCmd = Sheet426CoreConfig.getLogCmd(logPaths[0]);
        String strLog = HostConnector.executeCommand(getLogCmd);
        sheet426Model.setLog40(strLog);

        HostConnector.disconnect();
    }

    private static void inspectHost41(Sheet426CoreModel sheet426Model) throws Exception{

        final String[] hosts = Sheet426CoreConfig.getInspectedHosts2();
        final String[] logPaths = Sheet426CoreConfig.getLogPath2();

        HostConnector.connect(Sheet426CoreConfig.getUser()
                , Sheet426CoreConfig.getPassword()
                , hosts[1]
                , Sheet426CoreConfig.getPort());

        String inspectCmd = Sheet426CoreConfig.getORADetectionCmd(logPaths[1]);
        String strORA = HostConnector.executeCommand(inspectCmd);
        int cntError = Integer.valueOf(strORA.trim());

        if(cntError > 0){
            sheet426Model.setErrorInfo41(1);
        }else{
            sheet426Model.setErrorInfo41(0);
        }

        String getLogCmd = Sheet426CoreConfig.getLogCmd(logPaths[1]);
        String strLog = HostConnector.executeCommand(getLogCmd);
        sheet426Model.setLog41(strLog);

        HostConnector.disconnect();
    }
}
