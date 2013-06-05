/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ch.bfh.black.apollo.model.data.Client;
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
public class ClientTest {
    
    Client client = null;
    
    public ClientTest() throws SQLException {
        client = new Client();
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
    public void setClientName1InRange() {
        client.setClientName1("Hans Muster");
        assertEquals("expected: 'Hans Muster'", "Hans Muster", client.getName1());
    }
    
    @Test
    public void setClientName1BeyondRange() {
        try {
            char[] txt = new char[299];
            client.setClientName1(new String(txt));
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientName1Null() {
        try {
            client.setClientName1(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientName2InRange() {
        client.setClientName2("Hans Muster");
        assertEquals("expected: 'Hans Muster'", "Hans Muster", client.getName2());
    }
    
    @Test
    public void setClientName2BeyondRange() {
        try {
            char[] txt = new char[299];
            client.setClientName2(new String(txt));
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientName2Null() {
        try {
            client.setClientName1(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientName3InRange() {
        client.setClientName3("Hans Muster");
        assertEquals("expected: 'Hans Muster'", "Hans Muster", client.getName3());
    }
    
    @Test
    public void setClientName3BeyondRange() {
        try {
            char[] txt = new char[299];
            client.setClientName3(new String(txt));
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientName3Null() {
        try {
            client.setClientName3(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientStreetInRange() {
        client.setClientStreet("Musterstrasse 123");
        assertEquals("expected: 'Musterstrasse 123'", "Musterstrasse 123", client.getStreet());
    }
    
    @Test
    public void setClientStreetBeyondRange() {
        try {
            char[] txt = new char[299];
            client.setClientStreet(new String(txt));
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientStreetNull() {
        try {
            client.setClientStreet(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientZIPInRange() {
        client.setClientZIP("3600");
        assertEquals("expected: '3600'", "3600", client.getZip());
    }
    
    @Test
    public void setClientZIPBeyondRange() {
        try {
            client.setClientZIP("12345");
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientZIPNull() {
        try {
            client.setClientZIP(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientCityInRange() {
        client.setClientCity("Musterstadt");
        assertEquals("expected: 'Musterstadt'", "Musterstadt", client.getCity());
    }
    
    @Test
    public void setClientCityBeyondRange() {
        try {
            char[] txt = new char[299];
            client.setClientCity(new String(txt));
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientCityNull() {
        try {
            client.setClientCity(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientCountryInRange() {
        client.setClientCountry("CH");
        assertEquals("expected: 'CH'", "CH", client.getCountry());
    }
    
    @Test
    public void setClientCountryBeyondRange() {
        try {
            client.setClientCountry("SUI");
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientCountryNull() {
        try {
            client.setClientCountry(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
    
    @Test
    public void setClientBirthdateNull() {
        try {
            client.setClientBirthdate(null);
            fail("should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iaEx) {
            assertTrue("expected: true", true);
        }
    }
}