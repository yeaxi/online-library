<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Library</title>

</head>
<body/>

<div style=" display:block; background-color:#dddddd; font-size:large;  width: 65%; margin:0 350px 0 350px;">

    <div align="center" id="header"
         style="background: #ccc; height: auto;  font-size:xx-large; font-weight: 300;">
        Online library

        <div id="search" style="align-content: center;  font-size:large; font-weight: 100;">
            <form action="${pageContext.servletContext.contextPath}/general/search" method="get">
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

            <c:forEach items="${result}" var="book" varStatus="status">
                <a href="${pageContext.servletContext.contextPath}/general/about?book=${book}">${book.toString()}</a>
                <br>
            </c:forEach>
        </div>
    </div>

    <div id="content" style="width:85%; height: 100%; background: #eee; float:left">
        <c:set var="books" scope="application" value="${books}"/>

        <c:forEach items="${books}" var="book" varStatus="status">
            <a href="${pageContext.servletContext.contextPath}/general/about?book=${book}">${book.toString()}</a>
            <br>
            <hr>
        </c:forEach>

    </div>
    <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">
        <c:set var="isLogIn" scope="session" value="${isLogIn}"/>
        <c:if test="${isLogIn}">
            <c:set var="isAdmin" scope="session" value="${isAdmin}"/>
            <c:if test="${isAdmin}">
                <a href="${pageContext.servletContext.contextPath}/views/admin/Admin.jsp">Add books</a><br>
            </c:if>

            <c:set var="login" scope="session" value="${login}"/>
            <a href="${pageContext.servletContext.contextPath}/user/profile">My
                profile</a><br>
            <a href="${pageContext.servletContext.contextPath}/us">Log out</a><br>
        </c:if>

        <c:if test="${!isLogIn}">
            <a href="${pageContext.servletContext.contextPath}/views/general/Login.jsp">Log in</a> <br>
            <a href="${pageContext.servletContext.contextPath}/views/general/SignUp.jsp">Sign up</a><br>
        </c:if>
    </div>
</div>
</body>
</html>