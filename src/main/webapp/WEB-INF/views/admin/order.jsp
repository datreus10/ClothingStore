<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="../layout/header.jsp">

</c:import>
</head>
<body>
	<div id="app">
		<c:import url="sidebar.jsp">
			<c:param name="activeBar" value="${activeBar }"></c:param>
		</c:import>
		<div id="main">
		
		<section class="section">
				<div class="row" id="table-bordered">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Manager Order</h4>
							</div>

							<div class="table-responsive">
								<table class="table table-bordered mb-0">
									<thead>
										<tr>
											<th>No.</th>
											<th>Order Id</th>
											<th>Date created</th>
											<th>Quantity</th>
											<th>Price</th>
											<th>Payment</th>
											<th>Status</th>											
											<th>Action</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="order" items="${orders}" varStatus="loop">
											<tr>
												<td>${loop.index+1}</td>
												<td>${order.id}</td>
												<td>${order.getDateFormatted()}</td>
												<td>${order.totalQuantity}</td>
												<td>${order.priceFormatted()}</td>
												<td>${order.payment}</td>
												<td>${order.status}</td>
											
												<td width="10%">
													<div class="d-flex justify-content-around">
														<a
															href="<c:url value="/admin/order/detail?orderId=${order.id}"/>">
															<button type="button"
																class="btn btn-outline-primary block">
																<svg class="bi" width="1em" height="1em"
																	fill="currentColor">
                                                                    <use
																		xlink:href="<c:url value="/resources/assets/vendors/bootstrap-icons/bootstrap-icons.svg#pencil-square"/>" />
                                                                </svg>
															</button>
														</a>


														<button type="button"
															class="btn btn-outline-primary block"
															data-bs-toggle="modal"
															data-bs-target="#modalDelete-">
															<svg class="bi" width="1em" height="1em"
																fill="currentColor">
                                                                <use
																	xlink:href="<c:url value="/resources/assets/vendors/bootstrap-icons/bootstrap-icons.svg#trash"/>" />
                                                            </svg>
														</button>
														<!-- Vertically Centered modal Modal -->
														<div class="modal fade" id="modalDelete-"
															tabindex="-1" role="dialog"
															aria-labelledby="exampleModalCenterTitle"
															aria-hidden="true">
															<div
																class="modal-dialog modal-dialog-centered modal-dialog-centered modal-dialog-scrollable"
																role="document">
																<div class="modal-content">
																	<div class="modal-header">
																		<h5 class="modal-title" id="exampleModalCenterTitle">
																			Warning!!!</h5>
																		<button type="button" class="close"
																			data-bs-dismiss="modal" aria-label="Close">
																			<i data-feather="x"></i>
																		</button>
																	</div>
																	<div class="modal-body">
																		<p>Are you sure to delete user: </p>
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-light-secondary"
																			data-bs-dismiss="modal">
																			<i class="bx bx-x d-block d-sm-none"></i> <span
																				class="d-none d-sm-block">Close</span>
																		</button>
																		<button type="button"
																			class="btn btn-primary ml-1 delete-user"
																			data-bs-dismiss="modal" value="">
																			<i class="bx bx-check d-block d-sm-none"></i> <span
																				class="d-none d-sm-block">Accept</span>
																		</button>
																	</div>
																</div>
															</div>
														</div>
													</div>

												</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>

	</div>
</body>

</html>