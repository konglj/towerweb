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
                订单基本信息
            </h2>

			<div class="row">
				<label class=" col-md-3">
                                                             订单号：${order.orderid}
                </label>
			</div>
			<div class="row">
				<label class=" col-md-3">
                                                              订单状态：${order.towerstatename}
                </label>
			</div>

			<h3 class="form-section">
                抢单人信息</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                          抢单人姓名：
                        </label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.username}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            抢单人手机号：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.usertele}
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
                          抢单人区域：
                        </label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.usercityname} ${order.userdistrictname}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            抢单人等级：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.userlevelname}
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
								${order.usercompany}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                           所属行业：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.userbusiness}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>

			<h3 class="form-section">
                抢单信息</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            抢单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.ordercount}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            成功订单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.succcount}
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
                            进行中订单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.ingcount}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            失败订单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.failcount}
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
                            撤单数：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.cancelcount}
							</p>
						</div>
					</div>
				</div>
			</div>
			<h3 class="form-section">
                站址信息</h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                          站点名称：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towername}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                            区域经理联系方式：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towermanagername}-${order.towermanager}
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
                         站址地区：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towercityname}-${order.towerdistrictname}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                           订单状态：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towerstatename}
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
                          站址等级：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towerlevelname}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                      站型：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towerstylename}-${order.towertypename}
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
                                                                     站址描述：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towerinfo}
							</p>
						</div>
					</div>
				</div>

			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                 	 下单日期：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.toweraddtime}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                           订单结束日期：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								<c:choose>
									<c:when test="{empty order.towerabandontime}">
										${order.towerendtime}
									</c:when>
									<c:otherwise>
										${order.towerendtime}
									</c:otherwise>
								</c:choose>

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
                          目标谈址佣金费（元）：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towerfee}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				

				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                         延期次数：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.toweryqcount}
							</p>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                          首款（元）：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towerfirstfee}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				

				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                         尾款(元)：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.towerendfee}
							</p>
						</div>
					</div>
				</div>
			</div>
			

			<div class="row">
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                 用户评价：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.userpjcontent}
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-4">
                 管理员评价：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.adminpjcontent}
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
                           用户对站址描述：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								${order.userpjtower}
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
                           租赁合同：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								<c:if test="${not empty orderPage.ordertower.towerthreeht}">
									<a href="../../${orderPage.ordertower.towerhtimag}" name="a_ht_img" download="租赁合同文件">点击下载租赁合同文件</a>
								</c:if>
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
                           内部验收报告文件：</label>
						<div class="col-md-8">
							<p class="form-control-static">
								<c:if test="${not empty orderPage.ordertower.towerthreeht}">
								 <a href="../../${orderPage.ordertower.towerthreeht}" name="a_ht_img" download="三方合同文件">点击下载三方合同文件</a>
								</c:if>
							</p>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
			<div class="row">
				<div class="col-md-12" id="changeorderinfo" ></div>
			</div>

			<h3 class="form-section">
                日志</h3>
			<div class="row">
				<div class="col-md-12">

					<table class="table table-bordered">
						<caption>
							订单状态变更日志</caption>
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
							<c:forEach items="${order.shInfos}" var="doinfo">

								<tr>
									<td >${doinfo.ordername}</td>
									<td >${doinfo.orderphone}</td>
									<td >${doinfo.ordertypename}</td>
									<td >${doinfo.orderstatename}</td>
									<td >${doinfo.ordertime}</td>
									<td >${doinfo.ordershinfo}</td>
								</tr>
							</c:forEach>

							</tbody>
					</table>

				</div>
			</div>
		</div>
		<input type="hidden" id="loadurl" name="loadurl" value="${loadurl}" />
		<input type="hidden" id="page" name="page" value="${page }">
		<input type="hidden" id="id"  name="id" value="${order.id }">
	    <input type="hidden" id="towerstate" name="towerstate" value="${order.towerstate }">
	    <input type="hidden" id="towerdelayreason" value="${order.towerdelayreason}" />
	    <input type="hidden" id="towerfee" name="towerfee" value="${order.towerfee}" />
	</form>
	<!-- END FORM-->
</div>
<script src="<%=basePath%>assets/js/page/order/order.js"></script>
<script src="<%=basePath%>assets/js/page/order/orderinfo.js"></script>
<script src="<%=basePath%>assets/js/page/order/37/orderinfo.js"></script>