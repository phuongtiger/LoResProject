/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

/**
 *
 * @author ADMIN
 */
public class setUser extends DBConnect{
    public void setUser(String fullname, String account, String password){
        try {
            String sql2 = "INSERT INTO [Users] (UserID, Userfullname, PasswordHash, userAccount) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql2);
            stm.setInt(1, 7);
            stm.setString(2, fullname);
            stm.setString(3, account);
            stm.setString(4, password);
            stm.executeUpdate();
            System.out.println("Update success");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}