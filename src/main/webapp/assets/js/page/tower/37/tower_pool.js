var tower_visible=2;
// 条件搜索列表刷新
function searchSubmit() {
	$("#searchBtn").bind("click", function() {
		$('#sample_1').dataTable().fnDraw(false);
	});
	$("#city").bind("change",function(){
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
								name: "district",
								value: $("#district").val()
							},
							{
								name: "city",
								value: $("#city").val()
							},
							{
								name: "towerlevel",
								value: $("#towerlevel").val()
							},
						
							{
								name: "towercreatetype",
								value: $("#towercreatetype").val()
							},
							{
								name: "fromdate",
								value: $("#fromdate").val()
							},
							{
								name: "todate",
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

					"sAjaxSource": "./tower/get_towers.html?towervisible="+tower_visible, // 方法名 selectAll
					"columns": [{
							'sTitle': '<input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" />',
							'bSortable': false,
							"data": null
						}, 
						/* 需要显示在列表页的列  需要自行调配*/
						
					
						{
							"sTitle": "站址名称",
							"data": "towername"
						},
						{
							"sTitle": "站址城市",
							"data": "cityname"
						},
						{
							"sTitle": "站址区域",
							"data": "districtname"
						},
						{
							"sTitle": "详细地址",
							"data": "toweraddress"
						},
						{	
							"sTitle": "站址等级",
							"data": "towerlevelname"
						},
						{
							"sTitle": "建站类型",
							"data": "towercreatetypename"
						},	
						{
							"sTitle": "谈址佣金（元）",
							"data": "towerfee"
						},
						{
							"sTitle": "来源",
							data:null
						},
						{
							"sTitle": "创建时间",
							"data": "towercreatetime"
						},
						
						{
							"sTitle": "操作",
							"data": null,
							"width":"50px"
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
					columnDefs: [{
							targets: 0,
							render: function(a, b, c, d) {
								var id = c.id;
								return '<input type="checkbox" class="checkboxes"  value="' + id + '" />';
							}
						},

						{
							targets: 8,
							render: function(a, b, c, d) {
								var source = c.towersource;
								if(source==1){
									return '下架'
								}else{
									return '添加'
								}
							}
						},
						{
							targets: 10,
							render: function(a, b, c, d) {
								var id = c.id;
								return ' <a   onclick=check_auth('+id+',"A1",GetTowerYesInfo)><span class="glyphicon glyphicon-search"  title="查看" ></span> </a>' 
								+ '&nbsp;&nbsp;' + 
								'<a   onclick=check_auth('+id+',"A2",GetUpateTowerInfoPool)><span class="glyphicon glyphicon-pencil"  title="编辑" ></span>  </a> ';
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