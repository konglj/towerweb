//退出
function quit(){
	$.ajax({
		url :$.path + "/yun_user/yun_user_loginOut.action",
		type : "Post",
		dataType : "json",
		cache : false,
		async:false,
		success : function(data) {
			window.location.href="/Credit/plat/login.html";
		}
	});
}
//初始化登录用户信息
function InitUser(callback){
	$.ajax({
		url : $.path + "/yun_user/yun_user_sessionUser.action",
		type : "Post",
		data : {},
		dataType : "json",
		cache : false,
		success : function(data) {
			
			if (data.result.error) {
				myWarning("当前登录用户已失效，请重新登录1");
				jumps(1);
			} else {
				   var userinfo = data.result.data;
				   $("#myloginname").text(userinfo.loginName);
				   $("#roleId").val(userinfo.roleId);
				   $("#userId").val(userinfo.id);
				   if(null==$("#myloginname").text() || ''==$("#myloginname").text() ){
					   myWarning("当前登录用户已失效，请重新登录2");
					   jumps(1);
				   }
			}
		},
		error : function(textStatus, errorThrown) {
			 myWarning("当前登录用户已失效，请重新登录3");
			   jumps(1);
		},
        complete: function () {
        	
           if (callback && callback instanceof Function) {
                callback();
            }
        }
	});
	
}

function jumps(count) { 
    window.setTimeout(function(){ 
        count--; 
        if(count > 0) { 
            jumps(count); 
        } else { 
            location.href="login.html"; 
        } 
    }, 1000); 
} 
//二级菜单响应页面
function changeTab(url,menuId,menuName){
	
	var ul=$(".breadcrumb");
	ul.not(":first").remove();
	$(".breadcrumb li:gt(0)").remove();
	$.ajax({
		url :  $.path + "/yun_menu/yun_menu_makeTitle.action",
		type : "Post",
		data : {"yunResource.id":menuId},
		dataType : "json",
		cache : false,
		success : function(data) {
			
			if (data.result.error) {
			} else {
				   var list = data.result.data;
				   for (var i = 0; i < list.length; i++) {
					   if(i == list.length-1){
						   ul.append("<li ><a href='javascript:;' onclick=changeTab(\'" + list[i].url +"');>" + list[i].resName + "</a></li>");

					   }else{
						   
						   ul.append("<li ><a href='javascript:;'>" + list[i].resName + "</a><i class='icon-angle-right'></i></li>");
					   }
				    }
				  
			}
		},
		error : function(textStatus, errorThrown) {
			alert(ajaxError);
		},
		complete:function(a,b,c){
			$("#changeTab").load(url);
		}
		
	});
	
}

//导航菜单链接
function changeTopTab(url){
	if(url!== null && ''!=url){
		$("#changeTab").load(url);
	}
}

//加载二级菜单 
function GetSubMenu(data, li) {
    li = $(li).append("<ul class='sub-menu'></ul>");
    for (var i = 0; i < data.length; i++) {
        $(li).find(".sub-menu").append("<li><a href='javascript:;' onclick=changeTab(\'" + data[i].url + "','"+data[i].id+"','"+data[i].resName+"');><i class=" +data[i].resIcon+"></i>"+ data[i].resName + "</a></li>");
    }
    return li;
}
//加载左侧菜单栏
function InitLoadMenu(){
	var id=$("#userId").val();
	var roleId=$("#roleId").val();
	$.ajax({
		url : $.path + "/yun_menu/yun_menu_navMenuList.action",
		type : "Post",
		data : {"yunResource.parentId" : "-1","yunResource.roleId" : roleId},
		dataType : "json",
		cache : false,
		success : function(data) {
			
			if (data.result.error) {
				alert(data.result.errorMessage);
			} else {
				 var li;
				 data = data.result.data;
	             var ul = $(".page-sidebar-menu");
	                for (var i = 0; i < data.length; i++) {
	        
	                        if (data[i].submenu != null && !jQuery.isEmptyObject(data[i].submenu)) {
	                        	li = "<li class="+"menu"+i+" ><a href='javascript:;'> <i class="+data[i].resIcon+"></i><span class='title'>" + data[i].resName + "</span><span class='arrow '></span></a></li>";
	                            li = GetSubMenu(data[i].submenu, li);
	                        }else{
	                        	li = "<li class="+"menu"+i+" ><a  href='javascript:;' onclick=changeTab(\'" + data[i].url + "','"+data[i].id+"','"+data[i].resName+"');><i class="+data[i].resIcon+"></i><span class='title'>" + data[i].resName + "</a></li>";
	                        }
	                        ul.append(li);
	                }
			}
		},
		error : function(textStatus, errorThrown) {
			alert(ajaxError);
		},complete:function(a,b,c){
			  $(".page-sidebar-menu li").bind("click", function() {
					 $('.page-sidebar-menu li ').removeClass('menuactive');
				     $(this).addClass('menuactive');
				});
			  
			 $(" .sub-menu li").bind("click", function() {
					 $(' .sub-menu li').removeClass('active');
				     $(this).addClass('active');
				});
		}
	});
}

