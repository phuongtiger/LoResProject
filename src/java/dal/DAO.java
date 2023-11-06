/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

/**
 *
 * @author LENOVO
 */
public class DAO extends DBConnect{
    private  String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void addUser(String firstname, String lastname, String account, String password){
        String email = account + "@gmail.com";
        try {
            String sql2 = "INSERT INTO [User] (UserID, FirstName, LastName, Account, Password, Email, Phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql2);
            stm.setInt(1, 12);
            stm.setString(2, firstname);
            stm.setString(3, lastname);
            stm.setString(4, account);
            stm.setString(5, password);
            stm.executeUpdate();
            System.out.println("Add user success");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<User> getUser(){
        ArrayList<User> userList = new ArrayList<>();
        try {
            String sqlQuery = "select * from [User]";
            PreparedStatement stm = connection.prepareStatement(sqlQuery);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){   
                userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }
    private String md5(String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    
    
    public boolean isValid(String username, String password) {
        CallableStatement callableStatement = null;
        Boolean loginState = false;
        ArrayList<User> userList = getUser();
        try {
            callableStatement = connection.prepareCall("{call CheckLogin(?, ?)}");
            callableStatement.setString(1, username);
            callableStatement.setString(2, md5(password));
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                loginState = true;
                setUsername(rs.getString(1));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return loginState;
    }
}