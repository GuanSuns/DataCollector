package org.suns.data.collector.config.sheet423;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423PersonalConfig {
    private static String[] inspectedHosts = {"192.168.14.82"};
    private static int[] ports = {1521};
    private static String[] users = {"dev_01"};
    private static String[] passwords = {"a"};
    private static String[] sid = {"ggjs"};

    /*
    private static String[] inspectedHosts = {"150.12.201.40"};
    //Alternative host "150.12.201.42"
    private static int[] ports = {1521};
    private static String[] users = {"dev_01"};
    private static String[] passwords = {"a"};
    private static String[] sid = {"ggjs"};
    */

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

    public static int[] getPorts() {
        return ports;
    }

    public static void setPorts(int[] ports) {
        Sheet423PersonalConfig.ports = ports;
    }

    public static String[] getUsers() {
        return users;
    }

    public static void setUsers(String[] users) {
        Sheet423PersonalConfig.users = users;
    }

    public static String[] getPasswords() {
        return passwords;
    }

    public static void setPasswords(String[] passwords) {
        Sheet423PersonalConfig.passwords = passwords;
    }

    public static String[] getSid() {
        return sid;
    }

    public static void setSid(String[] sid) {
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
