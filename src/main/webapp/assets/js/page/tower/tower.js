

function GetTowerInfo(id,towervisible){
	var url=$.path + '/tower/towerinfo.html?towerid='+id+'&towervisible='+towervisible;
	$('#changeTab').load(url);
	
}

function GetTowerEdit(id,towervisible){
	var url=$.path + '/tower/toweredit.html?id='+id+'&towervisible='+towervisible;
	$('#changeTab').load(url);
	
}

function GetUpateTowerInfoyes(id){
	GetTowerEdit(id,1)
}
function GetUpateTowerInfoNo(id){
	GetTowerEdit(id,0)
}

function GetUpateTowerInfoPool(id){
	GetTowerEdit(id,2)
}


function GetTowerYesInfo(id){
	GetTowerInfo(id,1);
}
function goback(){
	var towervisible=$('#towervisible').val();
	var url=$.path + '/tower/towers.html?back=1&towervisible='+towervisible;
	$('#changeTab').load(url);
}
function updateTowerVisible(state) {
	var ids = '';
	$(".checkboxes").each(function() {
		var checked = jQuery(this).is(":checked");
		if (checked) {
			ids += $(this).val() + ",";
		}
	});
	
	if ("" == ids) {
		myAlert("您还未选择站址！");
		return;
	}
	var params = {
		"towerids": ids,
		 "state":state
	};
	myConfirm("确定要操作选中的站址吗？", function() {
		$.ajax({
			url: $.path + '/tower/updatevisible.html', // 方法名 delete
			data: params,
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {
					myAlert("操作成功");
					jump(3);
					$('#sample_1').dataTable().fnDraw();
				} else {
					myAlert(data.data);
					jump(3);

				}
			},
		});
	});
}

function delTower(del){
	
	var ids = '';
	$(".checkboxes").each(function() {
		var checked = jQuery(this).is(":checked");
		if (checked) {
			ids += $(this).val() + ",";
		}
	});
	
	if ("" == ids) {
		myAlert("您还未选择站址！");
		return;
	}
	var params = {
		"towerids": ids
	};
	myConfirm("确定要删除选中的站址吗？", function() {
		$.ajax({
			url: $.path + '/tower/deltower.html', // 方法名 delete
			data: params,
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {
					myAlert(data.data);
					$('#sample_1').dataTable().afnDraw();
					jump(3);
				} else {
					myAlert(data.data);
					jump(3);

				}
			},
		});
	});
	
}

function save_tower(url){
	var visible=$("#towervisible").val();
	$.ajax({
			url: $.path + '/tower/savetower.html', // 方法名 delete
			data: $("#saveForm").serialize(),
			dataType: "json",
			type: "POST",
			cache: false,
			success: function(data) {
				if (data.result) {
					myAlert("操作成功");
					jump(3);
					$('#changeTab').load($.path +url+'?towervisible='+visible);
				} else {
					myAlert(data.data);
					jump(3);

				}
			},
		});
}
