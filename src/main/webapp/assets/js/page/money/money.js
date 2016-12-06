

/**
 *提现申请详情 
 * @param {Object} id
 */
function GetApplyInfo(id,page){
	var url=$.path + '/money/get_tx_info.html?txid='+id+"&page="+page+"&shinfo=0";
	$('#changeTab').load(url);
}

/**
 *提现申请审核
 * @param {Object} id
 */
function ShApplyInfo(id){
	var url=$.path + '/money/get_tx_info.html?txid='+id+"&page=0&shinfo=1";
	$('#changeTab').load(url);
}

function DkApplyInfo(id){
 	var url=$.path + '/money/get_tx_info.html?txid='+id+"&page=1&shinfo=1";
	$('#changeTab').load(url);
}
