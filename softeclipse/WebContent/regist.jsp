<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>注册页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/regist.css">

<script type="text/javascript" src="js/jquery-1.5.1.js"></script>
<script type="text/javascript" src="js/regist.js"></script>
</head>

<body>
	<div id="divMain">
		<div id="divTitle">
			<span id="spanTitle">New User Signin</span>
		</div>
		<div id="divBody">
			<form action="/softeclipse/UserServlet" method="post" id="registForm">
				<input type="hidden" name="method" value="regist" />
				<table id="tableForm">
					<tr>
						<td class="tdText">User：</td>
						<td class="tdInput"><input class="inputClass" type="text"
							name="loginname" id="loginname" value="${form.loginname }" /></td>

					</tr>
					<tr>
						<td></td>
						<td class="tdError"><label class="errorClass"
							id="loginnameError">${errors.loginname }</label></td>

					</tr>
					<tr>
						<td class="tdText">Password：</td>
						<td><input class="inputClass" type="password"
							name="loginpass" id="loginpass" value="${form.loginpass }" /></td>


					</tr>
					<tr>
						<td></td>
						<td><label class="errorClass" id="loginpassError">${errors.loginpass }</label></td>

					</tr>
					<tr>
						<td class="tdText">Conform Password：</td>
						<td><input class="inputClass" type="password"
							name="reloginpass" id="reloginpass" value="${form.reloginpass }" />
						</td>

					</tr>
					<tr>
						<td></td>
						<td><label class="errorClass" id="reloginpassError">${errors.reloginpass}</label>
						</td>

					</tr>
					<tr>
						<td class="tdText">Email：</td>
						<td><input class="inputClass" type="text" name="email"
							id="email" value="${form.email }" /></td>

					</tr>
					<tr>
						<td></td>
						<td><label class="errorClass" id="emailError">${errors.email}</label>
						</td>

					</tr>
					<tr>
						<td class="tdText">Phone Number：</td>
						<td><input class="inputClass" type="text" name="phone"
							id="phone" value="${form.phone }" /></td>
						
					</tr>
					<tr>
						<td></td>
						<td><label class="errorClass" id="phoneError">${errors.phone}</label>
						</td>

					</tr>
					<tr>
						<td></td>
						<td><input type="submit" id="submitBtn" value="Signin" /></td>

					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
