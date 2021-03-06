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
    <title>渠道管理系统-缓存管理</title>
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
	            <a href="${path }/view/system/redis/list.jsp">缓存管理</a>
	        </li>
	        <li>
	            <a href="#">缓存维护</a>
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
			           <h2><i class="glyphicon glyphicon-edit"></i> 值列表</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<div class="box-content">
			           		<form id="fn-save-form" class="form-horizontal" method="post" action="${path }/redis/save">
			                    <div class="form-group col-sm-12 col-sm-8">
			                        <label class="control-label col-sm-4">缓存类型<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-8">
			                        	<cs:select allowBlank="true" name="type_" dicField="_redis_type" class="form-control required chosen"></cs:select>
			                        </div>
			                     </div>
			                     <div class="form-group col-sm-12 col-sm-8">
			                        <label class="control-label col-sm-4">时效<i class="glyphicon glyphicon-star red"></i></label>
			                         <div class="col-sm-8">
			                         	<cs:input type="int" class="form-control required" name="ttl_" maxlength="9"></cs:input>
			                        </div>
			                    </div>
			                     <div class="form-group col-sm-12 col-sm-8">
			                        <label class="control-label col-sm-4">键<i class="glyphicon glyphicon-star red"></i></label>
			                         <div class="col-sm-8">
			                        	<input type="text" class="form-control required" name="key_" maxlength="50">
			                        </div>
			                    </div>
			                     <div class="form-group col-sm-12 col-sm-8">
			                        <label class="control-label col-sm-4">值<i class="glyphicon glyphicon-star red"></i></label>
			                         <div class="col-sm-8">
			                         	<textarea rows="" cols="" class="form-control autogrow required" name="value_" maxlength="1000"></textarea>
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
	</div>
</body>
</html>
