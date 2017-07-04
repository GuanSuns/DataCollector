package org.suns.data.collector.config.sheet426;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426CoreConfig {
    private static String[] inspectedHosts2 = {"119.29.201.188", "119.29.201.188"};

    private static String[] logPath2 = {
            "/software/oracle/trace/test.log"
            , "/software/oracle/trace/test2.log"
    };

    private static String[] inspectedHosts3 = {"119.29.201.188"};

    private static String[] logPath3 = {
            "/software/oracle/trace/test.log"
    };

    private static String[] inspectedHosts4 = {"119.29.201.188", "119.29.201.188"};

    private static String[] logPath4 = {
            "/software/oracle/trace/test.log"
            , "/software/oracle/trace/test2.log"
    };
/*
    private static String[] inspectedHost2 = {"150.12.201.20", "150.12.201.22"};

    private static String[] logPath2 = {
            "/software/oracle/diag/rdbms/gdlthxzg/gdlthxzg1/trace/alert_gdlthxzg1.log"
            , "/software/oracle/diag/rdbms/gdlthxzg/gdlthxzg2/trace/alert_gdlthxzg2.log"
    };

    private static String[] inspectedHost3 = {"150.12.201.28"};

    private static String[] logPath3 = {
            "/software/oracle/diag/rdbms/gdltcxff/gdltgcxff/trace/alert_gdltcxff.log"
    };

    private static String[] inspectedHost4 = {"150.12.201.30", "150.12.201.32"};

    private static String[] logPath4 = {
            "/software/oracle/diag/rdbms/gdltjcpt/gdltjcpt1/trace/alert_gdltjcpt1.log"
            , "/software/oracle/diag/rdbms/gdltjcpt/gdltjcpt2/trace/alert_gdltjcpt2.log"
    };
*/

    private static int port = 22;
    private static String user = "root";
    private static String password = "whiteglcap25";

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet426CoreConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getLogPath2() {
        return logPath2;
    }

    public static void setLogPath2(String[] logPath2) {
        Sheet426CoreConfig.logPath2 = logPath2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet426CoreConfig.inspectedHosts3 = inspectedHosts3;
    }

    public static String[] getLogPath3() {
        return logPath3;
    }

    public static void setLogPath3(String[] logPath3) {
        Sheet426CoreConfig.logPath3 = logPath3;
    }

    public static String[] getInspectedHosts4() {
        return inspectedHosts4;
    }

    public static void setInspectedHosts4(String[] inspectedHosts4) {
        Sheet426CoreConfig.inspectedHosts4 = inspectedHosts4;
    }

    public static String[] getLogPath4() {
        return logPath4;
    }

    public static void setLogPath4(String[] logPath4) {
        Sheet426CoreConfig.logPath4 = logPath4;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet426CoreConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet426CoreConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet426CoreConfig.password = password;
    }

    public static String getORADetectionCmd(String logPath){
        return "tail -300 " + logPath + " | grep ORA- | wc -l";
    }

    public static String getLogCmd(String logPath){
        return "tail -300 " + logPath;
    }
}
