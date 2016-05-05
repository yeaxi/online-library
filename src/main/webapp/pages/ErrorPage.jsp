<%--
  Created by IntelliJ IDEA.
  User: RASTA
  Date: 16.03.2016
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<div style="font-size: large; color:black;">
    <div style="width: 85%; float: left">
        Request from ${pageContext.errorData.requestURI} is failed<br>
        Servlet name or type: ${pageContext.errorData.servletName}<br>
        Status id: ${pageContext.errorData.statusCode}<br>
        Exception: ${pageContext.errorData.throwable}<br>
    </div>
    <div style="width: 15%; float: right">
        <a style="align-content: center;" href="${pageContext.servletContext.contextPath}/controller?command=showBooks">Main</a>
    </div>
</div>


</body>
</html>
