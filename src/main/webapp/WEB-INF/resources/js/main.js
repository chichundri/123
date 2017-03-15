$(document).ready(function(){
	$(".signUp").click(function(e){
		e.preventDefault();
		var email = $("#userEmail").val();
		var password = $("#userPassword").val();
		var confirmPassword = $("#confirmPassword").val();
//		if(!ValidateEmail(email)){
//			return true;
//		} 
//		if(password=="" || confirmPassword ==""){
//			alert("Please enter password and confirm password");
//			return false;
//		}
//		if(password != confirmPassword ){
//			alert("Password and Confirm password doesnot match !!");
//			return false;
//		}
		
		var data = JSON.stringify($("#signUpForm").serializeObject());
		postAjaxRequest('signUp',data, function(jsonResponse) {
			if(jsonResponse != undefined || jsonResponse != null){
				alert(jsonResponse);
			}
		});
		
		
//		$("#signUpForm").submit();
	})
	

	function ValidateEmail(email) {
		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
			return true;
		}
		alert("Invalid email address!");
		return false;
	}
});