package org.suns.config.sheet412;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421CoreConfig {
    private static String[] inspectedHosts2 = {"119.29.201.188"};
    private static String[] inspectedHosts35 = {"119.29.201.188"};
    private static String[] inspectedHosts4 = {"119.29.201.188"};

    private static String rootDirectory = "/";
    private static String softwareDirectory = "/run";
    private static String softwareGgsDirectory = "/dev/shm";
    /*
    private static String rootDirectory = "/";
    private static String softwareDirectory = "/software";
    private static String softwareGgsDirectory = "/software/ggs";


    private static String[] inspectedHosts2 = {"150.12.73.20"
            , "150.12.73.22"
            , "150.12.201.20"
            , "150.12.201.22"};

    private static String[] inspectedHosts35 = {"150.12.73.28"
            , "150.12.201.28"};

    private static String[] inspectedHosts4 = {"150.12.73.30"
            , "150.12.73.32"
            , "150.12.201.30"
            , "150.12.201.32"};

    */

    private static int port = 22;
    private static String user = "root";
    private static String password = "whiteglcap25";

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet421CoreConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getInspectedHosts35() {
        return inspectedHosts35;
    }

    public static void setInspectedHosts35(String[] inspectedHosts35) {
        Sheet421CoreConfig.inspectedHosts35 = inspectedHosts35;
    }

    public static String[] getInspectedHosts4() {
        return inspectedHosts4;
    }

    public static void setInspectedHosts4(String[] inspectedHosts4) {
        Sheet421CoreConfig.inspectedHosts4 = inspectedHosts4;
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

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet421CoreConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet421CoreConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet421CoreConfig.password = password;
    }
}
