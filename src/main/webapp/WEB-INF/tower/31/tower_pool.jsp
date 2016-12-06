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
			<i class="icon-globe"></i>站址池管理
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
								<div class="col-md-6  style="padding-right:0px;" >
									<select id="district" name="district" class="form-control combox" ref="area" >
									 <c:forEach items="${towersPage.paramerDistricts }" var="dis">
      							  		<option value="${dis.disid}" <c:if test='${dis.disid==towersPage.district }'>selected="selected"</c:if>  >${dis.disname }</option>
      								 </c:forEach>
      								</select>
								</div>
								<div class="col-md-6" style="padding-right:0px;">
									<select name="area" id="area" class="form-control">
										 <c:forEach items="${towersPage.paramerAreas }" var="area">
      							  		 <option value="${area.id}" <c:if test='${area.id==towersPage.area }'>selected="selected"</c:if>  >${area.areaname }</option>
      								    </c:forEach>
      								</select>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label col-md-4"> 站址级别</label>
						<div class="col-md-8">
							<select name="towerlevel" id="towerlevel" class="form-control combox">
							
      							<option value="0" <c:if test="${towersPage.towerlevel==0 }">selected="selected" </c:if> >全部</option>
      							<c:forEach items="${towersPage.towerLevels }" var="level">
      							  <option value="${level.towerlevel }" <c:if test='${level.towerlevel==towersPage.towerlevel }'>selected="selected"</c:if>  >${level.levelname }</option>
      							</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label col-md-6"> 站址来源</label>
						<div class="col-md-6">
							<select name="towersource" id="towersource" class="form-control combox" >
      							<option value="-1" <c:if test="${towersPage.towersource==-1}" >selected="selected"</c:if>>所有</option>
								<option value="0"  <c:if test="${towersPage.towersource==0}" >selected="selected"</c:if>>添加</option>
								<option value="1"  <c:if test="${towersPage.towersource==1}" >selected="selected"</c:if>>下架</option>
							</select>
						</div>
					</div>
				</div>

			</div>
			<div class="row" style="margin-top: 5px">
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label col-md-4"> 建站类型</label>
						<div class="col-md-8">
							<select name="towercreatetype" id="towercreatetype" class="form-control combox" >
      						<option value="0" <c:if test='${0==towersPage.towercreatetype }'>selected="selected"</c:if>>全部</option>
      							<c:forEach items="${towersPage.towerCreateTypes }" var="type">
      							  <option value="${type.id }" <c:if test='${type.id==towersPage.towercreatetype }'>selected="selected"</c:if>  >${type.name }</option>
      							</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label col-md-4">上架时间</label>
						<div class="col-md-8" >
							<div class="input-group input-large date-picker input-daterange"  data-date-format="yyyy-mm-dd">
								<input type="text" class="form-control" name="fromdate" id="fromdate">
								<span class="input-group-addon">to
								 </span>
								<input type="text" class="form-control" name="todate" id="todate">
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-6">
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
			<div class="clearfix">
			<div class="btn-group">
				<a href="javascript:;" onclick="check_auth(0,'A2',updateTowerVisible);">
					<button type="button" class="btn green" style="margin-right: 20px;">
					审核<i class="icon-arrow-down"></i>
				</button>
				</a>
				
				<a href="javascript:;" onclick="check_auth(0,'A2',delTower);">
					<button type="button" class="btn green" style="margin-right: 20px;">
					删除<i class="icon-arrow-down"></i>
				</button>
				</a>

			</div>
		</div>
		</div>
	<!-- END EXAMPLE TABLE PORTLET-->
	<!-- 显示table列表信息 end -->
	
</div>
</div>


<script src="<%=basePath%>assets/js/page/tower/tower.js"></script>
<script src="<%=basePath%>assets/js/page/tower/31/tower_pool.js"></script>
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