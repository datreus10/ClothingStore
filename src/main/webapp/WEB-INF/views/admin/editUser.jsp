<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">

<c:import url="../layout/header.jsp">

</c:import>

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
									<form:form class="form" method="post" action="${pageContext.request.contextPath}/admin/user/edit" modelAttribute="user">
										<form:hidden path="id" value="${user.id }"/>
										<div class="row">
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="first-name-column">Username</label> 
													<form:input
														type="text" id="first-name-column" class="form-control"
														placeholder="Username" path="username"
														value="${user.username}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="last-name-column">Passowrd</label> 
													<form:input
														type="text" id="last-name-column" class="form-control"
														placeholder="Passowrd" path="password"
														value="${user.password}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="last-name-column">Email</label> 
													<form:input
														type="text" id="email" class="form-control"
														placeholder="Email" path="email"
														value="${user.email}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="city-column">Fullname</label> 
													<form:input
														type="text" id="city-column" class="form-control"
														placeholder="Fullname" path="fullname"
														value="${user.fullname}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="country-floating">Phone number</label> 
													<form:input
														type="text" id="country-floating" class="form-control"
														path="phone" placeholder="Phone number"
														value="${user.phone}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<div class="form-group">
													<label for="company-column">Address</label> 
													<form:input
														type="text" id="company-column" class="form-control"
														path="address" placeholder="Address"
														value="${user.address}"/>
												</div>
											</div>
											<div class="col-md-6 col-12">
												<label for="email-id-column">Role</label>
												<fieldset class="form-group">
													<form:select path="role" class="form-select" id="basicSelect">
														<option ${user.role=="user" ? "selected" : ""} value="user">User</option>
														<option ${user.role=="admin" ? "selected" : ""} value="admin">Admin</option>
													</form:select>
												</fieldset>

												<!-- <div class="form-group">
                                                    <label for="email-id-column">Role</label>
                                                    <input type="email" id="email-id-column" class="form-control"
                                                        name="email-id-column" placeholder="Role" value="${user.role}">
                                                </div> -->
											</div>

											<div class="col-12 d-flex justify-content-end">
												<button type="submit" class="btn btn-primary me-1 mb-1">Submit</button>
												<button type="reset"
													class="btn btn-light-secondary me-1 mb-1">
													<a href="<c:url value="/admin/customer"/>">Cancel</a>
												</button>
											</div>
										</div>
									</form:form>
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