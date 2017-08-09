package org.suns.data.collector.config.daily;

public class AppInspectionConfig {
    public static String getScriptCmd(String scriptPath){
        return "cd /;." + scriptPath;
    }
}
