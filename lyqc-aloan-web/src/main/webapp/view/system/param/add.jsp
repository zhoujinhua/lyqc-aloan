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
    <title>渠道管理系统-数据字典管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<script type="text/javascript">
	$(function(){
	  	$("#fn-btn-save").click(function() {
	  		validate();
	  		if($(".error").length!=0){
	  			return false;
	  		}
            $("#fn-save-form").submit();
         });
	});
</script>
<body>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">系统管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/system/param/list.jsp">参数管理</a>
	        </li>
	        <li>
	            <a href="#">参数维护</a>
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
		           		<form id="fn-save-form" class="form-horizontal" method="post" action="${path }/param/save">
		                    <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">参数名称<i class="glyphicon glyphicon-star red"></i></label>
		                        <div class="col-sm-8">
		                        	<input type="hidden" name="id" value="${parameter.id }">
	                       	 		<input type="text" class="form-control required" name="name" maxlength="10" value="${parameter.name}">
		                        </div>
		                     </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">参数KEY<i class="glyphicon glyphicon-star red"></i></label>
		                         <div class="col-sm-8">
		                        	<input type="text" class="form-control required" name="key" maxlength="25" value="${parameter.key}">
		                        </div>
		                    </div>
		                    <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">参数值<i class="glyphicon glyphicon-star red"></i></label>
		                         <div class="col-sm-8">
		                         	<input type="text" class="form-control required" name="value" maxlength="50" value="${parameter.value}">
		                        </div>
		                    </div>
		                    <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">所属分组<i class="glyphicon glyphicon-star red"></i></label>
		                         <div class="col-sm-8">
		                         	<cs:select class="form-control required chosen" dicField="_param_group" name="group" allowBlank="true" value="${parameter.group }"/>
		                        </div>
		                    </div>
		                     <div class="form-group col-sm-12 col-sm-8">
		                        <label class="control-label col-sm-4">备注</label>
		                         <div class="col-sm-8">
		                         	<textarea rows="" cols="" class="form-control autogrow" name="remark">${parameter.remark }</textarea>
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
