<%--
  Created by IntelliJ IDEA.
  User: cefim
  Date: 24/05/2022
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="common-head.jsp"/>
    <title>S'inscrire</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <main class="container h-100 pt-5 pb-3 d-flex flex-column align-items-center">
        <form:form class="d-flex flex-column" method="POST" action="register" modelAttribute="newClient">
            <div class="form-group">
                <form:label path="username">Choisissez votre nom d'utilisateur</form:label>
                <form:input path="username" name="username" placeholder="Entrez votre nom d'utilisateur" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="email">Entrez votre email</form:label>
                <form:input path="email" name="email" placeholder="Entrez votre email" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="password">Choisissez votre mot de passe</form:label>
                <form:input path="password" name="password" placeholder="Mot de passe" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="passwordConfirmation">Confirmez votre mot de passe</form:label>
                <form:input path="passwordConfirmation" name="passwordConfirmation" placeholder="Mot de passe confirmation" class="form-control" />
            </div>
            <button type="submit" class="btn btn-primary mt-3">S'inscrire</button>
        </form:form>
    </main>
</body>
</html>
