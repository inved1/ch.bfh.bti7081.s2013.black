/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data;

import ch.bfh.black.apollo.model.data.arch.ClientHistoryInterface;
import ch.bfh.black.apollo.model.data.settings.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/*******************************************************************************
 * Project:        Apollo, MHC-PMS 
 * Universtity: BFH Bern
 * Course:      BTI7081q
 * 
 * Class:       ClientInterface.java
 * 
 *-*****************************************************************************/

/**
 * This class represents the History of a Client
 * ClientHistory is stored in MYSQL DB, tb_CLientHistory
 * 
 * 30.05.2013  INV: Still uses SQL CMD's, change please to stored Procedures
 * @author Daniel Inversini
 */
public class ClientHistory implements ClientHistoryInterface{

    //default values
    public final static String SQL_TABLENAME_CLIENTHISTORY = "APP.tb_client_history";
    public final static int DEFAULT_IDCLIENT = 0;
    public final static String DEFAULT_DESCRIPTION = "Beschrieb";

    private int myID;
    private int myIDClient;
    private String myDesc;
    private Date myTm;
    
    
    /**
     * Inits a new ClientHistory with the Default values
     * @throws SQLException if any Errors
     */
    public ClientHistory() throws SQLException{
        myID = 0;
        myIDClient = DEFAULT_IDCLIENT;
        myDesc = DEFAULT_DESCRIPTION;
    }
    
    
    /**
     * Initializes a History from the Database, loads 
     * @param ID the ID of the History
     * @throws SQLException if any error on the DB
     * @throws IllegalArgumentException if ClientHistory not found
     */
    public ClientHistory(int ID) throws SQLException, IllegalArgumentException {
        
        ResultSet   resultSet;
        
        resultSet = Database.exec("SELECT * FROM "+SQL_TABLENAME_CLIENTHISTORY+" WHERE ID = " + ID);
        
        if (!resultSet.first()) {
            throw new IllegalArgumentException("No clientHistory with the given id available.");
        }
        myID = resultSet.getInt("ID");
        myDesc = resultSet.getString("Description");
        myIDClient = resultSet.getInt("ID_Client");
        myTm = resultSet.getDate("createdTm");
    }

    /**
     * saves the ClientHistoryto the DB, either insert or update
     * @throws SQLException if any error on the DB
     */
    @Override
    public void save() throws SQLException {
        ResultSet resultSet;
        if (myID > 0) { //UPDATE
            String[] param = { Integer.toString(myIDClient),myDesc};
            resultSet = Database.exec("UPDATE "+SQL_TABLENAME_CLIENTHISTORY+" SET ID_Client=?, Description=?", param);
        } else { //INSERT
            String[] param = { Integer.toString(myIDClient),myDesc};
            Database.exec("INSERT INTO "+SQL_TABLENAME_CLIENTHISTORY+" (ID_Client, Description) VALUES (?, ?)", param);
            resultSet = Database.exec("SELECT max(ID) FROM "+SQL_TABLENAME_CLIENTHISTORY);
            resultSet.first();
            myID = resultSet.getInt("ID");
        }
    }

    
    /**
     * removes this HistoryEntry from the Client
     * @throws SQLException if any Error on the DB
     * @throws IllegalArgumentException if any other Error
     */
    @Override
    public void remove() throws SQLException, IllegalArgumentException {
        Database.exec("DELETE FROM "+SQL_TABLENAME_CLIENTHISTORY+" WHERE ID = " + myID);
        myID = 0;
    }
    /**
     * gets the ID of the History Entry
     * @return ID
     */
    @Override
    public int getID() {
        return myID;
    }

    /**
     * sets The ClientID of this History Entry
     * @param ID 
     * @throws IllegalArgumentException if the ID is not valid
     */
    @Override
    public void setClientID(Integer ID) {
        if (ID == null || ID<= 0 ) {
            throw new IllegalArgumentException("ID Invalid.");
        }
        myIDClient = ID;
    }

    /**
     * gets the Timestamp of this LogEntry
     * @return Timestamp
     */
    public Date getTm(){
        return myTm;
    }
    
    /**
     * gets the CLientID
     * @return  ID
     */
    @Override
    public Integer getClientID() {
        return myIDClient;
    }

    
    /**
     * set the Description, text, of the CLientHistory
     * @param desc, the Text
     * @throws IllegalArgumentException if the length is longer than 8000 chars or null
     */
    @Override
    public void setDescription(String desc) throws IllegalArgumentException {
        if (desc == null || desc.length() > 8000 ) {
            throw new IllegalArgumentException("Description is empty or too long (more than 8000 characters).");
        }
        myDesc = desc ;
    }

    
    /**
     * gets the Description of the History Entry
     * @return the Text
     */
    @Override
    public String getDescription() {
        return myDesc;
    }

   
    
}
