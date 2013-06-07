/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data.settings;

import java.sql.SQLException;
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
public class DatabaseTest {
    
    
    Database myDatabase;
    
    public DatabaseTest() {
        
        myDatabase = new Database();
        
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
    public void setExecString() throws SQLException{
        Database.exec("SELECT '111'");
    }
    
    @Test (expected = SQLException.class)
    public void setExecStringFailure() throws SQLException{
        Database.exec("blubb");
    }
    
    
    
    
}