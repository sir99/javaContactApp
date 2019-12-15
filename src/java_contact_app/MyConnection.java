/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_contact_app;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sir
 */
public class MyConnection {
    
    public static Connection getConnection() throws SQLException {
        
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_contact_app", "root", "adminweb123");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        return conn;
    }
    
}
