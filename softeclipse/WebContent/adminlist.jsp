<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类管理</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='css/adminlist.css'/>">
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
								<li title="Login"><i class="lnr lnr-enter"></i><span
									id="denglu">Login</span></li>
							</c:when>
							<c:otherwise>
								<li title="User Center" id="yonghu"><i class="fa fa-user"></i><span>${sessionScope.admin.adminname }</span></li>
								<li title="Exit" id="tuichu"><i class="lnr lnr-exit"></i><span>Exit</span></li>
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
					<h1>SFUbuy Management</h1>
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

							<li class="dropdown"><a href="adminlunbo.jsp">Exchange Management</a></li>
							<li><a href="admincommoditymain.jsp">Commodity management</a></li>
							<li class="active"><a
								href="<c:url value='/AdminCategoryServlet?method=findAll'/>">Classified management</a></li>
							
						</ul>

					</div>
				</div>
				</nav>
			</div>
		</div>
	</div>
	</header>
	<h2 style="text-align: center;">分类列表</h2>
	<table align="center" border="1" cellpadding="0" cellspacing="0">
		<caption class="captionAddOneLevel">
			<a href="<c:url value='adminaddcategory.jsp'/>">添加一级分类</a>
		</caption>
		<tr class="trTitle">
			<th>分类名称</th>
			<th>描述</th>
			<th>操作</th>
		</tr>

		<c:forEach items="${parents }" var="parent">
			<tr class="trOneLevel">
				<td width="200px;">${parent.cname }</td>
				<td>${parent.desc }</td>
				<td width="200px;"><a
					href="<c:url value='/AdminCategoryServlet?method=addChildPre&pid=${parent.cid }'/>">Add secondary classification</a>
					<a
					href="<c:url value='/AdminCategoryServlet?method=editParentPre&cid=${parent.cid }'/>">modify</a>
					<a onclick="return confirm('Are you sure you want to delete the secondary category？')"
					href="<c:url value='/AdminCategoryServlet?method=deleteParent&cid=${parent.cid }'/>">Delete</a>
				</td>
			</tr>
			<c:forEach items="${parent.children }" var="child">
				<tr class="trTwoLevel">
					<td>${child.cname }</td>
					<td>${child.desc }</td>
					<td width="200px;" align="right"><a
						href="<c:url value='/AdminCategoryServlet?method=editChildPre&cid=${child.cid }'/>">modify</a>
						<a onclick="return confirm('Are you sure you want to delete the secondary category？')"
						href="<c:url value='/AdminCategoryServlet?method=deleteChild&cid=${child.cid }'/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</c:forEach>
		

	</table>
	<br>
	<br>
	<br>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/admin.js"></script>
</body>
</html>