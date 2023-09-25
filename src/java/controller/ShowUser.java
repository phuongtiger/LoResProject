/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.User;
import dal.getUser;
import java.io.PrintWriter;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="ShowUser", urlPatterns={"/ShowUser"})
public class ShowUser extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response , int ID)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userFullName = "";
        getUser userList = new getUser();
        ArrayList<User> listUser = userList.getUser();
        for (User u : listUser) {
            if(u.getUserID() == ID){
                userFullName = u.getUserLastName();
            }
        }
        request.setAttribute("userFullName", userFullName);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
}