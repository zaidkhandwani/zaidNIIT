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
<script>
	function formValidation() {
		var uid = document.registration.userid;
		var passid = document.registration.passid;
		var uname = document.registration.username;
		var uadd = document.registration.address;
		var ucountry = document.registration.country;
		var uzip = document.registration.zip;
		var uemail = document.registration.email;
		var umsex = document.registration.msex;
		var ufsex = document.registration.fsex;
		if (userid_validation(uid, 5, 12))
			var umob = document.registration.mob;
		{
			if (passid_validation(passid, 7, 12)) {
				if (allLetter(uname)) {
					if (alphanumeric(uadd)) {
						if (countryselect(ucountry)) {
							if (allnumeric(uzip)) {
								if (ValidateEmail(uemail)) {
									if (validsex(umsex, ufsex)) {
										if (allnumeric(umob)) {
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;

	}
	function userid_validation(uid, mx, my) {
		var uid_len = uid.value.length;
		if (uid_len == 0 || uid_len >= my || uid_len < mx) {
			alert("User Id should not be empty & length must be between " + mx
					+ " to " + my);
			uid.focus();
			return false;
		}
		return true;
	}
	function passid_validation(passid, mx, my) {
		var passid_len = passid.value.length;
		if (passid_len == 0 || passid_len >= my || passid_len < mx) {
			alert("Password should not be empty & length must be between " + mx
					+ " to " + my);
			passid.focus();
			return false;
		}
		return true;
	}
	function allLetter(uname) {
		var letters = /^[A-Za-z]+$/;
		if (uname.value.match(letters)) {
			return true;
		} else {
			alert('Username must have only alphabet characters');
			uname.focus();
			return false;
		}
	}

	function countryselect(ucountry) {
		if (ucountry.value == "Default") {
			alert('Select country');
			ucountry.focus();
			return false;
		} else {
			return true;
		}
	}
	function allnumeric(umob) {
		var numbers = /^[0-9]+$/;
		if (uzip.value.match(numbers)) {
			return true;
		} else {
			alert('Mobile Number must be Numeric');
			umob.focus();
			return false;
		}
	}
	function allnumeric(uzip) {
		var numbers = /^[0-9]+$/;
		if (uzip.value.match(numbers)) {
			return true;
		} else {
			alert('Zip Code Must Be Numeric');
			uzip.focus();
			return false;
		}
	}
	function ValidateEmail(uemail) {
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (uemail.value.match(mailformat)) {
			return true;
		} else {
			alert("Invalid E-mail");
			uemail.focus();
			return false;
		}
	}
	function validsex(umsex, ufsex) {
		x = 0;

		if (umsex.checked) {
			x++;
		}
		if (ufsex.checked) {
			x++;
		}
		if (x == 0) {
			alert('Select Gender');
			umsex.focus();
			return false;
		} else {
			alert('Form Succesfully Submitted');
			window.location.reload()
			return true;
		}
	}
</script>
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
							<li><a href="comp"> Computer &
									Accessories</a></li>
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



	<div class="container">
		<div class="form-group">

			<body onload="document.registration.userid.focus();">
				<div class="form-group">
					<form name='registration' onSubmit="return formValidation();"
						action="Success.html">

						<label for="userid">User id:</label> <input type="text"
							class="form-control" name="userid" placeholder="Enter User id" />
						<label for="passid">Password:</label> <input type="password"
							class="form-control" name="passid" placeholder="Enter Password" />
						<label for="username">Name:</label> <input type="text"
							class="form-control" name="username" placeholder="Enter Name" />
						<label for="address">Address:</label> <input type="text"
							class="form-control" name="address" placeholder="Enter Address" />
						<br> <label for="country">Country:</label> <select
							name="country">
							<option selected="" value="Default">Select</option>
							<option value="AF">Australia</option>
							<option value="AL">Canada</option>
							<option value="DZ">India</option>
							<option value="AS">Russia</option>
							<option value="AD">USA</option>
						</select> <br>
						<br>
						<label for="zip">ZIP Code:</label> <input type="text"
							class="form-control" name="zip" placeholder="Enter ZIP Code" /> <label
							for="email">Email Id:</label> <input type="text"
							class="form-control" name="email" size="50"
							placeholder="Enter Email Id" /> <br> <label for="mob">Mobile:</label>
						<input type="text" class="form-control" name="mob"
							placeholder="Enter Mobile Number" /> <br>
						<label id="gender">Sex:</label> <label class="radio-inline">
							<input type="radio" name="sex" id="msex" value="Male">Male
						</label> <label class="radio-inline"> <input type="radio"
							name="sex" id="fsex" value="Female">Female
						</label> <br> <br> <label>Language:</label> <label
							class="checkbox-inline"> <input type="checkbox" name="en"
							value="en" checked /><span>English</span></label> <label
							class="checkbox-inline"> <input type="checkbox"
							name="nonen" value="noen" /><span>Non English</span></label> <br>
						<br>
						<input type="submit" name="submit" value="Register" />

					</form>
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

