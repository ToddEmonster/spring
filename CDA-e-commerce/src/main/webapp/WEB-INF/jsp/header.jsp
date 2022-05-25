<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Surf Shop by Peter</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/album/">

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">

</head>

<body>

	<header>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between" fill="white">
				<a href="/" class="navbar-brand d-flex align-items-center"> <img
					alt="icon" src="/resources/images/surf_white.png"> <strong>Surf
						Shop by Peter</strong>
				</a>
				<div>
					<security:authorize access="isAuthenticated()" >
						<a href="/logout"><span style="color:#ffffff">Bonjour <security:authentication property="principal.username" /></span></a>
					</security:authorize>
					<security:authorize access="isAnonymous()">
						<a href="/login"> <spanclass="glyphicon glyphicon-user"></span>Sign in</a>
					</security:authorize>

					<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22"
						fill="white" class="bi bi-person" viewBox="0 0 16 12">
  <path
							d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" />
</svg>

					<a href="/orders/current"> <svg
							xmlns="http://www.w3.org/2000/svg" width="22" height="22"
							fill="white" class="bi bi-cart" viewBox="0 0 16 16">
  <path
								d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
</svg>
					</a>
				</div>
			</div>
		</div>
	</header>