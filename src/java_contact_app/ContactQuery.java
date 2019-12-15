/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_contact_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sir
 */
public class ContactQuery {
    
    public void insertContact(Contact cont) throws SQLException {
        PreparedStatement statement = null;
        Connection conn = MyConnection.getConnection();
        
        try {
            statement = conn.prepareStatement(
                    "INSERT INTO mycontact (fullname, groupc, phone, email, address, picture, userid) VALUES (?,?,?,?,?,?,?)"
            );
            
            statement.setString(1, cont.getFullname());
            statement.setString(2, cont.getGroupc());
            statement.setString(3, cont.getPhone());
            statement.setString(4, cont.getEmail());
            statement.setString(5, cont.getAddress());
            statement.setBytes(6, cont.getPic());
            statement.setInt(7, cont.getUid());
            
            if(statement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "New Contact Added");
            } else {
                JOptionPane.showMessageDialog(null, "Something Wrong");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateContact(Contact cont, boolean withImage) throws SQLException {
        PreparedStatement statement = null;
        Connection conn = MyConnection.getConnection();
        String updateQuery = "";
        
        // if the user want to update the contact profile picture too
        if(withImage == true) {
            updateQuery = "UPDATE mycontact SET fullname = ?, groupc = ?, phone = ?, email = ?, address = ?, picture = ? WHERE id = ?";
            
            try {
                statement = conn.prepareStatement(updateQuery);

                statement.setString(1, cont.getFullname());
                statement.setString(2, cont.getGroupc());
                statement.setString(3, cont.getPhone());
                statement.setString(4, cont.getEmail());
                statement.setString(5, cont.getAddress());
                statement.setBytes(6, cont.getPic());
                statement.setInt(7, cont.getCid());

                if(statement.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Contact Data Edited");
                } else {
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else { // the user want to keep the same image | remove image from update
            updateQuery = "UPDATE mycontact SET fullname = ?, groupc = ?, phone = ?, email = ?, address = ? WHERE id = ?";
            
            try {
                statement = conn.prepareStatement(updateQuery);

                statement.setString(1, cont.getFullname());
                statement.setString(2, cont.getGroupc());
                statement.setString(3, cont.getPhone());
                statement.setString(4, cont.getEmail());
                statement.setString(5, cont.getAddress());
                statement.setInt(6, cont.getCid());

                if(statement.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Contact Data Edited");
                } else {
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void deleteContact(int cid) throws SQLException {
        PreparedStatement statement = null;
        Connection conn = MyConnection.getConnection();
        
        try {
            statement = conn.prepareStatement(
                    "DELETE FROM mycontact WHERE id = ?"
            );
            
            statement.setInt(1, cid);
            
            if(statement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Contact Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Something Wrong");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // create a list of contact
    public ArrayList<Contact> contactList(int userId) throws SQLException {
        
        ArrayList<Contact> clist = new ArrayList<>();
        
        Connection conn = MyConnection.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            
            st = conn.createStatement();
            rs = st.executeQuery("SELECT id, fullname, groupc, phone, email, address, picture, userid FROM mycontact WHERE userId = " + userId);
            Contact ct;
            
            while(rs.next()) {
                ct = new Contact(rs.getInt("id"),
                                rs.getString("fullname"),
                                rs.getString("groupc"),
                                rs.getString("phone"),
                                rs.getString("email"),
                                rs.getString("address"),
                                rs.getBytes("picture"),
                                0
                );
                clist.add(ct);
            }
            
        } catch(SQLException ex) {
            Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return clist;
    }
    
}
