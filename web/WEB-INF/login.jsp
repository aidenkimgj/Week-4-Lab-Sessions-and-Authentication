<%-- 
    Document   : login
    Created on : Oct 7, 2020, 12:18:59 PM
    Author     : 837033
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="home" method="post">
            <label>Username: </label>
            <input type="text" name="username" value=""><br>
            <label>Password: </label>
            <input type="password" name="password" value=""><br>
            <input type="submit" value="Log in">
        </form>
        <div>
            ${message}
        </div>
        
    </body>
</html>
