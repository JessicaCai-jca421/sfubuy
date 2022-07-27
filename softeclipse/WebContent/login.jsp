
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>LOGIN</title>
    <link href="css/login.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/login.js"></script>
    <script src="js/hyz.js"></script>
<script type="text/javascript">
	$(function() {/*Map<String(Cookie name),Cookie(Cookie)>*/
		// get the username in Cookie
		var loginname = window.decodeURI("${cookie.loginname.value}");
		if("${requestScope.user.loginname}") {
			loginname = "${requestScope.user.loginname}";
		}
		$("#loginname").val(loginname);
	});
</script>
</head>
<body>
    <div class="app-cam">
        <div><h2>LOGIN</h2></div>
        <form action="/softeclipse/UserServlet" method="post" id="loginForm">  
			<input type="hidden" name="method" value="login"/>
            <input class="input" type="text" name="loginname" id="loginname"/>
            <input class="input" type="password" name="loginpass" id="loginpass"/>
            <label class="error" id="msg" style="color:red">${msg }</label><br>
            <input class="input" id="verifyCode" name="verifyCode"/>
            <img id="vCode" src="/softeclipse/VerifyCodeServlet" style="margin-top: 10px">
            <label><a href="javascript:hyz()">Can’t recognise ? Change to another one</a></label><br>
            <label id="verifyCodeError" style="color:red"></label>
            <div class="new">
                <p><a href="#">Forgot password?</a></p>
                <p class="sign">Doesn’t have an account?<a href="regist.jsp">SignUp</a></p>
                <div class="clear"></div>
            </div>
            <div class="submit"><input type="submit" value="Login" id="submit"></div>
           
        </form>
    </div>
 
</body>
</html>
