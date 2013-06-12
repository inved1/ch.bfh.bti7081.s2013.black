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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
      
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
    public final static Date CLIENT_BIRTHDATE = null;
    
    //values for DB, with ID
    private int myID;
    private String myName1;
    private String myName2;
    private String myName3;
    private String myStreet;
    private String myZIP;
    private String myCity;
    private String myCountry;
    private Date myBirthdate;

    
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
        myBirthdate = CLIENT_BIRTHDATE;
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
        myBirthdate = resultSet.getDate("Birthdate");
        
        
        
        //get history
        myHistory = new ArrayList<ClientHistory>();
        
        resultSet = Database.exec("SELECT ID from " + SQL_TABLENAME_CLIENTHISTORY + " WHERE ID_Client = " + ID);
        while (resultSet.next()){
            myHistory.add(new ClientHistory(resultSet.getInt("ID")));
            
        }

    }
    
    /**
     * list all existing Clients
     * 
     * @return list of all CLients 
     * @throws SQLException  if there's an error on the DB
     */
    public static ArrayList<Client> listAll() throws SQLException {
        return list("SELECT * FROM "+ SQL_TABLENAME_CLIENT + " Order by ID ASC ");
    }
    
    /**
     * Executes an SQL query and returns all the Clients 
     * @param SQLCmd the query which will be executed
     * @return a list with all the clients
     * @throws SQLException 
     */
    private static ArrayList<Client> list(String SQLCmd) throws SQLException {
        ArrayList<Client> lst = new ArrayList<Client>();
        ResultSet rs = Database.exec(SQLCmd);
        while (rs.next()){
            lst.add(new Client(rs.getInt("ID")));
        }
        return lst; 
   }
    
    /**
     * adds a history to the client
     * the client must be aviable, means saved on the db
     * 
     * @param clienthistory the history to be saved
     * @throws IllegalArgumentException  if the Client is not aviable or not saved
     */
    @Override
    public void addHistory(ClientHistory clienthistory) throws IllegalArgumentException {
        if (clienthistory == null || clienthistory.getID() <= 0 ){
            throw new IllegalArgumentException("History not aviable, mabye not saved yet");
        }
        
        myHistory.add(clienthistory);
        try {
            clienthistory.save();
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * removes a History from the client
     * @param clienthistory the history to reoved
     * @throws IllegalArgumentException uf the history is not on this client 
     */
    @Override
    public void removeHistory(ClientHistory clienthistory) throws IllegalArgumentException {
        if (!myHistory.remove(clienthistory)){
            throw new IllegalArgumentException("History not aviable on this Client.");
        }
    }

    /**
     * saves the client and its attributeso the DB
     * if it doesnt exists - insert, else update
     * @throws SQLException if any error on the DB
     */
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
        // needs to be redone in another sprint - 29.05.2013
        Database.exec("DELETE FROM " + SQL_TABLENAME_CLIENTHISTORY + " WHERE ID_Client = " + this.myID);
        
        for (ClientHistory h: this.myHistory){
            Database.exec("INSERT INTO " + SQL_TABLENAME_CLIENTHISTORY+ "(ID_Client,Description) VALUES("+this.myID+","+h.getDescription()+")");
        }
      
    }

    /**
     * removes a Client, with or without history. 
     * @param withHistory
     * @throws SQLException if there is an error on the DB
     * @throws IllegalArgumentException 
     */
    @Override
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

    /**
     * copys a whole Client, even with history
     * @return the new saved Client clone of this Client
     * @throws SQLException if any error on the DB
     */
    @Override
    public ClientInterface copy() throws SQLException {
        Client newClient = new Client();
        
        newClient.myName1 = this.myName1;
        newClient.myName2 = this.myName2;
        newClient.myName3 = this.myName3;
        newClient.myStreet = this.myStreet;
        newClient.myZIP = this.myZIP;
        newClient.myCity = this.myCity;
        newClient.myCountry = this.myCountry;
        
        try {
            for (ClientHistory cHistory: myHistory)
                newClient.addHistory(cHistory);
        }
        catch (IllegalArgumentException ex) {
            newClient.remove(false);
            throw ex;
        }
                
        
        newClient.save();
        return newClient;
                   
            
    }

   
    /**
     * returns the ID of the current CLient
     * @return the ID of the Client
     */
    @Override
    public int getClientID() {
        return myID;
    }

  
    /**
     * Sets the Name1 of the Client, checks lenght (max 255)
     * @param name1 the name to be saved
     * @throws IllegalArgumentException if any error
     */
    @Override
    public void setClientName1(String name1) throws IllegalArgumentException {
        if (name1 == null || name1.length() > 255 ) {
            throw new IllegalArgumentException("Name1 is empty or too long (more than 255 characters).");
        }
        myName1 = name1;
    }

    /**
     * returns the Name1 of the Client
     * @return the name1
     */
    @Override
    public String getName1() {
       return myName1;
    }

    /**
     * sets the name2 of the client, checks the length of the string, max 255
     * @param name2 the name2 of the client
     * @throws IllegalArgumentException if string is NULL or too long
     */
    @Override
    public void setClientName2(String name2) throws IllegalArgumentException {
        if (name2 == null || name2.length() > 255 ) {
            throw new IllegalArgumentException("Name2 is empty or too long (more than 255 characters).");
        }
        myName2 = name2;
    }


    /**
     * gets the name2 of the client
     * @return the name2
     */
    @Override
    public String getName2() {
        return myName2;
    }


    /**
     * sets the name3 of the client, checks also if null or length is too long, max 255
     * @param name3 the name3 of the client
     * @throws IllegalArgumentException if null or too long
     */
    @Override
    public void setClientName3(String name3) throws IllegalArgumentException {
        if (name3 == null || name3.length() > 255 ) {
            throw new IllegalArgumentException("Name3 is empty or too long (more than 255 characters).");
        }
        myName3 = name3;
    }

  
    /**
     * gets the name3 of the Client
     * @return the name3
     */
    @Override
    public String getName3() {
        return myName3;
    }


    /**
     * sets the street of the client, checks if null or string too long, max 255
     * @param street the new street to be saved
     * @throws IllegalArgumentException if its too long or null
     */
    @Override
    public void setClientStreet(String street) throws IllegalArgumentException {
        if (street == null || street.length() > 255 ) {
            throw new IllegalArgumentException("Street is empty or too long (more than 255 characters).");
        }
        myStreet = street;
    }

   
    /**
     * gets the street of the client
     * @return the street
     */
    @Override
    public String getStreet() {
        return myStreet;
    }

    
    /**
     * sets the zipcode of the client, as a string, not as an it
     * @param zip
     * @throws IllegalArgumentException if zhe zipcode is longer than 4 chars or if its null
     * 
     */
    @Override
    public void setClientZIP(String zip) throws IllegalArgumentException {
        if (zip == null || zip.length() > 4 ) {
            throw new IllegalArgumentException("ZIP is empty or too long (more than 4 characters).");
        }
        myZIP = zip;
    }

    /**
     * gets the zipcode - as a string, not an int
     * @return the zipcode
     */
    @Override
    public String getZip() {
        return myZIP;
    }

   
    /**
     * sets the client city, checks maxlenght and if'ts null
     * @param city
     * @throws IllegalArgumentException if string is too long or null
     */
    @Override
    public void setClientCity(String city) throws IllegalArgumentException {
        if (city == null || city.length() > 255 ) {
            throw new IllegalArgumentException("City is empty or too long (more than 255 characters).");
        }
        myCity = city;
    }

    /**
     * gets the clients city
     * @return the city
     */
    @Override
    public String getCity() {
        return myCity;
    }

    
    /**
     * sets the coutrny of the client,maxlength of 2
     * @param country 
     * @throws IllegalArgumentException if country is null or longer 2 chars
     */
    @Override
    public void setClientCountry(String country) throws IllegalArgumentException {
        if(country == null || country.length() > 2) {
             throw new IllegalArgumentException("Country is empty or too long (more than 2 characters).");
        }
        myCountry = country;
        
    }

    /**
     * gets the city of the client
     * @return the city
     */
    @Override
    public String getCountry() {
        return myCountry;
    }
    
    /**
     * 
     * @param myBirthdate 
     */
    @Override
    public void setClientBirthdate(Date birthdate) throws IllegalArgumentException {
        if (birthdate == null) {
            throw new IllegalArgumentException("Birthdate is empty.");
        }
        myBirthdate = (Date) birthdate.clone();
    }
    
    /**
     * gets the birthdate of the client
     * @return the birthdate 
     */
    @Override
    public Date getBirthdate() {
        //clone Date because it's an object, instead of i.e. an integer
        //otherwise we'll only return a refeerence, which could be modified without the "setter"
        return (Date)myBirthdate.clone();
    }
    
    

    /**
     * gets the history of the client as an array
     * @return the full history
     * @throws SQLException if any error on the DB
     */
    public ArrayList<ClientHistory> getClientHistory() throws SQLException{
        return myHistory;
    }

    
}


