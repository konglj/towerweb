<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page isELIgnored="false"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://"
   + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>

<div class="portlet box blue">
	<!-- 模块名称 start -->
	<div class="portlet-title">
		<div class="caption">
			<i class="icon-globe"></i>订单报表
		</div>
	</div>
	<!-- 模块名称 end -->
	<div class="portlet-body">
		
		<!-- 查询条件 start -->
		<div class="clearfix">
		</div>

		<form role="form" class="margin-bottom-10 margin-top-10">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-5">姓名（手机号）</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="parameter.username" id="username">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-4">站址名称(编号)</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="parameter.towername" id="towername">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-3">站址区域</label>
						<div class="col-md-9">
							<div class="row">
								<div class="col-md-6" >
									<select name="parameter.towercity" id="towercity" class="form-control" ref="towerdistrict">
										 <c:forEach items="${reportOrderPage.paramerCitys }" var="city">
      							  		 <option value="${city.cityid}" <c:if test='${city.cityid==reportOrderPage.parameter.towerarea }'>selected="selected"</c:if>  >${city.cityname }</option>
      								    </c:forEach>
      								</select>
								</div>
								<div class="col-md-6" >
									<select name="parameter.towerdistrict" id="towerdistrict" class="form-control combox"  >
									 <c:forEach items="${reportOrderPage.paramerDistricts }" var="dis">
      							  		<option value="${dis.disid}" <c:if test='${dis.disid==towersPage.district }'>selected="selected"</c:if>  >${dis.disname }</option>
      								 </c:forEach>
      								</select>
								</div>
								
							</div>
						</div>
					</div>

				</div>
				
			</div>
			<div class="row" style="margin-top: 5px">
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label col-md-2"> 状态</label>
						<div class="col-md-10">
							<select name="parameter.towerstate" id="towerstate" class="form-control combox">
							
      							<option value="-1" <c:if test="${reportOrderPage.parameter.towerstate ==-1 }">selected="selected" </c:if> >全部</option>
      							<c:forEach items="${reportOrderPage.orderStates }" var="state">
      							  <option value="${state.state }" <c:if test='${state.state==reportOrderPage.parameter.towerstate }'>selected="selected"</c:if>  >${state.statename }</option>
      							</c:forEach>
							</select>
						</div>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label col-md-5">是否有效</label>
						<div class="col-md-7">
							<select name="parameter.iseffect" id="iseffect" class="form-control combox">
							
      							<option value="-1" <c:if test="${reportOrderPage.parameter.iseffect==-1}">selected="selected"</c:if>>全部</option>
						        <option value="0"  <c:if test="${reportOrderPage.parameter.iseffect==0}">selected="selected"</c:if>  >失效</option>
						        <option value="1"  <c:if test="${reportOrderPage.parameter.iseffect==1}">selected="selected"</c:if> >有效</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-3"> 订单日期</label>
						<div class="col-md-9" >
							<div class="input-group  date-picker input-daterange"  data-date-format="yyyy-mm-dd" style="width: 100%;">
								<input type="text" class="form-control" name="parameter.fromdate" id="fromdate">
								<span class="input-group-addon">to
								 </span>
								<input type="text" class="form-control" name="parameter.todate" id="todate">
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label col-md-4"></label>
						<div class="col-md-8">
							<button type="button" id="searchBtn" name="searchBtn" class="btn green">查询</button>
							<button type="reset" class="btn btn-default" data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>

			</div>
		</form>

	</div>
	<!-- 查询条件 end -->

	<!-- 显示table列表信息 start -->
	<!-- BEGIN EXAMPLE TABLE PORTLET-->
		
		<div class="portlet-body table-responsive1 " >
			<table class="table table-striped table-bordered table-hover dataTable" id="sample_1" aria-describedby="sample_1_info">
			</table>
		</div>
	<!-- END EXAMPLE TABLE PORTLET-->
	<!-- 显示table列表信息 end -->
	
</div>
</div>


<script src="<%=basePath%>assets/js/page/report/37/orders.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
        jQuery(document).ready(function() {       
           	ComponentsPickers.init();
        });   
    </script>
<!-- END JAVASCRIPTS -->
<script type="text/javascript">


    </script>
<!-- 菜单管理需要的js -->