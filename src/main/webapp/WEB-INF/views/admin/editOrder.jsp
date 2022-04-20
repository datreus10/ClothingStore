<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<div class="card">
				<div class="card-header">
					<h4 class="card-title">Order detail</h4>
				</div>
				<div class="card-content">
					<div class="card-body">
						<form class="form form-vertical">
							<div class="form-body">
								<div class="row">
									<div class="col-12">
										<div class="form-group">
											<label for="first-name-vertical">Order Id</label> <input
												type="text" class="form-control" value="${order.id}"
												readonly="readonly">
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label for="email-id-vertical">Customer's name</label> <input
												type="text" class="form-control" value="${user.fullname}"
												readonly="readonly">
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label for="contact-info-vertical">Address</label> <input
												type="text" class="form-control" value="${order.address}"
												readonly="readonly">
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label for="password-vertical">Phone number</label> <input
												type="text" class="form-control" value="${order.phone}"
												readonly="readonly">
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label for="password-vertical">Payment method</label> <input
												type="text" class="form-control" value="${order.payment}"
												readonly="readonly">
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label for="password-vertical">Status</label> 
											<fieldset class="form-group">
													<select name="role" class="form-select" id="basicSelect">
														
														
														<c:forEach var="status" items="${listStatus}">
															<option ${order.status.equals(status)? "selected" : ""} value="${status}">${status}</option>
													
														</c:forEach>
													</select>
												</fieldset>
																
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label for="password-vertical">Order date</label> <input
												type="text" class="form-control" value="${order.orderDate}"
												readonly="readonly">
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label for="password-vertical">Total price</label> <input
												type="text" class="form-control" value="${order.priceFormatted()}"
												readonly="readonly">
										</div>
									</div>



									<div class="col-12 d-flex justify-content-end">
										<button type="submit" class="btn btn-primary me-1 mb-1">Update Status</button>	
									</div>
								</div>
							</div>

							<h3 class="text-center">Order items</h3>
							<div class="table-responsive">
								<table class="table table-bordered mb-0">
									<thead>
										<tr>
											<th>No.</th>
											<th>Product Option Id</th>
											<th>Name</th>
											<th>Size</th>
											<th>Color</th>
											<th>Quantity</th>
											<th>Total Price</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="detail" items="${orderDetails}"
											varStatus="loop">
											<tr>
												<td>${loop.index+1}</td>
												<td>${detail.productOption.id}</td>
												<td>${detail.productOption.product.name}</td>
												<td>${detail.productOption.size}</td>
												<td>${detail.productOption.color}</td>
												<td>${detail.quantity}</td>
												<td>${detail.totalPrice }</td>
											</tr>

										</c:forEach>

									</tbody>
								</table>
							</div>

						</form>

					</div>
				</div>
			</div>



		</div>



	</div>


</body>

</html>