package org.suns.data.collector.config.sheet429;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429PersonalConfig {
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
            "\n" +
            "    from dba_hist_sysmetric_summary\n" +
            "    where METRIC_NAME in('Network Traffic Volume Per Sec','I/O Megabytes per Second')\n" +
            "     and rownum < 11 order by std desc\n";
    /*
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
    */
    public static String[] getInspectedHosts() {
        return inspectedHosts;
    }

    public static void setInspectedHosts(String[] inspectedHosts) {
        Sheet429PersonalConfig.inspectedHosts = inspectedHosts;
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

    public static int[] getPorts() {
        return ports;
    }

    public static void setPorts(int[] ports) {
        Sheet429PersonalConfig.ports = ports;
    }

    public static String[] getUsers() {
        return users;
    }

    public static void setUsers(String[] users) {
        Sheet429PersonalConfig.users = users;
    }

    public static String[] getPasswords() {
        return passwords;
    }

    public static void setPasswords(String[] passwords) {
        Sheet429PersonalConfig.passwords = passwords;
    }

    public static String[] getSid() {
        return sid;
    }

    public static void setSid(String[] sid) {
        Sheet429PersonalConfig.sid = sid;
    }
}
