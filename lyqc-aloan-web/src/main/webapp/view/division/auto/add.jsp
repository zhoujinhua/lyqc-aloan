<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://javass.cn/common/" prefix="cs"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", path);
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>催收大平台-分单管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<script type="text/javascript">
	$(function(){
		$("#fn-btn-save").click(function(){
			validate();
			if($(".error").length!=0){
				return false;
			}
			$("#fn-save-form").attr("action","${path}/division/save?juid="+juid);
			$("#fn-save-form").submit();
		});	
	});
</script>
<body>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">分单管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/division/auto/list.jsp">分单管理</a>
	        </li>
	        <li>
	            <a href="#">规则维护</a>
	        </li>
	    </ul>
		<div class="row">
			<c:if test="${msg!=null && msg!=''}">
				<div class="col-md-12">
					<div class="alert alert-info alert-dismissible col-md-12" role="alert">
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					  ${msg }
					</div>
				</div>
			</c:if>
			<div class="box col-md-12">
			   	<div class="box-inner">
		      	   <div class="box-header well" data-original-title="">
			           <h2><i class="glyphicon glyphicon-edit"></i> 表单元素</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<form id="fn-save-form" class="form-horizontal" method="post">
		                    <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">规则名称<i class="glyphicon glyphicon-star red"></i></label>
		                        <div class="col-sm-8">
		                        	<input type="hidden" name="id" value="${rule.id }"	>
	                       	 		<input type="text" class="form-control required" name="name" maxlength="20" value="${rule.name }">
		                        </div>
		                     </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">规则类型<i class="glyphicon glyphicon-star red"></i></label>
		                         <div class="col-sm-8">
		                         	<cs:select class="form-control required chosen" dicField="_division_type" name="type" allowBlank="true" value="${rule.type }"/>
		                        </div>
		                    </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">是否有效<i class="glyphicon glyphicon-star red"></i></label>
		                         <div class="col-sm-8">
		                         	<cs:select class="form-control required chosen" dicField="_is" name="status" allowBlank="true" value="${rule.status }"/>
		                        </div>
		                    </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">分单依赖<i class="glyphicon glyphicon-star red"></i></label>
		                         <div class="col-sm-8">
		                         	<cs:select class="form-control required chosen" dicField="_division_depend" name="depend" allowBlank="true" value="${rule.depend }"/>
		                        </div>
		                    </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">值域(左开右闭)<i class="glyphicon glyphicon-star red"></i></label>
		                         <div class="col-sm-8">
		                         	<div style="padding-left: 0px; float: left; width: 47%; padding-right: 10px;">
			        					<cs:input class="form-control required" type="float" value="${rule.min }" name="min" maxlength="5"/>
					        		</div>
 										<div style="margin-left: 2%; float: left;">&mdash;</div>
					        		<div style="padding-right: 0px; padding-left: 10px; float: right; width: 47%;">
						        		<cs:input class="form-control required" type="float" value="${rule.max }" name="max" maxlength="5"/>
					        		</div>
		                        </div>
		                    </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">备注</label>
		                         <div class="col-sm-8">
		                         	<textarea rows="3" maxlength="1000" name="remark" class="form-control">${rule.remark }</textarea>
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
