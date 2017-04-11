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
    <title>催收大平台-Redis缓存管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
    <style type="text/css">
    	.large-dialog{
    		width:540px !important;
    		color:blue;
    	}
    </style>
</head>
<body>
	<script type="text/javascript">
		function operator(data, type, full, meta){
			var html = '';
    		html += ' <a class="link" href= "'+contextPath+'/view/system/redis/view.jsp?key='+data+'&type='+full.type_+'">查看</a>';
    		html += ' <a class="link delete" key="'+data+'" href= "javascript:;">删除</a>';
	    	return	data=html;
		}
		$(document).delegate('#fn-btn-search','click',function() {
		    reload("data-table");	
	    });
	    $(document).delegate('#fn-btn-add','click',function() {
		    window.location.href = contextPath + '/view/system/redis/add.jsp?juid='+juid;
	    });
	    $(document).delegate('#fn-btn-flush','click',function() {
		    window.location.href = contextPath + '/redis/flushAll?juid='+juid;
	    });
	    $(document).delegate('#fn-btn-build','click',function() {
		    window.location.href = contextPath + '/redis/build?juid='+juid;
	    });
	    $(document).delegate('.delete','click',function() {
	    	var key = $(this).attr("key");
	    	$.confirm("确定从缓存数据库中清除key为["+key+"]的值吗?",function(ok){
	    		if(ok){
	    			location.href="${path}/redis/delete?key="+key+"&juid="+juid;
	    		}
	    	});
	    });
	    $(document).delegate('#fn-btn-mointor','click',function() {
	    	$.ajax({
				type: 'POST',
				url: contextPath + '/redis/monitor',
				data:{},
				success: function(data){
					$.alert({
						"cssClass":"large-dialog",
						"content":data
					});
				},
				dataType: 'text'
			});
	    });
	</script>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">系统管理</a>
	        </li>
	        <li>
	            <a href="#">缓存管理</a>
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
			                        <label class="control-label col-sm-4">缓存KEY</label>
			                        <div class="col-sm-7">
		                       	 		<cs:input type="text" class="form-control" name="appKey" maxlength="20" renderId="data-table"/>
			                        </div>
		                        </div>
		                    </div>
		                     <div class="form-group">
			                     <div class="col-sm-12">
				                    <p class="center-block">
				                        <a href="#" class="btn btn-primary btn-mini" id="fn-btn-search"><i class="glyphicon glyphicon-search"></i> 查询</a>
				                        <a href="#" class="btn btn-default btn-mini" id="fn-btn-add"><i class="glyphicon glyphicon-plus"></i> 新增</a>
				                        <a href="#" class="btn btn-danger btn-mini" id="fn-btn-flush"><i class="glyphicon glyphicon-trash"></i> 清空缓存</a>
				                        <a href="#" class="btn btn-success btn-mini" id="fn-btn-build"><i class="glyphicon glyphicon-refresh"></i> 重建缓存</a>
				                        <!-- <a href="#" class="btn btn-info btn-mini" id="fn-btn-mointor"><i class="glyphicon glyphicon-plus"></i> 健康检查</a> -->
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
		           		<cs:table id="data-table" class="table table-striped table-bordered responsive" onrender="${path }/redis/list">
		           			<cs:column dataField="key_" name="缓存KEY"/>
		           			<cs:column dataField="type_" name="缓存类型"/>
		           			<cs:column dataField="ttl_" name="生命周期"/>
		           			<cs:column dataField="key_" name="操作" renderFn="operator"/>
		           		</cs:table>
		           </div>
		       </div>
	       </div>
       </div>
	</div>
</body>
</html>
