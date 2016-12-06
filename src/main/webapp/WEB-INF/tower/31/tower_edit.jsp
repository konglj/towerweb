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

<div class="row">
	<div class="col-md-12">
		<div class="tabbable-line boxless tabbable-reversed">
			<ul class="nav nav-tabs">
				<c:choose>
					<c:when test="${towersPage.tower.id==0}">
						<li class="active"><a href="#tab_0" data-toggle="tab">手动添加 </a></li>
						<li><a href="#tab_1" data-toggle="tab">批量添加</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#tab_0" data-toggle="tab">编辑 </a></li>
					</c:otherwise>
				</c:choose>
				

			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tab_0">
					<div class="portlet box green">
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form class="form-horizontal" role="form" id="saveForm" style="padding-right: 10px;padding-left: 10px;">
								<div class="form-body">

									<h3 class="form-section">站址基本信息</h3>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">站址名称：  </label>
												<div class="col-md-8">
													<input type="text" class="form-control" id="towername" name="towername" placeholder="" value="${towersPage.tower.towername }">
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">站址区域：</label>
												<div class="col-md-8">

													<select class="form-control input-small col-md-6" id="towerdistrict" name="towerdistrict">
											             <c:forEach items="${towersPage.paramerDistricts }" var="dis">
      							  							<option value="${dis.disid}" <c:if test='${dis.disid==towersPage.tower.towerdistrict }'>selected="selected"</c:if>  >${dis.disname }</option>
      													 </c:forEach>
										                       </select>
													<select class="form-control input-small col-md-6" id="towerarea" name="towerarea">
											             <c:forEach items="${towersPage.paramerAreas }" var="area">
      							  							 <option value="${area.id}" <c:if test='${area.id==towersPage.tower.towerarea }'>selected="selected"</c:if>  >${area.areaname }</option>
      								   					 </c:forEach>
											         </select>

												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<!--/row-->
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">详细地址： </label>
												<div class="col-md-8">
													<input type="text" class="form-control" placeholder="" id="toweraddress" name="toweraddress" value="${towersPage.tower.toweraddress}">
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">站址级别：</label>
												<div class="col-md-8">
												<select class="form-control input-small col-md-6" id="towerlevel" name="towerlevel">
													<c:forEach items="${towersPage.towerLevels }" var="level">
      							 					 <option value="${level.towerlevel }" <c:if test='${level.towerlevel==towersPage.tower.towerlevel }'>selected="selected"</c:if>  >${level.levelname }</option>
      												</c:forEach>
										           </select>

												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<!--/row-->
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">运营商需求(移动)：</label>
												<div class="col-md-8">
													<input type="text" class="form-control" placeholder="" id="towerwhoyd" name="towerwhoyd" value="${towersPage.tower.towerwhoyd}">
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">运营商需求(电信)：</label>
												<div class="col-md-8">
													<input type="text" class="form-control" placeholder="" id="towerwhodx" name="towerwhodx" value="${towersPage.tower.towerwhodx}">
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row">
										<div class="col-md-6" id="row11">

											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4">运营商需求(联通)：</label>
														<div class="col-md-8">
															<input type="text" class="form-control" placeholder="" id="towerwholt" name="towerwholt" value="${towersPage.tower.towerwholt}">
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4">目标谈址佣金（元）：    </label>
														<div class="col-md-8">
															<input type="text" class="form-control" placeholder="" id="towerfee" name="towerfee" value="${towersPage.tower.towerfee}">
														</div>
													</div>
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6 " id="row22">
											<div class="form-group">
												<label class="control-label col-md-4">站址描述：	</label>
												<div class="col-md-8">
													<textarea class="form-control" rows="4" id="towerinfo" name="towerinfo" >${towersPage.tower.towerinfo}</textarea>
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row">
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">目标租金（元）：  </label>
												<div class="col-md-8">
													<input type="text" class="form-control" placeholder="" id="towerrentfee" name="towerrentfee" value="${towersPage.tower.towerrentfee}">
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">主选经纬度：</label>
												<div class="col-md-8">

													<input type="text" class="form-control input-small col-md-6" placeholder="" name="towerj" id="towerj" value="${towersPage.tower.towerj}">

													<input type="text" class="form-control input-small col-md-6" placeholder="" name="towerw" id="towerw" value="${towersPage.tower.towerw}">

												</div>
											</div>
										</div>

									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">备选经纬度一：</label>
												<div class="col-md-8">

													<input type="text" class="form-control input-small col-md-6" placeholder="" id="towerfirstj" name="towerfirstj" value="${towersPage.tower.towerfirstj}">

													<input type="text" class="form-control input-small col-md-6" placeholder="" id="towerfirstw" name="towerfirstw" value="${towersPage.tower.towerfirstw}">

												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">备选经纬度二：</label>
												<div class="col-md-8">

													<input type="text" class="form-control input-small col-md-6" placeholder="" id="towersecondj" name="towersecondj" value="${towersPage.tower.towersecondj}">

													<input type="text" class="form-control input-small col-md-6" placeholder="" id="towersecondw" name="towersecondw" value="${towersPage.tower.towersecondw}">

												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">选址联系人姓名：</label>
												<div class="col-md-8">
													<input type="text" class="form-control" placeholder="" id="towermanagername" name="towermanagername" value="${towersPage.tower.towermanagername}">
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">选址联系人电话：   </label>
												<div class="col-md-8">
													<input type="text" class="form-control" placeholder="" id="towermanager" name="towermanager" value="${towersPage.tower.towermanager}">
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">站址类型：</label>
												<div class="col-md-8">
													
													<select class="form-control input-small col-md-6" id="towerstyle" name="towerstyle">
											         	 <c:forEach items="${towersPage.towerStyles }" var="towerstyle">
      							 					  		 <option value="${towerstyle.id }" <c:if test='${towerstyle.id==towersPage.tower.towerstyle }'>selected="selected"</c:if>  >${towerstyle.name }</option>
      												  	</c:forEach>
										             </select>
													<select class="form-control input-small col-md-6" id="towertype" name="towertype">
											             <c:forEach items="${towersPage.towerTypes }" var="towertype">
      							 					  		 <option value="${towertype.id }" <c:if test='${towertype.id==towersPage.tower.towertype }'>selected="selected"</c:if>  >${towertype.towertypename }</option>
      												  	</c:forEach>
										              </select>
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">自定义编号：</label>
												<div class="col-md-8">
													<input type="text" class="form-control" placeholder="" id="toweridefined" name="toweridefined" value="${towersPage.tower.toweridefined}">
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">站址库：	</label>
												<div class="col-md-8">
													<select class="form-control input-small col-md-6" id="towerstore" name="towerstore">
      												<c:forEach items="${towersPage.towerStores }" var="store" >
      							 					 <option value="${store.storeid }" <c:if test='${store.storeid==towersPage.tower.towerstore }'>selected="selected"</c:if>  >${store.storename }</option>
      												</c:forEach>             
										             </select>

												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">租用面积（m²）：</label>
												<div class="col-md-8">
													<input type="text" class="form-control" placeholder="" id="towerlarge" name="towerlarge" value="${towersPage.tower.towerlarge}">
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-4">建站类型：  </label>
												<div class="col-md-8">
													<select class="form-control input-small col-md-6" id="towercreatetype" name="towercreatetype">
      												<c:forEach items="${towersPage.towerCreateTypes }" var="type">
      							 					 <option value="${type.id }" <c:if test='${type.id==towersPage.tower.towercreatetype }'>selected="selected"</c:if>  >${type.name }</option>
      												</c:forEach>             
										             </select>
												</div>
											</div>
										</div>
										<!--/span-->

										<!--/span-->
									</div>

								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-6">
											<div class="row">
												<div class="col-md-offset-3 col-md-8">
													<button type="submit"  class="btn green"><i class="fa fa-pencil"></i> 保存此站址</button>
													<c:if test="${towersPage.tower.id>0}">
													<button type="button" onclick="go" class="btn default">返回</button>
													</c:if>
												</div>
											</div>
										</div>
										<div class="col-md-6">
										</div>
									</div>
								</div>
								
								<input type="hidden" id="id" name="id" value="${towersPage.tower.id}" />
								<input type="hidden" id="towervisible" name="towervisible" value="${towersPage.tower.towervisible}" />
								
							</form>
							<!-- END FORM-->
						</div>
					</div>

				</div>
				<div class="tab-pane" id="tab_1">
					<div class="portlet box blue">
						
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form action="#" class="horizontal-form">
								<div class="form-body">
									
								</div>
								<div class="form-actions right">
									<button type="button" class="btn default">Cancel</button>
									<button type="submit" class="btn blue"><i class="fa fa-check"></i> Save</button>
								</div>
							</form>
							<!-- END FORM-->
						</div>
					</div>
					<div class="portlet light bordered">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-equalizer font-blue-hoki"></i>
								<span class="caption-subject font-blue-hoki bold uppercase">Form Sample</span>
								<span class="caption-helper">demo form...</span>
							</div>
							<div class="tools">
								<a href="" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="" class="reload">
								</a>
								<a href="" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form action="#" class="horizontal-form">
								<div class="form-body">
								</div>
								<div class="form-actions right">
									<button type="button" class="btn default">Cancel</button>
									<button type="submit" class="btn blue"><i class="fa fa-check"></i> Save</button>
								</div>
							</form>
							<!-- END FORM-->
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>


<script src="<%=basePath%>assets/js/page/tower/tower.js"></script>
<script src="<%=basePath%>assets/js/page/tower/31/tower_edit.js"></script>