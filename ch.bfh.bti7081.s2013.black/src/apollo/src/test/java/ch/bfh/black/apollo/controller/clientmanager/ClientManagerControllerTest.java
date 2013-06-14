/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller.clientmanager;

import ch.bfh.black.apollo.controller.MainMenuState;
import ch.bfh.black.apollo.controller.MenuManager;
import ch.bfh.black.apollo.model.State;
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
public class ClientManagerControllerTest {
    
    ClientManagerController clientManagerController = null;
    MenuManager menuManager = null;
    
    public ClientManagerControllerTest() {
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
 
    @Test
    public void chooseClientInRange() {
        
    }
    
    /**
     * Test method for clientId beyond range
     */
    @Test(expected = IllegalArgumentException.class)
    public void chooseClientBeyondRange() {
        ClientManagerController clientManagerController = new ClientManagerController(menuManager, new State());
        clientManagerController.chooseClient(-99);
    }
}