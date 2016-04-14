<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div style=" display:block; background-color:#dddddd; font-size:large;  width: 80%; margin:0 150px 0 150px;">
    <div style=" display: block">

        <div align="center" id="header"
             style="background: #ccc; height: auto;  font-size:xx-large; font-weight: 300;">

            Adding books
        </div>

        <div id="content" style="width:85%; height: 100%; background: #eee; float:left">
            <jsp:useBean id="book" class="ua.dudka.models.Book" scope="session"/>

            <form action="/controller" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="command" value="AdminAddBook"/>
                <label for="bookName">BookName:</label>
                <input type="text" id="bookName" name="bookName"><br>
                <label for="author">Author:</label>
                <input type="text" id="author" name="author"><br>
                <label for="genre">Genre:</label>
                <input type="text" id="genre" name="genre"><br>
                <label for="desc">Description:</label>
                <textarea id="desc" name="description"></textarea><br>
                <label for="file">Choose file:</label>
                <input id="file" type="file" name="file">
                <input type="submit" name="submit" value="Add book"><br>

                <h5 style="color:green">${successAddingBook}</h5>
                <h5 style="color:darkred">${errorAddingBook}</h5>
            </form>

        </div>

        <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">

            <a href="${pageContext.servletContext.contextPath}/controller?command=showBooks">Main</a>
            <c:set var="isLogIn" scope="session" value="${isLogIn}"/>
            <c:if test="${isLogIn}">
                <c:set var="isAdmin" scope="session" value="${isAdmin}"/>

                <c:set var="login" scope="session" value="${login}"/>
                <a href="${pageContext.servletContext.contextPath}/controller?command=AboutUser&login=${login}">My
                    books</a><br>
                <a href="${pageContext.servletContext.contextPath}/controller?command=Logout">Log out</a><br>
            </c:if>

            <c:if test="${!isLogIn}">
                <a href="${pageContext.servletContext.contextPath}/views/UserLogin.jsp">Log in</a> <br>
                <a href="${pageContext.servletContext.contextPath}/views/UserSignUp.jsp">Sign up</a><br>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
