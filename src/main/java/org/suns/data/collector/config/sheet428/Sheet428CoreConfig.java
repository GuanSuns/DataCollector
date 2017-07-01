package org.suns.data.collector.config.sheet428;

/**
 * Created by guanl on 7/1/2017.
 */
public class Sheet428CoreConfig {
    private static String[] inspectedHosts1 = {"119.29.201.188"};
    private static String[] inspectedHosts2 = {"119.29.201.188"};
    private static String[] inspectedHosts34 = {"119.29.201.188"};

    private static String timeServer = "119.29.201.188";

    private static String timeCmd = "date \"+%Y-%m-%d %H:%M:%S\"";

    private static String correctReport = "准确，无差异";

    /*
    private static String[] inspectedHosts1 = {"150.12.73.20"
            , "150.12.201.20"
            , "150.12.201.22"
            , "150.12.73.22"};

    private static String[] inspectedHosts2 = {"150.12.73.30"
            , "150.12.73.32"
            , "150.12.201.30"
            , "150.12.201.32"
            , "150.12.192.20"
            , "150.12.192.21"
            , "150.12.192.22"};

    private static String[] inspectedHosts34 = {"150.12.73.28"
            , "150.12.200.20"
            , "150.12.200.21"
            , "150.12.200.22"};

    private static String timeServer = "150.12.216.250";

    */

    private static int port = 22;
    private static String user = "root";
    private static String password = "whiteglcap25";
    private static long diffTolerance = 1000 * 60 * 10;

    public static String[] getInspectedHosts1() {
        return inspectedHosts1;
    }

    public static void setInspectedHosts1(String[] inspectedHosts1) {
        Sheet428CoreConfig.inspectedHosts1 = inspectedHosts1;
    }

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet428CoreConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getInspectedHosts34() {
        return inspectedHosts34;
    }

    public static void setInspectedHosts34(String[] inspectedHosts34) {
        Sheet428CoreConfig.inspectedHosts34 = inspectedHosts34;
    }

    public static String getTimeServer() {
        return timeServer;
    }

    public static void setTimeServer(String timeServer) {
        Sheet428CoreConfig.timeServer = timeServer;
    }

    public static String getTimeCmd() {
        return timeCmd;
    }

    public static void setTimeCmd(String timeCmd) {
        Sheet428CoreConfig.timeCmd = timeCmd;
    }

    public static String getCorrectReport() {
        return correctReport;
    }

    public static void setCorrectReport(String correctReport) {
        Sheet428CoreConfig.correctReport = correctReport;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet428CoreConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet428CoreConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet428CoreConfig.password = password;
    }

    public static long getDiffTolerance() {
        return diffTolerance;
    }

    public static void setDiffTolerance(long diffTolerance) {
        Sheet428CoreConfig.diffTolerance = diffTolerance;
    }
}
