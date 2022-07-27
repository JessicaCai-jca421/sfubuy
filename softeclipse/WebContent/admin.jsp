<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Backstage management page</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/linearicons.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">

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
								<li title="log in"><i class="lnr lnr-enter"></i><span
									id="denglu">log in</span></li>
							</c:when>
							<c:otherwise>
								<li title="Personal center" id="yonghu"><i class="fa fa-user"></i><span>${sessionScope.admin.adminname }</span></li>
								<li title="drop out" id="tuichu"><i class="lnr lnr-exit"></i><span>drop out</span></li>
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
					<h1>SFUbuy Backstage management</h1>
					<div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                    data-target="#menu-id" aria-expanded="false"/>
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                    </div>
					<div class="collapse navbar-collapse" id="menu-id">
						<ul class="nav navbar-nav">
							
							<li class="dropdown"><a href="adminlunbo.jsp"></a>Carousel management</li>
							<li><a href="admincommoditymain.jsp">Commodity management</a></li>		
							<li><a href="<c:url value='/AdminCategoryServlet?method=findAll'/>">Classification management</a></li>
						</ul>
					
					</div>
				</div>
				</nav>
			</div>
		</div>
	</div>
	</header>
	<img src="<c:url value='images/admin_page.jpg'/>" width="100%"
		height="100%" />
	<script src="js/jquery-2.1.1.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/admin.js"></script>
</body>
</html>