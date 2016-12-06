function UpdateOrderShjj(){
	var shinfo=$("#shinfo").val();
	var towerstate=$("#towerstate").val();
	var id=$("#id").val();
	alert(towerstate);
	if(shinfo==''){
		myAlert("请填写审核原因");
		return;
	}
	var paramer={
		shresult:0,
		shinfo:'',
		id:id,
		towerstate:towerstate
	}
	myConfirm("确定要审核拒绝该订单吗?", function() {
		$.ajax({
			url: $.path + '/order/update_order_shjj.html', // 方法名 delete
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
				}
			}
		});
	});
}
/**
 * 用于提交租赁合同
 */
function order_tj_rentht(){
	var towerpowerprice=$("#towerpowerprice").val();
	if(towerpowerprice==''){
		myAlert('请输入电费单价！');
		return;
	}
		
	var towerpowert=$("#towerpowert").val();
	if(towerpowert==''){
		myAlert('请输入贴电费！');
		return;
	}
	var towerfactrentfee=$("#towerfactrentfee").val();
	if(towerfactrentfee==''){
		myAlert('请输入实际租金！');
		return;
	}
	var towerfactaddress=$("#towerfactaddress").val();
	if(towerfactaddress==''){
		myAlert('请输入实际建站地址！');
		return;
	}
	var toweryzname=$("#toweryzname").val();
	if(toweryzname==''){
		myAlert('请输入业主姓名！');
		return;
	}
	var toweryzphone=$("#toweryzphone").val();
	if(toweryzphone==''){
		myAlert('请输入业主联系方式！');
		return;
	}
	
	var ischeckht=$("#ischeckht").val();
	if(ischeckht==1){
		 var renthtid=$("#renthtid").val();
		 alert(renthtid);
		 if(renthtid==undefined||renthtid==''){
			myAlert('请填写租赁合同编号！');
			return;
		}
		 if(renthtid.length<=1&&renthtid!=''){
			 myAlert('请正确填写租赁合同编号！');
				return;
			}
		
		
	}else if(ischeckht==2){
		 var rentht=$('#demo-files img').attr("src");
		 if(rentht==undefined||rentht==''){
			myAlert('请上传租赁合同文件！');
			return;
		}
	}
	$("#f_id").val($("#id").val());
	$("#f_towerstate").val($("#towerstate").val());
	
	
	myConfirm("确定要提交租赁合同吗?", function() {
		$.ajax({
			url: $.path + '/order/31/update_rentht.html', // 方法名 delete
			data: $("#form_sh").serialize(),
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
 * 用于提交租赁合同
 */
function order_sc_threeht(){
	var towerfactfee=$("#towerfactfee").val();
	if(towerfactfee==''||towerfactfee<=0){
		myAlert('请输入实际谈址佣金！');
		return;
	}
	$("#f_id").val($("#id").val());
	$("#f_towerstate").val($("#towerstate").val());
	
	
	myConfirm("确定要生成三方合同吗?", function() {
		$.ajax({
			url: $.path + '/order/31/update_threeht.html', // 方法名 delete
			data: $("#form_sh").serialize(),
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
 * 用于审核三方合同
 */
function order_sh_threeht(shresult,ts){
	
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
			url: $.path + '/order/31/update_sh_threeht.html', // 方法名 delete
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
 * 用于提交租赁合同
 */
function order_fee_apply(){
	/*
	if($("#dxfwxyfile").val()==""){
		alert("请上传单项服务协议");
		return;
	}
	*/
	if($("#towerprojectno").val()==""){
		myAlert("请填写项目编号");
		return;
	}
	if($("#towerprojectname").val()==""){
		myAlert("请填写项目编号");
		return;
	}
	
	$("#f_id").val($("#id").val());
	$("#f_towerstate").val($("#towerstate").val());
	
	
	myConfirm("确定要提交单项服务协议吗?", function() {
		$.ajax({
			url: $.path + '/order/31/update_fee_apply.html', // 方法名 delete
			data: $("#form_sh").serialize(),
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
 * 用于审核三方合同
 */
function order_sh_fee(shresult,ts){
	
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
			url: $.path + '/order/31/update_sh_fee.html', // 方法名 delete
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

function rent_ht_display(){
	
	if ($("#ischeckht").val()==0) { 
		$("#renthtid").val("");
		$("#tr_htid").attr("hidden","hidden");
		$("#tr_htimg").attr("hidden","hidden");
		 $('#demo-files').empty();
	} else if($("#ischeckht").val()==1){
		 $('#demo-files').empty();
		 $("#tr_htid").removeAttr("hidden");
		$("#tr_htimg").attr("hidden","hidden");
	} else{
		$("#renthtid").val("");
		$("#tr_htimg").removeAttr("hidden");
		$("#tr_htid").attr("hidden","hidden");
	}
}
