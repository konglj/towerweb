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
			<h2 class="margin-bottom-20">
                提现基本信息
            </h2>

			<div class="row">
				<label class=" col-md-3">
                                                             提现编号：${tx.txid}
                </label>
			</div>

			<h3 class="form-section">
               提现人信息</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                          提现人姓名：
                        </label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.username}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                             提现人手机号：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.usertele}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                           提现人区域：
                        </label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.cityname}-${tx.districtname}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                             提现人等级：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.levelname}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            所在单位：	</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.usercompany}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            用户类型：	</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.typename}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>

			<h3 class="form-section">
                费用信息</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                           提现中总金额：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.gettingnow}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            可提现金额：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.getnow}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                         已提现金额：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.allgeting}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<h3 class="form-section">
               提现信息</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            提现姓名：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.bankaccount}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            提现银行：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.bankname}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                         提现开户行：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.bankopen}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                           提现卡号：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.bankcardid}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                           提现金额：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.fee}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                      状态：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.statename}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                                                                     银行流水号：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.bankbackid}
							</p>
						</div>
					</div>
				</div>

			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                 	    申请时间：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${tx.adddate}
							</p>
						</div>
					</div>
				</div>
				
			</div>

				<h3 class="form-section">
                金额信息</h3>
			<div class="row">
				<div class="col-md-12">

					<table class="table table-bordered">
						<caption>抢单金额信息</caption>
						<thead>
							<tr>
								<th>订单编号</th>
								<th >站址编号</th>
								<th>站址名称</th>
								<th>站址区域</th>
								<th>金额</th>
								<th>付款时间</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tx.txsources}" var="txsource">

								<tr>
									<td>${txsource.orderid}</td>
									<td>${txsource.towerid}</td>
									<td>${txsource.towername}</td>
									<td>${txsource.cityname}-${txsource.areaname}</td>
									<td>${txsource.fee}</td>
									<td>${txsource.paytime}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>

		<div class="row">
				<div class="col-md-12" id="changemoneyinfo" ></div>
			</div>
		

			<h3 class="form-section">
                日志</h3>
			<div class="row">
				<div class="col-md-12">

					<table class="table table-bordered">
						<caption>
							提现状态变更日志</caption>
						<thead>
							<tr>
            	<th>操作人</th>
            	<th style="max-width: 100px">操作人电话</th>
            	<th style="max-width: 50px">操作类型</th>
            	<th style="min-width: 150px">当前状态</th>
           		<th>操作时间</th>
            	<th>审核信息</th>
            </tr>
						</thead>
						<tbody>
							<c:forEach items="${tx.txdoinfos}" var="doinfo">

								<tr>
									<td >${doinfo.dousername}</td>
									<td >${doinfo.dousertele}</td>
									<td >${doinfo.usertypename}</td>
									<td >${doinfo.nowstatename}</td>
									<td >${doinfo.dodate}</td>
									<td >${doinfo.shinfo}</td>
								</tr>
							</c:forEach>

							</tbody>
					</table>

				</div>
			</div>
			
			
			
			
		</div>
		<input type="hidden" id="loadurl" name="loadurl" value="${loadurl}" />
		<input type="hidden" id="page" name="page" value="${page }">
		<input type="hidden" id="id"  name="id" value="${tx.id }">
		<input type="hidden" id="state"  name="state" value="${tx.state}">
	</form>
	<!-- END FORM-->
</div>
<script src="<%=basePath%>assets/js/page/money/money.js"></script>
<script src="<%=basePath%>assets/js/page/money/moneyinfo.js"></script>
