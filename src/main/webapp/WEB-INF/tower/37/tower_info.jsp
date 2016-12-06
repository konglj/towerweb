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

					<h3 class="form-section">站址基本信息</h3>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">站址名称：  </label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towername}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">运营商需求(移动)：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerwhoyd}
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
								<label class="control-label col-md-4">运营商需求(电信)： </label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerwhodx}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">运营商需求(联通)：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerwholt}
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
								<label class="control-label col-md-4">地区：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.cityname}-${tower.districtname}
									</p>
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">自定义编号：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.toweridefined}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">详细地址：  </label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.toweraddress}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">系统编号：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerid}
										
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">站址等级：    </label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerlevelname}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">站型：  </label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towertypename}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">目标谈址佣金（元）：</label>
								<div class="col-md-8">
									<p class="form-control-static">
											${tower.towerfee}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">目标租金（元）： </label>
								<div class="col-md-8">
									<p class="form-control-static">
											${tower.towerrentfee}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">站址状态：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerstatename}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">区域经理联系方式：   </label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towermanagername}-${tower.towermanager}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">添加日期：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.toweradddate}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">主选经纬度：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerj},${tower.towerw}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">备选经纬度一：  </label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerfirstj},${tower.towerfirstw}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">备选经纬度二：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towersecondj},${tower.towersecondw}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">上架日期：   </label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towervisibletime}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">租用面积（m²）：</label>
								<div class="col-md-8">
									<p class="form-control-static">
											${tower.towerlarge}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">站址库类型：  </label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerstorename}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">站址建站类型：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towercreatetypename}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">站址描述：</label>
								<div class="col-md-8">
									<p class="form-control-static">
										${tower.towerinfo}
									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">

						</div>
						<!--/span-->
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-4">生成地图：</label>
								<div class="col-md-8">
									<p class="form-control-static">

									</p>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="col-md-6">

						</div>
						<!--/span-->
					</div>
					<!--/row-->
					<div class="form-actions">
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button type="button" class="btn default" onclick="goback()">返回</button>
								</div>
							</div>
						</div>
						<div class="col-md-6">
						</div>
					</div>
				</div>
				<input type="hidden" id="towervisible" value="${tower.towervisible}" />
			</form>
			<!-- END FORM-->
		</div>
	<script src="<%=basePath%>assets/js/page/tower/tower.js"></script>	
