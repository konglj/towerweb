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
			<i class="icon-globe"></i>订单管理
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
						<label class="control-label col-md-4">姓名或手机</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="parameter.username" id="username" value="${orderPage.parameter.username }">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-3">站址区域</label>
						<div class="col-md-9">
							<div class="row">
								<div class="col-md-6  style="padding-right:0px;" >
									<select name="parameter.towerdistrict" id="towerdistrict" class="form-control combox" ref="towerarea" >
									 <c:forEach items="${orderPage.paramerDistricts }" var="dis">
      							  		<option value="${dis.disid}" <c:if test='${dis.disid==orderPage.parameter.towerdistrict }'>selected="selected"</c:if>  >${dis.disname }</option>
      								 </c:forEach>
      								</select>
								</div>
								<div class="col-md-6" style="padding-right:0px;">
									<select name="parameter.towerarea" id="towerarea" class="form-control">
										 <c:forEach items="${orderPage.paramerAreas }" var="area">
      							  		 <option value="${area.id}" <c:if test='${area.id==orderPage.parameter.towerarea }'>selected="selected"</c:if>  >${area.areaname }</option>
      								    </c:forEach>
      								</select>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-5"> 站址名称（编号）</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="parameter.towername" id="towername" value="${orderPage.parameter.username }">
						</div>
					</div>
				</div>
				
			</div>
			<div class="row" style="margin-top: 5px">
			<!-- 
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label col-md-4"> 状态</label>
						<div class="col-md-8">
							<select name="parameter.towerstate" id="towerstate" class="form-control combox" >
							<option value="-1" <c:if test="${orderPage.parameter.towerstate==-1}" >selected="selected"</c:if>>全部</option>
							<option value="-2" <c:if test="${orderPage.parameter.towerstate==-2}" >selected="selected"</c:if>>待处理</option>
							<c:forEach items="${orderPage.orderStates }" var="state">
							 <option value="${state.state}" <c:if test="${orderPage.parameter.towerstate==state.state}" >selected="selected"</c:if>>${state.statename}</option>
							</c:forEach>
							</select>
						</div>
					</div>
				</div>
			 -->	
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label col-md-5">用户区域</label>
						<div class="col-md-7">
							<select name="parameter.userdistrict" id="userdistrict" class="form-control combox">
							<c:forEach items="${orderPage.userParamerDistricts }" var="dis">
      							<option value="${dis.disid}" <c:if test="${dis.disid==orderPage.parameter.userdistrict }">selected="selected"</c:if>  >${dis.disname }</option>
      						</c:forEach>
      						</select>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label col-md-6">下单时间</label>
						<div class="col-md-6" >
							<div class="input-group input-large date-picker input-daterange"  data-date-format="yyyy-mm-dd">
								<input type="text" class="form-control" name="parameter.fromdate" id="fromdate">
								<span class="input-group-addon">to
								 </span>
								<input type="text" class="form-control" name="parameter.todate" id="todate">
							</div>
						</div>
					</div>

				</div>
				
				<div class="col-md-5">
					<div class="form-group">
					    <label class="control-label col-md-7"></label>
						<div class="col-md-5">
							<button type="button" id="searchBtn" name="searchBtn" class="btn green">查询</button>
							<button type="reset" class="btn btn-default" data-dismiss="modal">导出</button>
						</div>
					</div>
				</div>
				
				
			</div>
		</form>

	</div>
	<!-- 查询条件 end -->

	<!-- 显示table列表信息 start -->
	<!-- BEGIN EXAMPLE TABLE PORTLET-->
		
		<div class="portlet-body table-responsive1" >
			<table class="table table-striped table-bordered table-hover dataTable" id="sample_1" aria-describedby="sample_1_info">
			</table>
			<div class="clearfix">
		    </div>
		</div>
	<!-- END EXAMPLE TABLE PORTLET-->
	<!-- 显示table列表信息 end -->
	
</div>
</div>

<script>
        jQuery(document).ready(function() {       
           	ComponentsPickers.init();
        });   
    </script>
<script src="<%=basePath%>assets/js/page/order/order.js"></script>
<script src="<%=basePath%>assets/js/page/order/31/shorders.js"></script>

