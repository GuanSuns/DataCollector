package org.suns.data.collector.config.sheet428;

/**
 * Created by guanl on 7/1/2017.
 */
public class Sheet428CoreConfig {
    private static String[] inspectedHosts1 = {"119.29.201.188"};
    private static int[] ports1 = {22};
    private static String[] users1 = {"root"};
    private static String[] passwords1 = {"whiteglcap25"};

    private static String[] inspectedHosts2 = {"119.29.201.188"};
    private static int[] ports2 = {22};
    private static String[] users2 = {"root"};
    private static String[] passwords2 = {"whiteglcap25"};

    private static String[] inspectedHosts34 = {"119.29.201.188"};
    private static int[] ports34 = {22};
    private static String[] users34 = {"root"};
    private static String[] passwords34 = {"whiteglcap25"};

    private static String timeServer = "119.29.201.188";
    private static int[] portsTimeServer = {22};
    private static String[] usersTimeServer = {"root"};
    private static String[] passwordsTimeServer = {"whiteglcap25"};

    private static String timeCmd = "date \"+%Y-%m-%d %H:%M:%S\"";

    private static String correctReport = "准确，无差异";

    /*
    private static String[] inspectedHosts1 = {"150.12.73.20"
            , "150.12.201.20"
            , "150.12.201.22"
            , "150.12.73.22"};
    private static int[] ports1 = {22, 22, 22, 22};
    private static String[] users1 = {"root", "root", "root", "root"};
    private static String[] passwords1 = {"whiteglcap25", "whiteglcap25"
            , "whiteglcap25", "whiteglcap25"};

    private static String[] inspectedHosts2 = {"150.12.73.30"
            , "150.12.73.32"
            , "150.12.201.30"
            , "150.12.201.32"
            , "150.12.192.20"
            , "150.12.192.21"
            , "150.12.192.22"};
    private static int[] ports2 = {22, 22, 22, 22, 22, 22, 22};
    private static String[] users2 = {"root", "root", "root"
            , "root", "root", "root", "root"};
    private static String[] passwords2 = {"whiteglcap25", "whiteglcap25"
            , "whiteglcap25", "whiteglcap25"
            , "whiteglcap25", "whiteglcap25", "whiteglcap25"};


    private static String[] inspectedHosts34 = {"150.12.73.28"
            , "150.12.200.20"
            , "150.12.200.21"
            , "150.12.200.22"};
    private static int[] ports34 = {22, 22, 22, 22};
    private static String[] users34 = {"root", "root", "root", "root"};
    private static String[] passwords34 = {"whiteglcap25", "whiteglcap25"
            , "whiteglcap25", "whiteglcap25"};

    private static String timeServer = "150.12.216.250";
    private static int[] portsTimeServer = {22};
    private static String[] usersTimeServer = {"root"};
    private static String[] passwordsTimeServer = {"whiteglcap25"};
    */

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

    public static long getDiffTolerance() {
        return diffTolerance;
    }

    public static void setDiffTolerance(long diffTolerance) {
        Sheet428CoreConfig.diffTolerance = diffTolerance;
    }

    public static int[] getPorts1() {
        return ports1;
    }

    public static void setPorts1(int[] ports1) {
        Sheet428CoreConfig.ports1 = ports1;
    }

    public static String[] getUsers1() {
        return users1;
    }

    public static void setUsers1(String[] users1) {
        Sheet428CoreConfig.users1 = users1;
    }

    public static String[] getPasswords1() {
        return passwords1;
    }

    public static void setPasswords1(String[] passwords1) {
        Sheet428CoreConfig.passwords1 = passwords1;
    }

    public static int[] getPorts2() {
        return ports2;
    }

    public static void setPorts2(int[] ports2) {
        Sheet428CoreConfig.ports2 = ports2;
    }

    public static String[] getUsers2() {
        return users2;
    }

    public static void setUsers2(String[] users2) {
        Sheet428CoreConfig.users2 = users2;
    }

    public static String[] getPasswords2() {
        return passwords2;
    }

    public static void setPasswords2(String[] passwords2) {
        Sheet428CoreConfig.passwords2 = passwords2;
    }

    public static int[] getPorts34() {
        return ports34;
    }

    public static void setPorts34(int[] ports34) {
        Sheet428CoreConfig.ports34 = ports34;
    }

    public static String[] getUsers34() {
        return users34;
    }

    public static void setUsers34(String[] users34) {
        Sheet428CoreConfig.users34 = users34;
    }

    public static String[] getPasswords34() {
        return passwords34;
    }

    public static void setPasswords34(String[] passwords34) {
        Sheet428CoreConfig.passwords34 = passwords34;
    }

    public static int[] getPortsTimeServer() {
        return portsTimeServer;
    }

    public static void setPortsTimeServer(int[] portsTimeServer) {
        Sheet428CoreConfig.portsTimeServer = portsTimeServer;
    }

    public static String[] getUsersTimeServer() {
        return usersTimeServer;
    }

    public static void setUsersTimeServer(String[] usersTimeServer) {
        Sheet428CoreConfig.usersTimeServer = usersTimeServer;
    }

    public static String[] getPasswordsTimeServer() {
        return passwordsTimeServer;
    }

    public static void setPasswordsTimeServer(String[] passwordsTimeServer) {
        Sheet428CoreConfig.passwordsTimeServer = passwordsTimeServer;
    }
}
