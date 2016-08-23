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
					<li><a href="#">Please Verify Your Details</a></li>
					
				</ul>
				
			</div>
		</div>
	</nav>

<form:form modelAttribute="User">
<div class="container">

<div class="form-group">
    

<form:label path="uid">User id:</form:label>${User.uid} <br>

<form:label path="upassword">Password:</form:label>${User.upassword} <br>
  
<form:label path="uname">Name:</form:label> ${User.uname} <br>

<form:label path="uaddress">Address:</form:label>  ${User.uaddress} <br>

<form:label path="umobile">Mobile:</form:label>  ${User.umobile} <br>

<form:label path="ucountry">Country:</form:label>${User.ucountry} <br>

<form:label path="uzip">ZIP Code:</form:label> ${User.uzip} <br>

<form:label path="umail">Email Id:</form:label>${User.umail} <br>

 
<form:label path="usex">Sex:</form:label> ${User.usex} <br> 


 <a href="${flowExecutionUrl}&_eventId_edit" class="btn btn-warning" role="button">Edit</a>
<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-success" role="button">Confirm</a>
  
  

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

