/**
 * 
 */

$(function() {
	$('#salesPlanSalesExpectedDate').flatpickr(datePickerOption);

	$('#salesWorkBusinessDay').flatpickr(datePickerOption);

});

function updateSalesActivity(){
	
	if(insertUpdateCheck()){
		$("#salesActivityForm").attr("action", "/sales/work/update/");
		$("#salesActivityForm").submit();
	}else{
		return false;
	}
}

function insertSalesActivity(){
	
	if(insertUpdateCheck()){
		$("#salesActivityForm").submit();	
	}else{
		return false;
	}
}

function insertUpdateCheck(){
	var salesWorkBusinessDay = $("#salesWorkBusinessDay").val(); // 活動実績営業日
	var salesPlanSalesExpectedDate = $("#salesPlanSalesExpectedDate").val(); // 活動予定営業日
	var salesWorkWorkDetail = $("#salesWorkWorkDetail").val();　// 活動実績詳細
	
	if (isNullOrEmpty(salesWorkBusinessDay)){
		alert(getMessage("salesActivity.required.salesWorkBusinessDay"));
		return false;
	}
	
	if (isNullOrEmpty(salesPlanSalesExpectedDate)){
		alert(getMessage("salesActivity.required.salesPlanSalesExpectedDate"));
		return false;
	}

	if (isNullOrEmpty(salesWorkWorkDetail)){
		alert(getMessage("salesActivity.required.salesWorkWorkDetail"));
		return false;
	}
	
	return true;
}