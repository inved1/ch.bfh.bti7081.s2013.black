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

      
/*******************************************************************************
 * Project:        Apollo, MHC-PMS 
 * Universtity: BFH Bern
 * Course:      BTI7081q
 * 
 * Class:       Database.java
 * 
 *-*****************************************************************************/


/**
 *
 * @author Daniel Inversini
 * all static, dont need an object to be initialized at the moment
 * @returns always a resultSet
 * 
 */
public class Database {
    
    private static Connection myDBcnn = null;
    
    /**
     * Init connection, read from Settings
     * 
     * 29.05.2013 - register mysqlDriver, instead of derby driver
     * 
     * 
     * @throws SQLException if any error
     */
    private static synchronized void init() throws SQLException {
         if (myDBcnn == null ) {
            String dbType = Settings.get("DBtype");
            String dbHost = Settings.get("DBhost");
            String dbName = Settings.get("DBname");
            String dbUser = Settings.get("DBuser");
            String dbPassword = Settings.get("DBpw");
            String dbUrl = "jdbc:" + dbType + "://" + dbHost + "/" + dbName;
            

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            if (dbUser != null && dbPassword != null) {
                myDBcnn = DriverManager.getConnection(dbUrl, dbUser,
                        dbPassword);
            } else {
                myDBcnn = DriverManager.getConnection(dbUrl);
            }
        }
    }
    
    /**
     * executes an sql-commad with a statement on the DB. switches between select and insert/update/delete
     * 
     * @param sqlCMD the command to be executed on the DB
     * @return a ResultSet with the Information
     * @throws SQLException 
     */
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
    /**
     * executes an sql command on the db, with parameters
     * 
     * @param sqlCMD the command to be executed 
     * @param pParameter the parametes, arraylist
     * @return a resultSet
     * @throws SQLException if any error on the DB
     */
    
    public static ResultSet exec(String sqlCMD, ArrayList<String> pParameter) throws SQLException {
        String[] arrayOfParameters = new String[pParameter.size()];
        return exec(sqlCMD, pParameter.toArray(arrayOfParameters));
    }
    
        /**
         * executes an sql command on the DB, with parameters, replaces paremeters with '?'
         * @param sqlCMD the command
         * @param pParameter the parameters
         * @return a resultset with the result
         * @throws SQLException  if any error on the DB
         */
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

