<%@ include file="header.jsp"%>

<main role="main">

	<section class="jumbotron"
		style="background-image: url(/resources/images/header.jpg); background-size: 100% 100%; height: 300px"">
	</section>


	<div class="album py-5 bg-light">
		<div class="container">




			<div class="card mb-4 box-shadow">


				<img class="card-img-top" src="${product.picture}"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">${product.name}</h5>

					<h6 class="card-subtitle mb-2 text-muted">
						Prix : ${product.price}
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-currency-euro"
							viewBox="0 0 16 12"> <path
								d="M4 9.42h1.063C5.4 12.323 7.317 14 10.34 14c.622 0 1.167-.068 1.659-.185v-1.3c-.484.119-1.045.17-1.659.17-2.1 0-3.455-1.198-3.775-3.264h4.017v-.928H6.497v-.936c0-.11 0-.219.008-.329h4.078v-.927H6.618c.388-1.898 1.719-2.985 3.723-2.985.614 0 1.175.05 1.659.177V2.194A6.617 6.617 0 0 0 10.341 2c-2.928 0-4.82 1.569-5.244 4.3H4v.928h1.01v1.265H4v.928z"></path></svg>
					</h6>

					<p class="card-text">${product.description}</p>
					
					<h6 class="card-title">Quantit&eacute; : ${product.quantity}</h6>


					<a href="/orders/products/${product.id}" class="btn btn-primary">Ajouter au panier</a>
				</div>

			</div>


		</div>
	</div>

</main>

<%@ include file="footer.jsp"%>
