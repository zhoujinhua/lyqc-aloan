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
    <title>催收大平台-客户信息管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<body>
	<script type="text/javascript">
		$(function(){
			$(document).delegate('#fn-btn-search','click',function() {
				reload("data-table");
		 	});
			ztree_input("radio", contextPath + '/user/userTree', $("#coll-user"));
		});
	</script>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">分单管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/division/log/list.jsp">分单日志</a>
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
		           		<form id="fn-search-form" class="form-horizontal" method="post" >
		                    <div class="form-group">
		                        <label class="control-label col-sm-1">申请编号</label>
		                        <div class="col-sm-3">
		                        	<cs:input class="form-control" maxlength="20" name="appCode" renderId="data-table"/>
		                        </div>
		                        <label class="control-label col-sm-1">催收人员</label>
		                        <div class="col-sm-3">
		                        	<cs:input class="form-control" id="coll-user" readonly="true" name="userId" renderId="data-table"/>
		                        </div>
		                     </div>
		                     <div class="form-group">
			                     <div class="col-sm-12">
				                    <p class="center-block">
				                        <a href="#" class="btn btn-primary btn-mini" id="fn-btn-search"><i class="glyphicon glyphicon-search"></i> 查询</a>
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
			               <a href="#" class="btn btn-minimize btn-round btn-default">
			               		<i class="glyphicon glyphicon-chevron-up"></i>
			               	</a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<cs:table id="data-table" class="table table-striped table-bordered responsive" onrender="${path }/divisionLog/list">
		           			<cs:column dataField="appCode" name="申请编号"/>
		           			<cs:column dataField="userName" name="催收员"/>
		           			<cs:column dataField="assignType" name="分配类型" type="dict" format="_assign_type"/>
		           			<cs:column dataField="remark" name="备注"/>
		           			<cs:column dataField="assignDate" name="分配日期" type="date" format="YYYY-MM-DD"/>
		           		</cs:table>
		           </div>
		       </div>
	       </div>
       </div>
	</div>
</body>
</html>
