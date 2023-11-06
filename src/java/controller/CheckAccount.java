/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        DAO user = new DAO();
        // Write the response message, in an HTML page
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (user.isValid(username, password)) {
                Cookie u = new Cookie("user_name", username);
                u.setMaxAge(60);
                response.addCookie(u);
                request.setAttribute("userFullName", user.getUsername());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                String errorMessage = "Your account or password is not found!";

                // Gửi thông báo về trang HTML bằng cách đặt nó trong thuộc tính của request
                request.setAttribute("errorMessage", errorMessage);

                // Chuyển hướng hoặc forward đến trang HTML
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
}