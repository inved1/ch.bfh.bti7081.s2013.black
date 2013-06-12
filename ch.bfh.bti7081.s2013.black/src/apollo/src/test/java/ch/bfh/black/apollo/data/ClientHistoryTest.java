package ch.bfh.black.apollo.data;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ch.bfh.black.apollo.model.data.ClientHistory;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fanky
 */
public class ClientHistoryTest {
    
    ClientHistory clientHistory = null;
    
    public ClientHistoryTest() throws SQLException {
        clientHistory = new ClientHistory();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
 
    @Test
    public void setClientIDInRange() {
        clientHistory.setClientID(11);
        assertEquals("expected: ID = 11", 11, clientHistory.getClientID(), 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientIDBeyondRange() {
        clientHistory.setClientID(-1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientIDNull() {
        clientHistory.setClientID(null);
    }
    
    @Test
    public void setDescriptionInRange() {
        clientHistory.setDescription("Hello World!");
        assertEquals("expected: 'Hello World!'", "Hello World!", clientHistory.getDescription());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setDescriptionBeyondRange() {
        char[] txt = new char[8001];
        clientHistory.setDescription(new String(txt));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setDescriptionNull() {
        clientHistory.setDescription(null);
    }
    
    @Test
    public void saveHistoryWrongClientID() throws SQLException {
       
        clientHistory.setClientID(999);
        clientHistory.setDescription("test");
        clientHistory.save();
    }
            
}