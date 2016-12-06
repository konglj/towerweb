var province='37';

/**
 * 交单审核
 * @param {Object} shresult
 * @param {Object} ts
 */
function order_sh_jd(shresult,ts){
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
	myConfirm("确定要"+ts+"该订单吗?", function() {
		$.ajax({
			url: $.path + '/order/'+province+'/sh_order_jd.html', // 方法名 delete
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




/**
 *  用于付首款审核
 */
function order_tj_firstfee(){
	//firstfile
	var endfee=$("#endfee").val();
	if(Number(endfee)<=0||$("#firstfee").val()==""){
		myAlert("请输入正确的首付金额！");
		return;
	}
	var htno=$("#htno").val();
	if(htno==""){
		myAlert("请输入合同编号！");
		return;
	}
	
	//if($("#firstfile").val()==""){
	//	myAlert("请输入选择合同扫描件！");
	//	return;
	//}
	
	$("#f_id").val($("#id").val());
	$("#f_towerstate").val($("#towerstate").val());
	alert($("#f_towerstate").val());
	myConfirm("确定要提交预付款申请吗?", function() {
		$.ajax({
			url: $.path + '/order/'+province+'/update_firstfee_apply.html', // 方法名 delete
			data: $("#form_sh").serialize(),
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {
					//jump(3);
					myAlert('提交处理成功！',function(){
							goback();
					});
				
				} else {
					myAlert('提交处理失败！');
					//jump(1);

				}
			},
		});
	});
}


/**
 *  用于付首款审核
 */
function order_tj_endfee(){
	//firstfile
	
	//if($("#firstfile").val()==""){
	//	myAlert("请输入选择合同扫描件！");
	//	return;
	//}
	
	$("#f_id").val($("#id").val());
	$("#f_towerstate").val($("#towerstate").val());
	alert($("#f_towerstate").val());
	myConfirm("确定要提交预尾款申请吗?", function() {
		$.ajax({
			url: $.path + '/order/'+province+'/update_endfee_apply.html', // 方法名 delete
			data: $("#form_sh").serialize(),
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {
					//jump(3);
					myAlert('提交处理成功！',function(){
							goback();
					});
				
				} else {
					myAlert('提交处理失败！');
					//jump(1);

				}
			},
		});
	});
}

//付首款审核处理
function order_sh_firstfee(shresult,ts){
	
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
	myConfirm("确定要"+ts+"该申请吗?", function() {
		$.ajax({
			url: $.path + '/order/'+province+'/update_sh_firstfee.html', // 方法名 delete
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

//付首款审核处理
function order_end_fee(shresult,ts){
	
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
	myConfirm("确定要"+ts+"该申请吗?", function() {
		$.ajax({
			url: $.path + '/order/'+province+'/update_sh_endfee.html', // 方法名 delete
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

