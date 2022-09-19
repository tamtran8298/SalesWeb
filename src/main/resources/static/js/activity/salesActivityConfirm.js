$(function() {
	$("#add").colorbox({
		href : '/dialog/company/',
		width : '600px',
		height : '550px',
		closeButton : false
	});
});

/**
 * 活動詳細のリンククリック時の処理
 * 
 * @param data
 * @returns
 */
function showWorkDetail(data) {
	var detail = $(data).attr("data-work-detail").replace("\n", "<br>");
	$("#workDetail").html(detail);

	var className = $(data).attr("class");

	$("." + className).colorbox({
		inline : true,
		width : '600px',
		height : '450px',
		closeButton : false
	});
}

/**
 * 検索ボタン押下時の処理
 * 
 * @param data
 * @returns
 */
function showSearchDialog() {
	$("#searchDialogButton").colorbox({
		href : '/dialog/activity/search/',
		width : '600px',
		height : '400px',
		closeButton : false
	});
}

/**
 * 編集ボタン押下時の処理を行います.
 * 
 * @param data
 * @returns
 */
function confirmSalesActivity(data) {
	var confirmData = $(data).attr("data-confirm").split(",");
	var companyName = confirmData[0];
	var salesWorkResponsible = confirmData[1];
	var salesWorkBusinessDay = confirmData[2];

	$("#salesActivityConfirmForm").attr("action", "/sales/confirm/edit/");
	$("#companyName").val(companyName);
	$("#salesWorkResponsible").val(salesWorkResponsible);
	$("#salesWorkBusinessDay").val(salesWorkBusinessDay);
	$("#sendType").val("edit");

	$("#salesActivityConfirmForm").submit();
}

/**
 * 削除ボタン押下時の処理を行います.
 * 
 * @param data
 * @returns
 */
function deleteSalesActivity(data) {

	if (window.confirm("削除しますか?")) {
		var confirmData = $(data).attr("data-confirm").split(",");
		var companyName = confirmData[0];
		var salesWorkResponsible = confirmData[1];
		var salesWorkBusinessDay = confirmData[2];

		$("#salesActivityConfirmForm").attr("action", "/sales/work/delete/");
		$("#companyName").val(companyName);
		$("#salesWorkResponsible").val(salesWorkResponsible);
		$("#salesWorkBusinessDay").val(salesWorkBusinessDay);

		$("#salesActivityConfirmForm").submit();
	} else {
		return false;
	}
}

/**
 * クリアボタン押下時の処理を行います.
 * 
 * @returns
 */
function clearCondition(){
	$("#salesActivityConfirmForm").attr("action", "/sales/confirm/");
	$("#salesActivityConfirmForm").submit();
}