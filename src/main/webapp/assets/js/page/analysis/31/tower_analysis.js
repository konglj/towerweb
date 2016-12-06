// 条件搜索列表刷新
function searchSubmit() {
	$("#searchBtn").bind("click", function() {
		$('#sample_1').dataTable().fnDraw(false);
	});
	$("#towerdistrict").bind("change",function(){
		comm_get_areas($(this),1);
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
					//"sScrollX": "100%",   //表格的宽度
 					//"sScrollXInner": "110%",   //表格的内容宽度
 					//"bScrollCollapse": true,  //当显示的数据不足以支撑表格的默认的高度时，依然显示纵向的滚动条。(默认是false) 
					
					"fnServerData": function getData(sSource,
						aDataSet, fnCallback) {
						aDataSet.push(
							{
								name: "towername",
								value: $("#towername").val()
							},
							{
								name: "towerdistrict",
								value: $("#towerdistrict").val()
							},
							{
								name: "towerarea",
								value: $("#towerarea").val()
							},
							{
								name: "towerlevel",
								value: $("#towerlevel").val()
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

					"sAjaxSource": $.path +"/analysis/tower/get_towers.html", // 方法名 selectAll
					"columns": [
						/* 需要显示在列表页的列  需要自行调配*/
						
					
						{
							"sTitle": "站址名称",
							"data": "towername"
						},
						{
							"sTitle": "站址编号",
							"data": "towerid"
						},
						{
							"sTitle": "站址状态",
							"data": "towervisible"
						},
						{
							"sTitle": "订单状态",
							"data": "statename"
						},
						{
							"sTitle": "站址区域",
							"data": "towerdistrictname"
						},
						{
							"sTitle": "站址街道",
							"data": "towerareaname"
						},
						{	
							"sTitle": "站址等级",
							"data": "towerlevel"
						},
						{
							"sTitle": "目标谈址佣金(元)",
							"data": "towerfee"
						},	
						{
							"sTitle": "目标租金(元)",
							"data": "towerrentfee"
						},
						{
							"sTitle": "被查看次数",
							data:"viewcount"
						},
						{
							"sTitle": "被抢单数",
							"data": "selecount"
						},
						{
							"sTitle": "主动弃单次数",
							"data": "cancelcount"
						},
						
						{
							"sTitle": "超时弃单次数",
							"data": "timecount"
						},
						
						{
							"sTitle": "审核拒绝次数",
							"data": "rejectcount"
						}

					],
				
					drawCallback: function() {
						//$("input[type='checkbox']").uniform();
					},
					initComplete: function() {
						checkboxall("group-checkable","sample_1");
						
					},  
					fnDrawCallback: function (oSettings) {
						//alert("ddddd");
					},
					columnDefs: [


					],


				});
			}
	};
}();

$(function() {
	TableEditable.init();
	searchSubmit();
});