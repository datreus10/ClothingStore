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
								<h4 class="card-title">Manager User</h4>




							</div>

							<div class="table-responsive">
								<table class="table table-bordered mb-0">
									<thead>
										<tr>
											<th>No.</th>
											<th>User Id</th>
											<th>Username</th>
											<th>Fullname</th>
											<th>Phone</th>
											<th>Address</th>
											<th>Role</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="user" items="${users}" varStatus="loop">
											<tr>
												<td>${loop.index+1}</td>
												<td>${user.id}</td>
												<td>${user.username}</td>
												<td>${user.fullname}</td>
												<td>${user.phone}</td>
												<td>${user.address}</td>
												<td>${user.role}</td>
												<td width="10%">
													<div class="d-flex justify-content-around">
														<a
															href="<c:url value="/admin/user/edit?userId=${user.id}"/>">
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
															data-bs-target="#modalDelete-${user.id}">
															<svg class="bi" width="1em" height="1em"
																fill="currentColor">
                                                                <use
																	xlink:href="<c:url value="/resources/assets/vendors/bootstrap-icons/bootstrap-icons.svg#trash"/>" />
                                                            </svg>
														</button>
														<!-- Vertically Centered modal Modal -->
														<div class="modal fade" id="modalDelete-${user.id}"
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
																		<p>Are you sure to delete user: ${user.username}</p>
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-light-secondary"
																			data-bs-dismiss="modal">
																			<i class="bx bx-x d-block d-sm-none"></i> <span
																				class="d-none d-sm-block">Close</span>
																		</button>
																		<button type="button"
																			class="btn btn-primary ml-1 delete-user"
																			data-bs-dismiss="modal" value="${user.id}">
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
            $("button.delete-user").click(function (event) {
                var userId = $(this).attr("value");
                $.ajax({
                    method: "DELETE",
                    url: "/ClothingStore/admin/user/delete?userId=" + userId,
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