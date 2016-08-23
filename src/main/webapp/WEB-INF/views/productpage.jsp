<!DOCTYPE html>
<html lang="en">
<head><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <title>Electronica</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
	background-color: #660033;
	clear: left;
	text-align: center;
	border-top-left-radius: 40px;
}

footer {
	padding: 1em;
	color: white;
	background-color: black;
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

/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}

/* Remove the jumbotron's default bottom margin */
.jumbotron {
	margin-bottom: 0;
}

/* footer bg & padding */


.glyphicon.glyphicon-fire {
	font-size: 40px;
}

.glyphicon.glyphicon-flash {
	font-size: 20px;
}

.orange, .orange a {
	color: #ffa500;
}

.red, .red a {
	color: #ff0000;
}

.jumbotron {
	min-height: 200px;
}

.carousel-inner>.item>img {
	width: 100%;
	height: 360px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}
</style>
</head>
<body>
	<div class="jumbotron">
		<div class="container text-center">
			<h1 style="color: green;">
				electr<span class="glyphicon glyphicon-fire orange"></span>nica
			</h1>
			<p style="font-family: verdana;">Must have it? We've got it.</p>
		</div>
	</div>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/home"/>">electronica</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="#">Daily Deals</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Products<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="comp"> Computer & Accessories</a></li>
							<li><a href="tv">Television</a></li>
							<li><a href="mobile">Cell Phones</a></li>
							<li><a href="ha">Home Appliances</a></li>
							<li><a href="watch">Watches</a></li>
							<li class="divider"></li>
							<li><a href="#">More</a></li>
						</ul></li>
					<li><a href="#">Track Order</a></li>
					<li><a href="contact">Contact Us</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<c:forEach items="${productList}" var="product" varStatus="status">
		<center>
			<div class="container1">

				<header>
					<h1>${product.name}</h1>
				</header>

				<a href="${product.image}"><img src="${product.image}" alt="${product.name}"
					style="width: 150px; height: 150px"></a>

				<article>
					<h1>${product.name}</h1>
					<p>${product.description}</p>
					<br> <br>
					<p>
						<font color="green">&#8377 ${product.price}</font>
					</p>

				</article>

				<footer>
					<a href="myCart/add/${product.id}" class="btn btn-success"
						role="button">Add To Cart</a>
				</footer>

			</div>
			<br> <br>

		</center>
	</c:forEach>

	<br>
	<br>








	


</body>
</html>

