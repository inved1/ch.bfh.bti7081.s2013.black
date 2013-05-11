/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data.arch;


import java.sql.SQLException;

/**
 *
 * @author Daniel Inversini
 */
public interface ClientHistoryInterface {
    void save() throws SQLException;
    void remove() throws SQLException, IllegalArgumentException;
    
    int getID();
    
    void setClientID(Integer ID);
    Integer getClientID();

    void setDescription(String desc) throws IllegalArgumentException;
    String getDescription();    
     
}
