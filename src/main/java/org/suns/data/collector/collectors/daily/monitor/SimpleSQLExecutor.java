package org.suns.data.collector.collectors.daily.monitor;

import org.suns.data.collector.connector.OracleConnector;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleSQLExecutor {

    public static String getStringBySimpleSQL(String user, String password
            , String host, int port
            , String sid, String sql, String fieldName) throws Exception{
        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        String strResult = "";
        while (resultSet.next()){
            strResult = resultSet.getString(fieldName);
        }

        InspectionLogger.debug("Host " + host
                + ", cmd:" + sql
                + ", result: " + strResult);

        OracleConnector.closeConnection();
        return strResult;
    }
}
