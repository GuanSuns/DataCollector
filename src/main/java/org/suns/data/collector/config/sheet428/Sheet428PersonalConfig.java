package org.suns.data.collector.config.sheet428;

/**
 * Created by guanl on 7/1/2017.
 */
public class Sheet428PersonalConfig {
    private static String[] inspectedHosts1 = {"119.29.201.188"};
    private static String[] inspectedHosts2 = {"119.29.201.188"};
    private static String[] inspectedHosts3 = {"119.29.201.188"};
    private static String[] inspectedHosts4 = {"119.29.201.188"};

    private static String timeServer = "119.29.201.188";

    private static String timeCmd = "date \"+%Y-%m-%d %H:%M:%S\"";

    private static String correctReport = "准确，无差异";

    /*
    private static String[] inspectedHosts1 = {"150.12.73.40"
            , "150.12.201.40"
            , "150.12.201.42"
            , "150.12.73.42"};

    private static String[] inspectedHosts2 = {"150.12.192.40"
            , "150.12.192.41"
            , "150.12.192.42"};

    private static String[] inspectedHosts3 = {"150.12.200.40"
            , "150.12.200.41"
            , "150.12.200.42"};

    private static String[] inspectedHosts4 = {"150.12.200.40"
            , "150.12.200.41"};

    private static String timeServer = "150.12.216.250";

    */

    private static int port = 22;
    private static String user = "root";
    private static String password = "whiteglcap25";
    private static long diffTolerance = 1000 * 60 * 10;

    public static String getCorrectReport() {
        return correctReport;
    }

    public static void setCorrectReport(String correctReport) {
        Sheet428PersonalConfig.correctReport = correctReport;
    }

    public static String getTimeCmd() {
        return timeCmd;
    }

    public static void setTimeCmd(String timeCmd) {
        Sheet428PersonalConfig.timeCmd = timeCmd;
    }

    public static String[] getInspectedHosts1() {
        return inspectedHosts1;
    }

    public static void setInspectedHosts1(String[] inspectedHosts1) {
        Sheet428PersonalConfig.inspectedHosts1 = inspectedHosts1;
    }

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet428PersonalConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet428PersonalConfig.inspectedHosts3 = inspectedHosts3;
    }

    public static String[] getInspectedHosts4() {
        return inspectedHosts4;
    }

    public static void setInspectedHosts4(String[] inspectedHosts4) {
        Sheet428PersonalConfig.inspectedHosts4 = inspectedHosts4;
    }

    public static String getTimeServer() {
        return timeServer;
    }

    public static void setTimeServer(String timeServer) {
        Sheet428PersonalConfig.timeServer = timeServer;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet428PersonalConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet428PersonalConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet428PersonalConfig.password = password;
    }

    public static long getDiffTolerance() {
        return diffTolerance;
    }

    public static void setDiffTolerance(long diffTolerance) {
        Sheet428PersonalConfig.diffTolerance = diffTolerance;
    }
}
