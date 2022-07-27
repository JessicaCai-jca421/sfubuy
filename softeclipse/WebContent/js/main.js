$(document).ready(function() {
	$("#denglu").click(function() {
		window.location.href="login.jsp";
	});
	$("#tuichu").click(function() {
		window.location.href="/softeclipse/UserServlet?method=quit";
	});
	$("#yonghu").click(function() {
		window.location.href="user.jsp";
	});
	$("#fanhui").click(function() {
		window.location.href="index.jsp";
	});
});