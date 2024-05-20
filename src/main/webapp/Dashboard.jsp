<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="pharmacy.DB.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!--  add css  -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.png" />
<!-- add css -->
<meta charset="ISO-8859-1">
<title>Pharmacy Dashboard</title>




</head>
<body>
	<div class="container-scroller">

		<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
				<h4>Ceylon Medi Care</h4>
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
									<h4 class="font-weight-bold mb-0">Pharmacy Dashboard</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<p class="card-title text-md-center text-xl-left">Patients</p>
									<div
										class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
										<%
										Connection con = null;
										try {
											con = DBConnection.getconnection();
											String sql = "SELECT COUNT(*) AS Pcount FROM patient";
											PreparedStatement ps = con.prepareStatement(sql);
											ResultSet rs = ps.executeQuery();
											if (rs.next()) {
												int count = rs.getInt("Pcount");
										%>

										<h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0"><%=count%></h3>


										<%
										}
										} catch (Exception e) {
										e.printStackTrace();
										} finally {
										if (con != null) {
										try {
											con.close();
										} catch (Exception e) {
											e.printStackTrace();
										}
										}
										}
										%>
										<i class="ti-package icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
									</div>

								</div>
							</div>
						</div>
						<div class="col-md-3 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<p class="card-title text-md-center text-xl-left">Medicine</p>
									<div
										class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
										<%
										Connection con1 = null;
										try {
											con1 = DBConnection.getconnection();
											String sql = "SELECT COUNT(*) AS mcount FROM medicine";
											PreparedStatement ps = con1.prepareStatement(sql);
											ResultSet rs = ps.executeQuery();
											if (rs.next()) {
												int mcount = rs.getInt("mcount");
										%>

										<h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">
											<%=mcount%></h3>
										<%
										}
										} catch (Exception e) {
										e.printStackTrace();
										} finally {
										if (con1 != null) {
										try {
											con1.close();
										} catch (Exception e) {
											e.printStackTrace();
										}
										}
										}
										%>
										<i class="ti-user icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
									</div>

								</div>
							</div>
						</div>
						<div class="col-md-3 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<p class="card-title text-md-center text-xl-left">Sells</p>
									<div
										class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
										<%
										Connection con2 = null;
										try {
											con2 = DBConnection.getconnection();
											String sql = "SELECT SUM(price) AS total FROM phamacypayment";
											PreparedStatement ps = con2.prepareStatement(sql);
											ResultSet rs = ps.executeQuery();
											if (rs.next()) {
												int total = rs.getInt("total");
										%>

										<h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">
											Rs.
											<%=total%></h3>

										<%
										}
										} catch (Exception e) {
										e.printStackTrace();
										} finally {
										if (con1 != null) {
										try {
											con1.close();
										} catch (Exception e) {
											e.printStackTrace();
										}
										}
										}
										%>
										<i
											class="ti-pie-chart icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
									</div>

								</div>
							</div>
						</div>

					</div>
				</div>

				<footer class="footer">
					<div
						class="d-sm-flex justify-content-center justify-content-sm-between">
						<span
							class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright
							© <a href="https://www.bootstrapdash.com/" target="_blank"> </a>2023
							Sri Lanka
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


