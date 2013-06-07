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
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientName1BeyondRange() {
        char[] txt = new char[299];
        client.setClientName1(new String(txt));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientName1Null() {
        client.setClientName1(null);   
    }
    
    @Test
    public void setClientName2InRange() {
        client.setClientName2("Hans Muster");
        assertEquals("expected: 'Hans Muster'", "Hans Muster", client.getName2());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientName2BeyondRange() {
        char[] txt = new char[299];
        client.setClientName2(new String(txt));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientName2Null() {
        client.setClientName1(null);
    }
    
    @Test
    public void setClientName3InRange() {
        client.setClientName3("Hans Muster");
        assertEquals("expected: 'Hans Muster'", "Hans Muster", client.getName3());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientName3BeyondRange() {
        char[] txt = new char[299];
        client.setClientName3(new String(txt));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientName3Null() {
        client.setClientName3(null);
    }
    
    @Test
    public void setClientStreetInRange() {
        client.setClientStreet("Musterstrasse 123");
        assertEquals("expected: 'Musterstrasse 123'", "Musterstrasse 123", client.getStreet());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientStreetBeyondRange() {
        char[] txt = new char[299];
        client.setClientStreet(new String(txt));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientStreetNull() {
        client.setClientStreet(null);
    }
    
    @Test
    public void setClientZIPInRange() {
        client.setClientZIP("3600");
        assertEquals("expected: '3600'", "3600", client.getZip());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientZIPBeyondRange() {
        client.setClientZIP("12345");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientZIPNull() {
        client.setClientZIP(null);
    }
    
    @Test
    public void setClientCityInRange() {
        client.setClientCity("Musterstadt");
        assertEquals("expected: 'Musterstadt'", "Musterstadt", client.getCity());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientCityBeyondRange() {
        char[] txt = new char[299];
        client.setClientCity(new String(txt));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientCityNull() {
        client.setClientCity(null);
    }
    
    @Test
    public void setClientCountryInRange() {
        client.setClientCountry("CH");
        assertEquals("expected: 'CH'", "CH", client.getCountry());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientCountryBeyondRange() {
        client.setClientCountry("SUI");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientCountryNull() {
        client.setClientCountry(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setClientBirthdateNull() {
        client.setClientBirthdate(null);
    }
}