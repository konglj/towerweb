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
				<label class="control-label col-md-4">实际谈址佣金（元）：</label>
				<div class="col-md-8">
					<input type="number" class="form-control" placeholder="" min="0"
						id="towerfactfee" name="towerfactfee">
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
								onclick="order_sc_threeht()">
								<i class="glyphicon glyphicon-ok"></i>生成三方合同
							</button>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-offset-3 col-md-4">
							<button type="button" class="btn green"
								onclick="order_sh()">
								<i class="glyphicon glyphicon-remove"></i>审核拒绝
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<script type="text/javascript">




</script>