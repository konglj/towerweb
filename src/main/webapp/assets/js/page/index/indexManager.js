//退出
function quit(){
	$.ajax({
		url :$.path + "/loginout.html",
		type : "Post",
		dataType : "json",
		cache : false,
		async:false,
		success : function(data) {
			window.location.href=$.path + "/login.html";
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
function changeTab(url,menuId,parentname,menuName){
	
	var ul=$(".breadcrumb");
	ul.not(":first").remove();
	$(".breadcrumb li:gt(0)").remove();
	if(parentname==''){
		 ul.append("<li ><a href='javascript:;' onclick=changeTopTab(\'" + url +"'+);>" + menuName+ "</a></li>");
	}else{
		 ul.append("<li ><a href='javascript:;'>" + parentname+ "</a><i class='icon-angle-right'></i></li>");
		 ul.append("<li ><a href='javascript:;' onclick=changeTopTab(\'" + url +"');>" + menuName+ "</a></li>");
		
	}
	$("#changeTab").load(url);
	
	
}

//导航菜单链接
function changeTopTab(url){
	if(url!== null && ''!=url){
		$("#changeTab").load(url);
	}
}

//加载二级菜单 
function GetSubMenu(parentname,data, li) {
    li = $(li).append("<ul class='sub-menu'></ul>");
    for (var i = 0; i < data.length; i++) {
        $(li).find(".sub-menu").append("<li><a href='javascript:;' onclick=changeTab(\'" + data[i].menuurl + "','"+data[i].id+"','"+parentname+"','"+data[i].menuname+"');><i class=" +data[i].icon+"></i>"+ data[i].menuname + "</a></li>");
    }
    return li;
}
//加载左侧菜单栏
function InitLoadMenu(){
	$.ajax({
		url : "./menu/menus.html",
		type : "Post",
		data : {},
		dataType : "json",
		cache : false,
		success : function(data) {
			
			if (!data.result) {
				alert(data.data);
			} else {
				 var li;
				 data = data.data;
	             var ul = $(".page-sidebar-menu");
	                for (var i = 0; i < data.length; i++) {
	        
	                        if (data[i].childmenus != null && !jQuery.isEmptyObject(data[i].childmenus)) {
	                        	li = "<li class="+"menu"+i+" ><a href='javascript:;'> <i class="+data[i].icon+"></i><span class='title'>" + data[i].menuname + "</span><span class='arrow '></span></a></li>";
	                            li = GetSubMenu(data[i].menuname,data[i].childmenus, li);
	                        }else{
	                        	li = "<li class="+"menu"+i+" ><a  href='javascript:;' onclick=changeTab(\'" + data[i].menuurl + "','"+data[i].id+"','"+"''','"+data[i].menuname+"');><i class="+data[i].icon+"></i><span class='title'>" + data[i].menuname + "</a></li>";
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
			  
			 $(".sub-menu li").bind("click", function() {
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


//修改用户
var updateUser = function () {

	var userHandleSubmit = function() {
		$('#updateUser').validate({
	            errorElement: 'span', //   help-block-error  default input error message container
	            errorClass: 'help-block', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	            	adminname:{
	            		required: true
	            	},
	            	adminphone: {
	                    required: true,
	                    minlength : 11,
	                    maxlength:11,
	                    digits:true
	                }
	            },
	            messages: {
	            	adminname:{
	            		required: "请输入真实姓名"
	            	},
	            	adminphone: {
	                    required: "请输入手机号",
	                    minlength:"请正确输入手机号",
	                    maxlength:"请正确输入手机号",
	                    digits:"请正确输入手机号"
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
	            	
	            }
	        });
	}
    return {
        init: function () {
        	userHandleSubmit();
        }
    };
}();

function updatePassword(){
    var userpassword = $("#passWord").val();
    alert(userpassword);
    if($("#passWord").parent().hasClass("has-error")){
		 return false;
	} if($("#passWordBef").parent().hasClass("has-error")){
		 return false;
	}
    	$.ajax({
    		url : $.path + "/updatePass.html",
    		type : "Post",
    		data : {
    			"password" : userpassword,
    		},
    		dataType : "json",
    		cache : false,
    		success : function(data) {
    			if (data.result) {
    				
    				$('#updatePass').modal('hide');
    				myAlert("修改成功!");
    				jump(1);
    			} else {
    				myAlert("修改失败!");
    			
    			}
    			
    			
    		},
    		error : function(textStatus, errorThrown) {
    			alert(ajaxError);
    		}
    	});
}

function updateSysUser(){
	$.ajax({
    		url : $.path + "/updateSysUser.html",
    		type : "Post",
    		data : {
    			"adminname" :$("#adminname").val(),
    			"adminphone" :$("#adminphone").val()
    			
    		},
    		dataType : "json",
    		cache : false,
    		success : function(data) {
    			if (data.result) {
    				
    				$('#updateUser').modal('hide');
    				myAlert("修改成功!");
    				jump(1);
    			} else {
    				myAlert("修改失败!");
    			
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
	//InitUser();
	$.ajax({
		url : $.path + "/check_old_password.html",
		type : "Post",
		data : {
			"password" : $("#passWordBef").val(),
		},
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data.result) {
				$("#passWordBef").parent().removeClass("has-error");
				$("#passWordBef").siblings("span").text("");
				$(".blocks").hide();
			} else {
					$("#passWordBef").parent().addClass("has-error");
					$("#passWordBef").siblings("span").text("请输入正确的原始密码");
					$(".blocks").show();
					return false;
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
	InitLoadMenu();
	//初始化左侧菜单栏
	updatePass.init();
	updateUser.init();
	//初始化首页
	$('#changeTab').load('index_content.html');
});