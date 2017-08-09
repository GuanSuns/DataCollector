package org.suns.data.collector.config.sheet421;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421CoreConfig {

    private static String rootDirectory = "/";
    private static String softwareDirectory = "/software";
    private static String softwareGgsDirectory = "/software/ggs";


    private static String[] inspectedHosts2 = {"150.12.73.20"
            , "150.12.73.22"
            , "150.12.201.20"
            , "150.12.201.22"};
    private static int[] ports2 = {22, 22, 22, 22};
    private static String[] users2 = {"root", "root", "root", "root"};
    private static String[] passwords2 = {"whiteglcap25"
            , "whiteglcap25", "whiteglcap25", "whiteglcap25"};

    private static String[] inspectedHosts35 = {"150.12.73.28"
            , "150.12.201.28"};
    private static int[] ports35 = {22, 22};
    private static String[] users35 = {"root", "root"};
    private static String[] passwords35 = {"whiteglcap25"
            , "whiteglcap25"};

    private static String[] inspectedHosts4 = {"150.12.73.30"
            , "150.12.73.32"
            , "150.12.201.30"
            , "150.12.201.32"};
    private static int[] ports4 = {22, 22, 22, 22};
    private static String[] users4 = {"root", "root", "root", "root"};
    private static String[] passwords4 = {"whiteglcap25"
            , "whiteglcap25", "whiteglcap25", "whiteglcap25"};


    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet421CoreConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static int[] getPorts2() {
        return ports2;
    }

    public static void setPorts2(int[] ports2) {
        Sheet421CoreConfig.ports2 = ports2;
    }

    public static String[] getUsers2() {
        return users2;
    }

    public static void setUsers2(String[] users2) {
        Sheet421CoreConfig.users2 = users2;
    }

    public static String[] getPasswords2() {
        return passwords2;
    }

    public static void setPasswords2(String[] passwords2) {
        Sheet421CoreConfig.passwords2 = passwords2;
    }

    public static String[] getInspectedHosts35() {
        return inspectedHosts35;
    }

    public static void setInspectedHosts35(String[] inspectedHosts35) {
        Sheet421CoreConfig.inspectedHosts35 = inspectedHosts35;
    }

    public static int[] getPorts35() {
        return ports35;
    }

    public static void setPorts35(int[] ports35) {
        Sheet421CoreConfig.ports35 = ports35;
    }

    public static String[] getUsers35() {
        return users35;
    }

    public static void setUsers35(String[] users35) {
        Sheet421CoreConfig.users35 = users35;
    }

    public static String[] getPasswords35() {
        return passwords35;
    }

    public static void setPasswords35(String[] passwords35) {
        Sheet421CoreConfig.passwords35 = passwords35;
    }

    public static String[] getInspectedHosts4() {
        return inspectedHosts4;
    }

    public static void setInspectedHosts4(String[] inspectedHosts4) {
        Sheet421CoreConfig.inspectedHosts4 = inspectedHosts4;
    }

    public static int[] getPorts4() {
        return ports4;
    }

    public static void setPorts4(int[] ports4) {
        Sheet421CoreConfig.ports4 = ports4;
    }

    public static String[] getUsers4() {
        return users4;
    }

    public static void setUsers4(String[] users4) {
        Sheet421CoreConfig.users4 = users4;
    }

    public static String[] getPasswords4() {
        return passwords4;
    }

    public static void setPasswords4(String[] passwords4) {
        Sheet421CoreConfig.passwords4 = passwords4;
    }

    public static String getRootDirectory() {
        return rootDirectory;
    }

    public static void setRootDirectory(String rootDirectory) {
        Sheet421CoreConfig.rootDirectory = rootDirectory;
    }

    public static String getSoftwareDirectory() {
        return softwareDirectory;
    }

    public static void setSoftwareDirectory(String softwareDirectory) {
        Sheet421CoreConfig.softwareDirectory = softwareDirectory;
    }

    public static String getSoftwareGgsDirectory() {
        return softwareGgsDirectory;
    }

    public static void setSoftwareGgsDirectory(String softwareGgsDirectory) {
        Sheet421CoreConfig.softwareGgsDirectory = softwareGgsDirectory;
    }
}
