<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Error - NIC Already Registered</title>
<!--  add css  -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.png" />
<!-- add css -->
<style>
/* styles.css */

/* Style the error message container */
.error-container {
	text-align: center;
	border-color: #FF6B6B;
	padding: 20px;
	border: 1px solid #D9534F; /* Red border color */
	border-radius: 5px;
	margin: 20px auto;
	max-width: 400px; /* Adjust as needed */
}

/* Style the error message text */
.error-message {
	font-size: 24px;
	color: #D9534F; /* Red text color */
}

/* Style the "Go back" link */
.error-link {
	display: inline-block;
	text-decoration: none; S /* Blue background color */ color : #FFFFFF;
	/* White text color */
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	margin-top: 20px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.error-link:hover {
	background-color: #0056AC; /* Darker blue on hover */
}
</style>
</head>
<body>
<body>
	<div class="container-scroller">

		<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
				<a class="navbar-brand brand-logo me-5" href="Dashboard.jsp"><img
					src="images/logo.svg" class="me-2" alt="logo" /></a> <a
					class="navbar-brand brand-logo-mini" href="Dashboard.jsp"><img
					src="images/logo-mini.svg" alt="logo" /></a>
			</div>
			<div
				class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
				<button class="navbar-toggler navbar-toggler align-self-center"
					type="button" data-toggle="minimize">
					<span class="ti-view-list"></span>
				</button>

				<ul class="navbar-nav navbar-nav-right">

				</ul>
				<button
					class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
					type="button" data-toggle="offcanvas">
					<span class="ti-view-list"></span>
				</button>
			</div>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link" href="Dashboard.jsp">
							<i class="ti-shield menu-icon"></i> <span class="menu-title">Dashboard</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="AddPatient.jsp">
							<i class="ti-user menu-icon"></i> <span class="menu-title">Add
								Patient</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						data-bs-toggle="collapse" href="#ui-basic" aria-expanded="false"
						aria-controls="ui-basic"> <i class="ti-palette menu-icon"></i>
							<span class="menu-title">Manage Medicines</span> <i
							class="menu-arrow"></i>
					</a>
						<div class="collapse" id="ui-basic">
							<ul class="nav flex-column sub-menu">
								<li class="nav-item"><a class="nav-link"
									href="Addmedicine.jsp">Add Medicine</a></li>
								<li class="nav-item"><a class="nav-link"
									href="Listmedicine.jsp">Medicine List</a></li>
							</ul>
						</div></li>

					<li class="nav-item"><a class="nav-link"
						href="selectPatient.jsp"> <i class="ti-pie-chart menu-icon"></i>
							<span class="menu-title">Check-Out</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="paymentmanage.jsp"> <i
							class="ti-view-list-alt menu-icon"></i> <span class="menu-title">Payment</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="logout.jsp">
							<i class="ti-write menu-icon"></i> <span class="menu-title">Logout</span>
					</a></li>
				</ul>
			</nav>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-md-12 grid-margin">
							<div class="d-flex justify-content-between align-items-center">
								<div>
									<h4 class="font-weight-bold mb-0">Add Patient</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="error-container">
							<h1 class="error-message">Error - NIC Already Registered</h1>
							<h4 class="error-message">The NIC number you entered is
								already registered. Please enter a different NIC number.</h4>
							<a href="AddPatient.jsp" class="btn btn-inverse-danger btn-fw">Go
								back page </a>
						</div>

					</div>
				</div>
				<footer class="footer">
					<div
						class="d-sm-flex justify-content-center justify-content-sm-between">
						<span
							class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright
							© <a href="https://www.bootstrapdash.com/" target="_blank">
						</a>2023 Sri Lanka 
						</span>
					</div>
				</footer>

			</div>

		</div>

	</div>



	<script src="vendors/base/vendor.bundle.base.js"></script>
	<script src="vendors/chart.js/Chart.min.js"></script>
	<script src="js/jquery.cookie.js" type="text/javascript"></script>
	<script src="js/off-canvas.js"></script>
	<script src="js/hoverable-collapse.js"></script>
	<script src="js/template.js"></script>
	<script src="js/todolist.js"></script>
	<script src="js/dashboard.js"></script>

</body>

</html>