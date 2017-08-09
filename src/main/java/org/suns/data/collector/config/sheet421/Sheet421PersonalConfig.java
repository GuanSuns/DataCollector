package org.suns.data.collector.config.sheet421;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421PersonalConfig {

    private static String rootDirectory = "/";
    private static String softwareDirectory = "/software";
    private static String softwareGgsDirectory = "/software/ggs";

    private static String[] inspectedHosts2 = {"150.12.73.40"
            , "150.12.73.42"
            , "150.12.201.40"
            , "150.12.201.42"};
    private static int[] ports2 = {22, 22, 22, 22};
    private static String[] users2 = {"root", "root", "root", "root"};
    private static String[] passwords2 = {"whiteglcap25"
            , "whiteglcap25", "whiteglcap25", "whiteglcap25"};

    private static String[] inspectedHosts3 = {"150.12.73.28"
            , "150.12.201.28"};
    private static int[] ports3 = {22, 22};
    private static String[] users3 = {"root", "root"};
    private static String[] passwords3 = {"whiteglcap25"
            , "whiteglcap25"};

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet421PersonalConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static int[] getPorts2() {
        return ports2;
    }

    public static void setPorts2(int[] ports2) {
        Sheet421PersonalConfig.ports2 = ports2;
    }

    public static String[] getUsers2() {
        return users2;
    }

    public static void setUsers2(String[] users2) {
        Sheet421PersonalConfig.users2 = users2;
    }

    public static String[] getPasswords2() {
        return passwords2;
    }

    public static void setPasswords2(String[] passwords2) {
        Sheet421PersonalConfig.passwords2 = passwords2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet421PersonalConfig.inspectedHosts3 = inspectedHosts3;
    }

    public static int[] getPorts3() {
        return ports3;
    }

    public static void setPorts3(int[] ports3) {
        Sheet421PersonalConfig.ports3 = ports3;
    }

    public static String[] getUsers3() {
        return users3;
    }

    public static void setUsers3(String[] users3) {
        Sheet421PersonalConfig.users3 = users3;
    }

    public static String[] getPasswords3() {
        return passwords3;
    }

    public static void setPasswords3(String[] passwords3) {
        Sheet421PersonalConfig.passwords3 = passwords3;
    }

    public static String getRootDirectory() {
        return rootDirectory;
    }

    public static void setRootDirectory(String rootDirectory) {
        Sheet421PersonalConfig.rootDirectory = rootDirectory;
    }

    public static String getSoftwareDirectory() {
        return softwareDirectory;
    }

    public static void setSoftwareDirectory(String softwareDirectory) {
        Sheet421PersonalConfig.softwareDirectory = softwareDirectory;
    }

    public static String getSoftwareGgsDirectory() {
        return softwareGgsDirectory;
    }

    public static void setSoftwareGgsDirectory(String softwareGgsDirectory) {
        Sheet421PersonalConfig.softwareGgsDirectory = softwareGgsDirectory;
    }
}
