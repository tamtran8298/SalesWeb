/**
 * 
 */

$(function(){
	var errorMessageId = $("#errorMessageId").val();
	
	if (!isNullOrEmpty(errorMessageId)){
		alert(getMessage(errorMessageId));
	}
})

function confirmUser(data){
	var email = $(data).attr("data-email");
	
	if (!isNullOrEmpty(email)){
		$("#email").val(email);
		$("#userListForm").submit();
	}
}

function deleteUser(data){
	var email = $(data).attr("data-email");
	
	if (window.confirm("ユーザを削除しますが、よろしいですか?")){
		if (!isNullOrEmpty(email)){
			$("#email").val(email);
			$("#userListForm").attr("action", "/user/list/delete/")
			$("#userListForm").submit();
		}	
	}else{
		return false;
	}
}