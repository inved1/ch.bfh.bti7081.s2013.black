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
            clientHistory.setClientID(1);
            fail("incorrect");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("correct exception thrown", true);
        }
    }
    
    @Test
    public void setClientIDNull() {
        try {
            clientHistory.setClientID(null);
        } catch (IllegalArgumentException iaEx) {
            assertTrue("correct exception thrown", true);
        }
    }
}