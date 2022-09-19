$(function() {
});

/**
 * ログインボタン押下時の処理を行います。
 * 
 * @returns
 */
function doLogin() {
	var email = $('#email').val();
	var password = $('#password').val();

	if (email == '') {
		alert(getMessage('login.requiredMail'));
		return false;
	}

	if (password == '') {
		alert(getMessage('login.requiredPassword'));
		return false;
	}

	$('#loginForm').submit();
}