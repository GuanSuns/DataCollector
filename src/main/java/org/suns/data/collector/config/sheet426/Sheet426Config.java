package org.suns.data.collector.config.sheet426;

public class Sheet426Config {
    public static String getORADetectionCmd(String logPath){
        String strErrorList = "";
        for(int i=0; i<errorList.length; i++){
            if(i==0){
                strErrorList = strErrorList + errorList[i];
            }else {
                strErrorList = strErrorList + "|" + errorList[i];
            }
        }
        return "tail -300 " + logPath + " | grep -E \""
                + strErrorList + "\" | wc -l";
    }

    public static String getLogCmd(String logPath){
        return "tail -300 " + logPath;
    }

    private static String[] errorList = {"ORA-07445", "ORA-04030"
            , "ORA-04031", "ORA-29740", "ORA-00255", "ORA-00355"
            , "ORA-00356", "ORA-00239", "ORA-00240", "ORA-00494"
            , "ORA-03137", "ORA-00227", "ORA-00353", "ORA-01578"
            , "ORA-32701", "ORA-32703", "ORA-29770", "ORA-29771"
            , "ORA-00445", "ORA-25319", "ORA-56729"};

    public static String[] getErrorList() {
        return errorList;
    }

    public static void setErrorList(String[] errorList) {
        Sheet426Config.errorList = errorList;
    }
}
