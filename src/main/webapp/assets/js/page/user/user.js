function UpdateUserState(id, state) {
	var params = {
		"userid": id,
		"state": state

	}
	var msgtype = "";
	if (state == 0) {
		msgtype = "冻结"
	} else {
		msgtype = "解冻"
	}
	myConfirm("确定要" + msgtype + "该用户吗?", function() {
		$.ajax({
			url: $.path + '/user/update_user_state.html', // 方法名 delete
			data: params,
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {

					//jump(3);
					$('#sample_1').dataTable().fnDraw();
					myAlert(msgtype + "成功");
				} else {
					myAlert(msgtype + "失败");
					//jump(1);

				}
			},
		});
	});
}

function UpdateUserVerifyState(id, state) {
	var params = {
		"userid": id,
		"state": state
	}
	myConfirm("确定要验证该用户吗?", function() {
		$.ajax({
			url: $.path + '/user/update_user_verify_state.html', // 方法名 delete
			data: params,
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {

					//jump(3);
					$('#sample_1').dataTable().fnDraw();
					myAlert("操作成功");
				} else {
					myAlert("操作失败");
					//jump(1);

				}
			},
		});
	});
}

function UpdateUserBz() {
	$.ajax({
		url: $.path + '/user/update_user_bz.html', // 方法名 delete
		data: $("#form_update_userbz").serialize(),
		dataType: "json",
		type: "POST",
		cache: false,
		success: function(data) {
			if (data.result) {

				//jump(3);
				myAlertClose();
				myAlert("操作成功");
			} else {
				myAlertClose();
				myAlert("操作失败");
				//jump(1);

			}
		},
	});
}


function UpdateUserType() {
	$.ajax({
		url: $.path + '/user/update_user_type.html', // 方法名 delete
		data: $("#form_update_usertype").serialize(),
		dataType: "json",
		type: "POST",
		cache: false,
		success: function(data) {
			if (data.result) {

				//jump(3);
				$('#sample_1').dataTable().fnDraw();
				//myAlertClose();
				myAlert("操作成功");
			} else {
				myAlertClose();
				myAlert("操作失败");
				//jump(1);

			}
		},
	});
}

function ShowUpdateUserBz(id) {
	$.ajax({
		url: $.path + '/user/get_user_bz.html', // 方法名 delete
		data: {
			userid: id
		},
		dataType: "json",
		type: "POST",
		cache: false,
		success: function(data) {
			if (data.result) {
				$("#myModal_updateuser #myModalLabel3").html("修改用户备注信息");
				var ms = '<form id="form_update_userbz">' + '<textarea rows="5" id="userbz" name="userbz" style="width:100%" placeholder="修改用户备注">'+data.data+'</textarea>' + '<input type="hidden" id="userid" name="userid" value="' + id + '">' + '</form>';
				$("#myModal_updateuser #btn_submit").bind("click", UpdateUserBz);
				$("#myModal_updateuser .modal-body #myConfirmInfo").html(ms);
				$('#myModal_updateuser').modal('show');
			} else {
				myAlert("获取用户备注信息失败！");

			}
		},
	});

}


function ShowUpdateUserType(id) {
	
		
      	$.ajax({
		url: $.path + '/user/get_user_type.html', // 方法名 delete
		data: {
			userid: id
		},
		dataType: "json",
		type: "POST",
		cache: false,
		success: function(data) {
			if (data.result) {
				var ms ='<form id="form_update_usertype">';
				ms+='<input type="hidden" id="userid" name="userid" value="'+id+'">'
				ms+='<select name="usertype" id="usertype" class="form-control combox">';
				for(var i=0;i<data.data.types.length;i++){
					if(data.data.types[i].id==data.data.usertype){
						ms+='<option value="'+data.data.types[i].id+'"  selected="selected">'+data.data.types[i].typename+'</option>';
					}else{
						ms+='<option value="'+data.data.types[i].id+'" >'+data.data.types[i].typename+'</option>';
					}
				}
      			ms+='</select>';
      			ms+='</form>';
				
				$("#myModal_updateuser #myModalLabel3").html("修改用户类型信息");
				$("#myModal_updateuser #btn_submit").bind("click", UpdateUserType);
				$("#myModal_updateuser .modal-body #myConfirmInfo").html(ms);
				$('#myModal_updateuser').modal('show');
			} else {
				myAlert("获取用户备注信息失败！");

			}
		}
	});

}

function GetUserInfo(id){
	var url=$.path + '/user/get_userinfo.html?userid='+id;
	$('#changeTab').load(url);
}
