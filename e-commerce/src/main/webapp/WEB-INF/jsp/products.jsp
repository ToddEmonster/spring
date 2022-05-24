<%--
  Created by IntelliJ IDEA.
  User: cefim
  Date: 28/04/2022
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common-head.jsp"/>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">
    <title>Produits</title>
</head>
<body>
    <jsp:include page="header.jsp"/>

    <main role="main">

        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Emotions-Faciles.com</h1>
                <p class="lead text-muted">Difficile de ressentir ou retrouver certaines émotions ? Trouvez ce qui vous convient ici</p>
                <p>
                    <a href="#" class="btn btn-primary my-2">Prendre un abonnement</a>
                    <a href="#" class="btn btn-secondary my-2">En savoir plus</a>
                </p>
            </div>
        </section>

        <div class="album py-5 bg-light">
            <div class="container">

                <div class="row">

                    <c:forEach items="${products}" var="product">
                        <div class="col-md-4">
                            <div class="card mb-4 box-shadow">
                                <img class="card-img-top" src="${product.picture}" alt="Card image cap">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <p class="card-text text-center font-weight-bold mb-0">${product.name}</p>
                                        <a href="/products/${product.id}">
                                            <button type="button" class="btn btn-sm btn-outline-secondary">Voir</button>
                                        </a>
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
                    </c:forEach>
                </div> <%-- /end row --%>
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
