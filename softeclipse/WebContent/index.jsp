<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%-- <%@page import="dao.CommodityDao"%> --%>
<%@page import="java.util.List"%>
<%-- <%@page import="domain.Commodity"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>276</title>

<!--======== All Stylesheet =========-->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/linearicons.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<script src="js/jquery-2.1.1.js"></script>

</head>

<body>
	<!-- Header -->
	<header class="header" id="_top">
	<div class="top-header">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-xs-5">
					<ul class="list-inline security">
						<c:choose>
							<c:when test="${empty sessionScope.sessionUser }">
								<li title="Login"><i class="lnr lnr-enter"></i><span
									id="denglu">Login</span></li>
							</c:when>
							<c:otherwise>
								<li title="User Account" id="yonghu"><i class="fa fa-user"></i><span>${sessionScope.sessionUser.loginname }</span></li>
								<li title="Exit" id="tuichu"><i class="lnr lnr-exit"></i><span>Exit</span></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="middle-header">
		<div class="container">
			<div class="row">
				<div class="col-md-2 col-xs-6">
					<div>
						<a class="site-title" href="#">SFU<span>buy</span></a>Second hand book trading website
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-md-offset-7 col-xs-6">
					<div class="cart-label dropdown">
						<a class="btn btn-default dropdown-toggle" role="button"
							href="<c:url value='/CartItemServlet?method=myCart'/>"> <small>Shopping Cart</small>
							<i class="lnr lnr-cart"><span>←</span></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="bottom-header">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<nav class="navbar navbar-default">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#menu-id"
							aria-expanded="false" />
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</div>
					<div class="collapse navbar-collapse" id="menu-id">
						<ul class="nav navbar-nav">
							<li class="dropdown active"><a href="#">Home</a></li>
							<li><a href="practice.jsp">Categories</a></li>
							<li><a href="about.jsp">About Us</a></li>
							
						</ul>
						<div class="nav-search">
							<form class="navbar-form navbar-right"
								action="<c:url value='/CommodityServlet'/>" method="get"
								target="_self" id="form1">
								<input type="hidden" name="method" value="findByBname2" />
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Search" name="bname" /> <i><a
										class="fa fa-search search-btn"
										href="javascript:document.getElementById('form1').submit();"></a></i>
								</div>
							</form>
						</div>
					</div>
				</div>
				</nav>
			</div>
		</div>
	</div>

	</header>

	<!-- fashion-box -->
	<section class="fashion-box">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7 p-0 text-center">
				<div id="f-b" class="carousel slide" data-ride="carousel">
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<div class="fashion-content"
								style="background-image: url(images/1113.jpg)">
								<h2>Top Items</h2>
								<h2>all you need</h2>
								<ul class="list-inline">
									<li><i class="lnr lnr-star"></i></li>
									<li><i class="lnr lnr-star"></i></li>
									<li><i class="lnr lnr-star"></i></li>
									<li><i class="lnr lnr-star"></i></li>
									<li><i class="lnr lnr-star"></i></li>
								</ul>
							</div>
						</div>
						<div class="item">
							<div class="fashion-content"
								style="background-image: url(images/images.jpg)">
								<h2>All Majors</h2>
								<p>Math，Economic， IAT。。。。。</p>
								<ul class="list-inline">
									<li><i class="lnr lnr-star"></i></li>
									<li><i class="lnr lnr-star"></i></li>
									<li><i class="lnr lnr-star"></i></li>
									<li><i class="lnr lnr-star"></i></li>
									<li><i class="lnr lnr-star"></i></li>
								</ul>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#f-b" role="button"
						data-slide="prev"><i class="lnr lnr-chevron-left"></i></a> <a
						class="right carousel-control" href="#f-b" role="button"
						data-slide="next"><i class="lnr lnr-chevron-right"></i></a>
				</div>
			</div>
			<div class="col-md-5 p-0">
				<div class="counter">
					<div class="counter-content">

						<h2 class="save-offer">25% off</h2>
						<div>
							<a class="btn btn-default" href="#feature">Here！</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>



	<!-- add Two -->
	<div id="form_top">
		<a href="#_top" title="back to top">Top
			<div class="top_img fa fa-arrow-up"></div>
		</a>
	</div>
	<!--======== All Javascript =========-->

	<script src="bootstrap/js/bootstrap.min.js"></script>

	<script src="js/main.js"></script>
</body>
</html>
