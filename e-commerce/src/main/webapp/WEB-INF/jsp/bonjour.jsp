<%--
  Created by IntelliJ IDEA.
  User: cefim
  Date: 23/05/2022
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Vous êtes connecté•e</h1>
    <security:authorize access="isAuthenticated()">
        Bonjour&nbsp;<security:authentication property="principal.username"/>
    </security:authorize>

</body>
</html>
