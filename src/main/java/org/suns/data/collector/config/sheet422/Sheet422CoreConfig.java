package org.suns.data.collector.config.sheet422;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422CoreConfig {

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
    //Alternative host "150.12.201.22"
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
    //Alternative host: "150.12.201.32"
    private static int[] ports4 = {1521};
    private static String[] users4 = {"dev_01"};
    private static String[] passwords4 = {"a"};
    private static String[] sid4 = {"ggjs"};

    */

    private static String[] fieldNames = {"TsName"
            , "totalSpace(G)", "usedSpace(G)", "usage(%)"};

    private static String inspectSQL = "SELECT d.tablespace_name \""
            + fieldNames[0] +"\",\n" +
            "       to_char(nvl(a.bytes / 1024 / 1024 / 1024, 0), '99999999.999') \""
            + fieldNames[1] + "\",\n" +
            "       to_char(nvl(a.bytes - nvl(f.bytes, 0), 0) / 1024 / 1024/1024,'99999999.999') \""
            + fieldNames[2] + "\",\n" +
            "       to_char(nvl((a.bytes - nvl(f.bytes, 0)) / a.bytes * 100, 0),'990.00') \""
            + fieldNames[3] + "\"\n" +
            "  FROM sys.dba_tablespaces d,\n" +
            "       (SELECT tablespace_name, SUM(bytes) bytes\n" +
            "          FROM dba_data_files\n" +
            "         GROUP BY tablespace_name) a,\n" +
            "       (SELECT tablespace_name, SUM(bytes) bytes\n" +
            "          FROM dba_free_space\n" +
            "         GROUP BY tablespace_name) f\n" +
            " WHERE d.tablespace_name = a.tablespace_name(+)\n" +
            "   AND d.tablespace_name = f.tablespace_name(+)\n" +
            "   AND NOT\n" +
            "        (d.extent_management LIKE 'LOCAL' AND d.contents LIKE 'TEMPORARY')\n" +
            "   and nvl((a.bytes - nvl(f.bytes, 0)) / a.bytes * 100, 0) >= 85\n" +
            " order by 4\n";

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet422CoreConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet422CoreConfig.inspectedHosts3 = inspectedHosts3;
    }

    public static String[] getInspectedHosts4() {
        return inspectedHosts4;
    }

    public static void setInspectedHosts4(String[] inspectedHosts4) {
        Sheet422CoreConfig.inspectedHosts4 = inspectedHosts4;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet422CoreConfig.fieldNames = fieldNames;
    }

    public static String getInspectSQL() {
        return inspectSQL;
    }

    public static void setInspectSQL(String inspectSQL) {
        Sheet422CoreConfig.inspectSQL = inspectSQL;
    }

    public static int[] getPorts2() {
        return ports2;
    }

    public static void setPorts2(int[] ports2) {
        Sheet422CoreConfig.ports2 = ports2;
    }

    public static String[] getUsers2() {
        return users2;
    }

    public static void setUsers2(String[] users2) {
        Sheet422CoreConfig.users2 = users2;
    }

    public static String[] getPasswords2() {
        return passwords2;
    }

    public static void setPasswords2(String[] passwords2) {
        Sheet422CoreConfig.passwords2 = passwords2;
    }

    public static String[] getSid2() {
        return sid2;
    }

    public static void setSid2(String[] sid2) {
        Sheet422CoreConfig.sid2 = sid2;
    }

    public static int[] getPorts3() {
        return ports3;
    }

    public static void setPorts3(int[] ports3) {
        Sheet422CoreConfig.ports3 = ports3;
    }

    public static String[] getUsers3() {
        return users3;
    }

    public static void setUsers3(String[] users3) {
        Sheet422CoreConfig.users3 = users3;
    }

    public static String[] getPasswords3() {
        return passwords3;
    }

    public static void setPasswords3(String[] passwords3) {
        Sheet422CoreConfig.passwords3 = passwords3;
    }

    public static String[] getSid3() {
        return sid3;
    }

    public static void setSid3(String[] sid3) {
        Sheet422CoreConfig.sid3 = sid3;
    }

    public static int[] getPorts4() {
        return ports4;
    }

    public static void setPorts4(int[] ports4) {
        Sheet422CoreConfig.ports4 = ports4;
    }

    public static String[] getUsers4() {
        return users4;
    }

    public static void setUsers4(String[] users4) {
        Sheet422CoreConfig.users4 = users4;
    }

    public static String[] getPasswords4() {
        return passwords4;
    }

    public static void setPasswords4(String[] passwords4) {
        Sheet422CoreConfig.passwords4 = passwords4;
    }

    public static String[] getSid4() {
        return sid4;
    }

    public static void setSid4(String[] sid4) {
        Sheet422CoreConfig.sid4 = sid4;
    }
}
