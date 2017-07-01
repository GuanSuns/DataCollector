package org.suns.data.collector.config.sheet411;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411PersonalConfig {
    private static String[] inspectedHosts2 = {"119.29.201.188"};
    private static String[] inspectedHosts3 = {"119.29.201.188"};
    private static String[] inspectedHosts45 = {"119.29.201.188"};

    private static String rootDirectory = "/";
    private static String softwareDirectory = "/dev";
    /*
    private static String rootDirectory = "/";
    private static String softwareDirectory = "/software";


    private static String[] inspectedHosts2 = {"150.12.192.40"
            , "150.12.192.41"
            , "150.12.192.42"};

    private static String[] inspectedHosts3 = {"150.12.200.40"
            , "150.12.200.41"
            , "150.12.200.42"};

    private static String[] inspectedHosts45 = {"150.12.200.40"
            , "150.12.200.41"};

    */

    private static int port = 22;
    private static String user = "root";
    private static String password = "whiteglcap25";

    public static String getRootDirectory() {
        return rootDirectory;
    }

    public static String getSoftwareDirectory() {
        return softwareDirectory;
    }

    public static int getPort() {
        return port;
    }

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static String[] getInspectedHosts45() {
        return inspectedHosts45;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet411PersonalConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet411PersonalConfig.inspectedHosts3 = inspectedHosts3;
    }

    public static void setInspectedHosts45(String[] inspectedHosts45) {
        Sheet411PersonalConfig.inspectedHosts45 = inspectedHosts45;
    }

    public static void setPort(int port) {
        Sheet411PersonalConfig.port = port;
    }

    public static void setUser(String user) {
        Sheet411PersonalConfig.user = user;
    }

    public static void setPassword(String password) {
        Sheet411PersonalConfig.password = password;
    }

    public static void setRootDirectory(String rootDirectory) {
        Sheet411PersonalConfig.rootDirectory = rootDirectory;
    }

    public static void setSoftwareDirectory(String softwareDirectory) {
        Sheet411PersonalConfig.softwareDirectory = softwareDirectory;
    }
}
