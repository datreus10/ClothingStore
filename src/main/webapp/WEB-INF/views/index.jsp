<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<h1>My First Bootstrap Page</h1>
		<p>This part is inside a .container-fluid class.</p>
		<p>The .container-fluid class provides a full width container,
			spanning the entire width of the viewport.</p>
	</div>

	<h1>List user</h1>
	<table border="1" cellpadding="5">
		<tr>
			<th>No</th>
			<th>Name</th>

			<th>Address</th>
			<th>Phone</th>
			<th>Role</th>
		</tr>

		<c:forEach items="${ listUser}" var="user" varStatus="status">
			<tr>
				<td>${status.index +1}</td>
				<td>${user.fullname }</td>

				<td>${user.address }</td>
				<td>${user.phone }</td>
				<td>${user.role }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>