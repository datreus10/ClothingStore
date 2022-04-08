<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

<c:import url="layout/header.jsp">

</c:import>

<body>
    <div id="app">
        <c:import url="layout/sidebar.jsp">
            <c:param name="activeBar" value="${activeBar }"></c:param>
        </c:import>
        <div id="main">
            <section class="section">
                <div class="row" id="table-bordered">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Manager Customer</h4>
                            </div>
                            <!-- <div class="card-content">
                                <div class="card-body">
                                    <p class="card-text">Add <code>.table-bordered</code> for borders on all sides of
                                        the table
                                        and
                                        cells. For
                                        Inverse Dark Table, add <code>.table-dark</code> along with
                                        <code>.table-bordered</code>.
                                    </p>
                                </div> -->
                            <!-- table bordered -->
                            <div class="table-responsive">
                                <table class="table table-bordered mb-0">
                                    <thead>
                                        <tr>
                                            <th>No.</th>
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
                                                <td>${user.username}</td>
                                                <td>${user.fullname}</td>
                                                <td>${user.phone}</td>
                                                <td>${user.address}</td>
                                                <td>${user.role}</td>
                                                <td width="12%">
                                                    <div class="d-flex justify-content-around">

                                                        <button type="button" class="btn btn-outline-primary block">
                                                            <a href="#"><svg class="bi" width="1em" height="1em"
                                                                    fill="currentColor">
                                                                    <use
                                                                        xlink:href="<c:url value="/resources/assets/vendors/bootstrap-icons/bootstrap-icons.svg#plus-circle"/>" />
                                                                </svg></a>

                                                        </button>



                                                        <button type="button" class="btn btn-outline-primary block"> <a
                                                                href="#">
                                                                <svg class="bi" width="1em" height="1em"
                                                                    fill="currentColor">
                                                                    <use
                                                                        xlink:href="<c:url value="/resources/assets/vendors/bootstrap-icons/bootstrap-icons.svg#pencil-square"/>" />
                                                                </svg></a>
                                                        </button>


                                                        <button type="button" class="btn btn-outline-primary block"
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
                                                            <div class="modal-dialog modal-dialog-centered modal-dialog-centered modal-dialog-scrollable"
                                                                role="document">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title"
                                                                            id="exampleModalCenterTitle"> Warning!!!
                                                                        </h5>
                                                                        <button type="button" class="close"
                                                                            data-bs-dismiss="modal" aria-label="Close">
                                                                            <i data-feather="x"></i>
                                                                        </button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <p>
                                                                            Are you sure to delete this user ?
                                                                        </p>
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button"
                                                                            class="btn btn-light-secondary"
                                                                            data-bs-dismiss="modal">
                                                                            <i class="bx bx-x d-block d-sm-none"></i>
                                                                            <span class="d-none d-sm-block">Close</span>
                                                                        </button>
                                                                        <button type="button"
                                                                            class="btn btn-primary ml-1 delete-user"
                                                                            data-bs-dismiss="modal" value="${user.id}">
                                                                            <i
                                                                                class="bx bx-check d-block d-sm-none"></i>
                                                                            <span
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
                                        <!-- <tr>
                                                <td class="text-bold-500">Michael Right</td>
                                                <td>$15/hr</td>
                                                <td class="text-bold-500">UI/UX</td>
                                                <td>Remote</td>
                                                <td>Austin,Taxes</td>
                                                <td><a href="#"><i
                                                            class="badge-circle badge-circle-light-secondary font-medium-1"
                                                            data-feather="mail"></i></a></td>
                                            </tr> -->

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        </section>


    </div>
    </div>
    <script src="<c:url value="/resources/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"/>"> </script>
        <script src="<c:url value="/resources/assets/js/bootstrap.bundle.min.js"/>"> </script> <script
        src="<c:url value="/resources/assets/js/mazer.js"/>"> </script> <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">

    </script>

    <script>
        $(document).ready(function () {
            $("button.delete-user").click(function (event) {
                var userId = $(this).attr("value");
                $.ajax({
                        method: "DELETE",
                        url: "/ClothingStore/admin/customer/delete?userId=" + userId,
                    })
                    .done(function (msg) {
                        console.log(JSON.parse(msg));
                        alert(msg);
                        location.reload();
                    });
            });
        });
    </script>
</body>

</html>