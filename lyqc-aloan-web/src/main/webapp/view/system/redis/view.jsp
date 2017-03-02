<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/common.tld" prefix="cs"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", path);
request.setAttribute("basePath", basePath);
String type = request.getParameter("type");
String key = request.getParameter("key");
request.setAttribute("type", type);
request.setAttribute("key", key);
String juid = request.getParameter("juid");
request.setAttribute("juid", juid);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>渠道管理系统-缓存管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
    <script src="${path}/static/weblib/ace/js/ace.js" type="text/javascript" charset="utf-8"></script>
	<script src="${path}/static/weblib/beautify/beautify.js" type="text/javascript" charset="utf-8"></script>
	<style type="text/css">
		.checked{
			background-color:#676e7e;
		    color:#ffffff;
		}
    </style>
</head>
<script type="text/javascript">
	$(function(){
		$(document).delegate('#data-table tbody tr','click',function() {
	    	$(this).parent().find(".checked").removeClass("checked");
			$(this).addClass("checked");
			
			var html = $(this).find("td:nth-child(2)").html();
			window.frames[0].setValue(html);
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
			           		<cs:table id="data-table" size="8" class="table table-bordered responsive" onrender="${path }/redis/listValues?type=${type }&key=${key }">
			           			<cs:column dataField="field_" name="字段KEY" width="20%"/>
			           			<cs:column dataField="value_" name="字段VALUE" width="80%"/>
			           		</cs:table>
			           </div>
	               	</div>
		      	</div>
		    </div>
			<div class="box col-md-12">
			   	<div class="box-inner">
		      	   <div class="box-header well" data-original-title="">
			           <h2><i class="glyphicon glyphicon-edit"></i> 详细信息</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<div class="box-content">
			           		<iframe id="ace-editor" src="${path }/view/system/redis/editor.jsp?juid=${juid}" style="width: 100%;height: 96%;border:none;" frameborder="0"></iframe>
			           </div>
	               	</div>
		      	</div>
		    </div>
		</div>
	</div>
</body>
</html>
