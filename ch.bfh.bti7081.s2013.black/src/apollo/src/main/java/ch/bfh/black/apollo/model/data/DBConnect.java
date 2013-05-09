package ch.bfh.black.apollo.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Daniel Inversini
 */
public class DBConnect {
    
    public static Connection con;
    public static String host;
    public static String user;
    public static String pw;
    
    
    
    public static void main(String args[]){
        
        try {
            host = "jdbc:derby://localhost:1527/apollo";
            user = "root";
            pw = "root";

            con = DriverManager.getConnection( host, user, pw );
            
            Statement stm = con.createStatement();
            String sqlCmd = "Select * from app.tb_Client";
            ResultSet rs = stm.executeQuery(sqlCmd);
            
            while(rs.next()) {
                int myID = rs.getInt("ID");
                String myName1 = rs.getString("Name1");
                
                System.out.println(myID);
                System.out.println(myName1);
            }
            
            
        } catch (SQLException ex) {
            System.out.println( ex.getMessage( ) );
        }
        
        
    }
            
}
