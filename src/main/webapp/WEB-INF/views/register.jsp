<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<style>
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
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.glyphicon.glyphicon-fire {
	font-size: 40px;
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
				<a class="navbar-brand" href="home">electronica</a>
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
				<ul class="nav navbar-nav navbar-right">

					<li><a href="login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
				</ul>
			</div>
		</div>
	</nav>

<form:form action="addUser" method="post" enctype="multipart/form-data">
<div class="container">

<div class="form-group">
<form name='registration' onSubmit="return formValidation();">    

<label for="uid">User id:</label>  
<input type="text" class="form-control" name="uid" placeholder="Enter User id" pattern=".{6,15}" title="Username should not be less than 6 char and more than 15 char" required/> 
<label for="upassword">Password:</label>  
<input type="password" class="form-control" name="upassword" placeholder="Enter Password" pattern=".{6,15}" title="Password should not be less than 6 char and more than 15 char" required/>  
<label for="uname">Name:</label>  
<input type="text" class="form-control" name="uname" placeholder="Enter Name" pattern="[A-Za-z]{6,15}" title="Name should not be alphanumeric and should be between 6 to 15 char" required/> 
<label for="uaddress">Address:</label>  
<input type="text" class="form-control" name="uaddress" placeholder="Enter Address" required/> 
<label for="ucountry">Country:</label><br>
<select name="ucountry">  
<option selected="" value="Default" required>(Please select a country)</option>  
<option value="India">India</option>  
<option value="Australia">Australia</option>  
<option value="Canada">Canada</option>  
<option value="Russia">Russia</option>  
<option value="China">China</option>  
</select> 
<br><label for="uzip">ZIP Code:</label>  
<input type="text" class="form-control" name="uzip" placeholder="Enter ZIP Code" pattern="\d{6}" title="Invalid ZIP format" required/> 
<label for="umail">Email Id:</label>
<input type="text" class="form-control" name="umail" size="50" placeholder="Enter Email Id" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required/>
<br>  
<label id="gender">Sex:</label>  
<label class="radio-inline" required>
      <input type="radio" name="usex" id="msex" value="Male" >Male
    </label>
    <label class="radio-inline">
      <input type="radio" name="usex" id="fsex" value="Female" >Female
    </label>
    
<br>
<br>

 
<br><input type="submit" class="btn btn-primary active" name="submit" value="Register" /><br>
  
  
</form>
</div>
</div>
</form:form>







</body>






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

