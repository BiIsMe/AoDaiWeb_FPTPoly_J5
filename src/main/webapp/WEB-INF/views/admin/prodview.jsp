<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>AdminLTE 3 | Starter</title>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="/admin/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/admin/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="https://fonts.googleapis.com/css2?family=Dancing+Script&family=Fjalla+One&family=Lobster&family=Original+Surfer&family=Playfair+Display&display=swap" rel="stylesheet">
  <base href="${pageContext.servletContext.contextPath}/"/>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="index3.html" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>

    <!-- SEARCH FORM -->
    <form class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">3</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Brad Diesel
                  <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">Call me whenever you can...</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  John Pierce
                  <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">I got your message bro</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Nora Silvester
                  <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">The subject goes here</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
        </div>
      </li>
      <!-- Notifications Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-bell"></i>
          <span class="badge badge-warning navbar-badge">15</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <span class="dropdown-header">15 Notifications</span>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-envelope mr-2"></i> 4 new messages
            <span class="float-right text-muted text-sm">3 mins</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-users mr-2"></i> 8 friend requests
            <span class="float-right text-muted text-sm">12 hours</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-file mr-2"></i> 3 new reports
            <span class="float-right text-muted text-sm">2 days</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button"><i
            class="fas fa-th-large"></i></a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">${sessionScope.nameUser }</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item has-treeview ">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Quản Lý
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="admin/product" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Sản Phẩm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="admin/order" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Đơn Hàng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Loại Hàng</p>
                </a>
              </li>
            </ul>
          </li>

          <li class="nav-item has-treeview ">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Thống Kê
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="admin/statissale" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Doanh Thu</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>...</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark ">Product Page</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="admin/index">Home</a></li>
              <li class="breadcrumb-item active ">Product Page</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row justify-content-center ">
            <div class="col-sm-7 mr-3">
                <div class="card" style="border: rgb(205, 218, 27) 1px solid ;box-shadow: 3px 3px 3px rgb(229, 241, 157);">
                    <div class="card-header text-center" style="background-color: rgb(52,58,64);">
                        <div class="row justify-content-center">
                            <h3 class="card-title" style="color: rgb(241, 234, 226); font-size: 25px; font-weight: bold;">PRODUCT   LIST</h3>
                        </div>
                    </div>
                    <table class="table table-hover table-bordered  mb-0">
                        <thead>
                            <tr class="text-center" style="font-family:'Fjalla One', sans-serif; font-size: 16px;color:rgb(121, 73, 19)">
                                <th>ID</th>
                                <th>NAME</th>
                                <th style="width: 50px;">IMAGE</th>
                                <th>CATEGORY</th>
                                <th>PRICE</th>
                                <th>QUANTITY</th>
                                <th>&nbsp;</th>
                            </tr>
                        </thead>
                        <body>
                        	<c:forEach var="item" items="${page.content}">
                        		<tr>
	                                <td style="vertical-align: middle;">${item.id}</td>
                                <td style="vertical-align: middle;">${item.name}</td>
                                <td >
                                    <div style="width: 100%; overflow: hidden; height: 40px;">
                                        <img src="/images/phukien/${item.image}" width="100%" alt="">
                                    </div>
                                </td>
								<td>
	                               	<c:choose>
	                               		<c:when test="${item.category.id=='xx01' }">Trang Phục</c:when>
	                               		<c:when test="${item.category.id=='xx02' }">Trang Sức</c:when>
	                               		<c:otherwise>Phụ Kiện</c:otherwise>
	                               	</c:choose>
	                                </td>
                                <td style="vertical-align: middle;"><fmt:formatNumber type="number" pattern="###,###,###" value="${item.price}" /> VND</td>
                                <td style="vertical-align: middle;">${item.quantity}</td>
                                <td style="vertical-align: middle;"><a href="admin/product/${item.id }"> <span class="fa fa-edit" style="color: brown;font-size: 19px;"></span></a></td>
                            	</tr>
                        	</c:forEach>                 
                        </body>
                    </table>
                    <div class="card-footer">
                        <div class="row justify-content-center">
                            <div class="text-center">
                                <ul class="pagination mb-1"
                                        style="font-size: 29px; font-weight: bolder;">
                                        <li class="page-item mr-2 ${page.number == 0?'disabled':'' }"><a  href="admin/product?p=0"
                                            class="page-link btn btn-light"><span
                                                class="fa fa-angle-double-left	"
                                                style="color: rgb(52,58,64); font-size: 20px;"></span></a></li>
                                        <li class="page-item mr-2   ${page.number == 0?'disabled':'' }"><a href="admin/product?p=${page.number-1 }"
                                            class="page-link btn btn-light"><span
                                                class="fa fa-angle-left"
                                                style="color: rgb(52,58,64); font-size: 20px;"></span></a></li>
                                        <li class="page-item">
                                            <div  style="color: rgb(121, 73, 19); font-size: 15px; margin-left:3px;margin-right:9px;margin-top:10px">
                                                page ${page.number+1}/${page.totalPages}
                                            </div></li>
                                        <li class="page-item mr-2 ${page.number == (page.totalPages-1)?'disabled':'' }"><a   href="admin/product?p=${page.number+1 }"
                                            class="btn page-link btn-light"><span
                                                class="fa fa-angle-right"
                                                style="color: rgb(52,58,64); font-size: 20px;"></span></a></li>
                                        <li class="page-item mr-2 ${page.number == (page.totalPages-1)?'disabled':'' }"><a  href="admin/product?p=${page.totalPages-1 }"
                                            class="btn page-link btn-light"><span
                                                class="fa fa-angle-double-right"
                                                style="color: rgb(52,58,64); font-size: 20px;"></span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <form:form modelAttribute="product" action="admin/product" method="post" enctype="multipart/form-data">
                    <div class="card" style="border: rgb(205, 218, 27) 1px solid ;box-shadow: 3px 3px 3px rgb(229, 241, 157);">
                        <div class="card-header " style="background-color: rgb(52,58,64);">
                            <div class="row justify-content-center">
                            	<h3 class="card-title" style="color: rgb(241, 234, 226); font-size: 25px; font-weight: bold;">FORM</h3>
                            </div>
                        </div>
                        <div class="card-body">
                        	<div class="row">
								<div class="col">
									<c:if test="${not empty message }">
										<div class="alert alert-success">${message }</div>
									</c:if>
								</div>
							</div>
                            <script>
                                function chooseFile(fileInput) {
                                    if(fileInput.files && fileInput.files[0]){
                                        var reader = new FileReader();
                                        reader.onload = function(e){
                                            $('#image').attr('src',e.target.result);
                                        }
                                        reader.readAsDataURL(fileInput.files[0]);
                                    }
                                };
                            </script>
                            <div class="row justify-content-center">
                                <div class="col-sm-3" style="height: 80px;overflow: hidden;">
                                    <img id="image" src="images/phukien/${imgPro }" width="60%" alt="">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label for="" style="font-family: 'Fjalla One', sans-serif; font-size: 15px;">ID</label>
                            	<form:input  type="" disabled="true" class="form-control" path="id"/>
                            </div>    
                            <div class="form-group">
                                <label for="" style="font-family: 'Fjalla One', sans-serif; font-size: 15px;">NAME</label>
                                <form:input type="text" class="form-control" path="name"/>
                            </div>
                            <div class="form-group">
                            	<label for="" style="font-family: 'Fjalla One', sans-serif; font-size: 15px;">CATEGORY</label>
                            	<form:select class="form-control" path="category.id">
                            		<form:options items="${categories }"/>
                            	</form:select>
                            </div>
                            <div class="form-group">
                                <label for="" style="font-family: 'Fjalla One', sans-serif; font-size: 15px;">PRICE</label>
                                <div class="input-group">
                                	<div class="input-group-prepend">
		                                <span class="input-group-text">VND</span>
		                            </div>
		                            <form:input class="form-control" path="price" type="number"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" style="font-family: 'Fjalla One', sans-serif; font-size: 15px;">QUANTITY</label>
                                <form:input class="form-control" path="quantity" type="number"/>
                            </div>
                            
                            <div class="form-group">
								<label for="image" style="font-family: 'Fjalla One', sans-serif; font-size: 15px;">IMAGE</label>
								<input name="image" type="file" class="form-control-file"  onchange="chooseFile(this)" aria-describedby="image"/>
							</div>
                            
                           
                        </div>
                        <div class="card-footer">
                            <div class="row justify-content-end">
                                <button class="btn btn-success mr-3" name="btnInsert" style="font-family: 'Fjalla One', sans-serif;"> <i class="fa fa-bookmark-o" aria-hidden="true"></i> Create</button>
                                <button class="btn btn-warning mr-3" name="btnUpdate" style="font-family: 'Fjalla One', sans-serif;"><i class="fa fa-info" aria-hidden="true"></i> Update</button>
                                <button class="btn btn-info" name="btnReset" style="font-family: 'Fjalla One', sans-serif;"><i class="fa fa-paper-plane-o" aria-hidden="true"></i> Reset</button>
                            </div> 
                        </div>
                    </div>
                </form:form>
            </div>

          <!-- /.col-md-6 -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2014-2019 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="/admin/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/admin/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/admin/dist/js/adminlte.min.js"></script>

</body>
</html>
