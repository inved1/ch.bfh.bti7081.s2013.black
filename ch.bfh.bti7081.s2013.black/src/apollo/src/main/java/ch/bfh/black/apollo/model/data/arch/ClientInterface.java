/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data.arch;

import java.sql.SQLException;
import java.util.ArrayList;

import ch.bfh.black.apollo.model.data.ClientHistory;
/**
 *
 * @author Daniel Inversini
 */
public interface ClientInterface {
    
    void addHistory(ClientHistory clienthistory) throws IllegalArgumentException;
    void removeHistory(ClientHistory clienthistory) throws IllegalArgumentException;
    
    

    void save() throws SQLException;
    
    void remove(boolean withHistory) throws SQLException, IllegalArgumentException;
    
    ClientInterface copy() throws SQLException;
  

    int getClientID();

    void setClientName1(String name1) throws IllegalArgumentException;
    String getName1();
    void setClientName2(String name2) throws IllegalArgumentException;
    String getName2();
    
    void setClientName3(String name3) throws IllegalArgumentException;
    String getName3();
    
    
    void setClientStreet(String street) throws IllegalArgumentException;
    String getStreet();
    
    void setClientZIP(String zip) throws IllegalArgumentException;
    String getZip();
    
    void setClientCity(String city) throws IllegalArgumentException;
    String getCity();
    
    void setClientCountry(String country) throws IllegalArgumentException;
    String getCountry();
    
    
    
    
}
