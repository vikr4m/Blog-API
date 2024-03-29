<!doctype html>
<%@include file= "navbar.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Fetch</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
		<div class="container mt-5 text-center">
			<div class="row">
				<h3>Fetch Alien By ID</h3>
				<form action="getalien">
				Aid: <input type="text" name="aid"><br><br> 
				<input type="submit" value="Fetch"><br>
				</form>
			</div>
			<hr>
			<!-- <div class="row">
				<h3>Fetch Alien By Tech</h3>
				<form action="getbytechalien">
				Aid: <input type="text" name="tech"><br><br> 
				<input type="submit" value="Fetch"><br>
				</form>
			</div> -->
		</div>
</body>
</html>