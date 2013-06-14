package ch.bfh.black.apollo.data;

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
 * @author Michael Fankhauser
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
    
    /**
     * Test method for clientName1 within range
     */
    @Test
    public void setClientName1InRange() {
        client.setClientName1("Hans Muster");
        assertEquals("expected: 'Hans Muster'", "Hans Muster", client.getName1());
    }
    
    /**
     * Test method for clientName1 beyond range
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientName1BeyondRange() {
        char[] txt = new char[299];
        client.setClientName1(new String(txt));
    }
    
    /**
     * Test method for clientName1 = null
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientName1Null() {
        client.setClientName1(null);   
    }
    
    /**
     * Test method for clientName1 within range
     */
    @Test
    public void setClientName2InRange() {
        client.setClientName2("Hans Muster");
        assertEquals("expected: 'Hans Muster'", "Hans Muster", client.getName2());
    }
    
    /**
     * Test method for clientName2 beyond range
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientName2BeyondRange() {
        char[] txt = new char[299];
        client.setClientName2(new String(txt));
    }
    
    /**
     * Test method for clientName2 = null
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientName2Null() {
        client.setClientName1(null);
    }
    
    /**
     * Test method for clientName3 within range
     */
    @Test
    public void setClientName3InRange() {
        client.setClientName3("Hans Muster");
        assertEquals("expected: 'Hans Muster'", "Hans Muster", client.getName3());
    }
    
    /**
     * Test method for clientName3 beyond range
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientName3BeyondRange() {
        char[] txt = new char[299];
        client.setClientName3(new String(txt));
    }
    
    /**
     * Test method for clientName3 = null
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientName3Null() {
        client.setClientName3(null);
    }
    
    /**
     * Test method for clientStreet within range
     */
    @Test
    public void setClientStreetInRange() {
        client.setClientStreet("Musterstrasse 123");
        assertEquals("expected: 'Musterstrasse 123'", "Musterstrasse 123", client.getStreet());
    }
    
    /**
     * Test method for clientStreet beyond range
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientStreetBeyondRange() {
        char[] txt = new char[299];
        client.setClientStreet(new String(txt));
    }
    
    /**
     * Test method for clientStreet = null
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientStreetNull() {
        client.setClientStreet(null);
    }
    
    /**
     * Test method for clientZIP within range
     */
    @Test
    public void setClientZIPInRange() {
        client.setClientZIP("3600");
        assertEquals("expected: '3600'", "3600", client.getZip());
    }
    
    /**
     * Test method for clientZIP beyond range
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientZIPBeyondRange() {
        client.setClientZIP("12345");
    }
    
    /**
     * Test method for clientZIP = null
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientZIPNull() {
        client.setClientZIP(null);
    }
    
    /**
     * Test method for clientCity within range
     */
    @Test
    public void setClientCityInRange() {
        client.setClientCity("Musterstadt");
        assertEquals("expected: 'Musterstadt'", "Musterstadt", client.getCity());
    }
    
    /**
     * Test method for clientCity beyond range
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientCityBeyondRange() {
        char[] txt = new char[299];
        client.setClientCity(new String(txt));
    }
    
    /**
     * Test method for clientCity = null
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientCityNull() {
        client.setClientCity(null);
    }
    
    /**
     * Test method for clientCountry within range
     */
    @Test
    public void setClientCountryInRange() {
        client.setClientCountry("CH");
        assertEquals("expected: 'CH'", "CH", client.getCountry());
    }
    
    /**
     * Test method for clientCountry beyond range
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientCountryBeyondRange() {
        client.setClientCountry("SUI");
    }
    
    /**
     * Test method for clientCountry = null
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientCountryNull() {
        client.setClientCountry(null);
    }
    
    /**
     * Test method for clientBirthdate = null
     */
    @Test(expected = IllegalArgumentException.class)
    public void setClientBirthdateNull() {
        client.setClientBirthdate(null);
    }
}