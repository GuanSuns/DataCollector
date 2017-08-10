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
}