//修改密码

var updatePass = function () {

	var handleSubmit = function() {
		$('#userPass').validate({
	            errorElement: 'span', //   help-block-error  default input error message container
	            errorClass: 'help-block', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	            	passWordBef:{
	            		required: true
	            	},
	            	passWord: {
	                    required: true,
	                    passTRUE: true
	                },
	                rpassWord: {
	                	required: true,
	                    equalTo: "#passWord"
	                }
	            },
	            messages: {
	            	passWordBef:{
	            		required: "原始密码不能为空"
	            	},
	            	passWord: {
	                    required: "密码不能为空",
	                    passTRUE:"6-12位数字加英文字母"
	                },
	                rpassWord: {
	                	required: "确认密码不能为空",
	                    equalTo: "前后密码不一致"
	                }
	            },
	           
	            highlight: function (element) { // hightlight error inputs
	                $(element) .closest('.form-group').addClass('has-error'); // set error class to the control group
	            },
	            success: function (label) {
	                label.closest('.form-group').removeClass('has-error');
	                label.remove();
	            },
	            submitHandler: function (form) {
	            	updatePassword();
	            }
	        });
	}
    return {
        init: function () {
        	handleSubmit();
        }
    };
}();

function updatePassword(){
    var userpassword = $("#passWord").val();
    if($("#passWord").parent().hasClass("has-error")){
		 return false;
	} if($("#passWordBef").parent().hasClass("has-error")){
		 return false;
	}
    	$.ajax({
    		url : $.path + "/yun_user/yun_user_updatePass.action",
    		type : "Post",
    		data : {
    			"userinfo.id" : $("#userId").val(),
    			"userinfo.passWord" : userpassword,
    		},
    		dataType : "json",
    		cache : false,
    		success : function(data) {
    			if (data.result.error) {
    				alert(data.result.errorMessage);
    			} else {
    				$('#updatePass').modal('hide');
    				myAlert("修改成功!");
    				jump(1);
    			}
    		},
    		error : function(textStatus, errorThrown) {
    			alert(ajaxError);
    		}
    	});
}

function indexTab(){
	   $('.page-sidebar-menu li ').removeClass('menuactive');
	   $(' .sub-menu li').removeClass('active');
	   $(".sub-menu").hide();
	   $('.page-sidebar-menu li> a > span.arrow ').removeClass('open');
	$('.start').addClass('menuactive');
	$('#changeTab').load('indexLoad.html');
	$('.breadcrumb').html("<li><a href='javascript:;' onclick='indexTab();'>首页</a></li>");
}

function checkPaBe(){
	$("#passWordBef").parent().removeClass("has-error");
	if($("#passWordBef").val()=='' || $("#passWordBef").val()==null){
		$("#passWordBef").parent().addClass("has-error");
		$("#passWordBef").siblings("span").text("原始密码不能为空");
		return false;
	}
	InitUser();
	$.ajax({
		url : $.path + "/yun_user/yun_user_checkPassBe.action",
		type : "Post",
		data : {
			"userinfo.passWord" : $("#passWordBef").val(),
		},
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data.result.error) {
				alert(data.result.errorMessage);
			} else {
				var data=data.result.data;
				if(data==false){
					$("#passWordBef").parent().addClass("has-error");
					$("#passWordBef").siblings("span").text("请输入正确的原始密码");
					$(".blocks").show();
					return false;
				}
			}
		},
		error : function(textStatus, errorThrown) {
			alert(ajaxError);
		}
	});
}

$(function() {
	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	//初始化用户信息
	//InitUser(InitLoadMenu);
	//初始化左侧菜单栏
	//updatePass.init();
	//初始化首页
	$('#changeTab').load('index_content.html');
});