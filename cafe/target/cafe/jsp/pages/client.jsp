<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="page">
    <header>
        <%@include file="header/header.jsp"%>
    </header>
    ${user.firstName}, success!
    <div class="text-center">
        <ctg:footertag/>
    </div>
</div>
</body>
</html>
