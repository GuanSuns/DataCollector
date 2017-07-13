package org.suns.data.collector.config.sheet428;

/**
 * Created by guanl on 7/1/2017.
 */
public class Sheet428PersonalConfig {
    private static String[] inspectedHosts1 = {"119.29.201.188"};
    private static int[] ports1 = {22};
    private static String[] users1 = {"root"};
    private static String[] passwords1 = {"whiteglcap25"};

    private static String[] inspectedHosts2 = {"119.29.201.188"};
    private static int[] ports2 = {22};
    private static String[] users2 = {"root"};
    private static String[] passwords2 = {"whiteglcap25"};

    private static String[] inspectedHosts3 = {"119.29.201.188"};
    private static int[] ports3 = {22};
    private static String[] users3 = {"root"};
    private static String[] passwords3 = {"whiteglcap25"};

    private static String[] inspectedHosts4 = {"119.29.201.188"};
    private static int[] ports4 = {22};
    private static String[] users4 = {"root"};
    private static String[] passwords4 = {"whiteglcap25"};

    private static String timeServer = "119.29.201.188";
    private static int[] portsTimeServer = {22};
    private static String[] usersTimeServer = {"root"};
    private static String[] passwordsTimeServer = {"whiteglcap25"};

    private static String timeCmd = "date \"+%Y-%m-%d %H:%M:%S\"";

    private static String correctReport = "准确，无差异";

    /*
    private static String[] inspectedHosts1 = {"150.12.73.40"
            , "150.12.201.40"
            , "150.12.201.42"
            , "150.12.73.42"};
    private static int[] ports1 = {22, 22, 22, 22};
    private static String[] users1 = {"root", "root", "root", "root"};
    private static String[] passwords1 = {"whiteglcap25", "whiteglcap25"
            , "whiteglcap25", "whiteglcap25"};


    private static String[] inspectedHosts2 = {"150.12.192.40"
            , "150.12.192.41"
            , "150.12.192.42"};
    private static int[] ports2 = {22, 22, 22};
    private static String[] users2 = {"root", "root", "root"};
    private static String[] passwords2 = {"whiteglcap25", "whiteglcap25"
            , "whiteglcap25"};

    private static String[] inspectedHosts3 = {"150.12.200.40"
            , "150.12.200.41"
            , "150.12.200.42"};
    private static int[] ports3 = {22, 22, 22};
    private static String[] users3 = {"root", "root", "root"};
    private static String[] passwords3 = {"whiteglcap25", "whiteglcap25"
            , "whiteglcap25"};

    private static String[] inspectedHosts4 = {"150.12.200.40"
            , "150.12.200.41"};
    private static int[] ports4 = {22, 22};
    private static String[] users4 = {"root", "root"};
    private static String[] passwords4 = {"whiteglcap25", "whiteglcap25"};

    private static String timeServer = "150.12.216.250";
    private static int[] portsTimeServer = {22};
    private static String[] usersTimeServer = {"root"};
    private static String[] passwordsTimeServer = {"whiteglcap25"};

    */

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

    public static long getDiffTolerance() {
        return diffTolerance;
    }

    public static void setDiffTolerance(long diffTolerance) {
        Sheet428PersonalConfig.diffTolerance = diffTolerance;
    }

    public static int[] getPorts1() {
        return ports1;
    }

    public static void setPorts1(int[] ports1) {
        Sheet428PersonalConfig.ports1 = ports1;
    }

    public static String[] getUsers1() {
        return users1;
    }

    public static void setUsers1(String[] users1) {
        Sheet428PersonalConfig.users1 = users1;
    }

    public static String[] getPasswords1() {
        return passwords1;
    }

    public static void setPasswords1(String[] passwords1) {
        Sheet428PersonalConfig.passwords1 = passwords1;
    }

    public static int[] getPorts2() {
        return ports2;
    }

    public static void setPorts2(int[] ports2) {
        Sheet428PersonalConfig.ports2 = ports2;
    }

    public static String[] getUsers2() {
        return users2;
    }

    public static void setUsers2(String[] users2) {
        Sheet428PersonalConfig.users2 = users2;
    }

    public static String[] getPasswords2() {
        return passwords2;
    }

    public static void setPasswords2(String[] passwords2) {
        Sheet428PersonalConfig.passwords2 = passwords2;
    }

    public static int[] getPorts3() {
        return ports3;
    }

    public static void setPorts3(int[] ports3) {
        Sheet428PersonalConfig.ports3 = ports3;
    }

    public static String[] getUsers3() {
        return users3;
    }

    public static void setUsers3(String[] users3) {
        Sheet428PersonalConfig.users3 = users3;
    }

    public static String[] getPasswords3() {
        return passwords3;
    }

    public static void setPasswords3(String[] passwords3) {
        Sheet428PersonalConfig.passwords3 = passwords3;
    }

    public static int[] getPorts4() {
        return ports4;
    }

    public static void setPorts4(int[] ports4) {
        Sheet428PersonalConfig.ports4 = ports4;
    }

    public static String[] getUsers4() {
        return users4;
    }

    public static void setUsers4(String[] users4) {
        Sheet428PersonalConfig.users4 = users4;
    }

    public static String[] getPasswords4() {
        return passwords4;
    }

    public static void setPasswords4(String[] passwords4) {
        Sheet428PersonalConfig.passwords4 = passwords4;
    }

    public static int[] getPortsTimeServer() {
        return portsTimeServer;
    }

    public static void setPortsTimeServer(int[] portsTimeServer) {
        Sheet428PersonalConfig.portsTimeServer = portsTimeServer;
    }

    public static String[] getUsersTimeServer() {
        return usersTimeServer;
    }

    public static void setUsersTimeServer(String[] usersTimeServer) {
        Sheet428PersonalConfig.usersTimeServer = usersTimeServer;
    }

    public static String[] getPasswordsTimeServer() {
        return passwordsTimeServer;
    }

    public static void setPasswordsTimeServer(String[] passwordsTimeServer) {
        Sheet428PersonalConfig.passwordsTimeServer = passwordsTimeServer;
    }
}
