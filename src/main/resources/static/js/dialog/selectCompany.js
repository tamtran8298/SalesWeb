$(function(){
	
});

/**
 * 五十音
 * @param data
 * @returns
 */
function selectWord(data) {
	var word = $(data).attr("data-word");

	// 一旦すべてのclassからactiveを削除
	$('.company-word-list ul li').each(function(i, elem) {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active");
		}
	});

	$(data).addClass("active");
	
	$("#company-name-label").text("会社名を選択してください");
	$("#decision-button").attr("disabled", true);
	
	doAjax('GET', '#company-list', "/dialog/company/" + word + "/", {'word': word}, false);
	
}

/**
 * 選択した会社名を上部のラベルに設定します
 * 
 * @param companyName
 *            会社名
 * @returns なし
 */
function selectCompany(data) {
	var companyName = $(data).attr("data-company-name");
	$("#company-name-label").text(companyName);

	$("#decision-button").removeAttr("disabled");
	
	// 一旦すべてのclassからactiveを削除
	$('.company-list ul li').each(function(i, elem) {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active");
		}
	});
	
	$(data).addClass("active");
	
	
	$("#selectCompanyName").val(companyName);
	
}
