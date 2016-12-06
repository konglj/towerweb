<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row margin-top-10">
				<div class=" col-lg-3 col-md-3 col-sm-6 col-xs-12   bordd" >
					<div class="dashboard-stat2 kuangbor">
						<div class="display">
							<div class="number" >
								<h3 class="font-green-sharp"><span id="stuNum"></span><small class="font-green-sharp">名</small></h3>
								<small class="" >学生身份认证</small>
							</div>
							<div class="icon">
								<i class="icon-user"></i>
							</div>
						</div>
						<div class="progress-info">
							<div class="progress">
								<span id="stuNum3" class="progress-bar progress-bar-success green-sharp"></span>
							</div>
							<div class="status">
								<div class="status-title">
									 未认证
								</div>
								<div class="status-number">
									<span id="stuNum2"></span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12   bordd">
					<div class="dashboard-stat2 kuangbor">
						<div class="display">
							<div class="number">
								<h3 class="font-red-haze"><span id="stuLoanNum"></span></h3>
								<small>学生借款申请</small>
							</div>
							<div class="icon">
								<i class="icon-like"></i>
							</div>
						</div>
						<div class="progress-info">
							<div class="progress">
								<span id="stuLoanNum3" class="progress-bar progress-bar-success red-haze">
								</span>
							</div>
							<div class="status">
								<div class="status-title">
									未处理
								</div>
								<div class="status-number">
									<span id="stuLoanNum2"></span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class=" col-lg-3 col-md-3 col-sm-6 col-xs-12   bordd">
					<div class="dashboard-stat2 kuangbor">
						<div class="display">
							<div class="number">
								<h3 class="font-blue-sharp"><span id="stuBuyNum"></span></h3>
								<small>新品问卷商品信息审核</small>
							</div>
							<div class="icon">
								<i class="icon-basket"></i>
							</div>
						</div>
						<div class="progress-info">
							<div class="progress">
								<span id="stuBuyNum3" class="progress-bar progress-bar-success blue-sharp">
								</span>
							</div>
							<div class="status">
								<div class="status-title">
									 未审核
								</div>
								<div class="status-number">
									<span id="stuBuyNum2"></span>
								</div>
							</div>
						</div>
					</div>
				</div>
					<div class=" col-lg-3 col-md-3 col-sm-6 col-xs-12   bordd">
					<div class="dashboard-stat2 kuangbor">
						<div class="display">
							<div class="number">
								<h3 class="font-purple-soft"><span id="stuSchNum"></span></h3>
								<small>临时新增的学校审核</small>
							</div>
							<div class="icon">
								<i class="icon-bar-chart"></i>
							</div>
						</div>
						<div class="progress-info">
							<div class="progress">
								<span id="stuSchNum3" class="progress-bar progress-bar-success purple-soft">
								</span>
							</div>
							<div class="status">
								<div class="status-title">
									 未审核
								</div>
								<div class="status-number">
									<span id="stuSchNum2"></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


<!-- 日志管理需要的js -->
<script type="text/javascript">
$(function() {
	
	$.ajax({
		"url" : $.path+ "/yun_log/yun_log_selectByNum.action",
		"type" : "post",
		"data" : {},
		"dataType" : "json",
		"success" : function(data) {
			var ds = data.result.data;
		    $("#stuNum").text(ds.stuNumNo);
		    if(ds.stuNumCount==0){
		         $("#stuNum3").css("width","0%");
		         $("#stuNum2").text("0%");
		    }else{
		    	var a=(parseFloat(ds.stuNumNo/ds.stuNumCount)*100).toFixed(2)+'%';
		    	 $("#stuNum3").css("width",a);
				 $("#stuNum2").text(a);
		    }
		    $("#stuLoanNum").text(ds.stuLoNumNo);
		    if(ds.stuLoNumCo==0){
		  		  $("#stuLoanNum3").css("width","0%");
		    	  $("#stuLoanNum2").text("0%");
		    }else{
		    	var b=(parseFloat(ds.stuLoNumNo/ds.stuLoNumCo)*100).toFixed(2)+'%';
		    	 $("#stuLoanNum3").css("width",b);
				 $("#stuLoanNum2").text(b);
		    }
		    $("#stuBuyNum").text(ds.stuBuyNumNo);
		    if(ds.stuBuyNumCo==0){
		    	$("#stuBuyNum3").css("width","0%");
				$("#stuBuyNum2").text("0%");
		    }else{
		    var c=(parseFloat(ds.stuBuyNumNo/ds.stuBuyNumCo)*100).toFixed(2)+'%';
		    $("#stuBuyNum3").css("width",c);
		    $("#stuBuyNum2").text(c);
		    }
		    $("#stuSchNum").text(ds.stuSchNumCo);
		    $("#stuSchNum3").css("width","100%");
			$("#stuSchNum2").text("100%");
		}
	});
	
	$(".bordd").each(function(){
		$(this).click(function(){   
			if($(this).index()==0){
				abTab("menu3",1);
				$('#changeTab').load('loan/userCheck.html');
				var h='<li><a href="javascript:;" onclick="indexTab();">首页</a></li><li><a href="javascript:;">学生管理</a><i class="icon-angle-right"></i></li><li><a href="javascript:;" onclick="changeTab("loan/userCheck.html");">学生信息审核</a></li>';
				$('.breadcrumb').html(h);
			}if($(this).index()==1){
				abTab("menu4",3);
				$('#changeTab').load('loan/loanOrder.html');
				var h2='<li><a href="javascript:;" onclick="indexTab();">首页</a></li><li><a href="javascript:;">借款管理</a><i class="icon-angle-right"></i></li><li><a href="javascript:;" onclick="changeTab("loan/loanOrder.html");">借款申请审批</a></li>';
				$('.breadcrumb').html(h2);
			}if($(this).index()==2){
				abTab("menu7",3);
				$('#changeTab').load('activity/intentionBuyCertified.html');
				var h3='<li><a href="javascript:;" onclick="indexTab();">首页</a></li><li><a href="javascript:;">问卷管理</a><i class="icon-angle-right"></i></li><li><a href="javascript:;" onclick="changeTab("activity/intentionBuyCertified.html");">意向购买审核</a></li>';
				$('.breadcrumb').html(h3);
			}if($(this).index()==3){
				abTab("menu2",1);
				$('#changeTab').load('loan/schoolTempManager.html');
				var h3='<li><a href="javascript:;" onclick="indexTab();">首页</a></li><li><a href="javascript:;">学校管理</a><i class="icon-angle-right"></i></li><li><a href="javascript:;" onclick="changeTab("loan/schoolTempManager.html");">临时新增</a></li>';
				$('.breadcrumb').html(h3);
			}
		});
	});
});

function abTab(menu,index){
	   $('.page-sidebar-menu li ').removeClass('menuactive');
	   $(' .sub-menu li').removeClass('active');
	   $(".sub-menu").hide();
	   $('.page-sidebar-menu li> a > span.arrow ').removeClass('open');
	   $("."+menu).addClass('menuactive');
	   $("."+menu).find('> a > span.arrow').addClass('open');
	   $("."+menu+">ul").show();
	   $("."+menu+">ul>li").eq(index).addClass('active');
	   
}
</script>