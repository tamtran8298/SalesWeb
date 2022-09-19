/**
 * 
 */

var messages = {
	"MSG0001" : "",
	"MSG0002" : "",
	"MSG0003" : "",
	"MSG0004" : "",
	"MSG0005" : "",
	"MSG0006" : "",
	"MSG0007" : "",
	"MSG0008" : "",
	"MSG0009" : "",
	"MSG0010" : "",
	"MSG0011" : "",
	"MSG0012" : "",
	"MSG0013" : ""
};

/**
 * メッセージIDに対するメッセージを取得します
 * 
 * @param msgId
 *            メッセージID
 * @returns メッセージIDが存在する場合は対象のメッセージを返却し、なければブランク
 */
function getMessage(msgId) {
	var message = messages[msgId];

	if (isNullOrEmpty(message)) {
		return "";
	} else {
		return message;
	}
}

/**
 * 
 * @param msgId
 * @param replaceStr
 * @returns
 */
function getMessageReplace(msgId, replaceStr){
	var message = getMessage(msgId);
	
	if (!isNullOrEmpty(message)){
		return message.replace("$1", replaceStr);
	}else{
		return "";
	}
}