/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.getUser;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import models.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CheckAccount", urlPatterns = {"/CheckAccount"})
public class CheckAccount extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Set the response message's MIME type
        response.setContentType("text/html; charset=UTF-8");
        // Allocate a output writer to write the response message into the network socket
        getUser userList = new getUser();
        ArrayList<User> listUser = userList.getUser();
        ShowUser user = new ShowUser();
        // Write the response message, in an HTML page
        try {
            boolean checkAcc = false;
            String userID = "";
            // Retrieve the value of the query parameter "username" (from text field)
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // Get null if the parameter is missing from query string.
            // Get empty string or string of white spaces if user did not fill in
            for (User u : listUser) {
                if (u.getUserAccount().equals(username) && u.getUserPass().equals(password)) {
                    checkAcc = true;
                    userID = u.getUserID();
                }
            }
            if (checkAcc == true) {
                user.processRequest(request, response, userID);
            } else {
                String errorMessage = "Your account or password is not found!";

                // Gửi thông báo về trang HTML bằng cách đặt nó trong thuộc tính của request
                request.setAttribute("errorMessage", errorMessage);

                // Chuyển hướng hoặc forward đến trang HTML
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } finally {  // Always close the output writer
        }
    }

    // Filter the string for special HTML characters to prevent
    // command injection attack
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

    private static String htmlFilter(String message) {
        if (message == null) {
            return null;
        }
        int len = message.length();
        StringBuffer result = new StringBuffer(len + 20);
        char aChar;

        for (int i = 0; i < len; ++i) {
            aChar = message.charAt(i);
            switch (aChar) {
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                case '"':
                    result.append("&quot;");
                    break;
                default:
                    result.append(aChar);
            }
        }
        return (result.toString());
    }
}
