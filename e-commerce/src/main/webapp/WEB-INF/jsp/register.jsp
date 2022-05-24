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
        <form:form>
            <div class="form-group">
                <label for="registerInputUsername">Choisissez votre nom d'utilisateur</label>
                <input required name="username" type="text" class="form-control"  id="registerInputUsername" aria-describedby="usernameHelp" placeholder="Entrez votre nom d'utilisateur">
            </div>
            <div class="form-group">
                <label for="registerInputPassword">Choisissez votre mot de passe</label>
                <input required name="password" type="password" class="form-control" id="registerInputPassword" placeholder="Mot de passe">
            </div>
            <div class="form-group">
                <label for="registerInputPasswordConfirm">Confirmez votre mot de passe</label>
                <input required name="password" type="password" class="form-control" id="registerInputPasswordConfirm" placeholder="Mot de passe">
            </div>
            <button type="submit" class="btn btn-primary">S'inscrire</button>
        </form:form>
    </main>
</body>
</html>
