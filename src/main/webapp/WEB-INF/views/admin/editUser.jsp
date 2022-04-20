<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<c:import url="../layout/header.jsp">

</c:import>
</head>
<body>
	<div id="app">
		<c:import url="sidebar.jsp">
			<c:param name="activeBar" value="${activeBar}"></c:param>
		</c:import>

		<div id="main">

			<!-- // Basic multiple Column Form section start -->
			<section id="multiple-column-form">
				<div class="row match-height">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Edit User</h4>
							</div>
							<div class="card-content">
								<div class="card-body">
									<form class="form" method="post" action="${pageContext.request.contextPath}/admin/user/edit">
										<input name="id" value="${user.id }" hidden/>
										<div class="row">
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="first-name-column">Username</label> 
													<input
														type="text" id="first-name-column" class="form-control"
														placeholder="Username" name="username"
														value="${user.username}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="last-name-column">Passowrd</label> 
													<input
														type="text" id="last-name-column" class="form-control"
														placeholder="Passowrd" name="password"
														value="${user.password}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="last-name-column">Email</label> 
													<input
														type="text" id="email" class="form-control"
														placeholder="Email" name="email"
														value="${user.email}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="city-column">Fullname</label> 
													<input
														type="text" id="city-column" class="form-control"
														placeholder="Fullname" name="fullname"
														value="${user.fullname}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="country-floating">Phone number</label> 
													<input
														type="text" id="country-floating" class="form-control"
														name="phone" placeholder="Phone number"
														value="${user.phone}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="company-column">Address</label> 
													<input
														type="text" id="company-column" class="form-control"
														name="address" placeholder="Address"
														value="${user.address}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<label for="email-id-column">Role</label>
												<fieldset class="form-group">
													<select name="role" class="form-select" id="basicSelect">
														<option ${user.role=="user" ? "selected" : ""} value="user">User</option>
														<option ${user.role=="admin" ? "selected" : ""} value="admin">Admin</option>
													</select>
												</fieldset>

												
											</div>

											<div class="col-12 d-flex justify-content-end">
												<button type="submit" class="btn btn-primary me-1 mb-1">Submit</button>
												<button type="reset"
													class="btn btn-light-secondary me-1 mb-1">
													<a href="<c:url value="/admin/customer"/>">Cancel</a>
												</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- // Basic multiple Column Form section end -->


		</div>



	</div>


</body>

</html>