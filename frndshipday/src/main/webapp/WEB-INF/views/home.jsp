<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}

footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.glyphicon.glyphicon-fire {
	font-size: 15px;
}

.glyphicon.glyphicon-flash {
	font-size: 20px;
}

.orange, .orange a {
	color: #ffa500;
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
		display: none; # video-background { position : fixed;
		top: 0;
		right: 0;
		bottom: 0;
		left: 0;
		overflow: hidden;
		z-index: -100;
		width: 100%;
	}
}
</style>
</head>
<body>





	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/home"/>">electr<span
					class="glyphicon glyphicon-fire orange"></span>nica
				</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="#">Daily Deals</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Products<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value="/co"/>"> Computer &
									Accessories</a></li>
							<li><a href="<c:url value="/tv"/>">Television</a></li>
							<li><a href="<c:url value="/mobile"/>">Cell Phones</a></li>
							<li><a href="<c:url value="/ha"/>">Home Appliances</a></li>
							<li><a href="<c:url value="/watch"/>">Watches</a></li>
							<li class="divider"></li>
							<li><a href="#">More</a></li>
						</ul></li>
					<li><a href="#">Track Order</a></li>
					<li><a href="contact.html">Contact Us</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/signup"/>"><span
							class="glyphicon glyphicon-user"></span> Register</a></li>
					<li><a href="<c:url value="/login"/>"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<br>
	<br>

	<video id="video-background" preload muted autoplay loop>
		<source src="resources\video\mainvideo.mp4" type="video/mp4">
		<source src="resources\video\mainvideo.ogg" type="video/ogg">
	</video>


	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<a href="<c:url value="/comp"/>"><img
					src="resources\images\1.jpg" alt="laptop"></a>
				<div class="carousel-caption">
					<h3>Laptops</h3>
				</div>
			</div>

			<div class="item">
				<a href="<c:url value="/tv"/>"><img src="resources\images\6.jpg"
					alt="tv"></a>
				<div class="carousel-caption">
					<h3>Television</h3>
				</div>
			</div>
			<div class="item">
				<a href="<c:url value="/mobile"/>"><img
					src="resources\images\7.jpg" alt="mobile"></a>
				<div class="carousel-caption">
					<h3>Cell phones</h3>
				</div>
			</div>
			<div class="item">
				<a href="<c:url value="/ha"/>"><img src="resources\images\8.jpg"
					alt="ha"></a>
				<div class="carousel-caption">
					<h3>Home Appliance</h3>
				</div>
			</div>
			<div class="item">
				<a href="<c:url value="/watch"/>"><img
					src="resources\images\9.jpg" alt="watch" style="width: 100%"></a>
				<div class="carousel-caption">
					<h3>watch</h3>
				</div>
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<div class="container text-center">

		<div class="container">
			<h2>Running Deals</h2>

			<div class="row">
				<div class="col-md-4">
					<a href="resources\images\d1.jpg" class="thumbnail">
						<p>12 days of heavy discount.</p> <img
						src="resources\images\d1.jpg" alt="Pulpit Rock"
						style="width: 300px; height: 200px">
					</a>
				</div>
				<div class="col-md-4">
					<a href="resources\images\d2.jpg" class="thumbnail">
						<p>L.G, Sony, Samsung with 40% off</p> <img
						src="resources\images\d2.jpg" alt="Moustiers Sainte Marie"
						style="width: 300px; height: 200px">
					</a>
				</div>
				<div class="col-md-4">
					<a href="resources\images\d3.jpg" class="thumbnail">
						<p>Hot Deals</p> <img src="resources\images\d3.jpg"
						alt="Cinque Terre" style="width: 300px; height: 200px">
					</a>
				</div>
			</div>
		</div>
	</div>
	<br>













	<footer class="container-fluid text-center">
		<p>Copyrights reserved with Khandwani Mohd Zaid</p>
		<form class="form-inline">
			Get deals: <input type="email" class="form-control" size="50"
				placeholder="Email Address">
			<button type="button" class="btn btn-danger">Sign Up</button>
		</form>
	</footer>

</body>
</html>