<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="UTF-8">
    <title></title>

</head>
<body>

<body>
<table border="2" width="100%">
    <tr>
        <td colspan="3">
            <h1>Signing up</h1>
        </td>
    </tr>
    <tr>
        <td colspan="2">

            <form action="${pageContext.servletContext.contextPath}/controller" method="POST">
                <input type="hidden" name="command" value="SignUp"/>
                <label for="login">Enter your login:</label>
                <input type="text" id="login" name="login"><br>
                <label for="password">Enter your password:</label>
                <input type="password" id="password" name="password"><br>
                <input type="submit" name="submit" value="Зарегестрироваться"><br>

                <p style="color:darkred">${errorSignUp}</p>


            </form>
        </td>
        <td width="200" valign="top" align="left">
            <a href="${pageContext.servletContext.contextPath}/controller?command=ShowBooks">Main</a><br>
            <a href="${pageContext.servletContext.contextPath}/views/UserLogin.jsp">Log in</a>
        </td>
    </tr>
</table>
</body>


</html>