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
			<i class="icon-globe"></i>金额管理
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
						<label class="control-label col-md-4">姓名（手机号）</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="parameter.username" id="username">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-3">用户区域</label>
						<div class="col-md-9">
									<select name="parameter.userdistrict" id="userdistrict" class="form-control combox" >
									 <c:forEach items="${userManagePage.userParamerDistricts }" var="dis">
      							  		<option value="${dis.disid}" <c:if test='${dis.disid==userManagePage.parameter.userdistrict }'>selected="selected"</c:if>  >${dis.disname }</option>
      								 </c:forEach>
      								</select>
						</div>
					</div>

				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-4"> 用户级别</label>
						<div class="col-md-8">
							<select name="parameter.userlevel" id="userlevel" class="form-control combox">
							
      							<option value="0" <c:if test="${userManagePage.parameter.userlevel ==0 }">selected="selected" </c:if> >全部</option>
      							<c:forEach items="${userManagePage.userLevels }" var="level">
      							  <option value="${level.userlevel }" <c:if test='${level.userlevel==userManagePage.parameter.userlevel }'>selected="selected"</c:if>  >${level.levelname }</option>
      							</c:forEach>
							</select>
						</div>
					</div>
				</div>

			</div>
			<div class="row" style="margin-top: 5px">
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-4"> 用户类型</label>
						<div class="col-md-8">
							<select name="parameter.usertype" id="usertype" class="form-control combox">
							
      							<option value="0" <c:if test="${userManagePage.parameter.usertype ==0 }">selected="selected" </c:if> >全部</option>
      							<c:forEach items="${userManagePage.userTypes }" var="type">
      							  <option value="${type.id }" <c:if test='${type.id==userManagePage.parameter.usertype }'>selected="selected"</c:if>  >${type.typename }</option>
      							</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-4">注册时间</label>
						<div class="col-md-8" >
							<div class="input-group input-large date-picker input-daterange"  data-date-format="yyyy-mm-dd">
								<input type="text" class="form-control" name="parameter.fromdate" id="fromdate">
								<span class="input-group-addon">to
								 </span>
								<input type="text" class="form-control" name="parameter.todate" id="todate">
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-4">
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
		
		<div class="portlet-body table-responsive " >
			<table class="table table-striped table-bordered table-hover dataTable" id="sample_1" aria-describedby="sample_1_info">
			</table>
		</div>
	<!-- END EXAMPLE TABLE PORTLET-->
	<!-- 显示table列表信息 end -->
	
</div>
</div>


<script src="<%=basePath%>assets/js/page/user/user.js"></script>
<script src="<%=basePath%>assets/js/page/user/31/moneys.js"></script>
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