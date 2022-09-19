/**
 * 
 */
$(function() {
	var errorMessageId = $("#errorMessageId").val();

	if (!isNullOrEmpty(errorMessageId)) {
		alert(getMessage(errorMessageId));
	}
})

function addUser() {

	if (isCheck()){
		$("#userEditForm").submit();
	}else{
		return false;
	}
}

function updateUser() {
	if (isCheck()){
		$("#userEditForm").attr("action", "/usercreate/update/");
		$("#userEditForm").submit();
	}else{
		return false;
	}

}

/**
 * 入力チェックを行います
 * 
 * @returns true:問題なし、false:問題あり
 */
function isCheck() {
	var userName = $("#userName").val();
	var empNo = $("#empNo").val();
	var email = $("#email").val();

	if (isNullOrEmpty(userName)){
		alert(getMessage("user.required.userName"));
		return false;
	}
	
	if (isNullOrEmpty(empNo)){
		alert(getMessage("user.required.empNo"));
		return false;
	}
	
	if (!isHankakuNumber(empNo)){
		alert(getMessage("user.other.empNoIsNumber"));
		return false;
	}
	
	if (isNullOrEmpty(email)){
		alert(getMessage("user.required.mail"));
		return false;
	}
	
	if(!isMailCheck(email)){
		alert(getMessage("user.other.mailRegex"));
		return false;
	}
	
	return true;
}