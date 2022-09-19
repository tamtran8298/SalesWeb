

$(function() {
	$('#fromDate').flatpickr(datePickerOption);

	$('#toDate').flatpickr(datePickerOption);

});

/**
 * 五十音
 * @param data
 * @returns
 */
function changeCompany() {
	var selectedCompany = $("#company-list option:selected").val();
	
	doAjax('GET', '#staff-list', "/dialog/activity/search/result/", {'selectedCompany': selectedCompany}, false);	
}

function decision(){
	$("#activitySearchDialogForm").submit();
}