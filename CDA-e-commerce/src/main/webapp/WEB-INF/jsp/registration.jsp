<%@ include file="header.jsp"%>

<main role="main">

	<section class="jumbotron"
		style="background-image: url(/resources/images/header.jpg); background-size: 100% 100%; height: 300px">
	</section>


	<div class="bg-light">
		<div class="container">

			<h2 class="form-signin-heading">Please register</h2>

			<form:form action="registration" cssClass="form-horizontal"
				method="post" modelAttribute="user">




				<p>
					<label for="username" class="sr-only">Username</label>
					<form:input path="username" cssClass="form-control"
						placeholder="Username" />

				</p>

				<p>
					<label for="password" class="sr-only">Password</label>
					<form:password path="password" cssClass="form-control"
						placeholder="Password" />

				</p>
				<p>
					<label for="matchingPassword" class="sr-only">Confirmation Password</label>

					<form:password path="matchingPassword" cssClass="form-control"
						placeholder="Confirmation Password" />

				</p>

				<button class="btn btn-lg btn-primary btn-block" type="submit">Créer un compte</button>

			</form:form>
			
			
			<div class="d-flex justify-content-center">
				<a href="/login">Login</a>
			</div>
		</div>
	</div>
</main>

<%@ include file="footer.jsp"%>
