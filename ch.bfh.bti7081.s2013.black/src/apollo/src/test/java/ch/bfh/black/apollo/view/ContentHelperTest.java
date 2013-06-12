/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view;

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
public class ContentHelperTest {
    
    ContentHelper ch;
    
    public ContentHelperTest() {
        
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


    @Test (expected = NullPointerException.class)
    public void testConstrutorNull(){
        ch = new ContentHelper(null);
    }

    @Test (expected = NullPointerException.class)
    public void testConstructorDoubleNull(){
        ch = new ContentHelper(null,null);
    }
}