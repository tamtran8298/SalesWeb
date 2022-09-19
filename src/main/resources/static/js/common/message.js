/**
 * 
 */

const messages = {
	"login" : {
		"requiredMail" : "メールアドレスを入力してください",
		"requiredPassword" : "パスワードを入力してください"
	},
	"common":{
		"dataNotFound":"データが存在しません"
	},
	"user":{
		"required":{
			"userName":"ユーザ名を入力してください。",
			"empNo":"社員番号を入力してください。",
			"mail":"メールアドレスを入力してください。",
		},
		"other":{
			"empNoIsNumber":"社員番号は半角数字で入力してください。",
			"mailRegex":"メールアドレスを正しく入力してください。"
		}
	},
	"salesActivity":{
		"required":{
			"salesWorkBusinessDay":"活動実績の営業日を入れてください。",
			"salesPlanSalesExpectedDate":"活動予定の営業日を入れてください。",
			"salesWorkWorkDetail":"活動実績詳細を入れてください。"
		}
	},
	"company" :{
		"required":{
			"staff":"担当者情報にいずれかの項目が存在する場合は、姓名を入れてください"	
		}
	},
	"paging":{
		"required":{
			"pageNo":"ページNoが入力されていません"
		},
		"maxPageError":"最大ページを超えています。最大ページ：$1"
	},
	"userlist":{
		"authEmailError":"ログインしているユーザは削除できません。"
	}
	
};

/**
 * メッセージIDに該当するメッセージを取得します.
 * 
 * @param messageId
 *            メッセージID
 * @returns
 */
function getMessage(messageId) {

	var message = eval("messages." + messageId);

	if (isNullOrEmpty(message)) {
		return null;
	} else {
		return message;
	}
}

/**
 * メッセージIDに該当するメッセージを取得します.
 * 
 * @param messageId
 *            メッセージID
 * @returns
 */
function getMessageReplace(messageId, replaceStr) {

	var message = eval("messages." + messageId);

	if (isNullOrEmpty(message)) {
		return null;
	} else {
		return message.replace("$1", replaceStr);
	}
}