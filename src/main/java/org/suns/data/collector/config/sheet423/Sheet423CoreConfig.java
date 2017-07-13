package org.suns.data.collector.config.sheet423;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423CoreConfig {
    private static String[] inspectedHosts2 = {"192.168.14.82"};
    private static int[] ports2 = {1521};
    private static String[] users2 = {"dev_01"};
    private static String[] passwords2 = {"a"};
    private static String[] sid2 = {"ggjs"};

    private static String[] inspectedHosts3 = {"192.168.14.82"};
    private static int[] ports3 = {1521};
    private static String[] users3 = {"dev_01"};
    private static String[] passwords3 = {"a"};
    private static String[] sid3 = {"ggjs"};

    private static String[] inspectedHosts4 = {"192.168.14.82"};
    private static int[] ports4 = {1521};
    private static String[] users4 = {"dev_01"};
    private static String[] passwords4 = {"a"};
    private static String[] sid4 = {"ggjs"};

/*
    private static String[] inspectedHosts2 = {"150.12.201.20"};
    //Alternative Host "150.12.201.22"
    private static int[] ports2 = {1521};
    private static String[] users2 = {"dev_01"};
    private static String[] passwords2 = {"a"};
    private static String[] sid2 = {"ggjs"};

    private static String[] inspectedHosts3 = {"150.12.201.28"};
    private static int[] ports3 = {1521};
    private static String[] users3 = {"dev_01"};
    private static String[] passwords3 = {"a"};
    private static String[] sid3 = {"ggjs"};

    private static String[] inspectedHosts4 = {"150.12.201.30"};
    //Alternative Host "150.12.201.32"
    private static int[] ports4 = {1521};
    private static String[] users4 = {"dev_01"};
    private static String[] passwords4 = {"a"};
    private static String[] sid4 = {"ggjs"};
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

    public static int[] getPorts2() {
        return ports2;
    }

    public static void setPorts2(int[] ports2) {
        Sheet423CoreConfig.ports2 = ports2;
    }

    public static String[] getUsers2() {
        return users2;
    }

    public static void setUsers2(String[] users2) {
        Sheet423CoreConfig.users2 = users2;
    }

    public static String[] getPasswords2() {
        return passwords2;
    }

    public static void setPasswords2(String[] passwords2) {
        Sheet423CoreConfig.passwords2 = passwords2;
    }

    public static String[] getSid2() {
        return sid2;
    }

    public static void setSid2(String[] sid2) {
        Sheet423CoreConfig.sid2 = sid2;
    }

    public static int[] getPorts3() {
        return ports3;
    }

    public static void setPorts3(int[] ports3) {
        Sheet423CoreConfig.ports3 = ports3;
    }

    public static String[] getUsers3() {
        return users3;
    }

    public static void setUsers3(String[] users3) {
        Sheet423CoreConfig.users3 = users3;
    }

    public static String[] getPasswords3() {
        return passwords3;
    }

    public static void setPasswords3(String[] passwords3) {
        Sheet423CoreConfig.passwords3 = passwords3;
    }

    public static String[] getSid3() {
        return sid3;
    }

    public static void setSid3(String[] sid3) {
        Sheet423CoreConfig.sid3 = sid3;
    }

    public static int[] getPorts4() {
        return ports4;
    }

    public static void setPorts4(int[] ports4) {
        Sheet423CoreConfig.ports4 = ports4;
    }

    public static String[] getUsers4() {
        return users4;
    }

    public static void setUsers4(String[] users4) {
        Sheet423CoreConfig.users4 = users4;
    }

    public static String[] getPasswords4() {
        return passwords4;
    }

    public static void setPasswords4(String[] passwords4) {
        Sheet423CoreConfig.passwords4 = passwords4;
    }

    public static String[] getSid4() {
        return sid4;
    }

    public static void setSid4(String[] sid4) {
        Sheet423CoreConfig.sid4 = sid4;
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
