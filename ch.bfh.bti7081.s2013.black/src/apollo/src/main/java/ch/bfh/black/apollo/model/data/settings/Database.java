/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data.settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Daniel Inversini
 * all static, blah blah dont want an object
 * @returns always a resultSet
 * 
 */
public class Database {
    
    private static Connection myDBcnn;
    
    private static synchronized void init() throws SQLException {
         if (myDBcnn == null || !myDBcnn.isValid(0)) {
            String dbType = Settings.get("DBtype");
            String dbHost = Settings.get("DBhost");
            String dbName = Settings.get("DBname");
            String dbUser = Settings.get("DBuser");
            String dbPassword = Settings.get("DBpassword");
            String dbUrl = "jdbc:" + dbType + "://" + dbHost + "/" + dbName;
            if (dbUser != null && dbPassword != null) {
                myDBcnn = DriverManager.getConnection(dbUrl, dbUser,
                        dbPassword);
            } else {
                myDBcnn = DriverManager.getConnection(dbUrl);
            }
        }
    }
    
    
    public static ResultSet exec(String sqlCMD) throws SQLException {
        init();
        Statement stmt = myDBcnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        //adjustments
        sqlCMD = sqlCMD.trim();
        if (sqlCMD.startsWith("SELECT")) {
            return stmt.executeQuery(sqlCMD);
        } else {
            stmt.executeUpdate(sqlCMD);
            //here I m returning no result set - we can change it to the current entity which we have changed 
            //mby trough a (stored) proc, or just get the acutal row, dont know yet - daniel inversini
            return null;
        }
        
    }
    
    public static ResultSet exec(String sqlCMD, ArrayList<String> pParameter) throws SQLException {
        String[] arrayOfParameters = new String[pParameter.size()];
        return exec(sqlCMD, pParameter.toArray(arrayOfParameters));
    }
    
        
     public static ResultSet exec(String sqlCMD, String[] pParameter) throws SQLException {
        init();
        PreparedStatement prepStatement = myDBcnn.prepareStatement(sqlCMD);
        //again 
        sqlCMD = sqlCMD.trim();
        for (int i = 0; i < pParameter.length; ++i) {
            prepStatement.setString(i+1, pParameter[i]);
        }
        if (sqlCMD.startsWith("SELECT")) {
            return prepStatement.executeQuery();
        } else {
            prepStatement.executeUpdate();
            return null;
        }
    }
        
        
}

