/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo;

import com.vaadin.server.VaadinRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Daniel Inversini
 */
public class ApolloTest {
    
    public ApolloTest() {
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
     * Test of init method, of class Apollo.
     */
    @Test(expected = NullPointerException.class)
    public void testInitNULLRequest() {
        System.out.println("init");
        VaadinRequest request = null;
        Apollo instance = new Apollo();
        instance.init(request);

    }
}