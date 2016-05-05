<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RASTA
  Date: 14.03.2016
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div style=" display:block; background-color:#dddddd; font-size:large;  width: 65%; margin:0 350px 0 350px;">
    <div style=" display: block">
        <div align="center" id="header"
             style="background: #ccc; height: auto;  font-size:xx-large; font-weight: 300;">
            Library
        </div>

        <div id="content" style="width:85%; height: 100%; background: #eee; float:left">

            <div id="info" style="width: 100%">
                <jsp:useBean id="user" class="ua.dudka.beans.User" scope="session"/>

                <form action="${pageContext.servletContext.contextPath}/user/edit" method="POST">

                    <label for="name">Enter your name:</label>
                    <input type="text" id="name" name="name" value="${user.name}"><br>

                    <label for="surname">Enter your surname:</label>
                    <input type="text" id="surname" name="surname" value="${user.surname}"><br>

                    <label for="age">Enter your age:</label>
                    <input type="text" id="age" name="age" value="${user.age}"><br>

                    <label for="sex">Enter your sex:</label>
                    <input type="text" id="sex" name="sex" value="${user.sex}"><br>

                    <input type="submit" name="submit" value="Confirm"><br>

                    <p style="color:darkred">${errorSignUp}</p>

                </form>
            </div>

        </div>

        <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">

            <a href="${pageContext.servletContext.contextPath}/main">Main</a><br>

            <a href="${pageContext.servletContext.contextPath}/user/profile">My profile</a><br>

            <a href="${pageContext.servletContext.contextPath}/j_spring_security_logout">Log out</a><br>

        </div>
    </div>
</div>
</body>
</html>
