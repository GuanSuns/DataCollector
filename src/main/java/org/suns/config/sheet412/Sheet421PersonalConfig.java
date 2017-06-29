package org.suns.config.sheet412;

import org.suns.config.sheet411.Sheet411PersonalConfig;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421PersonalConfig {

    private static String[] inspectedHosts2 = {"119.29.201.188"};
    private static String[] inspectedHosts3 = {"119.29.201.188"};

    private static String rootDirectory = "/";
    private static String softwareDirectory = "/run";
    private static String softwareGgsDirectory = "/dev/shm";
    /*
    private static String rootDirectory = "/";
    private static String softwareDirectory = "/software";
    private static String softwareGgsDirectory = "/software/ggs";


    private static String[] inspectedHosts2 = {"150.12.73.40"
            , "150.12.73.42"
            , "150.12.201.40"
            , "150.12.201.42"};

    private static String[] inspectedHosts3 = {"150.12.73.28"
            , "150.12.201.28"};
    */

    private static int port = 22;
    private static String user = "root";
    private static String password = "whiteglcap25";

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet421PersonalConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet421PersonalConfig.inspectedHosts3 = inspectedHosts3;
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

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet421PersonalConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet421PersonalConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet421PersonalConfig.password = password;
    }
}
