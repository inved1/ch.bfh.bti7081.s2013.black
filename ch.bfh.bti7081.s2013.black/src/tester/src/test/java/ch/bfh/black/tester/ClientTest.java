/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.tester;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Inversini
 */
public class ClientTest {
    
    public ClientTest() {
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
     * Test of getMyName method, of class Client.
     */
    @Test
    public void testGetMyName() {
        System.out.println("getMyName");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getMyName();
        assertEquals("fail",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMyName method, of class Client.
     */
    @Test
    public void testSetMyName() {
        System.out.println("setMyName");
        String myName = "";
        Client instance = new Client();
        instance.setMyName(myName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMyStreet method, of class Client.
     */
    @Test
    public void testGetMyStreet() {
        System.out.println("getMyStreet");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getMyStreet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMyStreet method, of class Client.
     */
    @Test
    public void testSetMyStreet() {
        System.out.println("setMyStreet");
        String myStreet = "";
        Client instance = new Client();
        instance.setMyStreet(myStreet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMyCity method, of class Client.
     */
    @Test
    public void testGetMyCity() {
        System.out.println("getMyCity");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getMyCity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMyCity method, of class Client.
     */
    @Test
    public void testSetMyCity() {
        System.out.println("setMyCity");
        String myCity = "";
        Client instance = new Client();
        instance.setMyCity(myCity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMyZIP method, of class Client.
     */
    @Test
    public void testGetMyZIP() {
        System.out.println("getMyZIP");
        Client instance = new Client();
        int expResult = 4900;
        int result = instance.getMyZIP();
        assertEquals("fail", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }

    /**
     * Test of setMyZIP method, of class Client.
     */
    @Test
    public void testSetMyZIP() {
        System.out.println("setMyZIP");
        int myZIP = 0;
        Client instance = new Client();
        instance.setMyZIP(myZIP);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMyCountry method, of class Client.
     */
    @Test
    public void testGetMyCountry() {
        System.out.println("getMyCountry");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getMyCountry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMyCountry method, of class Client.
     */
    @Test
    public void testSetMyCountry() {
        System.out.println("setMyCountry");
        String myCountry = "";
        Client instance = new Client();
        instance.setMyCountry(myCountry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addInfo method, of class Client.
     */
    @Test
    public void testAddInfo() throws Exception {
        System.out.println("addInfo");
        String info = "";
        Client instance = new Client();
        instance.addInfo(info);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeInfo method, of class Client.
     */
    @Test
    public void testRemoveInfo() throws Exception {
        System.out.println("removeInfo");
        String info = "";
        Client instance = new Client();
        instance.removeInfo(info);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}