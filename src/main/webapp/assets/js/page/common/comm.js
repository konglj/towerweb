$.path = "/towerweb";
//退出
function check_auth(paramer, authcode, callback) {
	$.ajax({
		url: $.path + "/auth/check_auth.html",
		type: "Post",
		dataType: "json",
		data: {
			authcode: authcode
		},
		cache: false,
		async: false,
		success: function(data) {
			if (!data.result) {
				myAlert('对不起，您没有操作权限！')
			} else {
				if (callback && callback instanceof Function) {
					callback(paramer);
				}
			}
		}
	});
}



function check_auth_arg(paramer,argument, authcode, callback) {
	$.ajax({
		url: $.path + "/auth/check_auth.html",
		type: "Post",
		dataType: "json",
		data: {
			authcode: authcode
		},
		cache: false,
		async: false,
		success: function(data) {
			if (!data.result) {
				myAlert('对不起，您没有操作权限！')
			} else {
				if (callback && callback instanceof Function) {
					callback(paramer,argument);
				}
			}
		}
	});
}

function check_auth_ordersh(paramer,state, authcode, callback) {
	$.ajax({
		url: $.path + "/auth/check_auth_order.html",
		type: "Post",
		dataType: "json",
		data: {
			towerstate: state,
		},
		cache: false,
		async: false,
		success: function(data) {
			if (!data.result) {
				myAlert('对不起，您没有操作权限！')
			} else {
				if (callback && callback instanceof Function) {
					callback(paramer,state);
				}
			}
		}
	});
}


function checkboxall(checkClass, tablename) {
	jQuery("." + checkClass).bind("click", function() {
		var set = jQuery(this).attr("data-set");
		var checked = jQuery(this).is(":checked");
		jQuery(set).each(function() {
			if (checked) {
				$(this).attr("checked", true);
				// $(this).parents('tr').addClass("active");
			} else {
				$(this).attr("checked", false);
				// $(this).parents('tr').removeClass("active");
			}
		});
		jQuery.uniform.update(set);
	});
	$('#' + tablename).on('change', 'tbody tr .checkboxes', function() {
		// $(this).parents('tr').toggleClass("active");
	});
}

function goback(url) {
	$('#changeTab').load(url);
}

function comm_get_areas(event,isall){
	$.ajax({
		url: $.path + "/area/get_areas.html",
		type: "Post",
		dataType: "json",
		data: {
			district: event.val(),
			isall:isall
		},
		cache: false,
		async: false,
		success: function(data) {
			if(data.result){
				var area=$("#"+event.attr("ref"));
				area.empty();
				$.each(data.data, function(i, item){  
					area.append("<option value='"+item.id+"'>"+item.areaname+"</option>"); 
				});  
			}
		}
	});
}


function comm_get_districts(event,isall){
	$.ajax({
		url: $.path + "/area/get_districts.html",
		type: "Post",
		dataType: "json",
		data: {
			city: event.val(),
			isall:isall
		},
		cache: false,
		async: false,
		success: function(data) {
			if(data.result){
				var area=$("#"+event.attr("ref"));
				area.empty();
				$.each(data.data, function(i, item){  
					area.append("<option value='"+item.disid+"'>"+item.disname+"</option>"); 
				});  
			}
		}
	});
}
