<%--
  Created by IntelliJ IDEA.
  User: cefim
  Date: 23/05/2022
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="common-head.jsp"/>
    <title>Bonjour</title>
</head>
<body>
    <h1>Vous êtes connecté•e</h1>
    <security:authorize access="isAuthenticated()">
        Bonjour&nbsp;<security:authentication property="principal.username"/>
    </security:authorize>

    <button type="button" class="btn btn-outline-danger">
        <a class="text-danger" href="<c:url value="/logout" />">Se déconnecter</a>
    </button>
</body>
</html>
