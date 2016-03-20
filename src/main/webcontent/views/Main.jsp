<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Library</title>

</head>
<body/>

<div style=" display:block; background-color:#dddddd; font-size:large;  width: 100%; margin: 0 auto;">

    <div id="header"
         style="background: #ccc; height: auto; vertical-align: middle; font-size:xx-large; font-weight: 300;">
        Online library

        <div id="search" style="align-content: center;  font-size:large; font-weight: 100;">
            <form action="${pageContext.servletContext.contextPath}/controller" method="POST">
                <input type="hidden" name="command" value="search">
                <select size="1" name="by">
                    <option disabled>Search by</option>
                    <option value="bookName">BookName</option>
                    <option value="genre">Genre</option>
                    <option value="author">Author</option>
                </select>
                <input type="text" name="searchString">
                <input type="submit" name="submit" value="Find">

            </form>
            <p style="color:black">${searchResult}</p>
            <c:set var="result" scope="application" value="${findResult}"/>

            <c:forEach items="${result}" var="book" varStatus="status">
                <a href="${pageContext.servletContext.contextPath}/controller?command=aboutBook&bookName=${book.toString()}">${book.toString()}</a>
                <br>
            </c:forEach>
        </div>
    </div>


    <div id="content" style="width:85%; height: 100%; background: #eee; float:left">
        <c:set var="books" scope="application" value="${books}"/>

        <c:forEach items="${books}" var="book" varStatus="status">
            <a href="${pageContext.servletContext.contextPath}/controller?command=aboutBook&bookName=${book.toString()}">${book.toString()}</a>
            <br>
            <hr>
        </c:forEach>

    </div>
    <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">
        <c:set var="isLogIn" scope="session" value="${isLogIn}"/>
        <c:if test="${isLogIn}">
            <c:set var="isAdmin" scope="session" value="${isAdmin}"/>
            <c:if test="${isAdmin}">
                <a href="${pageContext.servletContext.contextPath}/views/Admin.jsp">Add books</a><br>
            </c:if>

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
</body>
</html>