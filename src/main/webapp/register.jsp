<%-- 
    Document   : register
    Created on : 15/01/2024, 4:35:16 PM
    Author     : yih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <div><span class="time" id="time"></span></div>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
        %>
        <h1>Sign Up<span class="message"><%=(existErr != null ? existErr : "")%></span></h1>
        <!--<form action="welcome.jsp" method="post">-->
        <form action="RegisterController" method="post">
            <table id="form_table">
                <tr><td>Email:</td><td><input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email" required"></td></tr>
                <tr><td>Full Name:</td><td><input type"text" placeholder="<%=(nameErr != null ? nameErr : "Enter name")%>" name="name" required></td></tr>
                <tr><td>Password:</td><td><input type="text" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password" required></td></tr>
                <!--                <tr><td>Full Name:</td><td><input type"text" placeholder="Enter name" name="name" required></td></tr>
                <tr><td>Password:</td><td><input type="text" placeholder="Enter password" name="name" required></td></tr>-->
                <tr><td>Gender:</td><td><input type="text" placeholder="Enter gender" name="gender" required></td></tr>
                <tr><td>Favourite Colour:</td><td><input type="text" placeholder="Enter favourite colour" name="favouriteColour" required></td></tr>
            </table>
            <div>
                <a class="button" href="index.jsp">Cancel</a>
                <input class="button" type="submit" value="Sign Up">
            </div>
        </form>
    </body>
</html>
