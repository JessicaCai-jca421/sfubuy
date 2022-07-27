
$(function() {
	 
	$("#loginForm").submit(function(){
		
		var bool = true;
		$(".input").each(function() {
			var inputName = $(this).attr("name");
			if(!invokeValidateFunction(inputName)) {
				bool = false;
			}
		});
		
		return bool;
	});
	
	 
	$(".input").focus(function() {
		var inputName = $(this).attr("name");
		$("#" + inputName + "Error").css("display", "none");
	});
	
	 
	$(".input").blur(function() {
		var inputName = $(this).attr("name");
		invokeValidateFunction(inputName);
	})
});

 
function invokeValidateFunction(inputName) {
	inputName = inputName.substring(0, 1).toUpperCase() + inputName.substring(1);
	var functionName = "validate" + inputName;
	return eval(functionName + "()");	
}

 
function validateLoginname() {
	var bool = true;
	$("#loginnameError").css("display", "none");
	var value = $("#loginname").val();
	if(!value) { 
		$("#loginnameError").css("display", "");
		$("#loginnameError").text("User name cannot be empty！");
		bool = false;
	} else if(value.length < 3 || value.length > 20) { 
		$("#loginnameError").css("display", "");
		$("#loginnameError").text("The length of the user name must be between 3 and 20！");
		bool = false;
	}
	return bool;
}
 
function validateLoginpass() {
	var bool = true;
	$("#loginpassError").css("display", "none");
	var value = $("#loginpass").val();
	if(!value) { 
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("Password cannot be empty！");
		bool = false;
	} else if(value.length < 3 || value.length > 20) { 
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("The length of the password must be between 3 and 20！");
		bool = false;
	}
	return bool;
}

 
function validateVerifyCode() {
	var bool = true;
	$("#verifyCodeError").css("display", "none");
	var value = $("#verifyCode").val();
	if(!value) { 
		$("#verifyCodeError").css("display", "");
		$("#verifyCodeError").text("Verification code cannot be empty！");
		bool = false;
	} else if(value.length != 4) { 
		$("#verifyCodeError").css("display", "");
		$("#verifyCodeError").text("Wrong verification code！");
		bool = false;
	} else { 
		$.ajax({
			cache: false,
			async: false,
			type: "POST",
			dataType: "json",
			data: {method: "ajaxValidateVerifyCode", verifyCode: value},
			url: "/softeclipse/UserServlet",
			success: function(flag) {
				if(!flag) {
					$("#verifyCodeError").css("display", "");
					$("#verifyCodeError").text("Wrong verification code！");
					bool = false;					
				}
			}
		});
	}
	return bool;
}



