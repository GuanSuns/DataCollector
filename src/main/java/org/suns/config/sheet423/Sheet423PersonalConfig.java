package org.suns.config.sheet423;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423PersonalConfig {
    private static String[] inspectedHosts = {"192.168.14.82"};

    /*
    private static String[] inspectedHosts = {"150.12.201.40"};
    //Alternative host "150.12.201.42"
    */

    private static int port = 1521;
    private static String user = "dev_01";
    private static String password = "a";
    private static String sid = "ggjs";

    private static String[] fieldNames = {"ASMName"
            , "totalSpace(MB)", "remainSpace(MB)", "usage(%)"};

    private static String inspectSQL ="select name \""
            + fieldNames[0] + "\",\n" +
            "       round(total_mb) \""
            + fieldNames[1] +  "\",\n" +
            "       round(free_mb) \""
            + fieldNames[2] + "\",\n" +
            "       to_char(100 * (1 - (free_mb / total_mb)), '990.99') \""
            + fieldNames[3] + "\"\n" +
            "  from v$asm_diskgroup\n";

    public static String[] getInspectedHosts() {
        return inspectedHosts;
    }

    public static void setInspectedHosts(String[] inspectedHosts) {
        Sheet423PersonalConfig.inspectedHosts = inspectedHosts;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet423PersonalConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet423PersonalConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet423PersonalConfig.password = password;
    }

    public static String getSid() {
        return sid;
    }

    public static void setSid(String sid) {
        Sheet423PersonalConfig.sid = sid;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet423PersonalConfig.fieldNames = fieldNames;
    }

    public static String getInspectSQL() {
        return inspectSQL;
    }

    public static void setInspectSQL(String inspectSQL) {
        Sheet423PersonalConfig.inspectSQL = inspectSQL;
    }
}
