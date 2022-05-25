<%@ include file="header.jsp"%>

<main role="main">

	<section class="jumbotron"
		style="background-image: url(/resources/images/header.jpg); background-size: 100% 100%; height: 300px">
	</section>


	<div class="bg-light">
		<div class="container">

			<form:form class="form-signin" method="POST" action="login">
				<h2 class="form-signin-heading">Please sign in</h2>
				<p>
					<label for="username" class="sr-only">Username</label> <input
						type="text" id="username" name="username" class="form-control"
						placeholder="Username" required autofocus />
				</p>
				<p>
					<label for="password" class="sr-only">Password</label> <input
						type="password" id="password" name="password" class="form-control"
						placeholder="Password" required />
				</p>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
					in</button>
			</form:form>

			<div class="d-flex justify-content-center">
				<a href="/registration">Créer un compte</a>
			</div>
		</div>
	</div>
</main>

<%@ include file="footer.jsp"%>
