<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RASTA
  Date: 14.03.2016
  Time: 12:10
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
        <td colspan="3">
            <h1>Logging in</h1>
        </td>
    </tr>
    <tr>
        <td colspan="2">

            <form action="${pageContext.servletContext.contextPath}/controller" method="POST">
                <input type="hidden" name="command" value="Login"/>
                <label for="login">Login</label>
                <input type="text" id="login" name="login"><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password"><br>
                <input type="submit" name="submit" value="Log in"><br>

                <p style="color:darkred;">${errorLoginPassMessage}</p>

            </form>
        </td>
        <td width="200" valign="top" align="left">
            <a href="${pageContext.servletContext.contextPath}/controller?command=ShowBooks">Main</a>
        </td>
    </tr>
</table>
</body>
</html>
