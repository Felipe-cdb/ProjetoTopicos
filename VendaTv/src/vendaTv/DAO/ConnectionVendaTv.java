/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaTv.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author felipe
 */
public class ConnectionVendaTv {
    public Connection getConnection(){
        Connection conn = null;
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendastv?useSSL=false","root", "f0987f");
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return conn;
    }
    
}
