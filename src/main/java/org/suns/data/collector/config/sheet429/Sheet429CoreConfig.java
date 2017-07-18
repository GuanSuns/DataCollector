package org.suns.data.collector.config.sheet429;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429CoreConfig {

    private static String[] inspectedHosts1 = {"150.12.201.20"};
    //Alternative Host "150.12.201.22"
    private static int[] ports1 = {1521};
    private static String[] users1 = {"dev_01"};
    private static String[] passwords1 = {"a"};
    private static String[] sid1 = {"ggjs"};

    private static String[] inspectedHosts2 = {"150.12.201.30"};
    //Alternative Host "150.12.201.32"
    private static int[] ports2 = {1521};
    private static String[] users2 = {"dev_01"};
    private static String[] passwords2 = {"a"};
    private static String[] sid2 = {"ggjs"};

    private static String[] inspectedHosts3 = {"150.12.201.28"};
    private static int[] ports3 = {1521};
    private static String[] users3 = {"dev_01"};
    private static String[] passwords3 = {"a"};
    private static String[] sid3 = {"ggjs"};

    private static String[] fieldNames = {"instID", "btime"
            , "INTSIZE", "metricName", "val", "MINVAL", "MAXVAL"
            , "avg", "std", "sumSquare"};

    private static String inspectSQL = "select \"INSTANCE_NUMBER\" "
            + fieldNames[0] +
            ",\"BEGIN_TIME\" " + fieldNames[1] +
            "," + fieldNames[2] +
            ",\"METRIC_NAME\" " + fieldNames[3] +
            ",\"NUM_INTERVAL\" "+ fieldNames[4] +
            "," + fieldNames[5] +"," + fieldNames[6] + ",\n" +
            "   \"AVERAGE\" " + fieldNames[7] +
            ",\"STANDARD_DEVIATION\" " + fieldNames[8] +
            " \n" +
            "    from dba_hist_sysmetric_summary \n" +
            "    where METRIC_NAME in('Network Traffic Volume Per Sec','I/O Megabytes per Second')\n" +
            "     and rownum < 11 order by std desc\n";

    /*
    private static String inspectSQL = "select \"INSTANCE_NUMBER\" "
            + fieldNames[0] +
            ",\"BEGIN_TIME\" " + fieldNames[1] +
            "," + fieldNames[2] +
            ",\"METRIC_NAME\" " + fieldNames[3] +
            ",\"NUM_INTERVAL\" "+ fieldNames[4] +
            "," + fieldNames[5] +"," + fieldNames[6] + ",\n" +
            "   \"AVERAGE\" " + fieldNames[7] +
            ",\"STANDARD_DEVIATION\" " + fieldNames[8] +
            ",\"SUM_SQUARES\" " + fieldNames[9] + " \n" +
            "    from dba_hist_sysmetric_summary \n" +
            "    where METRIC_NAME in('Network Traffic Volume Per Sec','I/O Megabytes per Second')\n" +
            "     and rownum < 11 order by std desc\n";
    */

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

    public static int[] getPorts1() {
        return ports1;
    }

    public static void setPorts1(int[] ports1) {
        Sheet429CoreConfig.ports1 = ports1;
    }

    public static String[] getUsers1() {
        return users1;
    }

    public static void setUsers1(String[] users1) {
        Sheet429CoreConfig.users1 = users1;
    }

    public static String[] getPasswords1() {
        return passwords1;
    }

    public static void setPasswords1(String[] passwords1) {
        Sheet429CoreConfig.passwords1 = passwords1;
    }

    public static String[] getSid1() {
        return sid1;
    }

    public static void setSid1(String[] sid1) {
        Sheet429CoreConfig.sid1 = sid1;
    }

    public static int[] getPorts2() {
        return ports2;
    }

    public static void setPorts2(int[] ports2) {
        Sheet429CoreConfig.ports2 = ports2;
    }

    public static String[] getUsers2() {
        return users2;
    }

    public static void setUsers2(String[] users2) {
        Sheet429CoreConfig.users2 = users2;
    }

    public static String[] getPasswords2() {
        return passwords2;
    }

    public static void setPasswords2(String[] passwords2) {
        Sheet429CoreConfig.passwords2 = passwords2;
    }

    public static String[] getSid2() {
        return sid2;
    }

    public static void setSid2(String[] sid2) {
        Sheet429CoreConfig.sid2 = sid2;
    }

    public static int[] getPorts3() {
        return ports3;
    }

    public static void setPorts3(int[] ports3) {
        Sheet429CoreConfig.ports3 = ports3;
    }

    public static String[] getUsers3() {
        return users3;
    }

    public static void setUsers3(String[] users3) {
        Sheet429CoreConfig.users3 = users3;
    }

    public static String[] getPasswords3() {
        return passwords3;
    }

    public static void setPasswords3(String[] passwords3) {
        Sheet429CoreConfig.passwords3 = passwords3;
    }

    public static String[] getSid3() {
        return sid3;
    }

    public static void setSid3(String[] sid3) {
        Sheet429CoreConfig.sid3 = sid3;
    }
}
