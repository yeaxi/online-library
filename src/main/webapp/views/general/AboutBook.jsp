<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: RASTA
  Date: 14.03.2016
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
<div style=" display:block; background-color:#dddddd; font-size:large;  width: 65%; margin:0 350px 0 350px;">
    <div style=" display: block">
        <div align="center" id="header"
             style="background: #ccc; height: auto;  font-size:xx-large; font-weight: 300;">

            ${book.name}
        </div>
        <div id="content" style="width:85%; height: 100%; background: #eee; float:left">
            <jsp:useBean id="book" class="ua.dudka.beans.Book" scope="session"/>

            <div id="about-book" style="width: 60%; float: left">
                <h3>
                    Author : ${book.author} <br>
                    Genre : ${book.genre} <br>
                    Description : ${book.description}<br>
                </h3>
            </div>

        </div>

        <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">

            <a href="${pageContext.servletContext.contextPath}/main">Main</a><br>

            <secutiry:authorize access="hasRole('ROLE_ADMIN')">
                <a href="${pageContext.servletContext.contextPath}/views/admin/AddBook.jsp">Add books</a><br>
            </secutiry:authorize>

            <secutiry:authorize access="authenticated">
                <a href="${pageContext.servletContext.contextPath}/user/profile">My
                    profile</a><br>
            </secutiry:authorize>

            <secutiry:authorize access="anonymous">
                <a href="${pageContext.servletContext.contextPath}/login">Log in</a> <br>
                <a href="${pageContext.servletContext.contextPath}/signup">Sign up</a><br>
            </secutiry:authorize>
        </div>
    </div>
</div>

</body>
</html>