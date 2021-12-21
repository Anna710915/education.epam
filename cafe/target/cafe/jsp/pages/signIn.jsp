<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="absolutePath">${pageContext.request.contextPath}</c:set>
<c:set var="current_page" value="${pageContext.request.requestURI}" scope="session"/>
<fmt:setLocale value="${language}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="language.language" var="rb"></fmt:setBundle>

<fmt:message var="log" key="form.sign_in.login" bundle="${rb}"></fmt:message>
<fmt:message var="pass" key="form.sign_in.password" bundle="${rb}"></fmt:message>
<fmt:message var="sign_in_button" key="form.button.sign_in" bundle="${rb}"></fmt:message>
<fmt:message var="errorMessage" key="error.login_or_password" bundle="${rb}"></fmt:message>
<fmt:message var="go_back" key="form.button.back_main" bundle="${rb}"></fmt:message>
<fmt:message var="user_blocked" key="form.user_status_blocked" bundle="${rb}"></fmt:message>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
    <form name="LoginForm" method="post" action="${absolutePath}/controller">
            <input type="hidden" name="command" value="sign_in"/>
            ${log}<br/>
            <input type="text" name="login" value=""/>
            <br/>${pass}<br/>
            <input type="password" name="password" value=""/>
                <br/>
                    <c:if test="${errorLoginPassMessage eq 'error.login_or_password'}">
                        ${errorMessage}
                    </c:if>
                    <c:if test="${blocked eq 'form.user_status_blocked'}">
                        ${user_blocked}
                    </c:if>
                <br/>
        <input type="submit" value="${sign_in_button}"/>
    </form>
</body><hr/>
</html>
