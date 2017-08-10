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

    private static String hasLongTermLockState = "有";
    private static String noLongTermLockState = "无";
    private static String[] dbLongTermLockFields = {"LOCK_CHECK"};

    public static String getHasLongTermLockState() {
        return hasLongTermLockState;
    }

    public static String getNoLongTermLockState() {
        return noLongTermLockState;
    }

    public static String getDbLongTermLockField() {
        return dbLongTermLockFields[0];
    }

    private static String dbLongTermLockSQL = "select /*+rule*/ case when count(*)=0 " +
            "then \'" + noLongTermLockState + "\' else \'"
            + hasLongTermLockState + "\' end " + getDbLongTermLockField() +
            "  from gv$lock where type " +
            "in ('TM','TX') and ctime >600";

    public static String getDbLongTermLockSQL() {
        return dbLongTermLockSQL;
    }

}
