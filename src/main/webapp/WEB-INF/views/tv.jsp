<!DOCTYPE html>
<html lang="en">
<head>
  <title>TV</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
    .jumbotron { min-height: 200px; }
    .carousel-inner > .item > img{
       width:100%;
       height:360px;
     }

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none;

</style>
</head>
<body>

<div class="jumbotron">
  <div class="container text-center">
    <h1 style="color:green;">electr<span class="glyphicon glyphicon-fire orange"></span>nica</h1>
    <p style="font-family:verdana;">Must have it? We've got it.</p>
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
				
			</div>
		</div>
	</nav>
<div class="row">
    <div class="col-md-4">
      <a href="resources\images\t1.jpg" class="thumbnail">
        <p>CRT</p>
        <img src="resources\images\t1.jpg" alt="CRT" style="width:150px;height:150px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="resources\images\t2.jpg" class="thumbnail">
        <p>LED TV</p>
        <img src="resources\images\t2.jpg" alt="LED" style="width:150px;height:150px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="resources\images\t3.jpg" class="thumbnail">
        <p>LCD TV</p>
        <img src="resources\images\t3.jpg" alt="LCD" style="width:150px;height:150px">
      </a>
    </div>
  </div>
<div class="row">
    <div class="col-md-4">
      <a href="resources\images\t4.jpg" class="thumbnail">
        <p>Curved</p>
        <img src="resources\images\t4.jpg" alt="Keyboards & Mouse" style="width:150px;height:150px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="resources\images\t5.jpg" class="thumbnail">
        <p>UHD TV</p>
        <img src="resources\images\t5.jpg" alt="HD TV" style="width:150px;height:150px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="resources\images\t6.jpg" class="thumbnail">
        <p>Smart TV</p>
        <img src="resources\images\t6.jpg" alt="Smart TV" style="width:150px;height:150px">
      </a>
    </div>
  </div>


  




<footer class="container-fluid text-center">
  <p>Copyrights reserved with Khandwani Mohd Zaid</p>
  <form class="form-inline">Get deals:
    <input type="email" class="form-control" size="50" placeholder="Email Address">
    <button type="button" class="btn btn-danger">Sign Up</button>
  </form>
</footer>

</body>
</html>

