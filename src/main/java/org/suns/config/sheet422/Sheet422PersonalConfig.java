package org.suns.config.sheet422;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422PersonalConfig {

    private static String[] inspectedHosts = {"192.168.14.82"};

    /*
    private static String[] inspectedHosts = {"150.12.201.40"
            , "150.12.201.42"};
    */

    private static int port = 1521;
    private static String user = "dev_01";
    private static String password = "a";
    private static String sid = "ggjs";

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

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet422PersonalConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet422PersonalConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet422PersonalConfig.password = password;
    }

    public static String getSid() {
        return sid;
    }

    public static void setSid(String sid) {
        Sheet422PersonalConfig.sid = sid;
    }
}
