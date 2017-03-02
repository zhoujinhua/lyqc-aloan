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
    <title>渠道管理系统-门店管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<body>
	<script type="text/javascript">
	 $(document).delegate('#fn-btn-search','click',function() {
		reload("data-table");
	 });
	 $(document).delegate('#fn-btn-add','click',function() {
		 location.href="${path}/view/dealer/dealer/add.jsp?juid="+juid;
	 });
	 function operator(data, type, full, meta){
		 var html = '<a data-id='+data+' href="'+contextPath+'/dealer/view?dealerCode='+data+'">查看</a>';
   		 html += ' <a class="edit" data-id='+data+' href="'+contextPath+'/dealer/edit?dealerCode='+data+'">编辑</a>';
    	 return	data=html;
	 }
	</script>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">经销商管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/dealer/dealer/list.jsp">门店管理</a>
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
		                        <label class="control-label col-sm-1">门店编码</label>
		                        <div class="col-sm-3">
		                        	<cs:input type="int" maxlength="8" class="form-control" name="dealerCode" renderId="data-table"></cs:input>
		                        </div>
		                        <label class="control-label col-sm-1">门店名称</label>
		                         <div class="col-sm-3">
		                         	<cs:input type="text" maxlength="20" class="form-control" name="dealerName" renderId="data-table"></cs:input>
		                        </div>
		                        <label class="control-label col-sm-1">是否启用</label>
		                        <div class="col-sm-3">
			                        <cs:select dicField="_is" class="form-control chosen" name="status" allowBlank="true" renderId="data-table" />
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <label class="control-label col-sm-1">单位编码</label>
		                        <div class="col-sm-3">
		                        	<cs:input type="int" maxlength="5" class="form-control" name="companyCode" renderId="data-table"></cs:input>
		                        </div>
		                        <label class="control-label col-sm-1">单位名称</label>
		                         <div class="col-sm-3">
		                        	<cs:input type="text" maxlength="20" class="form-control" name="companyName" renderId="data-table"></cs:input>
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
		           		<cs:table id="data-table" class="table table-striped table-bordered responsive" onrender="${path }/dealer/list">
	           				<cs:column dataField="dealerName" name="门店名称"></cs:column>
	           				<cs:column dataField="dealerCode" name="门店编码"></cs:column>
	           				<cs:column dataField="company.companyName" name="单位名称"></cs:column>
	           				<cs:column dataField="company.companyCode" name="单位编码"></cs:column>
	           				<cs:column dataField="dealerType" name="门店类型" type="dict" format="_dealer_type"></cs:column>
	           				<cs:column dataField="province" name="所在省"></cs:column>
	           				<cs:column dataField="city" name="所在城市"></cs:column>
	           				<cs:column dataField="status" name="是否启用" type="dict" format="_is"></cs:column>
	           				<cs:column dataField="createTime" name="创建时间" type="date" format="YYYY-MM-DD"></cs:column>
	           				<cs:column dataField="dealerCode" name="操作" renderFn="operator"></cs:column>
		           		</cs:table>
		           </div>
		       </div>
	       </div>
       </div>
	</div>
</body>
</html>
