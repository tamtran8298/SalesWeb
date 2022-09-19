// 正規表現一覧

// メールアドレスの正規表現
var regexMail = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;

// 半角数字のみ
var regexHankakuNumber = /^[0-9]+$/;
/**
 * 文字列がnullかどうかを判定します。
 * 
 * @param str
 *            走査文字列
 * @returns nullまたは空白の場合はtrue、そうでない場合はfalse
 */
function isNullOrEmpty(str) {

	if (str == null || str == '') {
		return true;
	} else {
		return false;
	}
}

/**
 * メールアドレスの正規表現チェック
 * 
 * @param mail
 *            チェック対象のメールアドレス
 * @returns true:問題なし、false:問題あり
 */
function isMailCheck(mail) {
	if (regexMail.test(mail)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 半角数字の正規表現チェック
 * 
 * @param str
 *            チェック対象文字列
 * @returns true:問題なし、false:問題あり
 */
function isHankakuNumber(str) {
	if (regexHankakuNumber.test(str)) {
		return true;
	} else {
		return false;
	}
}