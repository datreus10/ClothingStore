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
    <c:import url="layout/footer.jsp">

    </c:import>
</body>

</html>