package org.suns.config.sheet422;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422CoreConfig {

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

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet422CoreConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet422CoreConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet422CoreConfig.password = password;
    }

    public static String getSid() {
        return sid;
    }

    public static void setSid(String sid) {
        Sheet422CoreConfig.sid = sid;
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
}
