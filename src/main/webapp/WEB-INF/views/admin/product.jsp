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
	

</body>

</html>