<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/common.tld" prefix="cs"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", path);
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>渠道管理系统-模板管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">系统管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/param/model/list.jsp">模板管理</a>
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
			           <h2><i class="glyphicon glyphicon-edit"></i> 查询条件</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<form id="fn-search-form" class="form-horizontal" method="post">
		                    <div class="form-group">
		                    	<div class="col-sm-6 col-sm-12">
			                        <label class="control-label col-sm-4">模板名称</label>
			                        <div class="col-sm-7">
			                        	<cs:input name="name" maxlength="20" class="form-control" renderId="data-table"></cs:input>
			                        </div>
		                        </div>
		                    	<div class="col-sm-6 col-sm-12">
			                        <label class="control-label col-sm-4">模板代码</label>
			                        <div class="col-sm-7">
			                        	<cs:input name="code" maxlength="20" class="form-control" renderId="data-table"></cs:input>
			                        </div>
		                        </div>
		                    </div>
		                     <div class="form-group">
		                        <div class="col-sm-6 col-sm-12">
			                        <label class="control-label col-sm-4">模板类型</label>
			                         <div class="col-sm-7">
			                         	<cs:select class="form-control chosen" name="modelType" dicField="_model_type" renderId="data-table"></cs:select>
			                        </div>
		                        </div>
		                     	 <div class="col-sm-6 col-sm-12">
			                        <label class="control-label col-sm-4">模板状态</label>
			                         <div class="col-sm-7">
			                         	<cs:select class="form-control chosen" name="status" dicField="_is" renderId="data-table"></cs:select>
			                        </div>
		                        </div>
		                     </div>
		                     <div class="form-group">
			                     <div class="col-sm-12">
				                    <p class="center-block">
				                        <a href="#" class="btn btn-primary btn-mini" id="fn-btn-search"><i class="glyphicon glyphicon-search"></i> 查询</a>
				                        <a href="#" class="btn btn-default btn-mini" id="fn-btn-add"><i class="glyphicon glyphicon-plus"></i> 新增</a>
				                    </p>
				                </div>
			                </div>
		                </form>
	               	</div>
		      	</div>
		    </div>
		</div>
	    <div class="row">
	    	<div class="box col-md-12">
		      	<div class="box-inner">
		      	   <div class="box-header well" data-original-title="">
			           <h2><i class="glyphicon glyphicon-th"></i> 查询结果</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<cs:table id="data-table" class="table table-striped table-bordered responsive" onrender="${path }/model/list">
		           			<cs:column dataField="name" name="模板名称"/>
		           			<cs:column dataField="code" name="模板代码"/>
		           			<cs:column dataField="modelType" name="模板类型" type="dict" format="_announce_type"/>
		           			<cs:column dataField="status" name="是否启用" type="dict" format="_is"/>
		           			<cs:column dataField="postType" name="模板描述"/>
		           			<cs:column dataField="createTime" name="创建时间" type="date" format="YYYY-MM-DD"/>
		           			<cs:column dataField="id" name="操作" renderFn="operator"/>
		           		</cs:table>
		           </div>
		       </div>
	       </div>
       </div>
	</div>
</body>
</html>
