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
<title>渠道管理系统-用户管理</title>
<jsp:include page="/view/common/head.jsp"></jsp:include>
<script type="text/javascript" src="${path }/static/js/chosen-pri.js"></script>

</head>
<script type="text/javascript">
$(function(){
	function loadDealer(){
		$.ajax({
			  type: 'POST',
			  url: contextPath + '/dealer/listDC',
			  data:{},
			  success: function(data){
				  if(data!=null && data.aaData!=null){
					  $.each(data.aaData,function(i){
							$("#user-dealer").append("<option value='"+data.aaData[i].dealerCode+"'>"+data.aaData[i].dealerName+"</option>");
					  });
					  if($("#user-dealer").attr("data-value")!=null && $("#user-dealer").attr("data-value")!=""){
						  chose_mult_set_ini("#user-dealer",$("#user-dealer").attr("data-value"));
					  }
				  }
				  $("#user-dealer").chosen({
				        no_results_text: "未发现匹配的字符串!",
				    	allow_single_deselect: true,
				    	width:"100%"
			   	  });
			  },
			  dataType:'json'
		});
	}
	function sort(){
		var i = 0;
		$(".udealer-add").each(function(){
			$(this).find(".user-dealer-code").attr("name","userDealers["+i+"].dealer.dealerCode");
			$(this).find(".user-dealer-name").attr("name","userDealers["+i+"].dealer.dealerName");
			$(this).find(".user-dealer-role").attr("name","userDealers["+i+"].userPostion");
			i++;
		});
	}
	function init(){
		$(".chosen").not("#user-dealer").each(function(){
			$(this).val($(this).attr("data-value"));
			$(this).chosen({
		        no_results_text: "未发现匹配的字符串!",
		    	allow_single_deselect: true,
		    	width:"100%"
	   		});
		});
		ztree_input("radio", contextPath + '/department/deptTree', $("#user-department"));
		loadDealer();
	}
	$("#user-type").change(function(){
		$("#department-area").addClass("hide").hide();
		$("#dealer-area").addClass("hide").hide();
		$(".udealer-add").remove();
		if($(this).val()!=null && $(this).val()!=""){
			if($(this).val() == '01'){
				$("#department-area").removeClass("hide").show();
				$("#user-department").trigger("chosen:updated");
			} else {
				$("#dealer-area").removeClass("hide").show();
				$("#user-dealer").trigger("chosen:updated");
			}
		}
	});
	$(document).delegate('#user-dealer','change',function(evt, params){
		if(params.selected != undefined){
			var id = params.selected;
			var html = '<div class="form-group udealer-add"><div class="col-sm-6 col-sm-12"><label class="control-label col-sm-4">所属机构</label><div class="col-sm-7">';
			html += '<input class="input form-control user-dealer-name" readonly value="'+$("#user-dealer [value='"+id+"']").text()+'"><input type="hidden" class="user-dealer-code" value="'+id+'"></div></div>';
			html += '<div class="col-sm-6 col-sm-12"><label class="control-label col-sm-4">用户角色</label><div class="col-sm-7">';
			html += '<select class="select required form-control user-dealer-role" id="user-dealer-'+id+'"></select></div></div></div>';
			
			$("#dealer-area").after(html);
			$("#user-dealer-"+id).append($("#hidden-dealer-role").html());
			$("#user-dealer-"+id).chosen({
		        no_results_text: "未发现匹配的字符串!",
		    	allow_single_deselect: true,
		    	width:"100%",
		    	disable_search_threshold:10
	   		});
		} else {
			var id = params.deselected;
			$("#user-dealer-"+id).parent().parent().parent().remove();
		}
		sort();
	});
	$("#fn-btn-save").click(function() {
		validate();
		if ($(".error").length!=0) {
			return flag;
		}
		if($("input[name='userName']").val().trim()=='admin'){
			$("input[name='userName']").fieldError("用户名不可为admin");
			return false;
		}
		if($("#user-type").val()!='01'){
			$("#user-department").attr("name","");
			$("#user-department").siblings(":hidden").attr("name","");
			$("#user-role").attr("name","");
		}
		$("#fn-save-form").attr("action", "${path}/user/save?juid="+juid);
		$("#fn-save-form").submit();
	});
	
	init();
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
										<cs:select class="form-control chosen" dicField="_user_type" name="userType" id="user-type" allowBlank="true" value="${user.userType }"/>
										<cs:select class="form-control hide" dicField="_c_role" id="hidden-role" allowBlank="true"/>
										<cs:select class="form-control hide" dicField="_d_role" id="hidden-dealer-role" allowBlank="true"/>
									</div>
								</div>
							</div>
							<c:if test="${user.userDeparment==null }">
								<div class="form-group hide" id="department-area">
									<div class="col-sm-6 col-sm-12">
										<label class="control-label col-sm-4">所属机构</label>
										<div class="col-sm-7">
											<input class="form-control required" id="user-department" name='userDeparment.departmentName' readonly>
											<input type="hidden" id="user-department" name='userDeparment.departmentId'>
										</div>
									</div>
									<div class="col-sm-6 col-sm-12">
										<label class="control-label col-sm-4">用户角色</label>
										<div class="col-sm-7" id="user-role-area">
											<select class="form-control required chosen" id="user-role"  name='userDeparment.userPostion'>
												<option value="">--请选择--</option>
											</select>
										</div>
									</div>
								</div>
							</c:if>
							<c:if test="${user.userDeparment!=null && user.userType == '01'}">
								<div class="form-group" id="department-area">
									<div class="col-sm-6 col-sm-12">
										<label class="control-label col-sm-4">所属机构</label>
										<div class="col-sm-8">
											<input class="form-control required" id="user-department" name='userDeparment.departmentName' readonly value="${user.userDeparment.departmentName }">
											<input type="hidden" id="user-department" name='userDeparment.departmentId' value="${user.userDeparment.departmentId }">
										</div>
									</div>
									<div class="col-sm-6 col-sm-12">
										<label class="control-label col-sm-4">用户角色</label>
										<div class="col-sm-7" id="user-role-area">
											<select class="form-control required" id="user-role"  name='userDeparment.userPostion' data-value="${user.userDeparment.userPostion }">
												<option value="">--请选择--</option>
											</select>
										</div>
									</div>
								</div>
							</c:if>
							<c:if test="${user.userDealers==null || fn:length(user.userDealers) == 0}">
								<div class="form-group hide" id="dealer-area">
									<div class="col-sm-6 col-sm-12">
										<label class="control-label col-sm-4">所属机构</label>
										<div class="col-sm-7">
											<select class="select form-control required" name="" id="user-dealer" multiple>
											
											</select>
										</div>
									</div>
								</div>
							</c:if>
							<c:if test="${user.userDealers!=null && fn:length(user.userDealers)!=0 }">
								<div class="form-group" id="dealer-area">
									<div class="col-sm-6 col-sm-12">
										<label class="control-label col-sm-4">所属机构</label>
										<div class="col-sm-7">
											<select class="select form-control required" name="" id="user-dealer" multiple data-value="${user.dealerCode }">
											</select>
										</div>
									</div>
								</div>
								<c:forEach items="${user.userDealers }" var="userDealer" varStatus="status">
									<div class="form-group udealer-add">
										<div class="col-sm-6 col-sm-12">
											<label class="control-label col-sm-4">所属机构</label>
											<div class="col-sm-7">
												<input class="input form-control user-dealer-name" readonly value="${userDealer.dealer.dealerName }" name="userDealers[${status.index }].dealer.Name">
												<input type="hidden" class="user-dealer-code" value="${userDealer.dealer.dealerCode }" name="userDealers[${status.index }].dealer.dealerCode">
											</div>
										</div>
										<div class="col-sm-6 col-sm-12">
											<label class="control-label col-sm-4">用户角色</label>
											<div class="col-sm-7">
												<cs:select class="select required form-control user-dealer-role chosen" dicField="_d_role"  id="user-dealer-${userDealer.dealer.dealerCode }" allowBlank="true" name="userDealers[${status.index }].userPostion" value="${userDealer.userPostion }"/>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:if>
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
