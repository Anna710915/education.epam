<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 20.12.2021
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 404</title>
    <br>
    Request From -> ${pageContext.errorData.requestURI}
    <br/>
    Exception -> ${pageContext.exception}
    <br/>
    Exception Status -> ${pageContext.errorData.statusCode}
    <br/>
    Servlet Name -> ${pageContext.errorData.servletName}
    <br/>
    <a href="index.jsp">backToStartPage</a>
</head>
<body>

</body>
</html>
