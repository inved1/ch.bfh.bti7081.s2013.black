/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data.settings;

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
public class SettingsTest {
    
    Settings mySettings;
    
    public SettingsTest() {
        mySettings = new Settings();
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void getExistingSettingsValue(){
        Settings.get("DBtype");
    }
    
    @Test
    public void getNotExistingSettingsValue(){
        assertEquals(null, Settings.get("blubb"));
        
    }
}