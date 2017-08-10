package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.connector.OracleConnector;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleSQLExecutor {
    public static String getStringBySimpleSQL(String user, String password
            , String host, int port
            , String sid, String sql, String fieldName) throws Exception{
        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        OracleConnector.closeConnection();

        String strResult = "";
        while (resultSet.next()){
            strResult = resultSet.getString(fieldName);
        }

        InspectionLogger.debug("Host " + host
                + ", cmd:" + sql
                + ", result: " + strResult);

        return strResult;
    }
}
