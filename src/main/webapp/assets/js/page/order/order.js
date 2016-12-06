

/**
 *订单详情 
 * @param {Object} id
 */
function GetOrderInfo(id){
	var url=$.path + '/order/order_info.html?orderid='+id+"&page=0&shinfo=0";
	$('#changeTab').load(url);
}

/**
 *  订单审核页面
 * @param {Object} id
 */
function GetOrderInfoSh(id){
	var url=$.path + '/order/order_info.html?orderid='+id+"&page=0&shinfo=1";
	$('#changeTab').load(url);
}


/**
 *  付款审核详情
 * @param {Object} id
 */
function GetShOrderInfo(id){
	var url=$.path + '/order/order_info.html?orderid='+id+"&page=1&shinfo=0";
	$('#changeTab').load(url);
}



function GetShOrderInfoSh(id){
	var url=$.path + '/order/order_info.html?orderid='+id+"&page=1&shinfo=1";
	$('#changeTab').load(url);
}

function GetOrderInfoPj(id){
	var url=$.path + '/order/order_pj.html?orderid='+id+"&page=0";
	$('#changeTab').load(url);
	
}

function goback(page){
	//var page=$('#page').val();
	var url=$.path + '/order/orders.html?back=1&page='+page;
	$('#changeTab').load(url);
}




