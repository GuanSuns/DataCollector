package org.suns.config.sheet429;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429CoreConfig {
    private static String[] inspectedHosts1 = {"192.168.14.82"};
    private static String[] inspectedHosts2 = {"192.168.14.82"};
    private static String[] inspectedHosts3 = {"192.168.14.82"};

/*
    private static String[] inspectedHosts2 = {"150.12.201.20"};
    //Alternative Host "150.12.201.22"

    private static String[] inspectedHosts3 = {"150.12.201.30"};
    //Alternative Host "150.12.201.32"

    private static String[] inspectedHosts4 = {"150.12.201.28"};
*/

    private static int port = 1521;
    private static String user = "dev_01";
    private static String password = "a";
    private static String sid = "ggjs";

    private static String[] fieldNames = {"instID", "btime"
            , "INTSIZE", "metricName", "val", "MINVAL", "MAXVAL"
            , "avg", "std", "sumSquare"};

    private static String inspectSQL = "select INSTANCE_NUMBER "
            + fieldNames[0] +
            ",BEGIN_TIME " + fieldNames[1] +
            "," + fieldNames[2] +
            ",METRIC_NAME " + fieldNames[3] +
            ",NUM_INTERVAL "+ fieldNames[4] +
            "," + fieldNames[5] +"," + fieldNames[6] + ",\n" +
            "   AVERAGE " + fieldNames[7] +
            ",STANDARD_DEVIATION " + fieldNames[8] +
            ",SUM_SQUARES " + fieldNames[9] + "\n" +
            "    from dba_hist_sysmetric_summary\n" +
            "    where METRIC_NAME in('Network Traffic Volume Per Sec','I/O Megabytes per Second')\n" +
            "     and rownum < 11 order by std desc\n";

    public static String[] getInspectedHosts1() {
        return inspectedHosts1;
    }

    public static void setInspectedHosts1(String[] inspectedHosts1) {
        Sheet429CoreConfig.inspectedHosts1 = inspectedHosts1;
    }

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet429CoreConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet429CoreConfig.inspectedHosts3 = inspectedHosts3;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet429CoreConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet429CoreConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet429CoreConfig.password = password;
    }

    public static String getSid() {
        return sid;
    }

    public static void setSid(String sid) {
        Sheet429CoreConfig.sid = sid;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet429CoreConfig.fieldNames = fieldNames;
    }

    public static String getInspectSQL() {
        return inspectSQL;
    }

    public static void setInspectSQL(String inspectSQL) {
        Sheet429CoreConfig.inspectSQL = inspectSQL;
    }
}
