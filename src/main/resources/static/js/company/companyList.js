/**
 * 
 */

function editCompany(data) {
	var companyName = $(data).attr("data-company-name");

	if (!isNullOrEmpty(companyName)) {
		$("#companyName").val(companyName);
	}

	$("#companyListForm").submit();

}

function addCompany() {
	$("#companyName").val("");

	$("#companyListForm").submit();

}

function confirmCompany(data) {
	var companyName = $(data).attr("data-company-name");

	if (!isNullOrEmpty(companyName)) {
		$("#companyName").val(companyName);
	}

	$("#companyListForm").attr("action", "/company/form/confirm/");
	$("#companyListForm").submit();

}

function showSearchDialog() {
	$("#searchDialogButton").colorbox({
		href : '/dialog/company/search/',
		width : '600px',
		height : '300px',
		closeButton : false
	});
}