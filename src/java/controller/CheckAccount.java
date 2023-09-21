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
        PrintWriter out = response.getWriter();
        getUser userList = new getUser();
        ArrayList<User> listUser = userList.getUser();
        ShowUser user = new ShowUser();
        // Write the response message, in an HTML page
        try {
            boolean checkAcc = false;
            boolean checkPass = false;
            int userID = 1;
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Echo Servlet</title></head>");
            // Retrieve the value of the query parameter "username" (from text field)
            String username = request.getParameter("username");
            // Get null if the parameter is missing from query string.
            // Get empty string or string of white spaces if user did not fill in
            if (username == null
                    || (username = htmlFilter(username.trim())).length() == 0) {
                out.println("<p>Name: MISSING</p>");
            } else {
                for (User u : listUser) {
                    if (u.getUserPass().equals(username)) {
                        checkAcc = true;
                    }
                }
            }
            // Retrieve the value of the query parameter "password" (from password field)
            String password = request.getParameter("password");
            if (password == null
                    || (password = htmlFilter(password.trim())).length() == 0) {
                out.println("");
            } else {
                for (User u : listUser) {
                    if (u.getUserPass().equals(password)) {
                        checkPass = true;
                        userID = u.getUserID();
                    }
                }
            }
            if (checkAcc == true && checkPass == true) {
                user.processRequest(request, response, userID);
            } else {
                String errorMessage = "Your account or password is not found!";

                // Gửi thông báo về trang HTML bằng cách đặt nó trong thuộc tính của request
                request.setAttribute("errorMessage", errorMessage);

                // Chuyển hướng hoặc forward đến trang HTML
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
            out.println("</body></html>");
        } finally {
            out.close();  // Always close the output writer
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
