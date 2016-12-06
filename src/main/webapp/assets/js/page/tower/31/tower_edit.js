//验证
var validateTower = function () {
	var saveSubmit = function() {
		$('#saveForm').validate({
	            errorElement: 'span', //   help-block-error  default input error message container
	            errorClass: 'help-block', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	            	towername: {
	                    required: true
	                },
	                towerdistrict: {
	                    required: true,
	                    min: "1"
	                },
	                towerarea:{
	                	required: true,
	                	min: "1"
	                },
	                toweraddress: {
	                	required: true
	                },
	                towerfee:{
	                	required: true,
	                	number:true
	                },
	                towerrentfee:{
	                	required: true,
	                	number:true
	                },
	              
	               towerj:{
	               		required: true,
	                	number:true
	                },
	                towerw:{
	                	required: true,
	                	number:true
	                },
	                towerfirstj:{
	                	number:true
	                },
	                towerfirstw:{
	                	number:true
	                },
	                towersecondj:{
	                	number:true
	                },
	                towersecondw:{
	                	number:true
	                },
	                towermanagername:{
	                	required: true
	                },
	                towermanager:{
	                	required : true,
            			minlength : 11,	
            			maxlength:11
	                },
	                towerlarge:{
	                	required: true,
	                	number:true
	                }
	                
	               
	            },
	            messages: {
	            	towername: {
	                    required: "站址名称不能为空"
	                },
	                towerdistrict: {
	                    required: "站址区域不能为空"
	                },
	                towerarea:{
	                	required: "站址区域不能为空",
	                	numdTRUE:"站址区域选择错误"
	                },
	                toweraddress: {
	                	 required: "站址详细地址不能为空"
	                },
	                 towerfee:{
	                	required: "目标谈址费不能为空",
	                	number:"目标谈址费格式错误"
	                },
	                towerrentfee:{
	                	required: "目标租赁费不能为空",
	                	number:"目标租赁费格式错误"
	                },
	              
	               towerj:{
	               		required: "主经度不能为空",
	                	number:"精度格式错误"
	                },
	                towerw:{
	                	required: "主纬度不能为空",
	                	number:"纬度格式错误"
	                },
	                towerfirstj:{
	                	number:"精度格式错误"
	                },
	                towerfirstw:{
	                	number:"纬度格式错误"
	                },
	                towersecondj:{
	                	number:"精度格式错误"
	                },
	                towersecondw:{
	                	number:"纬度格式错误"
	                },
	                towermanagername:{
	                	required: "管理员不能为空"
	                },
	                towermanager:{
	                	required : "管理员联系方式不能为空",
            			minlength : "管理员联系方式格式错误",	
            			maxlength: "管理员联系方式格式错误"
	                },
	                towerlarge:{
	                	required: "租用面积不能为空",
	                	number:"租用面积格斯错误"
	                }
	            },
	          
	            highlight: function (element) { // hightlight error inputs
	                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
	            },
	            success: function (label) {
	                label.closest('.form-group').removeClass('has-error');
	                label.remove();
	            },
	            submitHandler: function (form) {
	            	var visible=0;
	            	if($("#id").val()==0){
	            		visible=2;
	            		$("#towervisible").val(visible);
	            	}else{
	            		visible=$("#towervisible").val();
	            	}
	            	
	            	save_tower('/tower/towers.html');
	            }
	        });
	}

    return {
        init: function () {
        	saveSubmit();
        	
        }
    };
}();

$(function() {
	validateTower.init();
});