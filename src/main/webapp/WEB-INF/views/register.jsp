<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<c:import url="layout/header.jsp">

</c:import>

<body>
	<div class="d-flex justify-content-center align-items-center"
		style="height: 100vh;">
		<div class="col-md-6 col-12">
			<div class="card">
				<div class="card-header">
					<h3 class="text-center">Register Account</h3>
				</div>
				<div class="card-content">
					<div class="card-body">
						<form:form action="register" method="post" class="form form-vertical" modelAttribute="user">
							<div class="form-body">
								<div class="row">
									<div class="col-12">
										<div class="form-group has-icon-left">
											<label for="username">Username</label>
											<div class="position-relative">
												<form:input path="username"  type="text" class="form-control"
													placeholder="Username" id="username"/>
												<div class="form-control-icon">
													<i class="bi bi-person"></i>
												</div>
											</div>
										</div>
									</div>
									<div class="col-12">
										<div class="form-group has-icon-left">
											<label for="password-id-icon">Password</label>
											<div class="position-relative">
												<form:input path="password"  type="password" class="form-control"
													placeholder="Password" id="password-id-icon"/>
												<div class="form-control-icon">
													<i class="bi bi-lock"></i>
												</div>
											</div>
										</div>
										<div class="col-12">
											<div class="form-group has-icon-left">
												<label for="fullname">Fullname</label>
												<div class="position-relative">
													<form:input path="fullname"  type="text" class="form-control"
														placeholder="Input with icon left" id="fullname"
														/>
													<div class="form-control-icon">
														<i class="bi bi-person"></i>
													</div>
												</div>
											</div>
										</div>
										<div class="col-12">

											<div class="form-group has-icon-left">
												<label for="email-id-icon">Email</label>
												<div class="position-relative">
													<form:input path="email"  type="text" class="form-control"
														placeholder="Email" id="email-id-icon"/>
													<div class="form-control-icon">
														<i class="bi bi-envelope"></i>
													</div>
												</div>
											</div>
										</div>
										<div class="col-12">
											<div class="form-group has-icon-left">
												<label for="mobile-id-icon">Phone</label>
												<div class="position-relative">
													<form:input path="phone"  type="text" class="form-control" placeholder="Phone"
														 id="mobile-id-icon"/>
													<div class="form-control-icon">
														<i class="bi bi-phone"></i>
													</div>
												</div>
											</div>
										</div>
										<div class="col-12">
											<div class="form-group has-icon-left">
												<label for="address">Address</label>
												<div class="position-relative">
													<form:input path="address"  type="text" class="form-control"
														placeholder="Mobile" id="address"/>
													<div class="form-control-icon">
														<i class="bi bi-phone"></i>
													</div>
												</div>
											</div>
										</div>

									</div>

									<div class="col-12 d-flex justify-content-end">
										<button type="reset" class="btn btn-light-secondary me-1 mb-1"><a href="<c:url value="/login"/>">Back</a> </button>
										<button type="submit" class="btn btn-primary me-1 mb-1">Register</button>

									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	</div>



</body>