<%-- 
    Document   : ShowInfomation
    Created on : Sep 20, 2023, 3:13:16 PM
    Author     : ADMIN
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information of User</title>
    </head>
    <body>           
        <h1> Hello <%= request.getAttribute("userFullName") %></h1>  
    </body>
</html>
