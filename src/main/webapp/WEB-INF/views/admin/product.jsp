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
							<div class="card-header d-flex justify-content-between">
								<h4 class="card-title">Manager Product</h4>
								<a href="<c:url value="/admin/product/new"/>" class="btn icon icon-left btn-primary d-flex align-items-center justify-content-around"> 
									<svg class="bi" width="1em" height="1em" fill="currentColor">
                                    <use xlink:href="<c:url value="/resources/assets/vendors/bootstrap-icons/bootstrap-icons.svg#plus"/>"></use>
                                </svg> 
                                <span>Create new</span>
								</a>

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
											<th>Size</th>
											<th>Color</th>
											<th>Quantity</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="product" items="${products}" varStatus="loop">
											<c:forEach var="opt" items="${product.options}" varStatus="loop">
											<tr>
                                                <td>${loop.index+1}</td>
												<td>Img</td>
												<td>${product.id}</td>
												<td>${product.name}</td>
												<td>${product.priceFormatted()}</td>
												<td>${opt.size}</td>
												<td>${opt.color}</td>
												<td>${opt.quantity}</td>
												<td width="10%">
													<div class="d-flex justify-content-around">
														<a
															href="<c:url value="/admin/product/edit?productId=${product.id}"/>">
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
															data-bs-target="#modalDelete-${product.id}-${opt.id}">
															<svg class="bi" width="1em" height="1em"
																fill="currentColor">
                                                                <use
																	xlink:href="<c:url value="/resources/assets/vendors/bootstrap-icons/bootstrap-icons.svg#trash"/>" />
                                                            </svg>
														</button>
														<!-- Vertically Centered modal Modal -->
														<div class="modal fade" id="modalDelete-${product.id}-${opt.id}"
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
																		<p>Are you sure to delete product: ${product.name}</p>
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-light-secondary"
																			data-bs-dismiss="modal">
																			<i class="bx bx-x d-block d-sm-none"></i> <span
																				class="d-none d-sm-block">Close</span>
																		</button>
																		<button type="button"
																			class="btn btn-primary ml-1 delete-product"
																			data-bs-dismiss="modal" value="${product.id}_${opt.id}">
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
	<div>
		<!-- button trigger for  Vertically Centered modal -->
		<button type="button" class="notifiModal" data-bs-toggle="modal"
			data-bs-target="#notifiModal"
			style="visibility: hidden; display: none;"></button>
		<!-- Vertically Centered modal Modal -->
		<div class="modal fade" id="notifiModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-centered modal-dialog-scrollable"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Notification
						</h5>

					</div>
					<div class="modal-body">
						<p>Successfully delete product</p>
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
<script
		src="<c:url value="/resources/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"/>">
		
	</script>
	<script
		src="<c:url value="/resources/assets/js/bootstrap.bundle.min.js"/>">
		
	</script>
	<script src="<c:url value="/resources/assets/js/mazer.js"/>">
		
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
	</script>

	<script>
        $(document).ready(function () {
            $("button.delete-product").click(function (event) {
                var [productId,optionId] = $(this).attr("value").split("_"); 
                $.ajax({
                    method: "DELETE",
                    url: "/ClothingStore/admin/product/opt?id="+optionId,
                }).done(function (msg) {
                    console.log(JSON.parse(msg));
                    $("button.notifiModal").click();
                    $("#notifiModal .modal-footer button").on("click", function () {
                        location.reload();
                    });
                });
            });
        });
	</script>
</body>

</html>