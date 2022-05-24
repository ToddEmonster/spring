<%--
  Created by IntelliJ IDEA.
  User: cefim
  Date: 23/05/2022
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common-head.jsp"/>
    <title>Login</title>
</head>
<body class="container h-100 pt-5 pb-3 d-flex flex-column align-items-center">
    <h1>Login form</h1>

    <form:form name='f' action="perform_login" method='POST'>

        <div class="form-group">
            <label for="loginInputUsername">Nom d'utilisateur</label>
            <input required name="username" type="text" class="form-control"  id="loginInputUsername" aria-describedby="usernameHelp" placeholder="Entrez votre nom d'utilisateur">
            <small id="usernameHelp" class="form-text text-muted">Vos données sont safe avec nous >:)</small>
        </div>
        <div class="form-group">
            <label for="loginInputPassword">Mot de passe</label>
            <input required name="password" type="password" class="form-control" id="loginInputPassword" placeholder="Mot de passe">
        </div>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Se souvenir de moi</label>
        </div>
        <button type="submit" class="btn btn-primary">Se connecter</button>

    </form:form>
</body>
</html>
