<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>customer-list</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
.data {
	font-size: large;
	color: orange;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
</style>
</head>
<body>
	<div class="container-fluid bg-dark text-white">
		<h1 style="text-align: center">Customer Relations Management</h1>
		<h3 style="text-align: center;">***Delivering beyond
			expectations***</h3>
		<p>
			<a href="showForm" class="btn btn-warning btn-lg">Click here to
				add customer</a>

		</p>
		<hr style="background-color: rgb(225, 0, 119); height: 1px;">
		<div class="container">
			<table class="table table-dark">
				<thead>
					<tr>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach var="customer" items="${customers}" varStatus="c">
					<tbody>
						<tr>
							<td>${c.count }</td>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td><a class="btn btn-success"
								href="update?id=${customer.id}">Update</a> <a
								class="btn btn-danger" href="delete?id=${customer.id}"
								onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>