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
<link href="<%=basePath %>assets/global/plugins/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<form class="form-horizontal" id="form_sh" role="form">
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-4"> 延期理由：</label>
				<div class="col-md-8">
					<textarea id="yqreason" rows="3" name="yqreason" readonly="readonly" style="width: 100%;"></textarea>
				</div>
			</div>
		</div>

	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-4"> 延期天数：</label>
				<div class="col-md-8">
					<input type="number" class="form-control" placeholder="请输入延期天数(${info.yqminday}-${info.yqmaxday}天)" min="${info.yqminday}" max="${info.yqmaxday}"  <c:if test="${info.yqminday==info.yqmaxday}"> value="${info.yqminday}" readonly="readonly" </c:if> id="delayday"  name="delayday">
				</div>
			</div>
		</div>

	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-4"> 审核信息：</label>
				<div class="col-md-8">
					<textarea id="shinfo" rows="3" name="shinfo" style="width: 100%;"></textarea>
				</div>
			</div>
		</div>

	</div>

	<input type="hidden" id="f_id" name="id" />
	<input type="hidden" id="f_towerstate" name="towerstate" />
	<input type="hidden" id="yqminday" name="yqminday"  value="${info.yqminday}"/>
	<input type="hidden" id="yqmaxday" name="yqmaxday" value="${info.yqmaxday}"/>

</form>
<div class="form-actions">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-6">
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-offset-3 col-md-4">
							<button type="button" class="btn green" onclick="goback()">
								<i class="glyphicon glyphicon-arrow-left"></i>&nbsp;&nbsp;返回&nbsp;&nbsp;
							</button>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-offset-3 col-md-4">
							<button type="button" class="btn green"
								onclick="order_sh_delay(1,'审核通过')">
								<i class="glyphicon glyphicon-ok"></i>审核通过
							</button>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-offset-3 col-md-4">
							<button type="button" class="btn green" onclick="order_sh_delay(0,'审核拒绝')">
								<i class="glyphicon glyphicon-remove"></i>审核拒绝
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$(function() {
	$("#yqreason").val($("#towerdelayreason").val());
});
</script>