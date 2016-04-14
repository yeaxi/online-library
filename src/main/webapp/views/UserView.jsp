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
<div style=" display:block; background-color:#dddddd; font-size:large;  width: 80%; margin:0 150px 0 150px;">
    <div style=" display: block">

        <div align="center" id="header"
             style="background: #ccc; height: auto;  font-size:xx-large; font-weight: 300;">
            My books
        </div>

        <div id="content" style="width:85%; height: 100%; background: #eee; float:left">

            <c:set var="books" scope="session" value="books"/>
            <c:forEach items="${books}" var="book" varStatus="status">
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
