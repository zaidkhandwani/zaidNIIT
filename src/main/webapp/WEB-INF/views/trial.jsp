<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Product Display</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
div.container1 {
	width: 70%;
	border: 1px solid gray;
	border-top-left-radius: 40px;
	border-bottom-right-radius: 40px;
}

header {
	padding: 1em;
	color: white;
	background-color: green;
	clear: left;
	text-align: center;
	border-top-left-radius: 40px;
}

footer {
	padding: 1em;
	color: white;
	background-color: green;
	clear: left;
	text-align: center;
	border-bottom-right-radius: 40px;
}

img {
	float: left;
	max-width: 500px;
	margin: 0;
	padding: 1em;
}

article {
	margin-left: 7px;
	border-left: 1px solid gray;
	padding: 1em;
	overflow: hidden;
}
</style>
</head>
<body>

<c:forEach items="${productList}" var="product" varStatus="status">
	<center>
		<div class="container1">

			<header>
				<h1>${product.name}</h1>
			</header>

			<img src="${product.image}" alt="${product.name}" style="width: 150px; height: 150px">

			<article>
				<h1>${product.name}</h1>
				<p>${product.description}</p>
				<br>
				<br>
				<a href="#" class="btn btn-info" role="button">View Details</a>
			
			</article>

			<footer><a href="#" class="btn btn-success" role="button">Add To Cart</a></footer>

		</div>
	</center>
	</c:forEach>

	<br>
	<br>











</body>
</html>

