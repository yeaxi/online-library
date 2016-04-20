<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            <div id="about-book">
                <p>
                    Author : ${book.author} <br>
                    Genre : ${book.genre} <br>
                    Description : ${book.description}<br>
                </p>
            </div>

            <div id="actions">
                <c:if test="${isLogIn}">
                    <a href="${pageContext.servletContext.contextPath}/controller?command=addBook&login=${login}&bookName=${book.name}">
                        Add book to my list
                    </a>
                    <h5 style="color:green">${success}</h5>
                    <h5 style="color:darkred">${hasBook}</h5>

                    <a href="${pageContext.servletContext.contextPath}/controller?command=removeBook&login=${login}&bookName=${book.name}">
                        Remove book from my list
                    </a><br><br>
                    <c:if test="${isAdmin}">
                        <a href="${pageContext.servletContext.contextPath}/controller?command=adminRemoveBook&bookName=${book.name}">
                            Remove book from the server
                        </a>
                    </c:if>
                    <h4>${removeMessage}</h4>

                    <form action="/downloader">
                        <input type="hidden" name="bookName" value="${book.name}">
                        <input type="submit" value="Open/Download">
                    </form>

                    <h5 style="color:darkred">${downloadError}</h5>
                </c:if>
            </div>
        </div>

        <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">
            <a href="${pageContext.servletContext.contextPath}/book/showAll">Main</a><br>
            <c:set var="isLogIn" scope="session" value="${isLogIn}"/>
            <c:if test="${isLogIn}">
                <c:set var="isAdmin" scope="session" value="${isAdmin}"/>
                <c:if test="${isAdmin}">
                    <a href="${pageContext.servletContext.contextPath}/views/admin/Admin.jsp">Add books</a><br>
                </c:if>

                <c:set var="login" scope="session" value="${login}"/>
                <a href="${pageContext.servletContext.contextPath}/controller?command=AboutUser&login=${login}">My
                    books</a><br>
            </c:if>

            <c:if test="${!isLogIn}">
                <a href="${pageContext.servletContext.contextPath}/views/book/Login.jsp">Log in</a> <br>
                <a href="${pageContext.servletContext.contextPath}/views/book/SignUp.jsp">Sign up</a><br>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
