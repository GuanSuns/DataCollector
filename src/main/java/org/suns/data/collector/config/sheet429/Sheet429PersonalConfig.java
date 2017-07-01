package org.suns.data.collector.config.sheet429;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429PersonalConfig {
    private static String[] inspectedHosts = {"192.168.14.82"};

    /*
    private static String[] inspectedHosts = {"150.12.201.40"};
    //Alternative host "150.12.201.42"
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

    public static String[] getInspectedHosts() {
        return inspectedHosts;
    }

    public static void setInspectedHosts(String[] inspectedHosts) {
        Sheet429PersonalConfig.inspectedHosts = inspectedHosts;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet429PersonalConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet429PersonalConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet429PersonalConfig.password = password;
    }

    public static String getSid() {
        return sid;
    }

    public static void setSid(String sid) {
        Sheet429PersonalConfig.sid = sid;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet429PersonalConfig.fieldNames = fieldNames;
    }

    public static String getInspectSQL() {
        return inspectSQL;
    }

    public static void setInspectSQL(String inspectSQL) {
        Sheet429PersonalConfig.inspectSQL = inspectSQL;
    }
}
