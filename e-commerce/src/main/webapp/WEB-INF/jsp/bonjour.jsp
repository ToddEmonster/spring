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
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common-head.jsp"/>
    <title>Bonjour</title>
</head>
<body class="container h-100 pt-5 pb-3 d-flex flex-column align-items-center">
    <h1>Vous êtes connecté•e</h1>

    <div>
    <security:authorize access="isAuthenticated()">
        Bonjour&nbsp;<security:authentication property="principal.username"/>
    </security:authorize>
    </div>

    <form:form name='f' action="perform_logout" method='POST'>
        <button type="submit" class="btn btn-outline-danger mt-3">Se déconnecter</button>
    </form:form>

    <button type="button" class="btn btn-info mt-3">
        <a class="text-light" href="<c:url value="/products" />">Voir les produits</a>
    </button>
</body>
</html>
