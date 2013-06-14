/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller;

import ch.bfh.black.apollo.controller.clientmanager.ClientChooserState;
import com.vaadin.navigator.Navigator;
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
public class MenuManagerTest {
    
    MenuManager menuManager = null;
    
    public MenuManagerTest() {
        menuManager = new MenuManager();
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
     * Test method for menuState in Range
     */
    @Test
    public void setMenuStateInRange() {
        menuManager.setMenuState(new ClientChooserState(menuManager));
    }
    
    /**
     * Test method for menuState = null
     */
    @Test(expected = IllegalArgumentException.class)
    public void setMenuStateNull() {
        menuManager.setMenuState(null);
    }
}