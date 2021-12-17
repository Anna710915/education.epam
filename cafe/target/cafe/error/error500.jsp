<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
    request from= ${pageContext.errorData.requestURI} is failed
<hr/>
    exception= ${pageContext.exception}
<hr/>
    status= ${pageContext.errorData.statusCode}
<hr/>
    servlet name= ${pageContext.errorData.servletName}
<hr/>
<a href="index.jsp">toStartPage</a>
</body>
</html>
