// 条件搜索列表刷新
function searchSubmit() {
	$("#searchBtn").bind("click", function() {
		$('#sample_1').dataTable().fnDraw(true);
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
								name: "parameter.towerarea",
								value: $("#towerarea").val()
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
								name: "parameter.towerstate",
								value: $("#towerstate").val()
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

					"sAjaxSource": $.path +"/order/get_orders.html?page=0", // 方法名 selectAll
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
							"sTitle": "站址区域",
							"data": "towerdistrictname"
						},
						{
							"sTitle": "站址街道",
							"data": "towerareaname"
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
							"sTitle": "中标类型",
							"data": "userwintype"
						},						
						{
							"sTitle": "下单时间",
							"data": "toweraddtime"
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
							targets: 11,
							render: function(a, b, c, d) {
								var id = c.id;
								var towerstateshtype=c.towerstateshtype;
								var towerstate=c.orderstate;
								var moneyapply=c.moneyapply;
								var towerpjprogress=c.towerpjprogress;
								var res='<a   onclick=check_auth('+id+',"A1",GetOrderInfo)><span class="glyphicon glyphicon-search"  title="查看" ></span> </a>';
								if(moneyapply==1){
									res=res+ '&nbsp;&nbsp;' + 
								      '<a > <span   title="无操作" >--</span> </a> ';
								 return res;
								}
								if(towerstateshtype==0){
									res=res+ '&nbsp;&nbsp;' + 
								      '<a > <span   title="无操作" >--</span> </a> ';
								}
								else if(towerstateshtype==1){
									res=res+ '&nbsp;&nbsp;' + 
								      '<a   onclick=check_auth_ordersh('+id+','+towerstate+',"A2",GetOrderInfoSh)><span class="glyphicon glyphicon-cog"  title="审核" ></span>  </a> ';
								}else if(towerstateshtype==2){
									res=res+ '&nbsp;&nbsp;' + 
								      '<a   onclick=check_auth_ordersh('+id+','+towerstate+',"A2",GetOrderInfoSh)><span class="glyphicon glyphicon-usd"  title="付款申请" ></span>  </a>';
								}
								else if(towerstateshtype==3){
									if(towerpjprogress==0||towerpjprogress==1){
									res=res+ '&nbsp;&nbsp;' + 
								      '<a   onclick=check_auth_ordersh('+id+','+towerstate+',"A2",GetOrderInfoPj)><span class="glyphicon glyphicon-pencil"  title="评价" ></span>  </a> ';
									}else{
										res=res+ '&nbsp;&nbsp;' + 
								      '<a > <span   title="无操作" >--</span> </a> ';
									}
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