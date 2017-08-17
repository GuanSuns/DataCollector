package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.connector.HostConnector;
import org.suns.inspection.logger.InspectionLogger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScriptExecutor {
    public static Float getFloatFromPercentageByScript(String user, String password
            , String host, int port, String scriptCMD) throws Exception{
        HostConnector.connect(user, password, host, port);

        String strPercentage = HostConnector.executeCommand(scriptCMD);
        HostConnector.disconnect();

        InspectionLogger.debug("Host " + host
                + ", cmd:" + scriptCMD
                + ", result: " + strPercentage);

        if(strPercentage.equals("")){
            return null;
        }

        String rex = "\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(strPercentage);

        if(!matcher.find()){
            return null;
        }

        return Float.valueOf(matcher.group());
    }

    public static Float getFloatFromPercentageByAixScript(String user, String password
            , String rootPassword, String host
            , int port, String scriptCMD) throws Exception{
        HostConnector.connect(user, password, host, port);

        String strPercentage = HostConnector.executeSuCommand(scriptCMD, rootPassword);
        HostConnector.disconnect();

        InspectionLogger.debug("Host " + host
                + ", cmd:" + scriptCMD
                + ", result: " + strPercentage);

        if(strPercentage.equals("")){
            return null;
        }

        String rex = "\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(strPercentage);

        if(!matcher.find()){
            return null;
        }

        return Float.valueOf(matcher.group());
    }



    public static String getScriptCmd(String scriptPath){
        return "export LANG=en_US; cd /; bash " + scriptPath;
    }
}
