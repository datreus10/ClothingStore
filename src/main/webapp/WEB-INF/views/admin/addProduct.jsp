<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">



<head>
<c:import url="../layout/header.jsp" />
<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css"
	rel="stylesheet">
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
									<form class="form form-vertical">
										<div class="form-body">
											<div class="row">
												<div class="col-12">
													<div class="form-group">
														<label for="product-name">Name</label> <input type="text"
															class="form-control" placeholder="Name" id="product-name" />
													</div>
												</div>
												<div class="col-12">
													<div class="form-group">
														<label for="product-price">Price</label> <input
															type="text" class="form-control" placeholder="Price"
															id="product-price" />
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
																		<td><input type="text" class="form-control" value="S"/></td>
																		<td><input type="text" class="form-control" /></td>
																		<td><input type="text" class="form-control" /></td>
																	</tr>

																	<tr>
																		<td><input type="text" class="form-control" value="M"/></td>
																		<td><input type="text" class="form-control" /></td>
																		<td><input type="text" class="form-control" /></td>
																	</tr>
																	
																	<tr>
																		<td><input type="text" class="form-control" value="L"/></td>
																		<td><input type="text" class="form-control" /></td>
																		<td><input type="text" class="form-control" /></td>
																	</tr>
																	
																	<tr>
																		<td><input type="text" class="form-control" value="XL"/></td>
																		<td><input type="text" class="form-control" /></td>
																		<td><input type="text" class="form-control" /></td>
																	</tr>


																</tbody>
															</table>
														</div>
													</div>






													<div class="col-12 d-flex justify-content-end">
														<button type="submit" class="btn btn-primary me-1 mb-1">Submit</button>
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


	<!-- Include the Quill library -->
	<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>


	<!-- Initialize Quill editor -->
	<script>
		$(document).ready(function() {
			var quill = new Quill('#product-desc', {
				theme : 'snow'
			});

			$("form").submit(function(event) {
				var formData = {
					name : $("#product-name").val(),
					price : $("#product-price").val(),
					description : quill.root.innerHTML,
					images : "img1.jpg,img2.jpg",
					options: new Array({
						color:"white",
						size:"XL",
						quantity:1
					},{
						color:"red",
						size:"L",
						quantity:2
					})
				};
				console.log(formData);
				$.ajax({
					type : "POST",
					url : "/ClothingStore/admin/product/new",
					data : formData,
					dataType : "json",
					encode : true,

				}).done(function(data) {
					console.log(data);
				});

				event.preventDefault();
			});
		});
	</script>

</body>

</html>