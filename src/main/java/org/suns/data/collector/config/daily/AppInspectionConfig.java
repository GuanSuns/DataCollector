package org.suns.data.collector.config.daily;

public class AppInspectionConfig {
    private static String softwareDirectory = "/software";

    public static String getScriptCmd(String scriptPath){
        return "cd /;." + scriptPath;
    }

    public static String getSoftwareDirectory() {
        return softwareDirectory;
    }

    public static void setSoftwareDirectory(String softwareDirectory) {
        AppInspectionConfig.softwareDirectory = softwareDirectory;
    }
}
