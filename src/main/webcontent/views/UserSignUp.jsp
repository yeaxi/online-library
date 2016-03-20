<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>Sign up</title>
</head>
<body>
<div style=" display:block; background-color:#dddddd; font-size:large;  width: 80%; margin:0 150px 0 150px;">
    <div style=" display: block">

        <div align="center" id="header"
             style="background: #ccc; height: auto;  font-size:xx-large; font-weight: 300;">
            Signing up
        </div>

        <div id="content" style="width:85%; height: 100%; background: #eee; float:left">

            <form action="${pageContext.servletContext.contextPath}/controller" method="POST">
                <input type="hidden" name="command" value="SignUp"/>
                <label for="login">Enter your login:</label>
                <input type="text" id="login" name="login"><br>
                <label for="password">Enter your password:</label>
                <input type="password" id="password" name="password"><br>
                <input type="submit" name="submit" value="Зарегестрироваться"><br>

                <p style="color:darkred">${errorSignUp}</p>


            </form>
        </div>

        <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">

            <a href="${pageContext.servletContext.contextPath}/controller?command=ShowBooks">Main</a><br>
            <a href="${pageContext.servletContext.contextPath}/views/UserLogin.jsp">Log in</a>
        </div>
    </div>
</div>
</body>


</html>