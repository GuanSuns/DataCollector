package org.suns.data.collector.config;

/**
 * Created by guanl on 6/28/2017.
 */
public class DFFormat {
    public enum InspectionSysType{
        LINUX,
        AIX
    }
    
    private static int fileSystemColumnLinux = 1;
    private static int mountedSysColumnLinux = 6;
    private static int usageColumnLinux = 5;
    private static int fileSystemColumnAIX = 1;
    private static int mountedSysColumnAIX = 6;
    private static int usageColumnAIX = 5;

    public static void setFileSystemColumnLinux(int fileSystemColumnLinux) {
        DFFormat.fileSystemColumnLinux = fileSystemColumnLinux;
    }

    public static void setMountedSysColumnLinux(int mountedSysColumnLinux) {
        DFFormat.mountedSysColumnLinux = mountedSysColumnLinux;
    }

    public static void setUsageColumnLinux(int usageColumnLinux) {
        DFFormat.usageColumnLinux = usageColumnLinux;
    }

    public static void setFileSystemColumnAIX(int fileSystemColumnAIX) {
        DFFormat.fileSystemColumnAIX = fileSystemColumnAIX;
    }

    public static void setMountedSysColumnAIX(int mountedSysColumnAIX) {
        DFFormat.mountedSysColumnAIX = mountedSysColumnAIX;
    }

    public static void setUsageColumnAIX(int usageColumnAIX) {
        DFFormat.usageColumnAIX = usageColumnAIX;
    }

    public static int getMountedSysColumn(InspectionSysType sysType) {
        switch (sysType){
            case AIX:
                return mountedSysColumnAIX;
            case LINUX:
                return mountedSysColumnLinux;
            default:
                return 0;
        }
    }

    public static int getFileSystemColumn(InspectionSysType sysType) {
        switch (sysType){
            case AIX:
                return fileSystemColumnAIX;
            case LINUX:
                return fileSystemColumnLinux;
            default:
                return 0;
        }
    }

    public static int getUsageColumn(InspectionSysType sysType) {
        switch (sysType){
            case AIX:
                return usageColumnAIX;
            case LINUX:
                return usageColumnLinux;
            default:
                return 0;
        }
    }

    public static String getMountedSysCmd(InspectionSysType sysType){
        switch (sysType){
            case AIX:
                return "df -Pk | awk '{print $" + mountedSysColumnAIX + "}'";
            case LINUX:
                return "df -Pk | awk '{print $" + mountedSysColumnLinux + "}'";
            default:
                return "df -Pk | awk '{print $" + mountedSysColumnLinux + "}'";
        }
        
    }

    public static String getUsageCmd(InspectionSysType sysType){
        switch (sysType){
            case AIX:
                return "df -Pk | awk '{print $" + usageColumnAIX + "}'";
            case LINUX:
                return "df -Pk | awk '{print $" + usageColumnLinux + "}'";
            default:
                return "df -Pk | awk '{print $" + usageColumnLinux + "}'";
        }
    }

}
