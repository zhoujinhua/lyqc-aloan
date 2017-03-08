<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/common.tld" prefix="cs"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", path);
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>催收大平台-部门管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<script type="text/javascript">
	$(function(){
		ztree_input("radio", contextPath + '/department/deptTree', $("#par-department-id"));
		
		$("#fn-btn-save").click(function(){
			validate();
			if($(".error").length!=0){
				return false;
			}
			$("#fn-save-form").attr("action","${path}/department/save?juid="+juid);
			$("#fn-save-form").submit();
		});	
		init();
	});
</script>
<body>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">系统管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/system/department/list.jsp">部门管理</a>
	        </li>
	        <li>
	            <a href="#">部门维护</a>
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
			<div id="deptTree" class="ztree" ></div>
			<div id="argTree" class="ztree" ></div>
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
		                        <label class="control-label col-sm-4">部门名称</label>
		                        <div class="col-sm-8">
		                        	<input type="hidden" name="departmentId" value="${department.departmentId }"	>
	                       	 		<input type="text" class="form-control required" name="departmentName" maxlength="20" value="${department.departmentName }" data-placement="top" title="不可为空.">
		                        </div>
		                     </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">上级部门</label>
		                         <div class="col-sm-8">
		                         	<input class="form-control" name="parDepartment.departmentName" id="par-department-id" readonly/>
		                         	<input type="hidden" name="parDepartment.departmentId"/>
		                        </div>
		                    </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">是否启用</label>
		                         <div class="col-sm-8">
		                         	<cs:select class="form-control required chosen" id="department-status" dicField="_is" name="status" allowBlank="true" value="${department.status }"/>
		                        </div>
		                    </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">描述</label>
		                         <div class="col-sm-8">
		                         	<textarea rows="3" maxlength="100" name="remark" class="form-control">${department.remark }</textarea>
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
