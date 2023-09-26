package com.pepsico.retail.helpers;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

@Component
public class ExcelReaderHelper {

    static String testDataFile = "./resources-testdata/TestDataForShopping.xlsx";

    public static Map<String,String> gettestDataInMap(String sheetName,String testCaseId) throws Exception{

        Fillo fillo = new Fillo();
        Connection conn = null;
        Recordset recordset = null;
        String query = String.format("SELECT * FROM %s WHERE scenario_id='%s'",sheetName,testCaseId);
        Map<String,String> TestDataInMap = new TreeMap<String,String>();

        try{
            conn = fillo.getConnection(testDataFile);
            recordset = conn.executeQuery(query);
            while(recordset.next()){
                for(String field:recordset.getFieldNames()){
                    TestDataInMap.put(field, recordset.getField(field));
                }
            }

        }catch(FilloException e){
            e.printStackTrace();
            throw new Exception("Test data not found....");
        }

        conn.close();
        return TestDataInMap;
    }
    
}
