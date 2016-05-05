<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


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
            <form action="${pageContext.servletContext.contextPath}/search" method="get">
                <select size="1" name="by">
                    <option disabled>Search by</option>
                    <option value="bookName">BookName</option>
                    <option value="genre">Genre</option>
                    <option value="author">Author</option>
                </select>
                <input type="text" name="searchString">
                <input type="submit" name="submit" value="Find">
            </form>

            <p style="color:black">${searchMessage}</p>

            <c:forEach items="${searchResult}" var="book" varStatus="status">
                <a href="${pageContext.servletContext.contextPath}/aboutBook?book=${book}">${book.name}</a>
            </c:forEach>
        </div>
    </div>

    <div id="content" style="width:85%; height: 100%; background: #eee; float:left">

        <c:set var="books" scope="application" value="${books}"/>

        <security:authorize access="authenticated">
        </security:authorize>
        <c:forEach items="${books}" var="book" varStatus="status">
            Name: ${book.name}<br>
            Author: ${book.author}<br>
            Genre: ${book.genre}<br>
            Description: ${book.description}<br>

            <security:authorize access="authenticated">
                <div id="actions">

                    <c:if test="${!usersBooks.contains(book)}">
                        <a href="${pageContext.servletContext.contextPath}/user/addBook?bookName=${book.name}">
                            Add to my list
                        </a><br>
                    </c:if>
                    <c:if test="${usersBooks.contains(book)}">
                        <a href="${pageContext.servletContext.contextPath}/user/removeBook?bookName=${book.name}">
                            Remove from my list
                        </a><br>
                    </c:if>
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="${pageContext.servletContext.contextPath}/admin/removeBook?bookName=${book.name}">
                            Remove from the server</a>
                        <br><br>
                    </security:authorize>

                    <form action="/user/download">
                        <input type="hidden" name="bookName" value="${book.name}">
                        <input type="submit" value="Open/Download">
                    </form>

                </div>
            </security:authorize>
            <hr>
        </c:forEach>

    </div>
    <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">

        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/pages/admin/AddBook.jsp">Add books</a><br>
            <a href="/admin/users">Admin page</a><br>
        </security:authorize>

        <security:authorize access="authenticated">
            <a href="/user/profile">My profile</a><br>
            <a href="<c:url value="/j_spring_security_logout"/> ">Log out</a><br>
        </security:authorize>

        <security:authorize access="anonymous">
            <a href="/login">Log in</a> <br>
            <a href="/signup">Sign up</a><br>
        </security:authorize>
    </div>
</div>
</body>
</html>