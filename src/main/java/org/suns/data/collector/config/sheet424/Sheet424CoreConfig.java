package org.suns.data.collector.config.sheet424;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424CoreConfig {
    private static String[] inspectedHosts2 = {"192.168.14.82"};
    private static String[] inspectedHosts3 = {"192.168.14.82"};
    private static String[] inspectedHosts4 = {"192.168.14.82"};

/*
    private static String[] inspectedHosts2 = {"150.12.201.20"};
    //Alternative Host "150.12.201.22"

    private static String[] inspectedHosts3 = {"150.12.201.28"};

    private static String[] inspectedHosts4 = {"150.12.201.30"};
    //Alternative Host "150.12.201.32"
*/

    private static int port = 1521;
    private static String user = "dev_01";
    private static String password = "a";
    private static String sid = "ggjs";

    private static String[] fieldNamesTime = {"lastAnalysis"};

    private static String inspectTimeSQL = "select max(LAST_ANALYZED) "
            + fieldNamesTime[0] + " from dba_tables WHERE temporary='N'";

    private static String[] fieldNamesStat = {"temp Table Statistics"};

    private static String tempStatSQL = "select '有 '||count(*)||'张表' \""
            + fieldNamesStat[0] +"\"\n" +
            "  from dba_tables\n" +
            " where temporary='Y' AND  last_analyzed is not null\n";

    public static String[] getInspectedHosts2() {
        return inspectedHosts2;
    }

    public static void setInspectedHosts2(String[] inspectedHosts2) {
        Sheet424CoreConfig.inspectedHosts2 = inspectedHosts2;
    }

    public static String[] getInspectedHosts3() {
        return inspectedHosts3;
    }

    public static void setInspectedHosts3(String[] inspectedHosts3) {
        Sheet424CoreConfig.inspectedHosts3 = inspectedHosts3;
    }

    public static String[] getInspectedHosts4() {
        return inspectedHosts4;
    }

    public static void setInspectedHosts4(String[] inspectedHosts4) {
        Sheet424CoreConfig.inspectedHosts4 = inspectedHosts4;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Sheet424CoreConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Sheet424CoreConfig.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Sheet424CoreConfig.password = password;
    }

    public static String getSid() {
        return sid;
    }

    public static void setSid(String sid) {
        Sheet424CoreConfig.sid = sid;
    }

    public static String[] getFieldNamesTime() {
        return fieldNamesTime;
    }

    public static void setFieldNamesTime(String[] fieldNamesTime) {
        Sheet424CoreConfig.fieldNamesTime = fieldNamesTime;
    }

    public static String getInspectTimeSQL() {
        return inspectTimeSQL;
    }

    public static void setInspectTimeSQL(String inspectTimeSQL) {
        Sheet424CoreConfig.inspectTimeSQL = inspectTimeSQL;
    }

    public static String[] getFieldNamesStat() {
        return fieldNamesStat;
    }

    public static void setFieldNamesStat(String[] fieldNamesStat) {
        Sheet424CoreConfig.fieldNamesStat = fieldNamesStat;
    }

    public static String getTempStatSQL() {
        return tempStatSQL;
    }

    public static void setTempStatSQL(String tempStatSQL) {
        Sheet424CoreConfig.tempStatSQL = tempStatSQL;
    }
}
