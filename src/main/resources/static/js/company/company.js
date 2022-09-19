/**
 * 
 */

$(function() {
	$('#foundation').flatpickr(datePickerOption);
});

function updateCompany() {

	if (!isCheckStaff()) {
		alert(getMessage("company.required.staff"));
	} else {
		$("#companyForm").attr("action", "/company/form/update/")
		$("#companyForm").submit();
	}
}

/**
 * 登録ボタン押下時の処理を行います。
 * 
 * @returns
 */
function addCompany() {

	if (!isCheckStaff()) {
		alert("担当者情報にいずれかの項目が存在する場合は、姓名を入れてください");
	} else {
		$("#companyForm").submit();
	}
}

/**
 * 担当者情報の入力項目を精査します
 * 
 * 
 * @returns
 */
function isCheckStaff() {
	for (var i = 0; i < 4; i++) {
		var department = $("#department" + i).val();
		var position = $("#position" + i).val();
		var nameSei = $("#nameSei" + i).val();
		var name = $("#name" + i).val();
		var mail = $("#mail" + i).val();
		var tel = $("#tel" + i).val();

		if (isBlankStaffName(department, nameSei, name)) {
			return false;
		}

		if (isBlankStaffName(position, nameSei, name)) {
			return false;
		}

		if (isBlankStaffName(mail, nameSei, name)) {
			return false;
		}

		if (isBlankStaffName(tel, nameSei, name)) {
			return false;
		}
	}

	return true;
}

/**
 * 
 * @param target
 * @param nameSei
 * @param name
 * @returns
 */
function isBlankStaffName(target, nameSei, name) {

	if (!isNullOrEmpty(target)) {
		if (isNullOrEmpty(nameSei) || isNullOrEmpty(name)) {
			return true;
		} else {
			return false;
		}
	} else {
		return false;
	}

}