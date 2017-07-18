package org.suns.data.collector.config.sheet426;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426PersonalConfig {
    private static String[] inspectedHosts2 = {"119.29.201.188", "119.29.201.188"};

    private static String[] logPath2 = {"/software/oracle/trace/test.log"
            , "/software/oracle/trace/test2.log"};
    private static int[] ports2 = {22, 22};
    private static String[] users2 = {"root", "root"};
    private static String[] passwords2 = {"whiteglcap25"
            , "whiteglcap25"};

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

    public static int[] getPorts2() {
        return ports2;
    }

    public static void setPorts2(int[] ports2) {
        Sheet426PersonalConfig.ports2 = ports2;
    }

    public static String[] getUsers2() {
        return users2;
    }

    public static void setUsers2(String[] users2) {
        Sheet426PersonalConfig.users2 = users2;
    }

    public static String[] getPasswords2() {
        return passwords2;
    }

    public static void setPasswords2(String[] passwords2) {
        Sheet426PersonalConfig.passwords2 = passwords2;
    }

    public static String getORADetectionCmd(String logPath){
        return "tail -300 " + logPath + " | grep ORA- | wc -l";
    }

    public static String getLogCmd(String logPath){
        return "tail -300 " + logPath;
    }
}
