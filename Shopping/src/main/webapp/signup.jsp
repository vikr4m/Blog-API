<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<jsp:include page="navbar.jsp" />
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Signup</title>
</head>
<body>

	<div class="container text-center">
		<h2>Signup</h2>
		<div class="row">
			<div class="col-6 offset-3" >
				<div class="card">
					<div class="card-body">
						<form action="signup" method="post">
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text" id="username">Username</span>
								</div>
								<input type="text" class="form-control" name="username">
							</div><br>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text" id="email">Email</span>
								</div>
								<input type="email" class="form-control" name="email">
							</div><br>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text" id="password">Password</span>
								</div>
								<input type="password" class="form-control" name="password">
							</div><br>
							<button class="btn btn-success" type="submit">Signup</button>
						</form>
					</div>
				</div><br>
				<button class="btn btn-primary">	
							<a href="signup.jsp"></a>Signup
				</button>
			</div>
		</div>
	</div>
</body>
</html>