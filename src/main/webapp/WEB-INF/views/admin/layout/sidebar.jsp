<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div id="sidebar" class="active">
    <div class="sidebar-wrapper active">
        <div class="sidebar-header">
            <div class="d-flex justify-content-between">
                <div class="logo">
                    <a href="index.html"><img src="/resources/assets/images/logo/logo.png" alt="Logo" srcset=""></a>
                </div>
                <div class="toggler">
                    <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                </div>
            </div>
        </div>
        <div class="sidebar-menu">
            <ul class="menu">
                <li class="sidebar-title">Menu</li>
 				
 				<c:set var = "baseURL" value = "${'/ClothingStore/admin'}"/>
                
                <li class="sidebar-item ${activeBar==0 ? 'active' : '' }">
                    <a href="<c:out value = "${baseURL}"/>" class='sidebar-link'>
                        <i class="bi bi-grid-fill"></i>
                        <span>Dashboard</span>
                    </a>
                </li>

                <li class="sidebar-item ${activeBar==1 ? 'active' : '' }">
                    <a href="<c:out value = "${baseURL}"/>/customer" class='sidebar-link'>
                        <i class="bi bi-file-earmark-medical-fill"></i>
                        <span>Customer</span>
                    </a>
                </li>

                <li class="sidebar-item ${activeBar==2 ? 'active' : '' }">
                    <a href="form-layout.html" class='sidebar-link'>
                        <i class="bi bi-file-earmark-medical-fill"></i>
                        <span>Product</span>
                    </a>
                </li>

                <li class="sidebar-item ${activeBar==3 ? 'active' : '' }">
                    <a href="form-layout.html" class='sidebar-link'>
                        <i class="bi bi-file-earmark-medical-fill"></i>
                        <span>Order</span>
                    </a>
                </li>

               

            </ul>
        </div>
        <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
    </div>
</div>