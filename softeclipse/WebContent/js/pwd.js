$(function() {	
	
	$("#submit").submit(function(){
		$("#msg").text("");
		var bool = true;
		$(".input").each(function() {
			var inputName = $(this).attr("name");
			if(!invokeValidateFunction(inputName)) {
				bool = false;
			}
		});
		return bool;
	});
	
	 
	$(".input").blur(function() {
		var inputName = $(this).attr("name");
		invokeValidateFunction(inputName);
	});
});

 
function invokeValidateFunction(inputName) {
	inputName = inputName.substring(0, 1).toUpperCase() + inputName.substring(1);
	var functionName = "validate" + inputName;
	return eval(functionName + "()");	
}

 
function validateLoginpass() {
	var bool = true;
	$("#loginpassError").css("display", "none");
	var value = $("#loginpass").val();
	if(!value) { 
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("Password cannot be empty!");
		bool = false;
	} else if(value.length < 3 || value.length > 20) { 
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("The password length must be between 3 and 20！");
		bool = false;
	};
	return bool;
}
 
function validateNewpass() {
	var bool = true;
	$("#newpassError").css("display", "none");
	var value = $("#newpass").val();
	if(!value) { 
		$("#newpassError").css("display", "");
		$("#newpassError").text("New password cannot be empty！");
		bool = false;
	} else if(value.length < 3 || value.length > 20) { 
		$("#newpassError").css("display", "");
		$("#newpassError").text("New password length must be between 3 and 20!");
		bool = false;
	}
	return bool;
}

 
function validateReloginpass() {
	var bool = true;
	$("#reloginpassError").css("display", "none");
	var value = $("#reloginpass").val();
	if(!value) { 
		$("#reloginpassError").css("display", "");
		$("#reloginpassError").text("Confirm password cannot be empty！");
		bool = false;
	} else if(value != $("#newloginpass").val()) { 
		$("#reloginpassError").css("display", "");
		$("#reloginpassError").text("The two passwords are inconsistent！");
		bool = false;
	}
	return bool;	
}

 

