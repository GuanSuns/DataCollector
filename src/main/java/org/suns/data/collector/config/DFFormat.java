package org.suns.data.collector.config;

/**
 * Created by guanl on 6/28/2017.
 */
public class DFFormat {
    private static int fileSystemColumn = 1;
    private static int mountedSysColumn = 6;
    private static int usageColumn = 5;

    public static int getMountedSysColumn() {
        return mountedSysColumn;
    }

    public static int getFileSystemColumn() {
        return fileSystemColumn;
    }

    public static int getUsageColumn() {
        return usageColumn;
    }

    public static void setFileSystemColumn(int fileSystemColumn) {
        DFFormat.fileSystemColumn = fileSystemColumn;
    }

    public static void setMountedSysColumn(int mountedSysColumn) {
        DFFormat.mountedSysColumn = mountedSysColumn;
    }

    public static void setUsageColumn(int usageColumn) {
        DFFormat.usageColumn = usageColumn;
    }

    public static String getMountedSysCmd(){
        return "df -h | awk '{print $" + mountedSysColumn + "}'";
    }

    public static String getUsageCmd(){
        return "df -h | awk '{print $" + usageColumn + "}'";
    }

}
