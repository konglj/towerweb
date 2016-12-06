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
			<i class="icon-globe"></i>站址活跃
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
						<label class="control-label col-md-4">站址筛选</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="towername" id="towername">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-md-3">站址区域</label>
						<div class="col-md-9">
							<div class="row">
								<div class="col-md-6"   >
									<select name="towerdistrict" class="form-control combox" ref="area" refUrl="${ctx}/procity?pro_code={value}&city_code=HSLY">
									 <c:forEach items="${towerAnalysisPage.paramerDistricts }" var="dis">
      							  		<option value="${dis.disid}" <c:if test='${dis.disid==towerAnalysisPage.district }'>selected="selected"</c:if>  >${dis.disname }</option>
      								 </c:forEach>
      								</select>
								</div>
								<div class="col-md-6" >
									<select name="towerarea" id="towerarea" class="form-control">
										 <c:forEach items="${towerAnalysisPage.paramerAreas }" var="area">
      							  		 <option value="${area.id}" <c:if test='${area.id==towerAnalysisPage.area }'>selected="selected"</c:if>  >${area.areaname }</option>
      								    </c:forEach>
      								</select>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label col-md-5"> 站址级别</label>
						<div class="col-md-7">
							<select name="towerlevel" id="towerlevel" class="form-control combox">
							
      							<option value="0" <c:if test="${towerAnalysisPage.towerlevel==0 }">selected="selected" </c:if> >全部</option>
      							<c:forEach items="${towerAnalysisPage.towerLevels }" var="level">
      							  <option value="${level.towerlevel }" <c:if test='${level.towerlevel==towerAnalysisPage.towerlevel }'>selected="selected"</c:if>  >${level.levelname }</option>
      							</c:forEach>
							</select>
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
			<div class="clearfix"></div>
		</div>
	<!-- END EXAMPLE TABLE PORTLET-->
	<!-- 显示table列表信息 end -->
	
</div>
</div>


<script src="<%=basePath%>assets/js/page/analysis/31/tower_analysis.js"></script>
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