<%@ include file="header.jsp"%>

<main role="main">

	<section class="jumbotron"
		style="background-image: url(/resources/images/header.jpg); background-size: 100% 100%; height: 300px">
	</section>


	<div class="container">
		<h1 class="jumbotron-heading">Mon panier</h1>
	</div>


	<div class="bg-light">
		<div class="container">

			<p>Commande n°${order.id}</p>
			<p>Statut ${order.status}</p>

			<ol class="list-group list-group-numbered">
				<c:forEach items="${order.orderProducts}" var="orderProduct">
					<li class="list-group-item d-flex justify-content-between align-items-start">
							<img src="${orderProduct.product.picture}" alt="..." class="rounded float-left" width="200px">
						<div class="ms-2">
							<div class="fw-bold">${orderProduct.product.name}</div>
							Quantity : ${orderProduct.quantity}
						</div> <span>${orderProduct.product.price}</span>
					</li>

				</c:forEach>
			</ol>
			<a href="/orders/current/update" class="btn btn-primary">Commander</a>
		</div>
	</div>
</main>

<%@ include file="footer.jsp"%>
