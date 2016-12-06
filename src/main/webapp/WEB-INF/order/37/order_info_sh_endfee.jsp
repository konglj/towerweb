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
<form class="form-horizontal" id="form_sh" role="form">

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
	
</form>
<div class="form-actions">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-offset-3 col-md-4">
							<button type="button" class="btn green" onclick="goback()">
								<i class="glyphicon glyphicon-arrow-left"></i>返回
							</button>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-offset-3 col-md-4">
							<button type="button" class="btn green"
								onclick="order_end_fee(1,'审核通过')">
								<i class="glyphicon glyphicon-ok"></i>审核通过
							</button>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-offset-3 col-md-4">
							<button type="button" class="btn green" onclick="order_end_fee(0,'审核拒绝')">
								<i class="glyphicon glyphicon-remove"></i>审核拒绝
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-4"></div>
</div>
</div>

<script>

</script>