package org.suns.data.collector.config.sheet422;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422PersonalConfig {

    private static String[] inspectedHosts = {"192.168.14.82"};
    //Alternative host: "150.12.201.42"
    private static int[] ports = {1521};
    private static String[] users = {"dev_01"};
    private static String[] passwords = {"a"};
    private static String[] sid = {"ggjs"};

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

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet422PersonalConfig.fieldNames = fieldNames;
    }

    public static String getInspectSQL() {
        return inspectSQL;
    }

    public static void setInspectSQL(String inspectSQL) {
        Sheet422PersonalConfig.inspectSQL = inspectSQL;
    }

    public static String[] getInspectedHosts() {
        return inspectedHosts;
    }

    public static void setInspectedHosts(String[] inspectedHosts) {
        Sheet422PersonalConfig.inspectedHosts = inspectedHosts;
    }

    public static int[] getPorts() {
        return ports;
    }

    public static void setPorts(int[] ports) {
        Sheet422PersonalConfig.ports = ports;
    }

    public static String[] getUsers() {
        return users;
    }

    public static void setUsers(String[] users) {
        Sheet422PersonalConfig.users = users;
    }

    public static String[] getPasswords() {
        return passwords;
    }

    public static void setPasswords(String[] passwords) {
        Sheet422PersonalConfig.passwords = passwords;
    }

    public static String[] getSid() {
        return sid;
    }

    public static void setSid(String[] sid) {
        Sheet422PersonalConfig.sid = sid;
    }
}
