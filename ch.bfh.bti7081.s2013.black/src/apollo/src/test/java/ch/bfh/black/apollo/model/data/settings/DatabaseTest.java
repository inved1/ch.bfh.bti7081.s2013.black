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
    public void setSelectExecString() throws SQLException{
        Database.exec("SELECT '111'");
    }
    
    @Test (expected = SQLException.class)
    public void setelectExecStringFailure() throws SQLException{
        Database.exec("blubb");
    }
    
    @Test 
    public void setUpdateExecString() throws SQLException {
        Database.exec("UPDATE TB_CLIENT SET Name1 = '' WHERE 1=2");
        
    }
    @Test
    public void setUpdateExecStringReal() throws SQLException{
        Database.exec("UPDATE TB_CLIENT SET Name1 = 'Daniel Inversini' WHERE ID = 1");
        
    }
    
    
    
    
    
    
}