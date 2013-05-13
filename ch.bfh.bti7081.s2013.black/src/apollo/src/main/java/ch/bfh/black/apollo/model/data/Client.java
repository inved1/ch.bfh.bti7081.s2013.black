/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch.bfh.black.apollo.model.data.arch.ClientInterface;
import ch.bfh.black.apollo.model.data.settings.Database;
      


  
   
    
    /**
 *
 * @author Daniel Inversini
 */
public class Client implements ClientInterface {
    
    //default values for table
    public final static String SQL_TABLENAME_CLIENT = "tb_client";
    public final static String SQL_TABLENAME_CLIENTHISTORY = "tb_client_history";
    
    //default values with new object
    public final static String CLIENT_NAME1 = "Hans Muster";
    public final static String CLIENT_NAME2 = "";
    public final static String CLIENT_NAME3 = "";
    public final static String CLIENT_STREET = "Musterstrasse 666";
    public final static String CLIENT_ZIP = "3000";
    public final static String CLIENT_CITY = "Bern";
    public final static String CLIENT_COUNTRY = "CH";
    
    //values for DB, with ID
    private int myID;
    private String myName1;
    private String myName2;
    private String myName3;
    private String myStreet;
    private String myZIP;
    private String myCity;
    private String myCountry;
    private String myCreatedBy;
    private String myCreatedTm;
    
    private ArrayList<ClientHistory> myHistory;
    
     /**
     * new client, default values
     */
    public Client() throws SQLException {
        myName1 = CLIENT_NAME1;
        myName2 = CLIENT_NAME2;
        myName3 = CLIENT_NAME3;
        myStreet = CLIENT_STREET;
        myZIP = CLIENT_ZIP;
        myCity = CLIENT_CITY;
        myCountry = CLIENT_COUNTRY;
        myHistory = new ArrayList<ClientHistory>();
               
    }
            
     /**
     * get a Client from DB
     */
    public Client(int ID) throws SQLException, IllegalArgumentException {
        ResultSet resultSet = Database.exec("SELECT * FROM "+ SQL_TABLENAME_CLIENT +" WHERE ID = " + ID);
        if (!resultSet.next()) {
            throw new IllegalArgumentException("Kein Clienten gefunden mit ID =" + ID);
        }

        myID = resultSet.getInt("ID");
        myName1 = resultSet.getString("Name1");
        myName2 = resultSet.getString("Name2");
        myName3 = resultSet.getString("Name3");
        myStreet = resultSet.getString("Street");
        myZIP = resultSet.getString("ZIP");
        myCity = resultSet.getString("City");
        myCountry = resultSet.getString("Country");
        
        
        myHistory = new ArrayList<ClientHistory>();
        
        resultSet = Database.exec("SELECT ID from " + SQL_TABLENAME_CLIENTHISTORY + " WHERE ID_Client = " + ID);
        while (resultSet.next()){
            myHistory.add(new ClientHistory(resultSet.getInt("ID")));
            
        }

      
    }
    

  
    public void addHistory(ClientHistory clienthistory) throws IllegalArgumentException {
        if (clienthistory == null || clienthistory.getID() <= 0 ){
            throw new IllegalArgumentException("History not aviable, mabye not saved yet");
        }
        
        myHistory.add(clienthistory);
                    
    }


    @Override
    public void removeHistory(ClientHistory clienthistory) throws IllegalArgumentException {
        if (!myHistory.remove(clienthistory)){
            throw new IllegalArgumentException("History not aviable on this CLient.");
        }
    }

