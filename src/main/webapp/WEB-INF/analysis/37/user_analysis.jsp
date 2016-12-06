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
			<i class="icon-globe"></i>用户活跃分析
		</div>
	</div>
	<!-- 模块名称 end -->
	<div class="portlet-body">
		
		<!-- 查询条件 start -->
		<div class="clearfix">
		</div>

		<form role="form" class="margin-bottom-10 margin-top-10">
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label col-md-4">姓名</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="username" id="username">
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label col-md-4">手机号</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="usertele" id="usertele">
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label col-md-4">用户区域</label>
						<div class="col-md-8">
							<div class="row">
								<div class="col-md-6  style="padding-right:0px;" >
									<select name="usercity" id="usercity" class="form-control combox" ref="userdistrict" >
									 <c:forEach items="${userAnalysisPage.userParamerCitys }" var="city">
      							  		<option value="${city.cityid}" <c:if test='${city.cityid==userAnalysisPage.usercity }'>selected="selected"</c:if>  >${city.cityname }</option>
      								 </c:forEach>
      								</select>
								</div>
								<div class="col-md-6  style="padding-right:0px;" >
									<select name="userdistrict" id="userdistrict" class="form-control combox" >
									 <c:forEach items="${userAnalysisPage.userParamerDistricts }" var="dis">
      							  		<option value="${dis.disid}" <c:if test='${dis.disid==userAnalysisPage.userdistrict }'>selected="selected"</c:if>  >${dis.disname }</option>
      								 </c:forEach>
      								</select>
								</div>
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


<script src="<%=basePath%>assets/js/page/analysis/37/user_analysis.js"></script>
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