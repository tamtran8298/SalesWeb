/**
 * 
 */

$(function() {
	$('#periodFromDate').flatpickr(datePickerOption);

	$('#periodToDate').flatpickr(datePickerOption);

	$("#periodFromDate").val(getMonthFirstDay());
	$("#periodToDate").val(getMonthEndDay());
	
	var messageId = $("#messageId").val();
	
	if (!isNullOrEmpty(messageId)){
		alert(getMessage(messageId));
	}
});