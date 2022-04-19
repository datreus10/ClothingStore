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
                                                <label for="first-name-vertical">Order Id</label>
                                                <input type="text" class="form-control" value="${order.id}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <label for="email-id-vertical">Customer's name</label>
                                                <input type="text" class="form-control" value="${user.fullname}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <label for="contact-info-vertical">Address</label>
                                                <input type="text" class="form-control" value="${order.address}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <label for="password-vertical">Phone number</label>
                                                <input type="text" class="form-control" value="${order.phone}" readonly="readonly">
                                            </div>
                                        </div>
                                         <div class="col-12">
                                            <div class="form-group">
                                                <label for="password-vertical">Payment method</label>
                                                <input type="text" class="form-control" value="${order.payment}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <label for="password-vertical">Status</label>
                                                <input type="text" class="form-control" value="${order.status}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <label for="password-vertical">Order date</label>
                                                <input type="text" class="form-control" value="${order.orderDate}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <label for="password-vertical">Total price</label>
                                                <input type="text" class="form-control" value="${order.totalPrice}" readonly="readonly">
                                            </div>
                                        </div>
                                        
                                        
                                        
                                        <div class="col-12 d-flex justify-content-end">
                                            <button type="submit" class="btn btn-primary me-1 mb-1">Submit</button>
                                            <button type="reset" class="btn btn-light-secondary me-1 mb-1">Reset</button>
                                        </div>
                                    </div>
                                </div>
                                
                                <h3 class="text-center">Order items</h3>
                                <div class="table-responsive">
                            <table class="table table-bordered mb-0">
                                <thead>
                                    <tr>
                                        <th>NAME</th>
                                        <th>RATE</th>
                                        <th>SKILL</th>
                                        <th>TYPE</th>
                                        <th>LOCATION</th>
                                        <th>ACTION</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="text-bold-500">Michael Right</td>
                                        <td>$15/hr</td>
                                        <td class="text-bold-500">UI/UX</td>
                                        <td>Remote</td>
                                        <td>Austin,Taxes</td>
                                        <td><a href="#"><i class="badge-circle badge-circle-light-secondary font-medium-1" data-feather="mail"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td class="text-bold-500">Morgan Vanblum</td>
                                        <td>$13/hr</td>
                                        <td class="text-bold-500">Graphic concepts</td>
                                        <td>Remote</td>
                                        <td>Shangai,China</td>
                                        <td><a href="#"><i class="badge-circle badge-circle-light-secondary font-medium-1" data-feather="mail"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td class="text-bold-500">Tiffani Blogz</td>
                                        <td>$15/hr</td>
                                        <td class="text-bold-500">Animation</td>
                                        <td>Remote</td>
                                        <td>Austin,Texas</td>
                                        <td><a href="#"><i class="badge-circle badge-circle-light-secondary font-medium-1" data-feather="mail"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td class="text-bold-500">Ashley Boul</td>
                                        <td>$15/hr</td>
                                        <td class="text-bold-500">Animation</td>
                                        <td>Remote</td>
                                        <td>Austin,Texas</td>
                                        <td><a href="#"><i class="badge-circle badge-circle-light-secondary font-medium-1" data-feather="mail"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td class="text-bold-500">Mikkey Mice</td>
                                        <td>$15/hr</td>
                                        <td class="text-bold-500">Animation</td>
                                        <td>Remote</td>
                                        <td>Austin,Texas</td>
                                        <td><a href="#"><i class="badge-circle badge-circle-light-secondary font-medium-1" data-feather="mail"></i></a></td>
                                    </tr>
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