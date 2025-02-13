<%-- 
    Document   : index
    Created on : 30/01/2024, 10:39:36 AM
    Author     : yih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>ISD Week6 Home Page</h1>
        <div>
            <a class="button" href="register.jsp">Register</a>
            <a class="button" href="login.jsp">Login</a>
            <a class="button" href="https://my.feit.uts.edu.au/">UTS FEIT</a>
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
