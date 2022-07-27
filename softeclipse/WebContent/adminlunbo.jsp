<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="dao.LunboDao"%>
<%@page import="java.util.List"%>
<%@page import="domain.Lunbo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Management</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/linearicons.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<script src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">
$(function () {
	
	$("#btn").click(function() {
		
		$("#form").submit();
	});
});
</script>
</head>
<body>
	<header class="header" id="_top">
	<div class="top-header">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-xs-5">
					<ul class="list-inline security">
						<c:choose>
							<c:when test="${empty sessionScope.admin }">
								<li title="Login"><i class="lnr lnr-enter"></i><span
									id="denglu">Login</span></li>
							</c:when>
							<c:otherwise>
								<li title="User center" id="yonghu"><i class="fa fa-user"></i><span>${sessionScope.admin.adminname }</span></li>
								<li title="Exit" id="tuichu"><i class="lnr lnr-exit"></i><span>EExit</span></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="bottom-header">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<nav class="navbar navbar-default">
				<div class="container">
					<h1>SFUbuy back-stage management</h1>
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

							<li class="dropdown active"><a href="#">Management</a></li>
							<li><a href="admincommoditymain.jsp">Commodity management</a></li>
							<li><a
								href="<c:url value='/AdminCategoryServlet?method=findAll'/>">Classified management</a></li>
							
						</ul>

					</div>
				</div>
				</nav>
			</div>
		</div>
	</div>
	</header>
	<section class="fashion-box">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7 p-0 text-center">
				<div id="f-b" class="carousel slide" data-ride="carousel">
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<div class="fashion-content"
								style="background-image: url(images/main1.jpg)">
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
						<%
							LunboDao commodityDao = new LunboDao();
							List<Lunbo> imageList = commodityDao.lunBo();
							int count = 0;

							for (Lunbo image : imageList)
							{
								
						%>
						<div class="item">
							<div class="fashion-content"
								style="background-image: url(<%=image.getImage()%>)">
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

						<%
							}
						%>
					</div>
					<a class="left carousel-control" href="#f-b" role="button"
						data-slide="prev"><i class="lnr lnr-chevron-left"></i></a> <a
						class="right carousel-control" href="#f-b" role="button"
						data-slide="next"><i class="lnr lnr-chevron-right"></i></a>
				</div>
			</div>

		</div>
	</div>
	</section>


	<section class="feature-product" id="feature">
	<div class="grid-product">
		<div class="container">
			<div class="row">
				<div
					class="section-title col-md-offset-3 col-md-6 col-xs-12 text-center">
					<h2>pictures</h2>
					<div class="section-border">
						<span class="dash"></span>
					</div>
				</div>
			</div>
			<div class="row">
				<%
					for (Lunbo image : imageList)
					{
						String no = image.getImageNo();
						request.setAttribute("no", no);
				%>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="single-grid">
						<div class="grid-img">
							<img class="img-resposive"
								src="<c:url value='<%=image.getImage()%>'/>" />
							<div class="grid-overlay">
								<ul>
									<li><a class="lnr lnr-trash" title="Delete"
										href="<c:url value='/AdminCommodityServlet?method=deletelunbo&no=${no }'/>"></a></li>
								</ul>
							</div>
						</div>

					</div>
				</div>

				<%
					}
				%>

			</div>
		</div>
	</div>
	</section>
	<p style="font-weight: 900; color: red;">${msg }</p>
	<form action="<c:url value='/AdminAddLunboServlet'/>"
		enctype="multipart/form-data" method="post" id="form">
		<div style="margin-left:20%">
			添加图片： <input id="image" type="file" name="image" /> 
			<br>
			<input type="button" id="btn" class="btn" value="添加图片">
		</div>
	</form>
	<br>
	<br>
	<script src="bootstrap/js/bootstrap.min.js"></script>

	<script src="js/admin.js"></script>
</body>
</html>