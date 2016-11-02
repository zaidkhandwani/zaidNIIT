<!DOCTYPE html>
<html lang="en">
<head>
<title>NIIT.Hub</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<style>

.navbar-default.navbar-fixed-top {
    height: 60px; /* Whatever you want. */
}
.navbar-default .navbar-nav>li>a:hover, .navbar-default .navbar-nav>li>a:focus
	{
	color: #66ffff; /*Sets the text hover color on navbar*/
	
}

.navbar-default .navbar-nav>.active>a, .navbar-default .navbar-nav>.active>a:hover,
	.navbar-default .navbar-nav>.active>a:focus {
	color: white; /*BACKGROUND color for active*/
	background-color: red;
	height: 60px;
}

.navbar-default {
	background-color: #006dcc;
	border-color: #030033;

}

.dropdown-menu>li>a:hover, .dropdown-menu>li>a:focus {
	color: #262626;
	text-decoration: none;
	background-color: #66CCFF; /*change color of links in drop down here*/
}

.nav>li>a:hover, .nav>li>a:focus {
	text-decoration: none;
	background-color: #66ffff; /*Change rollover cell color here*/
}

.navbar-default .navbar-nav>li>a {
	color: white; /*Change active text color here*/
}
</style>
</head>
<body ng-app="myApp">

	<nav class="navbar navbar-default navbar-fixed-top ">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><p style="color: white;">
						<span class="glyphicon glyphicon-education"></span><b> NiiT</b>
						Hub
					</p></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Blogs</a></li>
					<li><a href="#">Forum</a></li>
					<li><a href="#">Events</a></li>
					<li><a href="#">News</a></li>
					<li><a href="#">Career</a></li>
			
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group input-group">
						<input type="text" class="form-control" placeholder="Search Blog">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</form>
				<div ng-if="currentUser.username">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							{{currentUser.username}}</a></li>
				</ul>
				</div>
			</div>
		</div>
	</nav>
	
	
	
	
	<div ng-view></div>
	
	
	
	
	<nav class="navbar navbar-default navbar-fixed-bottom ">
		<div class="container-fluid">
			<div class="navbar-header">
		</div>
			
				<ul class="nav navbar-nav">
				
					<li><a href="#">&copy; 2016. Khandwani Mohd. Zaid.</a></li>
				</ul>
			<div ng-if="currentUser.username">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				</ul>
			</div>
	
	</nav>

</body>
<script src="app.js"></script>
<script src="User/UserController.js"></script>
<script src="User/UserService.js"></script>
<script src="Blog/BlogController.js"></script>
<script src="Blog/BlogService.js"></script>
</html>

