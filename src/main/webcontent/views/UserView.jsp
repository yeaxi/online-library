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
<table border="2" width="100%">
    <tr>
        <td colspan="3" align="center">
            <h1>My books</h1>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:set var="books" scope="session" value="books"/>
            <c:forEach items="${books}" var="book" varStatus="status">
                <a href="${pageContext.servletContext.contextPath}/controller?command=AboutBook&bookName=${book}">${book}</a>
                <hr>
            </c:forEach>
        </td>
        <td width="200" valign="top" align="left">
            <a href="${pageContext.servletContext.contextPath}controller?command=ShowBooks">Main</a>
        </td>
    </tr>

</table>
</body>
</html>
