package org.suns.data.collector.config.sheet426;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426PersonalConfig {
    private static String[] inspectedHosts2 = {"119.29.201.188", "119.29.201.188"};

    private static String[] logPath2 = {"/software/oracle/trace/test.log", "/software/oracle/trace/test2.log"};

    /*

    private static String[] inspectedHost2 = {"150.12.201.40", "150.12.201.42"};

    private static String[] logPath2 = {
            "/software/oracle/diag/rdbms/gdltgshx/gdltgshx1/trace/alert_gdltgshx1.log"
            , "/software/oracle/diag/rdbms/gdltgshx/gdltgshx2/trace/alert_gdltgshx2.log"
    };

    */

    private static int port = 22;
    private static String user = "root";
    private static String password = "whiteglcap25";

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet426PersonalConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getLogPath2() {
        return logPath2;
    }

    public static void setLogPath2(String[] logPath2) {
        Sheet426PersonalConfig.logPath2 = logPath2;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet426PersonalConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet426PersonalConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet426PersonalConfig.password = password;
    }

    public static String getORADetectionCmd(String logPath){
        return "tail -300 " + logPath + " | grep ORA- | wc -l";
    }

    public static String getLogCmd(String logPath){
        return "tail -300 " + logPath;
    }
}
