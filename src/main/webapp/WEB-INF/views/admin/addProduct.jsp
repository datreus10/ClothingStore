<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">



<head>
	<c:import url="../layout/header.jsp" />
	<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
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
								<h4 class="card-title">Add new product</h4>


							</div>
							<div class="card-content">
								<div class="card-body">
									<form class="form form-vertical" modelAttribute="product">
										<div class="form-body">
											<div class="row">
												<div class="col-12">
													<div class="form-group">
														<label for="product-name">Name</label> <input type="text"
															class="form-control" name="name" placeholder="Name" id="product-name" />
													</div>
												</div>
												<div class="col-12">
													<div class="form-group">
														<label for="product-price">Price</label> <input type="number"
															class="form-control" placeholder="Price"
															id="product-price" name="price" />
													</div>
												</div>

												<div class="col-12">
													<div class="form-group">
														<label for="product-desc">Description</label>
														<div id="product-desc"></div>
													</div>
												</div>

												<div class="col-12">
													<div class="form-group">
														<label for="detail">Detail</label>

														<div id="detail" class="table-responsive">
															<table class="table table-lg">
																<thead>
																	<tr>
																		<th>Size</th>
																		<th>Color</th>
																		<th>Quantity</th>
																	</tr>
																</thead>
																<tbody>

																	<tr>

																		<td><input name="options[0].size"
																				class="form-control" type="text"/></td>
																		<td><input name="options[0].color"
																				class="form-control" type="text"></td>
																		<td><input name="options[0].quantity"
																				class="form-control" type="number"/></td>
																	</tr>
																</tbody>

															</table>
															<a href="#" class="btn icon icon-left btn-primary">
																<svg class="bi" width="1em" height="1em"
																	fill="currentColor">
																	<use xlink:href="<c:url value="/resources/assets/vendors/bootstrap-icons/bootstrap-icons.svg#plus"/>">
																		</use> </svg> <span>Add detail</span>
															</a>
														</div>
													</div>






													<div class="col-12 d-flex justify-content-end">
														<button type="submit"
															class="btn btn-primary me-1 mb-1">Submit</button>
														<button type="reset"
															class="btn btn-light-secondary me-1 mb-1">Reset</button>
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>

						</div>
					</div>
				</div>
			</section>


		</div>
	</div>
<!-- Modal -->

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
					<p>Successfully add product</p>
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
	
	<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>


	
	<script>
		$(document).ready(function () {
			var quill = new Quill('#product-desc', {
				theme: 'snow'
			});


			var rowCount = 1;
			$("#detail a.btn").click(function () {

				const newRow = `<tr>
					<td><input
							name="options[\${rowCount}].size"
							class="form-control" /></td>
					<td><input
							name="options[\${rowCount}].color"		
							class="form-control" /></td>
					<td><input
							name="options[\${rowCount}].quantity"
							class="form-control" /></td>
					</tr>`;

				$("#detail tbody").append(newRow);
				rowCount += 1;
			})

			

			$("form").submit(function (event) {
				const data = Object.fromEntries(new FormData(event.target).entries());
				data.description = quill.root.innerHTML;
				data.images = "temp.png";

  				console.log(data)

				$.ajax({
					type: "POST",
					url: "/ClothingStore/admin/product/new",
					data: data,
					dataType: "json",
					encode: true,
				}).done(function (data) {
					console.log(data);
					$("button.notifiModal").click();
                    $("#notifiModal .modal-footer button").on("click", function () {
                        location.reload();
                    });
				});

				event.preventDefault();
			});
		});
	</script>

</body>

</html>