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


	</div>
	<!-- 查询条件 end -->

	<!-- 显示table列表信息 start -->
	<!-- BEGIN EXAMPLE TABLE PORTLET-->
		
		<div class="portlet-body table-responsive " >
			<table class="table table-striped table-bordered table-hover dataTable" id="sample_1" aria-describedby="sample_1_info">
			</table>
			<div class="clearfix">
			
		</div>
		</div>
	<!-- END EXAMPLE TABLE PORTLET-->
	<!-- 显示table列表信息 end -->
	
</div>
</div>


<script src="<%=basePath%>assets/js/page/analysis/31/usersource_analysis.js"></script>
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