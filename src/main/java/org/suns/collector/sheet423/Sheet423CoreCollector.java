package org.suns.collector.sheet423;

import org.suns.config.DBConfig;
import org.suns.config.sheet423.Sheet423CoreConfig;
import org.suns.connector.OracleConnector;
import org.suns.controller.Sheet423Controller;
import org.suns.model.Sheet423CoreModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423CoreCollector {
    public static void inspect() throws Exception{
        ArrayList<Sheet423CoreModel> result2 = new ArrayList<>();
        ArrayList<Sheet423CoreModel> result3 = new ArrayList<>();
        ArrayList<Sheet423CoreModel> result4 = new ArrayList<>();
        ArrayList<Sheet423CoreModel> totalResult = new ArrayList<>();

        inspect2(result2);
        inspect3(result3);
        inspect4(result4);

        mergeAllResults(totalResult, result2, result3, result4);

        for(Sheet423CoreModel sheet423Model : totalResult){
            if(!Sheet423Controller.addCore(sheet423Model)){
                System.out.println(sheet423Model.toString());
                throw new Exception("Fail to add Sheet 423 Core model to database");
            }
        }
    }

    private static void mergeAllResults(ArrayList<Sheet423CoreModel> totalResult
            , ArrayList<Sheet423CoreModel> result2
            , ArrayList<Sheet423CoreModel> result3
            , ArrayList<Sheet423CoreModel> result4){

        int size2 = result2.size();
        int size3 = result3.size();
        int size4 = result4.size();
        int maxIndex = Math.max(Math.max(size2, size3), size4);

        for(int i=0; i<maxIndex; i++){
            Sheet423CoreModel sheet423CoreModel = new Sheet423CoreModel();
            sheet423CoreModel.setDate(new Timestamp(new Date().getTime()));

            setModel2(size2, i, result2, sheet423CoreModel);
            setModel3(size3, i, result3, sheet423CoreModel);
            setModel4(size4, i, result4, sheet423CoreModel);

            totalResult.add(sheet423CoreModel);
        }
    }

    private static void setModel2(int size, int index
            , ArrayList<Sheet423CoreModel> from, Sheet423CoreModel to){
        if(index >= size){
            to.setAsmName2("");
            to.setTotalSpace2(DBConfig.getDefaultNumericNullValue());
            to.setRemainSpace2(DBConfig.getDefaultNumericNullValue());
            to.setUsage2((float)DBConfig.getDefaultNumericNullValue());
        }else{
            Sheet423CoreModel fromModel = from.get(index);
            to.setAsmName2(fromModel.getAsmName2());
            to.setTotalSpace2(fromModel.getTotalSpace2());
            to.setRemainSpace2(fromModel.getRemainSpace2());
            to.setUsage2(fromModel.getUsage2());
        }
    }

    private static void setModel3(int size, int index
            , ArrayList<Sheet423CoreModel> from, Sheet423CoreModel to){
        if(index >= size){
            to.setAsmName3("");
            to.setTotalSpace3(DBConfig.getDefaultNumericNullValue());
            to.setRemainSpace3(DBConfig.getDefaultNumericNullValue());
            to.setUsage3((float)DBConfig.getDefaultNumericNullValue());
        }else{
            Sheet423CoreModel fromModel = from.get(index);
            to.setAsmName3(fromModel.getAsmName3());
            to.setTotalSpace3(fromModel.getTotalSpace3());
            to.setRemainSpace3(fromModel.getRemainSpace3());
            to.setUsage3(fromModel.getUsage3());
        }
    }

    private static void setModel4(int size, int index
            , ArrayList<Sheet423CoreModel> from, Sheet423CoreModel to){
        if(index >= size){
            to.setAsmName4("");
            to.setTotalSpace4(DBConfig.getDefaultNumericNullValue());
            to.setRemainSpace4(DBConfig.getDefaultNumericNullValue());
            to.setUsage4((float)DBConfig.getDefaultNumericNullValue());
        }else{
            Sheet423CoreModel fromModel = from.get(index);
            to.setAsmName4(fromModel.getAsmName4());
            to.setTotalSpace4(fromModel.getTotalSpace4());
            to.setRemainSpace4(fromModel.getRemainSpace4());
            to.setUsage4(fromModel.getUsage4());
        }
    }

    private static void inspect2(ArrayList<Sheet423CoreModel> sheet423Models) throws Exception{
        final String[] inspectedHosts = Sheet423CoreConfig.getInspectedHosts2();

        for(String host : inspectedHosts){
            inspectHost2(Sheet423CoreConfig.getUser()
                    , Sheet423CoreConfig.getPassword()
                    , host
                    , Sheet423CoreConfig.getPort()
                    , Sheet423CoreConfig.getSid()
                    , sheet423Models);
        }
    }

    private static void inspect3(ArrayList<Sheet423CoreModel> sheet423Models) throws Exception{
        final String[] inspectedHosts = Sheet423CoreConfig.getInspectedHosts3();

        for(String host : inspectedHosts){
            inspectHost3(Sheet423CoreConfig.getUser()
                    , Sheet423CoreConfig.getPassword()
                    , host
                    , Sheet423CoreConfig.getPort()
                    , Sheet423CoreConfig.getSid()
                    , sheet423Models);
        }
    }

    private static void inspect4(ArrayList<Sheet423CoreModel> sheet423Models) throws Exception{
        final String[] inspectedHosts = Sheet423CoreConfig.getInspectedHosts4();

        for(String host : inspectedHosts){
            inspectHost4(Sheet423CoreConfig.getUser()
                    , Sheet423CoreConfig.getPassword()
                    , host
                    , Sheet423CoreConfig.getPort()
                    , Sheet423CoreConfig.getSid()
                    , sheet423Models);
        }
    }

    private static void inspectHost2(String user
            , String password, String host
            , int port, String sid
            , ArrayList<Sheet423CoreModel> sheet423Models) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet423CoreConfig.getInspectSQL());

        final String[] fieldNames = Sheet423CoreConfig.getFieldNames();
        while (resultSet.next()){
            String asmName = resultSet.getString(fieldNames[0]);
            Integer totalSpace = resultSet.getInt(fieldNames[1]);
            Integer remainSpace = resultSet.getInt(fieldNames[2]);
            Float usage = resultSet.getFloat(fieldNames[3]);

            Sheet423CoreModel sheet423CoreModel = new Sheet423CoreModel();
            sheet423CoreModel.setAsmName2(asmName);
            sheet423CoreModel.setTotalSpace2(totalSpace);
            sheet423CoreModel.setRemainSpace2(remainSpace);
            sheet423CoreModel.setUsage2(usage);

            sheet423Models.add(sheet423CoreModel);
        }

        OracleConnector.closeConnection();
    }

    private static void inspectHost3(String user
            , String password, String host
            , int port, String sid
            , ArrayList<Sheet423CoreModel> sheet423Models) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet423CoreConfig.getInspectSQL());

        final String[] fieldNames = Sheet423CoreConfig.getFieldNames();
        while (resultSet.next()){
            String asmName = resultSet.getString(fieldNames[0]);
            Integer totalSpace = resultSet.getInt(fieldNames[1]);
            Integer remainSpace = resultSet.getInt(fieldNames[2]);
            Float usage = resultSet.getFloat(fieldNames[3]);

            Sheet423CoreModel sheet423CoreModel = new Sheet423CoreModel();
            sheet423CoreModel.setAsmName3(asmName);
            sheet423CoreModel.setTotalSpace3(totalSpace);
            sheet423CoreModel.setRemainSpace3(remainSpace);
            sheet423CoreModel.setUsage3(usage);

            sheet423Models.add(sheet423CoreModel);
        }

        OracleConnector.closeConnection();
    }

    private static void inspectHost4(String user
            , String password, String host
            , int port, String sid
            , ArrayList<Sheet423CoreModel> sheet423Models) throws Exception{

        Connection connection = OracleConnector.getConnection(user
                , password, host, port, sid);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Sheet423CoreConfig.getInspectSQL());

        final String[] fieldNames = Sheet423CoreConfig.getFieldNames();
        while (resultSet.next()){
            String asmName = resultSet.getString(fieldNames[0]);
            Integer totalSpace = resultSet.getInt(fieldNames[1]);
            Integer remainSpace = resultSet.getInt(fieldNames[2]);
            Float usage = resultSet.getFloat(fieldNames[3]);

            Sheet423CoreModel sheet423CoreModel = new Sheet423CoreModel();
            sheet423CoreModel.setAsmName4(asmName);
            sheet423CoreModel.setTotalSpace4(totalSpace);
            sheet423CoreModel.setRemainSpace4(remainSpace);
            sheet423CoreModel.setUsage4(usage);

            sheet423Models.add(sheet423CoreModel);
        }

        OracleConnector.closeConnection();
    }
}
