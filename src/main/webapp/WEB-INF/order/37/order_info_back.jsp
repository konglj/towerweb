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
<div class="form-actions">
	<div class="row">
		<div class="col-md-4">
		</div>
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
			</div>
		</div>
	</div>
</div>