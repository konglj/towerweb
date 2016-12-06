// 条件搜索列表刷新
function searchSubmit() {
	$("#searchBtn").bind("click", function() {
		$('#sample_1').dataTable().fnDraw(true);
	});
}

// 加载dataTableList
var TableEditable = function() {
	return {
		init: function() {
			$('#sample_1')
				.dataTable({
					"lengthMenu": 
						[10, 20, 50],
				 	"oLanguage": {//语言设置
			  		"sLengthMenu": "每页显示  _MENU_ 条记录",  
			  		"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
			  		"oPaginate": {
				  		"sFirst": "首页",
				  		"sPrevious": "前一页",
				  		"sNext": "后一页",
				  		"sLast": "尾页"
				  	},
			  		"sZeroRecords": "抱歉， 没有匹配数据",
			  		"sInfoEmpty": "没有数据"
					},
	 				"bProcessing": true, //当datatable获取数据时候是否显示正在处理提示信息。
					"serverSide": true,
					"bFilter": false, // 搜索栏不显示
					"ordering":false,//是否启用排序
					"sScrollX": "100%",   //表格的宽度
// 					"sScrollXInner": "110%",   //表格的内容宽度
 					//"bScrollCollapse": true,  //当显示的数据不足以支撑表格的默认的高度时，依然显示纵向的滚动条。(默认是false) 
					
					"fnServerData": function getData(sSource,
						aDataSet, fnCallback) {
						aDataSet.push(
							{
								name: "parameter.username",
								value: $("#username").val()
							},
							{
								name: "parameter.userdistrict",
								value: $("#userdistrict").val()
							},
							{
								name: "parameter.userlevel",
								value: $("#userlevel").val()
							},
							{
								name: "parameter.userverifystate",
								value: $("#userverifystate").val()
							},
							{
								name: "parameter.userstate",
								value: $("#userstate").val()
							},
							{
								name: "parameter.usertype",
								value: $("#usertype").val()
							},
							
							{
								name: "parameter.fromdate",
								value: $("#fromdate").val()
							},
							{
								name: "parameter.todate",
								value: $("#todate").val()
							}
							
						
						);
						
						$.ajax({
							type: "POST",
							url: sSource,
							dataType: 'json',
							data: aDataSet,
							success: function(data) {
								fnCallback(data.data);
							}
						});
					},

					"sAjaxSource": $.path +"/user/get_users.html", // 方法名 selectAll
					"columns": [
					     /*
					      {
							'sTitle': '<input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" />',
							'bSortable': false,
							"data": null
						}, 
						*/
						
						/* 需要显示在列表页的列  需要自行调配*/
						
						{
							"sTitle": "姓名",
							"data": "username"
						},
						{
							"sTitle": "手机号",
							"data": "usertele"
						},
						{
							"sTitle": "单位",
							"data": "usercompany"
							
						},
						{
							"sTitle": "区域",
							"data": "districtname"
						},
						{
							"sTitle": "级别",
							"data": "levelname"
						},
						{
							"sTitle": "类型",
							"data": "typename"
						},
						{
							"sTitle": "行业",
							"data": "userbusinessname"
						},
						{
							"sTitle": "状态",
							"data": "statename"
						},		
						{	
							"sTitle": "中标类型",
							"data": "userwintype"
						},											
						{
							"sTitle": "注册",
							"data": "addtime"
						},						
						{
							"sTitle": "操作",
							"data": null
							
						}

					],
				
					drawCallback: function() {
						$("input[type='checkbox']").uniform();
					},
					initComplete: function() {
						checkboxall("group-checkable","sample_1");
						
					},  
					fnDrawCallback: function (oSettings) {
						//alert("ddddd");
					},
					columnDefs: [
						
						{
							targets: 10,
							render: function(a, b, c, d) {
								var id = c.id;
								var userstate=c.userstate;
								var userverifystate=c.userverifystate;
								var res='<span> <a   onclick=check_auth('+id+',"A1",GetUserInfo)><span class="glyphicon glyphicon-search"  title="查看" ></span> </a>';
								if(userstate==0){
									 res+='<span> <a   onclick=check_auth_arg('+id+',1,"user_update_state",UpdateUserState)><span class="glyphicon glyphicon-circle-arrow-up"  title="解冻" ></span> </a>';
								}else{
									 res+='<span> <a   onclick=check_auth_arg('+id+',0,"user_update_state",UpdateUserState)><span class="glyphicon glyphicon-circle-arrow-down"  title="冻结" ></span> </a>';
								}
								if(userverifystate==0){
									 res+='<span> <a   onclick=check_auth_arg('+id+',1,"user_update_verify_state",UpdateUserVerifyState)><span class="glyphicon glyphicon-thumbs-up"  title="验证" ></span> </a>';
								}else{
									res+='<a><span   title="&nbsp;已验证" >--</span> </a>'
								}
								res+='<a  onclick=check_auth('+id+',"user_update_state",ShowUpdateUserType)><span class="glyphicon glyphicon-user"  title="修改用户类型" ></span> </a>';
								
								res+='<a  onclick=check_auth('+id+',"user_update_bz",ShowUpdateUserBz)><span class="glyphicon glyphicon-pencil"  title="修改备注" ></span> </a>';
								
								return res;
								
								
							}
						}


					],


				});
			}
	};
}();

$(function() {
	TableEditable.init();
	searchSubmit();
});