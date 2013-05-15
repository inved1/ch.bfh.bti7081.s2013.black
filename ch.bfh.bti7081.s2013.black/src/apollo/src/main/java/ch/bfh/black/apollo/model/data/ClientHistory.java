/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data;

import ch.bfh.black.apollo.model.data.arch.ClientHistoryInterface;
import ch.bfh.black.apollo.model.data.settings.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel Inversini
 */
public class ClientHistory implements ClientHistoryInterface{

    
    public final static String SQL_TABLENAME_CLIENTHISTORY = "APP.tb_client_history";
    public final static int DEFAULT_IDCLIENT = 0;
    public final static String DEFAULT_DESCRIPTION = "Beschrieb";

    private int myID;
    private int myIDClient;
    private String myDesc;
    
    
    public ClientHistory() throws SQLException{
        myID = 0;
        myIDClient = DEFAULT_IDCLIENT;
        myDesc = DEFAULT_DESCRIPTION;
    }
    
    public ClientHistory(int ID) throws SQLException, IllegalArgumentException {
        
        ResultSet   resultSet;
        
        resultSet = Database.exec("SELECT * FROM "+SQL_TABLENAME_CLIENTHISTORY+" WHERE ID = " + ID);
        
        if (!resultSet.first()) {
            throw new IllegalArgumentException("No clientHistory with the given id available.");
        }
        myID = resultSet.getInt("ID");
        myDesc = resultSet.getString("Description");
        myIDClient = resultSet.getInt("ID_Client");
        
    }

    
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

    @Override
    public void remove() throws SQLException, IllegalArgumentException {
        Database.exec("DELETE FROM "+SQL_TABLENAME_CLIENTHISTORY+" WHERE ID = " + myID);
        myID = 0;
    }

    @Override
    public int getID() {
        return myID;
    }

    @Override
    public void setClientID(Integer ID) {
        if (ID == null || ID<= 0 ) {
            throw new IllegalArgumentException("ID Invalid.");
        }
        myIDClient = ID;
    }

    @Override
    public Integer getClientID() {
        return myIDClient;
    }

    @Override
    public void setDescription(String desc) throws IllegalArgumentException {
        if (desc == null || desc.length() > 8000 ) {
            throw new IllegalArgumentException("Description is empty or too long (more than 8000 characters).");
        }
        myDesc = desc ;
    }

    @Override
    public String getDescription() {
        return myDesc;
    }

   
    
}
