<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: RASTA
  Date: 17.03.2016
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<div style=" display:block; background-color:#dddddd; font-size:large;  width: 65%; margin:0 350px 0 350px;">
    <div style=" display: block">

        <div align="center" id="header"
             style="background: #ccc; height: auto;  font-size:xx-large; font-weight: 300;">
            Admin page
        </div>

        <div id="content" style="width:85%; height: 100%; background: #eee; float:left">
            <c:forEach var="user" items="${users}" varStatus="status">
                login:${user.login}<br>
                password:${user.password}<br>
                role: ${user.role}<br>
                <a href="${pageContext.servletContext.contextPath}/admin/removeUser?login=${user.login}">Delete user</a>
                <br>
                <hr>
            </c:forEach>

        </div>

        <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">
            <a href="${pageContext.servletContext.contextPath}/views/admin/AddBook.jsp">Add books</a><br>

            <a href="${pageContext.servletContext.contextPath}/main">Main</a><br>

            <security:authorize access="Authenticated">
                <a href="${pageContext.servletContext.contextPath}/user/profile">My
                    profile</a><br>
                <a href="${pageContext.servletContext.contextPath}/j_spring_security_logout">Log out</a><br>
            </security:authorize>

        </div>
    </div>
</div>
</body>
</html>
