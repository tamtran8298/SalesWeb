var datePickerOption = {
	"dateFormat" : "Y-m-d",
	"locale" : "ja"
}


$(function() {
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
	});
})

/**
 * ログアウト処理を行います。
 * 
 * @returns
 */
function logout() {
	$("#menuForm").submit();
}

/**
 * 非同期通信を行います
 * 
 * @param sendType
 *            送信タイプ(GETまたはPOST)
 * @param id
 *            読み込みID
 * @param url
 *            送信先のURL
 * @param sendData
 *            送信データ
 * @param loadingFlag
 *            ローディング表示フラグ
 * @returns
 */
function doAjax(sendType, id, url, sendData, loadingFlag) {

	if (loadingFlag){
		showDialog();
	}
	
	 $.ajax({
         url: url,
         type: sendType,
         data:{
             sendData
         }
     })
     // Ajaxリクエストが成功した時発動
     .done( (data) => {
    	 $(id).empty();
    	 $(id).append(data);
     })
     // Ajaxリクエストが失敗した時発動
     .fail( (data) => {
     })
     // Ajaxリクエストが成功・失敗どちらでも発動
     .always( (data) => {

     });
	
}

/**
 * 当月の初日を返却します。
 * 
 * @returns
 */
function getMonthFirstDay(){
	var date = new Date();
	date .setDate(1);
	
	return moment(date).format("YYYY/MM/DD");
}

/**
 * 当月の最終日を返却します.
 * 
 * @returns
 */
function getMonthEndDay(){
	var date = new Date();
	date.setDate(1);
	date.setMonth(date.getMonth() + 1);
	date.setDate(0);
	
	return moment(date).format("YYYY/MM/DD");
}

/**
 * 移動処理を追加
 * 
 * @param actionUrl ページNoを付与するURL
 * @returns
 */
function movePage(actionUrl){
	var movePageNo = $("#movePageText").val();
	var maxPageNo = parseInt($("#maxPageNo").val(), 10);
	
	if (movePageNo == ''){
		alert(getMessage("paging.required.pageNo"));
		return false;
	}
	
	// 文字列比較のためチェック後に変換
	movePageNo = parseInt(movePageNo, 10);

	// 最大ページを超えています。
	if (movePageNo > maxPageNo){
		alert(getMessageReplace("paging.maxPageError", maxPageNo));
		return false;
	}
	
	
	location.href = actionUrl + movePageNo + "/";
}