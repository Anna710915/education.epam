<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="absolutePath">${pageContext.request.contextPath}</c:set>
<c:set var="current_page" value="${pageContext.request.requestURI}" scope="session"/>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="language.language" var="rb"/>
<html>
<header>
    <%@include file="header/header.jsp"%>
</header>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
GUEST
</body>
</html>