/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

/**
 *
 * @author ADMIN
 */
public class getUser extends DBConnect{
    public ArrayList<User> getUser(){
        ArrayList<User> userList = new ArrayList<>();
        try {
            String sqlQuery = "select * from [Users]";
            PreparedStatement stm = connection.prepareStatement(sqlQuery);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){   
                userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }
}