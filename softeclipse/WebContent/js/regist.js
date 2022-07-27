$(document).ready(
		function() {
			$(".errorClass").each(function() {
				showError($(this));
			});

			$(".inputClass").focus(function() {
				var labelId = $(this).attr("id") + "Error";
				$("#" + labelId).text("");
				showError($("#" + labelId));
			});

			$(".inputClass").blur(
					function() {
						var id = $(this).attr("id");
						var funName = "validate"
								+ id.substring(0, 1).toUpperCase()
								+ id.substring(1) + "()";
						eval(funName);
					});

			
			$("#registForm").submit(function() {
				var bool = true;
				if (!validateLoginname()) {
					bool = false;
				}
				if (!validateLoginpass()) {
					bool = false;
				}
				if (!validateReloginpass()) {
					bool = false;
				}
				if (!validateEmail()) {
					bool = false;
				}
				if (!validatePhone()) {
					bool = false;
				}

				return bool;
			});
		});

function validateLoginname() {
	var id = "loginname";
	var value = $("#" + id).val();
	
	if (!value) {
		
		$("#" + id + "Error").text("User name cannot be empty!");
		showError($("#" + id + "Error"));
		return false;
	}
	
	if (value.length < 3 || value.length > 20) {
		
		$("#" + id + "Error").text("The length of user name must be between 3 and 20!");
		showError($("#" + id + "Error"));
		return false;
	}
	
	$.ajax({
		url : "/softeclipse/UserServlet",
		data : {
			method : "ajaxValidateLoginname",
			loginname : value
		},
		type : "POST",
		dataType : "json",
		async : false,
		cache : false,
		success : function(result) {
			if (!result) {
				$("#" + id + "Error").text("User name has been registered!");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}


function validateLoginpass() {
	var id = "loginpass";
	var value = $("#" + id).val();
	
	if (!value) {
		
		$("#" + id + "Error").text("Password cannot be empty!");
		showError($("#" + id + "Error"));
		return false;
	}
	
	if (value.length < 3 || value.length > 20) {
		
		$("#" + id + "Error").text("The length of Password must be between 3 and 20!");
		showError($("#" + id + "Error"));
		return false;
	}
	return true;
}

function validateReloginpass() {
	var id = "reloginpass";
	var value = $("#" + id).val();
	
	if (!value) {
		
		$("#" + id + "Error").text("Confirm password cannot be empty!");
		showError($("#" + id + "Error"));
		return false;
	}
	 
	if (value != $("#loginpass").val()) {
		 
		$("#" + id + "Error").text("The passwords entered did not match");
		showError($("#" + id + "Error"));
		return false;
	}
	return true;
}

 
function validateEmail() {
	var id = "email";
	var value = $("#" + id).val(); 
	 
	if (!value) {
		 
		$("#" + id + "Error").text("Email cannot be empty！");
		showError($("#" + id + "Error"));
		return false;
	}
	 
	if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
			.test(value)) {
		 
		$("#" + id + "Error").text("Wrong email format!");
		showError($("#" + id + "Error"));
		return false;
	}
	 
	$.ajax({
		url : "/softeclipse/UserServlet", 
		data : {
			method : "ajaxValidateEmail",
			email : value
		}, 
		type : "POST",
		dataType : "json",
		async : false, 
		cache : false,
		success : function(result) {
			if (!result) { 
				$("#" + id + "Error").text("Email has been registered!");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}

 
function validatePhone() {
	var id = "phone";
	var value = $("#" + id).val(); 
	 
	if (!value) {
		 
		$("#" + id + "Error").text("phone number cannot be empty!");
		showError($("#" + id + "Error"));
		return false;
	}
	 
	if (value.length !=11) {
		 
		$("#" + id + "Error").text("Mobile phone must be 10 digits!");
		showError($("#" + id + "Error"));
		return false;
	}
	 
	$.ajax({
		url : "/softeclipse/UserServlet",  
		data : {
			method : "ajaxValidatePhone",
			phone : value
		}, 
		type : "POST",
		dataType : "json",
		async : false, 
		cache : false,
		success : function(result) {
			if (!result) { 
				$("#" + id + "Error").text("Mobile number has been registered!");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}
 
function showError(ele) {
	var text = ele.text(); 
	if (!text) { 
		ele.css("display", "none"); 
	} else { 
		ele.css("display", ""); 
	}
}
