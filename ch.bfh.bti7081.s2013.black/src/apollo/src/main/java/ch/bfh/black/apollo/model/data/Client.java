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
      
/*******************************************************************************
 * Project:        Apollo, MHC-PMS 
 * Universtity: BFH Bern
 * Course:      BTI7081q
 * 
 * Class:       Client.java
 * 
 *-*****************************************************************************/

    
 /**
 * This Class represents a single Client. 
 * CLient data comes from a mySQL DB, tb_Client
 * 
 * 29.05.2013  INV: SQL Commands still used, procedures (stored) 2nd priority
 *  
 * 
 * @author Daniel Inversini
 */
public class Client  implements ClientInterface  {
    
    //default values for table
    public final static String SQL_TABLENAME_CLIENT = "TB_CLIENT";
    public final static String SQL_TABLENAME_CLIENTHISTORY = "TB_CLIENT_HISTORY";
    
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
      * Initializes a new Client with default attributes
      * @thrwos SQLException if there's an error on the DB
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
      * Initializes an existing CLient from the DB
      * 
      * loads also history, if exists (class ClientHistory.java)
      * 
      * @param ID - existing CLient 
      * @throws SQLException if there's an error on the DB
      * @throws IllegalArgumentException if the Param ID is invalid
      */
     
    public Client(int ID) throws SQLException, IllegalArgumentException {
        ResultSet resultSet = Database.exec("SELECT * FROM "+ SQL_TABLENAME_CLIENT +" WHERE ID = " + ID);
        if (!resultSet.next()) {
            throw new IllegalArgumentException("Kein Clienten gefunden mit ID =" + ID);
        }

        //initialize attributes
        myID = resultSet.getInt("ID");
        myName1 = resultSet.getString("Name1");
        myName2 = resultSet.getString("Name2");
        myName3 = resultSet.getString("Name3");
        myStreet = resultSet.getString("Street");
        myZIP = resultSet.getString("ZIP");
        myCity = resultSet.getString("City");
        myCountry = resultSet.getString("Country");
        
        
        
        //get history
        myHistory = new ArrayList<ClientHistory>();
        
        resultSet = Database.exec("SELECT ID from " + SQL_TABLENAME_CLIENTHISTORY + " WHERE ID_Client = " + ID);
        while (resultSet.next()){
            myHistory.add(new ClientHistory(resultSet.getInt("ID")));
            
        }

    }
    
    /**
     * 
     * @return list of all CLients 
     * @throws SQLException 
     */
    public static ArrayList<Client> listAll() throws SQLException {
        return list("SELECT * FROM "+ SQL_TABLENAME_CLIENT + " Order by ID ASC ");
    }
    
  
/*
    public static Container listAllContainer() throws SQLException {
        Container co = new IndexedContainer();
        co.addContainerProperty("Name1", String.class, "");
        co.addContainerProperty("ID", Integer.class,0);
        
        for(Client c: listAll()){
            
            Object o = co.addItem((Object) c.getClientID());
            Item i = (Item) o;
            i.
            co.addItem(c.getName1(),c.getClientID());
        }
        
        
        return null;
        
    }
*/
    private static ArrayList<Client> list(String SQLCmd) throws SQLException {
        ArrayList<Client> lst = new ArrayList<Client>();
        ResultSet rs = Database.exec(SQLCmd);
        while (rs.next()){
            lst.add(new Client(rs.getInt("ID")));
        }
        return lst; 
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

    public ArrayList<ClientHistory> getClientHistory() throws SQLException{
        return myHistory;
    }

    
}


