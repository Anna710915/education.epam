<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 19.12.2021
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="absolutePath">${pageContext.request.contextPath}</c:set>
<c:choose>
    <c:when test="${not empty language}"> <fmt:setLocale value="${language}" scope="session"/></c:when>
    <c:when test="${empty language}"> <fmt:setLocale value="${language = 'ru_RU'}" scope="session"/></c:when>
</c:choose>
<fmt:setBundle basename="language.language"/>
<fmt:message key="header.brand" var="brand"/>
<fmt:message key="header.about_us" var="about_us"/>
<fmt:message key="header.contacts" var="contacts"/>
<fmt:message key="header.language" var="lang"/>
<fmt:message key="header.main" var="main"/>
<fmt:message key="header.sign_in" var="login"/>
<html>
<head>
    <script>
        function preventBack() {
            window.history.forward();
        }

        setTimeout("preventBack()", 0);
        window.onunload = function() {
            null
        };
    </script>

  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-default">
    <div class="navbar-header">
      ${brand}
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">${main}</a></li>
        <li><a  href="#">${about_us}</a></li>
        <li><a  href="#">${contacts}</a></li>
              <c:choose>
                  <c:when test="${language eq 'ru_RU'}">
                    <li>
                      <a  href="${absolutePath}/controller?command=change_language&language=en_US">${lang}</a>
                    </li>
                  </c:when>
                  <c:when test="${language eq 'en_US'}">
                      <li>
                          <a  href="${absolutePath}/controller?command=change_language&language=ru_RU">${lang}</a>
                      </li>
                  </c:when>
                  <c:otherwise>
                      <li>
                          <a  href="${absolutePath}/controller?command=change_language&language=ru_RU">${lang}</a>
                      </li>
                  </c:otherwise>
              </c:choose>
        <li><a  href="${absolutePath}/jsp/pages/signIn.jsp">${login}</a></li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>
