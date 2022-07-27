<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrator login</title>
<link href="css/login.css" rel='stylesheet' type='text/css' />
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
		function checkForm() {
			if(!$("#adminname").val()) {
				alert("Administrator name cannot be empty！");
				return false;
			}
			if(!$("#adminpwd").val()) {
				alert("Administrator password cannot be empty！");
				return false;
			}
			return true;
		}
		
	</script>
</head>
<body>
<div class="app-cam">
        <div><h2>Administrator login</h2></div>
        <form action="<c:url value='/AdminServlet'/>" method="post" onsubmit="return checkForm()" target="_top">  
			<input type="hidden" name="method" value="login"/>
            <input type="text" name="adminname" value="" id="adminname"/><br/>
			<input type="password" name="adminpwd" id="adminpwd"/><br/>
			<label class="error" id="msg" style="color:red">${msg }</label><br>
            <div class="submit"><input type="submit" value="login" id="submit"></div>
           
        </form>
    </div>
</body>
</html>