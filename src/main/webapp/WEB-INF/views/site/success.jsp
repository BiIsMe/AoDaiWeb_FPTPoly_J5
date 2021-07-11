<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | XeoXo</title>
    <link href="/site/css/bootstrap.min.css" rel="stylesheet">
    <link href="/site/css/font-awesome.min.css" rel="stylesheet">
    <link href="/site/css/prettyPhoto.css" rel="stylesheet">
    <link href="/site/css/price-range.css" rel="stylesheet">
    <link href="/site/css/animate.css" rel="stylesheet">
	<link href="/site/css/main.css" rel="stylesheet">
	<link href="/site/css/responsive.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Dancing+Script|M+PLUS+1p|Playfair+Display&display=swap" rel="stylesheet">

	
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <base href="${pageContext.servletContext.contextPath}/"/>
</head>
<body>
	<div class="container text-center">
		<div class="logo-404">
			<a href="index.html"><img src="../images/home/logo.png" alt="" /></a>
		</div>
		<div class="content-404" style="margin-top:70px">
            <h1><li>Đơn hàng có mã : <b>${idOrder}</b> - Tổng tiền : <b><fmt:formatNumber type="number" pattern="###,###,###" value="${totalPrice}" /></b> VND <br /> đã được tiếp nhận</li></h1> <br>
			<h1><b>Cảm ơn quý khách đã sử dụng dịch vụ</b> </h1> <br>
			<h2><a href="xeoxo/index">Tiếp tục mua hàng</a></h2>
		</div>
	</div>

  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>