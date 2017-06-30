package org.suns.config.sheet423;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423CoreConfig {
    private static String[] inspectedHosts2 = {"192.168.14.82"};
    private static String[] inspectedHosts3 = {"192.168.14.82"};
    private static String[] inspectedHosts4 = {"192.168.14.82"};

/*
    private static String[] inspectedHosts2 = {"150.12.201.20"
            , "150.12.201.22"};

    private static String[] inspectedHosts3 = {"150.12.201.28"};

    private static String[] inspectedHosts4 = {"150.12.201.30"
            , "150.12.201.32"};
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

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet423CoreConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet423CoreConfig.inspectedHosts3 = inspectedHosts3;
    }

    public static String[] getInspectedHosts4() {
        return inspectedHosts4;
    }

    public static void setInspectedHosts4(String[] inspectedHosts4) {
        Sheet423CoreConfig.inspectedHosts4 = inspectedHosts4;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet423CoreConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet423CoreConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet423CoreConfig.password = password;
    }

    public static String getSid() {
        return sid;
    }

    public static void setSid(String sid) {
        Sheet423CoreConfig.sid = sid;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet423CoreConfig.fieldNames = fieldNames;
    }

    public static String getInspectSQL() {
        return inspectSQL;
    }

    public static void setInspectSQL(String inspectSQL) {
        Sheet423CoreConfig.inspectSQL = inspectSQL;
    }
}
