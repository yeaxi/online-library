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
                <h4>${user.name} ${user.surname}</h4>
                <h5>Age: ${user.age}</h5>
                <h5>Sex: ${user.sex}</h5>
                <h5>Email: ${user.email}</h5>
                <hr>
                <a hidden="hidden" href="/controller?command=userEdit&login=${user.login}">Edit</a>
            </div>

            <c:forEach items="${user.books}" var="book" varStatus="status">
                <a href="${pageContext.servletContext.contextPath}/controller?command=AboutBook&bookName=${book}">${book}</a>
                <hr>
            </c:forEach>
        </div>

        <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">

            <a href="${pageContext.servletContext.contextPath}/controller?command=ShowBooks">Main</a><br>
            <a href="${pageContext.servletContext.contextPath}/controller?command=Logout">Log out</a><br>

        </div>
    </div>
</div>
</body>
</html>
