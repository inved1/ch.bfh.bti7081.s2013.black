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
    
    @Test
    public void setClientIDBeyondRange() {
        try {
            clientHistory.setClientID(-1);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientIDNull() {
        try {
            clientHistory.setClientID(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setDescriptionInRange() {
        clientHistory.setDescription("Hello World!");
        assertEquals("expected: 'Hello World!'", "Hello World!", clientHistory.getDescription());
    }
    
    @Test
    public void setDescriptionBeyondRange() {
        try {
            char[] txt = new char[8001];
            clientHistory.setDescription(new String(txt));
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    public void setDescriptionNull() {
        try {
            clientHistory.setDescription(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
}