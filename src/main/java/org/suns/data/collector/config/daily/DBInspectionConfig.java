package org.suns.data.collector.config.daily;

public class DBInspectionConfig {
    private static String[] archiveSpaceSQLFields = {"PERCENT_SPACE_USED"};

    public static String getArchiveSpaceSQLField() {
        return archiveSpaceSQLFields[0];
    }

    public static String getArchiveSpaceSQL() {
        return "select " + archiveSpaceSQLFields[0] +
                " from v$flash_recovery_area_usage " +
                "where file_type=\'ARCHIVED LOG\'";
    }

    private static String descriptionHasState = "有";
    private static String descriptionNoState = "无";
    private static String[] dbLongTermLockFields = {"LOCK_CHECK"};

    public static String getDescriptionHasState() {
        return descriptionHasState;
    }

    public static String getDescriptionNoState() {
        return descriptionNoState;
    }

    public static String getDbLongTermLockField() {
        return dbLongTermLockFields[0];
    }

    private static String dbLongTermLockSQL = "select /*+rule*/ case when count(*)=0 " +
            "then \'" + descriptionNoState + "\' else \'"
            + descriptionHasState + "\' end " + getDbLongTermLockField() +
            "  from gv$lock where type " +
            "in ('TM','TX') and ctime >600";

    public static String getDbLongTermLockSQL() {
        return dbLongTermLockSQL;
    }

    private static String[] tableSpaceUsageFields = {"TBS_CHECK"};

    public static String getTableSpaceUsageField(){
        return tableSpaceUsageFields[0];
    }

    private static String tableSpaceUsageSQL = "SELECT case when count(*)=0 " +
            "then \'" + descriptionNoState + "\' else \'"
            + descriptionHasState + "\' end " + getTableSpaceUsageField() +
            "  FROM dba_tablespace_usage_metrics where used_percent>90";

    public static String getTableSpaceUsageSQL() {
        return tableSpaceUsageSQL;
    }
}
