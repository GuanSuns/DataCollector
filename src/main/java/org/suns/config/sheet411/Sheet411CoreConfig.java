package org.suns.config.sheet411;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411CoreConfig {
    private static String[] inspectedHosts2 = {"119.29.201.188"};
    private static String[] inspectedHosts3 = {"119.29.201.188"};
    private static String[] inspectedHosts4 = {"119.29.201.188"};
    private static String[] inspectedHosts5 = {"119.29.201.188"};
    private static String[] inspectedHosts6 = {"119.29.201.188"};
    private static String[] inspectedHosts8 = {"119.29.201.188"};


    private static String rootDirectory = "/";
    private static String softwareDirectory = "/dev";

    /*
    private static String rootDirectory = "/";
    private static String softwareDirectory = "/software";


    private static String[] inspectedHosts2 = {"150.12.192.20"
            , "150.12.192.21"
            , "150.12.192.22"};

    private static String[] inspectedHosts3 = {"150.12.200.20"
            , "150.12.200.21"
            , "150.12.200.22"};

    private static String[] inspectedHosts4 = {"150.12.200.27"
            , "150.12.200.28"
            , "150.12.200.29"};

    private static String[] inspectedHosts5 = {"150.12.192.30"
            , "150.12.192.31"};

    private static String[] inspectedHosts6 = {"150.12.200.30"
            , "150.12.200.31"};

    private static String[] inspectedHosts8 = {"150.12.240.34"
            , "150.12.240.35"};

    */


    private static int port = 22;
    private static String user = "root";
    private static String password = "whiteglcap25";

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static String[] getInspectedHosts4() {
        return inspectedHosts4;
    }

    public static String[] getInspectedHosts5() {
        return inspectedHosts5;
    }

    public static String[] getInspectedHosts6() {
        return inspectedHosts6;
    }

    public static String[] getInspectedHosts8() {
        return inspectedHosts8;
    }

    public static String getRootDirectory() {
        return rootDirectory;
    }

    public static String getSoftwareDirectory() {
        return softwareDirectory;
    }

    public static int getPort() {
        return port;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet411CoreConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet411CoreConfig.inspectedHosts3 = inspectedHosts3;
    }

    public static void setInspectedHosts4(String[] inspectedHosts4) {
        Sheet411CoreConfig.inspectedHosts4 = inspectedHosts4;
    }

    public static void setInspectedHosts5(String[] inspectedHosts5) {
        Sheet411CoreConfig.inspectedHosts5 = inspectedHosts5;
    }

    public static void setInspectedHosts6(String[] inspectedHosts6) {
        Sheet411CoreConfig.inspectedHosts6 = inspectedHosts6;
    }

    public static void setInspectedHosts8(String[] inspectedHosts8) {
        Sheet411CoreConfig.inspectedHosts8 = inspectedHosts8;
    }

    public static void setRootDirectory(String rootDirectory) {
        Sheet411CoreConfig.rootDirectory = rootDirectory;
    }

    public static void setSoftwareDirectory(String softwareDirectory) {
        Sheet411CoreConfig.softwareDirectory = softwareDirectory;
    }

    public static void setPort(int port) {
        Sheet411CoreConfig.port = port;
    }

    public static void setUser(String user) {
        Sheet411CoreConfig.user = user;
    }

    public static void setPassword(String password) {
        Sheet411CoreConfig.password = password;
    }
}
