
function goback(){
	var url=$.path + '/order/orders.html?back=1&page='+$("#page").val();
	$('#changeTab').load(url);
}

/**
 * 用于目标建站地址审核
 */
function order_sh_address(shresult,ts){
	var shinfo=$("#shinfo").val();
	
	if(shresult==0&&shinfo==''){
		myAlert("请填写审核原因");
		return;
	}
	var id=$("#id").val();
	var towerstate=$("#towerstate").val();
	var paramer={
		shresult:shresult,
		shinfo:shinfo,
		id:id,
		towerstate:towerstate
		
	}
	$("#shresult").val(shresult);
	myConfirm("确定要"+ts+"该订单吗?", function() {
		$.ajax({
			url: $.path + '/order/sh_order_targetaddress.html', // 方法名 delete
			data: paramer,
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				
				if (data.result) {
					//jump(3);
					myAlert(data.data,function(){
							goback();
					});
				
				} else {
					myAlert(data.data);
					//jump(1);

				}
			},
		});
	});
}

function order_sh(){
	var shinfo=$("#shinfo").val();
	
	if(shinfo==''){
		myAlert("请填写审核原因");
		return;
	}
	var id=$("#id").val();
	var towerstate=$("#towerstate").val();
	var paramer={
		shresult:0,
		shinfo:shinfo,
		id:id,
		towerstate:towerstate
	}
	myConfirm("确定要审核拒绝该订单吗?", function() {
		$.ajax({
			url: $.path + '/order/order_sh.html', // 方法名 delete
			data: paramer,
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {
					//jump(3);
					myAlert(data.data,function(){
							goback();
					});
				
				} else {
					myAlert(data.data);
					//jump(1);

				}
			},
		});
	});
}


function order_sh_delay(shresult,ts){
	var shinfo=$("#shinfo").val();
	if(shresult==0&&shinfo==''){
		myAlert("请填写审核原因");
		return;
	}
	
	var delayday=$("#delayday").val();
	if(shresult==1){
	if(delayday==''){
		myAlert("请输入延期天数");
		return;
	}
	var min=$("#yqminday").val();
	var max=$("#yqmaxday").val();
	if(Number(delayday)<Number(min)||Number(delayday)>Number(max)){
		myAlert("请正确输入延期天数");
		return;
	}
	}else{
		delayday=0;
	}

	var id=$("#id").val();
	var towerstate=$("#towerstate").val();
	
	var paramer={
		shresult:shresult,
		shinfo:shinfo,
		id:id,
		towerstate:towerstate,
		delayday:delayday
		
	};
	myConfirm("确定要"+ts+"该订单吗?", function() {
		$.ajax({
			url: $.path + '/order/sh_order_delay.html', // 方法名 delete
			data: paramer,
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {
					//jump(3);
					myAlert(data.data,function(){
							goback();
					});
			
				} else {
					myAlert(data.data);
					//jump(1);

				}
			},
		});
	});
}


function order_evaluate(){
	var shinfo=$("#shinfo").val();
	if(shinfo==''){
		myAlert("请填写评价内容");
		return;
	}

	var id=$("#id").val();
	var paramer={
		shinfo:shinfo,
		id:id
	};
	myConfirm("确定要评价该订单吗?", function() {
		$.ajax({
			url: $.path + '/order/order_evaluate.html', // 方法名 delete
			data: paramer,
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {
					//jump(3);
					myAlert(data.data,function(){
							goback();
					});
			
				} else {
					myAlert(data.data);
					//jump(1);

				}
			},
		});
	});
}

$(function() {
	var url=$("#loadurl").val();
	$('#changeorderinfo').html();
	$('#changeorderinfo').load($.path+url);
});
