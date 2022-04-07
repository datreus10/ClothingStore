<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">

			<!--boostrap 4-->
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
			<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

			<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
		</head>

		<body>
			<div class="wrapper fadeInDown">
				<div id="formContent">
					<!-- Tabs Titles -->

					<!-- Icon -->
					<div class="fadeIn first">
						<img src="https://cdn-icons-png.flaticon.com/512/5968/5968504.png" id="icon" alt="User Icon" />
					</div>

					<!-- Login Form -->
					<form action="login" method="post">
						<c:if test="${msg !=null }">
							<p class="text-danger">
								<c:out value="${msg }"></c:out>
							</p>
						</c:if>
						<input type="text" id="login" class="fadeIn second" name="username" placeholder="username" />
						<input type="text" id="password" class="fadeIn third" name="password" placeholder="password" />
						<input type="submit" class="fadeIn fourth" value="Log In" />
					</form>

					<!-- Remind Passowrd -->
					<div id="formFooter">
						<a class="underlineHover" href="#">Forgot Password?</a>
					</div>

				</div>
			</div>
		</body>

		</html>