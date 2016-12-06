
function goback(){
	var page=$("#page").val();
	var url="";
	if(page==0){
	 url=$.path + '/money/tx_applys.html?back=1&page='+page;
		
	}else{
		 url=$.path + '/money/tx_dks.html?back=1&page='+page;
	}
	$('#changeTab').load(url);
}

function sh_money_apply(shresult,msg){
	var shinfo=$("#shinfo").val();
	if(shresult==0&&shinfo==''){
		myAlert("请填写审核原因");
		return;
	}
	var id=$("#id").val();
	var state=$("#state").val();
	var paramer={
		shresult:shresult,
		shinfo:shinfo,
		id:id,
		state:state
	}
	myConfirm("确定要"+msg+"该申请吗?", function() {
		$.ajax({
			url: $.path + '/money/sh_money_apply.html', // 方法名 delete
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


function sh_money_dk(shresult,msg){
	var shinfo=$("#shinfo").val();
	if(shresult==0&&shinfo==''){
		myAlert("请填写审核原因");
		return;
	}
	var id=$("#id").val();
	var state=$("#state").val();
	var paramer={
		shresult:shresult,
		shinfo:shinfo,
		id:id,
		state:state
	}
	myConfirm("确定要"+msg+"该打款吗?", function() {
		$.ajax({
			url: $.path + '/money/sh_money_dk.html', // 方法名 delete
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
	$('#changemoneyinfo').html();
	$('#changemoneyinfo').load($.path+url);
});