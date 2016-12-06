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

<div class="portlet-body form">
	<!-- BEGIN FORM-->
	<form class="form-horizontal" role="form">
		<div class="form-body">

			<h3 class="form-section">用户基本信息</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 微信昵称： </label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.username}</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 性别：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.sexname}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 级别：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.levelname}</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 姓名：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.username}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 地区：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${userinfo.cityname}-${userinfo.districtname}</p>
						</div>
					</div>
				</div>
				<!--/span-->

				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 电话：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.usertele}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 所在单位：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.usercompany}</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 行业：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.userbusinessname}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 类型：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.typename}</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 状态：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.statename}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 积分：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.score}</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 经验：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.exp}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 注册时间：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.addtime}</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 组织类型：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.teamtypename}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 验证状态：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.verifystatename}</p>
						</div>
					</div>
				</div>

			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 身份证或企业营业执照：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.userteamimg}</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 中标类型：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.userwintype}</p>
						</div>
					</div>
				</div>

			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 备注：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.userbz}</p>
						</div>
					</div>
				</div>

			</div>

			<h3 class="form-section"> 抢单信息</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 抢单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.ordercount}</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 派单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.pdcount}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 进行中订单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.ingcount}</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">  失败订单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.failcount}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4"> 撤单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.cancelcount}</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">   成功订单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">${userinfo.succcount}</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>

			<div class="row">
				<div class="col-md-12">

					<table class="table table-bordered">
						<caption>订单信息</caption>
						<thead>
							<tr>
								<th>订单编号</th>
								<th>站址编号</th>
								<th>站址名称</th>
								<th>目标谈址佣金(元)</th>
								<th>交单时间</th>
								<th>订单状态</th>
								<th>下单时间</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userinfo.orderinfos}" var="orderinfo">

								<tr>
									<td >${orderinfo.orderid}</td>
									<td >${orderinfo.towerbh}</td>
									<td >${orderinfo.towername}</td>
									<td >${orderinfo.towerfee}</td>
									<td >${orderinfo.towerenddate}</td>
									<td >${orderinfo.towerstatename}</td>
									<td >${orderinfo.toweraddtime}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>


		

		</div>
	</form>
	<!-- END FORM-->
</div>
<script src="<%=basePath%>assets/js/page/user/user.js"></script>
