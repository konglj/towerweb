// 条件搜索列表刷新
function searchSubmit() {
	$("#searchBtn").bind("click", function() {
		$('#sample_1').dataTable().fnDraw(true);
	});
		$("#towercity").bind("change",function(){
		comm_get_districts($(this),1);
	});
	
	$("#usercity").bind("change",function(){
		comm_get_districts($(this),1);
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
 					"sScrollXInner": "110%",   //表格的内容宽度
 					//"bScrollCollapse": true,  //当显示的数据不足以支撑表格的默认的高度时，依然显示纵向的滚动条。(默认是false) 
					
					"fnServerData": function getData(sSource,
						aDataSet, fnCallback) {
						aDataSet.push(
							{
								name: "parameter.username",
								value: $("#username").val()
							},
							{
								name: "parameter.towerdistrict",
								value: $("#towerdistrict").val()
							},
							{
								name: "parameter.towercity",
								value: $("#towercity").val()
							},
							{
								name: "parameter.towername",
								value: $("#towername").val()
							},
							{
								name: "parameter.towerno",
								value: $("#towerno").val()
							},
							{
								name: "parameter.userdistrict",
								value: $("#userdistrict").val()
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

					"sAjaxSource": $.path +"/order/get_orders.html?page=1", // 方法名 selectAll
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
							"sTitle": "用户城市",
							"data": "usercityname"
						},
						{
							"sTitle": "用户区域",
							"data": "userdistrictname"
						},
						{
							"sTitle": "站址名称",
							"data": "towername"
						},
						{
							"sTitle": "站址编号",
							"data": "toweridefined"
						},
						{
							"sTitle": "站址城市",
							"data": "towercityname"
						},
						{
							"sTitle": "站址区域",
							"data": "towerdistrictname"
						},		
						{	
							"sTitle": "状态",
							"data": "orderstatename"
						},						
						{
							"sTitle": "谈址佣金（元）",
							"data": "towerfee"
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
								var towerstateeffect=c.towerstateeffect;
								var res='<a   onclick=check_auth('+id+',"A1",GetShOrderInfo)><span class="glyphicon glyphicon-search"  title="查看" ></span> </a>';
								
								if(towerstateeffect==1){
									res=res+ '&nbsp;&nbsp;&nbsp;&nbsp;' + 
								      '<a   onclick=check_auth('+id+',"A2",GetShOrderInfoSh)><span class="glyphicon glyphicon-cog"  title="审核" ></span>  </a> ';
								}
								
								
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