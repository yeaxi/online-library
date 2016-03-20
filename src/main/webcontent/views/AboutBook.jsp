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
<div style="background-color:#dddddd;  width: 100%; margin: 0 auto;">
    <div style=" display: block">

        <div id="header"
             style="background: #ccc; height: auto; align-content: center; vertical-align: middle; font-size:xx-large; font-weight: 300;">

            ${book.name}
        </div>
        <div id="content" style="width:85%; height: 100%; background: #eee; float:left">
            <jsp:useBean id="book" class="models.Book" scope="session"/>
            <div id="about-book">
                <p>
                    Author : ${book.author} <br>
                    Genre : ${book.genre} <br>
                    Description : ${book.description}<br>
                </p>
            </div>

            <div id="actions">
                <c:if test="${isLogIn and book ne null}">
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
                        <input type="hidden" name="path" value="${book.filePath}">
                        <input type="submit" value="Open/Download">
                    </form>


                </c:if>

            </div>
        </div>
        <div id="navigation" style="width:15%; height: 100%; background-color: #dddddd; float: right;">

            <c:if test="${isLogIn}">

                <c:if test="${isAdmin}">
                    <a href="${pageContext.servletContext.contextPath}/views/Admin.jsp">Add books</a><br>
                </c:if>

                <a href="${pageContext.servletContext.contextPath}/controller?command=AboutUser&login=${login}">My
                    books</a><br>

            </c:if>

            <a href="${pageContext.servletContext.contextPath}controller?command=ShowBooks">Main</a>
        </div>
    </div>
</div>
</div>
</body>
</html>
