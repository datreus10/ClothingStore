<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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