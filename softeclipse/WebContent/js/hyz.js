// 验证码换一张
function hyz() {
	$("#vCode").attr("src",
			"/softeclipse/VerifyCodeServlet?a=" + new Date().getTime());
}
