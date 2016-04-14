<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RASTA
  Date: 14.03.2016
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<div style=" display:block; background-color:#dddddd; font-size:large;  width: 80%; margin:0 150px 0 150px;">
    <div style=" display: block">

        <div align="center" id="header"
             style="background: #ccc; height: auto;  font-size:xx-large; font-weight: 300;">
            Logging in
        </div>

        <div id="content" style="width:85%; height: 100%; background: #eee; float:left">
            <form action="${pageContext.servletContext.contextPath}/controller" method="POST">
                <input type="hidden" name="command" value="Login"/>
                <label for="login">Login</label>
                <input type="text" id="login" name="login"><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password"><br>
                <input type="submit" name="submit" value="Log in"><br>

                <p style="color:darkred;">${errorLoginPassMessage}</p>
            </form>
        </div>

        <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">
            <a href="${pageContext.servletContext.contextPath}/controller?command=showBooks">Main</a>
        </div>
    </div>
</div>
</body>
</html>
