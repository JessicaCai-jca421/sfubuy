<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类栏</title>
<script type="text/javascript" src="<c:url value='js/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='js/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='css/mymenu.css'/>" type="text/css" media="all">
	<link rel="stylesheet" type="text/css" href="<c:url value='css/left.css'/>">
<script language="javascript">
/*
 * 1. 对象名必须与第一个参数相同！
   2. 第二个参数是显示在菜单上的大标题
 */
var bar = new Q6MenuBar("bar", "分类商品");
$(function() {
	bar.colorStyle = 2;//指定配色样式，一共0,1,2,3,4
	bar.config.imgDir = "<c:url value='images/'/>";//小工具所需图片的路径
	bar.config.radioButton=true;//是否排斥，多个一级分类是否排斥

	/*
	1. 程序设计：一级分类名称
	2. Java Javascript：二级分类名称
	3. /goods/jsps/book/list.jsp：点击二级分类后链接到的URL
	4. body:链接的内容在哪个框架页中显示
	*/
<c:forEach items="${parents}" var="parent">
  <c:forEach items="${parent.children}" var="child">
	bar.add("${parent.cname}", "${child.cname}", "/softeclipse/CommodityServlet?method=findByCategory&cid=${child.cid}", "body");
  </c:forEach>
</c:forEach>
	
	$("#menu").html(bar.toString());
});
</script>
</head>
  
<body>  
  <div id="menu"></div>
</body>
</html>