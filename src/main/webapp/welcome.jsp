<%-- 
    Document   : welcome
    Created on : 15/01/2024, 5:32:08 PM
    Author     : yih
--%>

<%@page import="my.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body bgcolor="#FFB6C1">
        <%
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String favouriteColour = request.getParameter("favouriteColour");
        %>
        <h1>Welcome <%= name %></h1>
        <p class="p">Your email is: <%= email %></p>
        <p class="p">Your password is: <%= password %></p>
        <p class="p">Your gender is: <%= gender %></p>
        <p class="p">Your favourite colour is: <%= favouriteColour %></p>
        <div class="parent_div">
            Click <a class="button" href="main.jsp">here</a> to proceed to the main page.
        </div>
        <%
            User user = new User(email,name,password,gender,favouriteColour);
            session.setAttribute("user", user);
        %>
    </body>
</html>
