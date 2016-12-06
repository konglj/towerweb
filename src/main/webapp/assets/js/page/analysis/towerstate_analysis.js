// 条件搜索列表刷新
function searchSubmit() {
	$("#searchBtn").bind("click", function() {
		$('#sample_1').dataTable().fnDraw(false);
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

					"sAjaxSource": $.path +"/analysis/tower/get_towerstates.html", // 方法名 selectAll
					"columns": [
						/* 需要显示在列表页的列  需要自行调配*/
						
					
						{
							"sTitle": "地市",
							"data": "cityname"
						},
						{
							"sTitle": "上架站址数",
							"data": "towervisisblecount"
						},
						{
							"sTitle": "已抢单站址数",
							"data": "towerqdcount"
						},
						{
							"sTitle": "未抢单站址数",
							"data": "towerunqdcount"
						},
						{	
							"sTitle": "目标建站地址审核通过数",
							"data": "ordertargetaddresscount"
						},
						{
							"sTitle": "已交单站址数量",
							"data": "orderjdcount"
						},	
						{
							"sTitle": "审核进行中",
							"data": "ordershingcount"
						},
						{
							"sTitle": "订单完成站址数",
							"data":"ordercompletecount"
						},
						{
							"sTitle":"提现成功数",
							"data":"txsuccesscount"
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