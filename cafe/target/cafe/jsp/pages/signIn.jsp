<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="absolutePath">${pageContext.request.contextPath}</c:set>
<c:set var="current_page" value="${pageContext.request.requestURI}" scope="session"/>
<c:choose>
    <c:when test="${not empty language}"> <fmt:setLocale value="${language}" scope="session"/></c:when>
    <c:when test="${empty language}"> <fmt:setLocale value="ru_RU" scope="session"/></c:when>
</c:choose>
<fmt:setBundle basename="language.language"></fmt:setBundle>

<fmt:message var="log" key="form.sign_in.login"></fmt:message>
<fmt:message var="pass" key="form.sign_in.password"></fmt:message>
<fmt:message var="sign_in_button" key="form.button.sign_in"></fmt:message>
<fmt:message var="errorMessage" key="error.login_or_password"></fmt:message>
<fmt:message var="go_back" key="form.button.back_main"></fmt:message>
<fmt:message var="user_blocked" key="form.user_status_blocked"></fmt:message>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script>
        function preventBack() {
            window.history.forward();
        }

        setTimeout("preventBack()", 0);
        window.onunload = function() {
            null
        };
        history.pushState(null, null, document.URL);
    </script>
    <title><fmt:message key="form.sign_in"/></title>
</head>
<body>
<div class="container justify-content-center">
    <h3 class="text-center p-3"><fmt:message key="form.sign_in"/></h3>
    <form name="LoginForm" method="post" action="${absolutePath}/controller" class="needs-validation" novalidate>
        <input type="hidden" name="command" value="sign_in"/>
        </br>
        <div class="form-group" class="mb-3">
            <label class="form-label">${log}</label>
            <input type="text" name="login" class="form-control"  required pattern="^[A-Za-zА-Яа-я0-9_]{4,16}$">
        </div>
        </br>
        <div class="form-group" class="mb-3">
            <label class="form-label">${pass}</label>
            <input type="password" name="password" class="form-control" required pattern="^[A-Za-zА-Яа-я0-9\.]{5,40}$">
            <div class="invalid-feedback">
                <fmt:message key="error.login_or_password"/>
            </div>
            <c:if test="${errorLoginPassMessage eq 'error.login_or_password'}">
                ${errorMessage}
            </c:if>
            <c:if test="${blocked eq 'form.user_status_blocked'}">
                ${user_blocked}
            </c:if>
            </br>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary"><fmt:message key="form.sign_in"/></button>
            <a class="btn btn-secondary" href="${absolutePath}/jsp/pages/guest.jsp" role="button">${go_back}</a>
            <a class="btn btn-info" href="${absolutePath}/jsp/pages/registration.jsp" role="button"><fmt:message key="registration.name"/></a>
        </div>
        </form>
</div>
<script>
    (function () {
        'use strict'
        var forms = document.querySelectorAll('.needs-validation')

        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
</body><hr/>
</html>
