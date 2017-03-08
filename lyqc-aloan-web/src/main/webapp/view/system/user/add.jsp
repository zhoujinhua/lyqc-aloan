<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="/WEB-INF/tld/common.tld" prefix="cs"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", path);
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<title>催收大平台-用户管理</title>
<jsp:include page="/view/common/head.jsp"></jsp:include>
<script type="text/javascript" src="${path }/static/js/chosen-pri.js"></script>

</head>
<script type="text/javascript">
$(function(){
	$("#fn-btn-save").click(function() {
		validate();
		if ($(".error").length!=0) {
			return flag;
		}
		if($("input[name='userName']").val().trim()=='admin'){
			$("input[name='userName']").fieldError("用户名不可为admin");
			return false;
		}
		$("#fn-save-form").attr("action", "${path}/user/save?juid="+juid);
		$("#fn-save-form").submit();
	});
	
	ztree_input("radio", contextPath + '/department/deptTree', $("#user-department"));
});
</script>
<body id="inner-body">
	<div class="ch-container">
		<ul class="breadcrumb">
			<li><a href="#">系统管理</a></li>
			<li><a href="${path }/view/system/user/list.jsp">用户管理</a></li>
			<li><a href="#">用户新增</a></li>
		</ul>
		<div class="row">
			<c:if test="${msg!=null && msg!=''}">
				<div class="col-md-12">
					<div class="alert alert-info alert-dismissible col-md-12"
						role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						${msg }
					</div>
				</div>
			</c:if>
			<div class="box col-md-12">
				<div class="box-inner">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-edit"></i> 表单元素
						</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form id="fn-save-form" class="form-horizontal" method="post">
							<div class="form-group">
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">用户名</label>
									<div class="col-sm-7">
										<input type="hidden" name="userId" value="${user.userId }">
										<input type="hidden" name="userDeparment.userId" value="${user.userId }">
										<input type="text" class="form-control required" name="userName" maxlength="20" value="${user.userName }">
									</div>
								</div>
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">寄送地址</label>
									<div class="col-sm-7">
										<input type="text" class="form-control required" name="address" maxlength="20" value="${user.address }">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">真实姓名</label>
									<div class="col-sm-7">
										<input type="text" class="form-control required" name="trueName" maxlength="20" value="${user.trueName }">
									</div>
								</div>
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">性别</label>
									<div class="col-sm-7">
										<cs:select class="form-control required chosen" dicField="_sex" name="sex" allowBlank="true" value="${user.sex }"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">手机号码</label>
									<div class="col-sm-7">
										<input type="text" class="form-control required" name="phone" maxlength="20" value="${user.phone }">
									</div>
								</div>
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">E-Mail</label>
									<div class="col-sm-7">
										<input type="text" class="form-control required" name="email" maxlength="50" value="${user.email }">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">证件类型</label>
									<div class="col-sm-7">
										<cs:select class="form-control required chosen" dicField="_id_type" name="cardType" allowBlank="true" value="${user.cardType }"/>
									</div>
								</div>
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">证件号码</label>
									<div class="col-sm-7">
										<input type="text" class="form-control required" name="cardId" maxlength="20" value="${user.cardId }">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">邮政编码</label>
									<div class="col-sm-7">
										<input type="text" class="form-control required" name="postalCode" maxlength="20" value="${user.postalCode }">
									</div>
								</div>
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">用户类型</label>
									<div class="col-sm-7">
										<cs:select class="form-control chosen" dicField="_user_type" dicFilter="01" name="userType" id="user-type" value="${user.userType }"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">所属机构</label>
									<div class="col-sm-7">
										<input class="form-control required" id="user-department" name='userDeparment.departmentName' readonly value="${user.userDeparment.departmentName }">
										<input type="hidden" id="user-department" name='userDeparment.departmentId' value="${user.userDeparment.departmentId }">
									</div>
								</div>
								<div class="col-sm-6 col-sm-12">
									<label class="control-label col-sm-4">用户角色</label>
									<div class="col-sm-7">
										<cs:select class="form-control required chosen" dicField="_c_role" allowBlank="true" value="${user.userDeparment.userPostion }" name="userDeparment.userPostion"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<p class="center-block">
										<a href="#" class="btn btn-primary btn-mini" id="fn-btn-save"><i class="glyphicon glyphicon-ok"></i> 保存</a>
									</p>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