    @Override
    public void save() throws SQLException {
        ResultSet resultSet;
        //exec
        if(myID == 0) //new
        {
            //make new arraylist and save with paramstring
            ArrayList<String> params = new ArrayList<String>();
            
            params.add(myName1);
            params.add(myName2);
            params.add(myName3);
            params.add(myStreet);
            params.add(myZIP);
            params.add(myCity);
            params.add(myCountry);
            
            
            String sqlCMD = "INSERT INTO " + SQL_TABLENAME_CLIENT + " (Name1, Name2, Name3, Street, ZIP, City, Country)";
            sqlCMD += " VALUES(?,?,?,?,?,?,?)";
            
            Database.exec(sqlCMD,params);
            resultSet = Database.exec("SELECT MAX(ID) FROM " + SQL_TABLENAME_CLIENT);
            resultSet.first();
            myID = resultSet.getInt("ID");                    
            
        }
        else //update
        {
            ArrayList<String> params = new ArrayList<String>();
            
            params.add(myName1);
            params.add(myName2);
            params.add(myName3);
            params.add(myStreet);
            params.add(myZIP);
            params.add(myCity);
            params.add(myCountry);
            params.add(Integer.toString(myID));
            
            String sqlCMD = "UPDATE " + SQL_TABLENAME_CLIENT + " SET Name1 = ?, Name2 = ?, Name3 = ?, Street = ?, ZIP = ?, City = ?, Country = ?";
            
            sqlCMD  += " WHERE ID = ?";
            
            Database.exec(sqlCMD, params);
        }
        
        //finally delete all history and ad them new - NOT VERY NICE
        Database.exec("DELETE FROM " + SQL_TABLENAME_CLIENTHISTORY + " WHERE ID_Client = " + this.myID);
        
        for (ClientHistory h: this.myHistory){
            Database.exec("INSERT INTO " + SQL_TABLENAME_CLIENTHISTORY+ "(ID_Client,Description) VALUES("+this.myID+","+h.getDescription()+")");
        }
      
    }

    public void remove(boolean withHistory) throws SQLException, IllegalArgumentException {
        ClientHistory ch;
        ResultSet resultSet;
        if (withHistory){
            resultSet = Database.exec("Select * FROM " + SQL_TABLENAME_CLIENTHISTORY + " WHERE ID_Client = "+this.myID );
            while (resultSet.next()) {
             ch = new ClientHistory(resultSet.getInt("ID"));
             Database.exec("DELETE FROM "+ SQL_TABLENAME_CLIENTHISTORY+ " WHERE ID = " +Integer.toString(ch.getID()));
            }
        }
        Database.exec("DELETE FROM " + SQL_TABLENAME_CLIENT + " WHERE ID = " + this.myID);
        this.myID = 0;
        
    }

    
    public ClientInterface copy() throws SQLException {
        Client newClient = new Client();
        
        newClient.myName1 = this.myName1;
        newClient.myName2 = this.myName2;
        newClient.myName3 = this.myName3;
        newClient.myStreet = this.myStreet;
        newClient.myZIP = this.myZIP;
        newClient.myCity = this.myCity;
        newClient.myCountry = this.myCountry;
        
        newClient.save();
        return newClient;
                   
            
    }

   
    public int getClientID() {
        return myID;
    }

  
    public void setClientName1(String name1) throws IllegalArgumentException {
        if (name1 == null || name1.length() > 255 ) {
            throw new IllegalArgumentException("Name1 is empty or too long (more than 255 characters).");
        }
        myName1 = name1;
    }

    public String getName1() {
       return myName1;
    }


    public void setClientName2(String name2) throws IllegalArgumentException {
        if (name2 == null || name2.length() > 255 ) {
            throw new IllegalArgumentException("Name2 is empty or too long (more than 255 characters).");
        }
        myName2 = name2;
    }


    public String getName2() {
        return myName2;
    }


    public void setClientName3(String name3) throws IllegalArgumentException {
        if (name3 == null || name3.length() > 255 ) {
            throw new IllegalArgumentException("Name3 is empty or too long (more than 255 characters).");
        }
        myName3 = name3;
    }

  
    public String getName3() {
        return myName3;
    }


    public void setClientStreet(String street) throws IllegalArgumentException {
        if (street == null || street.length() > 255 ) {
            throw new IllegalArgumentException("Street is empty or too long (more than 255 characters).");
        }
        myStreet = street;
    }

   
    public String getStreet() {
        return myStreet;
    }

    
    public void setClientZIP(String zip) throws IllegalArgumentException {
        if (zip == null || zip.length() > 4 ) {
            throw new IllegalArgumentException("ZIP is empty or too long (more than 4 characters).");
        }
        myZIP = zip;
    }

    
    public String getZip() {
        return myZIP;
    }

   
    public void setClientCity(String city) throws IllegalArgumentException {
        if (city == null || city.length() > 255 ) {
            throw new IllegalArgumentException("City is empty or too long (more than 255 characters).");
        }
        myCity = city;
    }

    
    public String getCity() {
        return myCity;
    }

    
    public void setClientCountry(String country) throws IllegalArgumentException {
        if(country == null || country.length() > 2) {
             throw new IllegalArgumentException("Country is empty or too long (more than 2 characters).");
        }
        myCountry = country;
        
    }

    @Override
    public String getCountry() {
        return myCountry;
    }


    
}

