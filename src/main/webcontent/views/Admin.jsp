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
<table border="2" width="100%">
    <tr>
        <td colspan="3">
            <h1>Adding books</h1>
        </td>
    </tr>
    <tr>
        <td colspan="2">

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
        </td>
        <td width="200" valign="top" align="left">
            <a href="${pageContext.servletContext.contextPath}/controller?command=showBooks">На главную</a>
        </td>
    </tr>
</table>
</body>
</html>
