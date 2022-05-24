<%--
  Created by IntelliJ IDEA.
  User: cefim
  Date: 28/04/2022
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Produits</title>
    <link rel="icon" href="https://getbootstrap.com/docs/4.0/assets/img/favicons/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <jsp:include page="header.jsp"/>

    <main role="main" class="container h-100 pt-5 pb-3 d-flex flex-column align-items-center">

        <section class="jumbotron">
            <a href="/products">
                <button type="button" class="btn btn-sm btn-outline-secondary">Retour</button>
            </a>
            <h1 class="jumbotron-heading text-center">${product.name}</h1>
        </section>

        <div class="album py-5 bg-light d-flex justify-content-center">
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top" src="${product.picture}" alt="Card image cap">
                    <div class="card-body">
                        <div class="d-flex justify-content-between align-items-center">
                            <p class="card-text text-center font-weight-bold mb-0">${product.name}</p>
                            <button type="button" class="btn btn-sm btn-outline-secondary">Acheter</button>
                        </div>
                        <div class="d-flex justify-content-between align-items-center">
                            <span class="my-3 font-italic w-100 text-center">${product.description}</span>
                        </div>
                        <div class="d-flex justify-content-between align-items-center">
                            <small class="text-info font-weight-bold">${product.price} €</small>
                            <small class="text-muted">Stock restant : ${product.quantity}</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </main>

    <footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? <a href="../../">Visit the homepage</a> or read our <a href="../../getting-started/">getting started guide</a>.</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/popper.min.js"></script>
<script src="https://getbootstrap.com/docs/4.0/dist/js/bootstrap.min.js"></script>
<script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/holder.min.js"></script>


</body>
</html>
