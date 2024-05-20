<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="pharmacy.DB.DBConnection"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="pharmacy.managemedicine.medicine"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.SQLException"%>

<!DOCTYPE html>
<html>
<head>
<title>List Medicine</title>
<!--  add css  -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.png" />
<!-- add css -->


</head>
<body>
	<div class="container-scroller">

		<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
				<a class="navbar-brand brand-logo me-5" href="index.html"><img
					src="images/logo.svg" class="me-2" alt="logo" /></a> <a
					class="navbar-brand brand-logo-mini" href="index.html"><img
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
						href="pages/tables/basic-table.html"> <i
							class="ti-view-list-alt menu-icon"></i> <span class="menu-title">Payment</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="documentation/documentation.html"> <i
							class="ti-write menu-icon"></i> <span class="menu-title">Logout</span>
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
									<h4 class="font-weight-bold mb-0">List of Medicines</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="row">



						<div class="col-md-6">
							<div class="card-body">


								<div class="template-demo">

									<a href="Addmedicine.jsp"
										class="btn btn-inverse-primary btn-fw">Add Medicine</a>


								</div>
							</div>
						</div>
						<div class="col-lg-12 grid-margin stretch-card">

							<div class="card">
								<div class="card-body">
									<h4 class="card-title">List of Medicines</h4>

									<div class="table-responsive">
										<table class="table table-striped">
											<tr>
												<th>Medicine ID</th>
												<th>Name</th>
												<th>Brand</th>
												<th>Code</th>
												<th>Quantity</th>
												<th>Price</th>
												<th>Actions</th>
											</tr>
											<%
											Connection conn = null;
											PreparedStatement stmt = null;
											ResultSet rs = null;
											List<medicine> medicineList = new ArrayList<>();

											try {
												conn = DBConnection.getconnection();
												String query = "SELECT * FROM medicine";
												stmt = conn.prepareStatement(query);
												rs = stmt.executeQuery();

												while (rs.next()) {
													int id = rs.getInt(1);
													String name = rs.getString(2);
													String brand = rs.getString(3);
													String code = rs.getString(4);
													int quantity = rs.getInt(5);
													double price = rs.getDouble(6);

													medicine medicine = new medicine(id, name, brand, code, quantity, price);
													medicineList.add(medicine);
												}
											} catch (SQLException e) {
												e.printStackTrace();
											}
											%>

											<c:forEach items="<%=medicineList%>" var="medicine">
												<tr>
													<td><c:out value="${medicine.id}" /></td>
													<td><c:out value="${medicine.name}" /></td>
													<td><c:out value="${medicine.brand}" /></td>
													<td><c:out value="${medicine.code}" /></td>
													<td><c:out value="${medicine.quantity}" /></td>
													<td><c:out value="${medicine.price}" /></td>
													<td class=""><a
														href="editmedicine.jsp?id=<c:out value='${medicine.id}'/>"
														class="btn btn-inverse-warning btn-fw">Edit</a> <a
														href="deleteMedicineServlet?id=<c:out value='${medicine.id}'/>"
														class="btn btn-inverse-danger btn-fw">Delete</a></td>
												</tr>
											</c:forEach>
										</table>
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

