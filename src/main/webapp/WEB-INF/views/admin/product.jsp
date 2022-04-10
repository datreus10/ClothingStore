<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

<c:import url="../layout/header.jsp">

</c:import>

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
								<h4 class="card-title">Manager Product</h4>


								<div>
									<!-- button trigger for  Vertically Centered modal -->
									<button type="button" class="notifiModal"
										data-bs-toggle="modal" data-bs-target="#notifiModal"
										style="visibility: hidden; display: none;"></button>
									<!-- Vertically Centered modal Modal -->
									<div class="modal fade" id="notifiModal" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalCenterTitle"
										aria-hidden="true">
										<div
											class="modal-dialog modal-dialog-centered modal-dialog-centered modal-dialog-scrollable"
											role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalCenterTitle">Notification
													</h5>

												</div>
												<div class="modal-body">
													<p>Successfully delete user</p>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-primary ml-1"
														data-bs-dismiss="modal">
														<i class="bx bx-check d-block d-sm-none"></i> <span
															class="d-none d-sm-block">OK</span>
													</button>
												</div>
											</div>
										</div>
									</div>


								</div>

							</div>

							<div class="table-responsive">
								<table class="table table-bordered mb-0">
									<thead>
										<tr>
                                            <th>No.</th>
											<th>Image</th>
											<th>Product Id</th>
											<th>Name</th>
											<th>Price</th>
										
											<th>Action</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="product" items="${products}" varStatus="loop">
											<tr>
                                                <td>${loop.index+1}</td>
												<td>Img</td>
												<td>${product.id}</td>
												<td>${product.name}</td>
												<td>${product.priceFormatted()}</td>
												<td >
													

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
	</div>

</body>

</html>