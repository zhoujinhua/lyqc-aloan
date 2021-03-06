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
    <title>渠道管理系统-用户管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<body>
	<script type="text/javascript">
		function operator(data, type, full, meta){
			var html = '';
	    	if(full.userName != 'admin'){
		    	html += '<a class="edit" data-id='+data+' href="javascript:;">编辑</a>';
		    	if(full.userStatus.value == 'N'){
		    		html += ' <a class="stop" data-id='+data+' href="javascript:;">停用</a>';
		    	} else {
		    		html += ' <a class="start" data-id='+data+' href="javascript:;">启用</a>';
		    	}
	    	}
	    	html += ' <a class="init-password" data-id='+data+' href="javascript:;">重置密码</a>';
	    	html += ' <a class="view-permset" data-id='+data+' href="javascript:;">管理权限集</a>';
	    	return	data=html;
		}
		function setPerm(zTree, nodes, obj){
			var ids = "";
			if(nodes!=null&&nodes.length!=0){
				for(var i=0;i<nodes.length;i++){
					if(!nodes[i].isParent){
						ids += nodes[i].id+",";
					}
				}
			} 
			if(ids == ""){
				$.alert("您没有为该用户设置任何权限集,请选择用户对应权限集.");
				return false;
			}
			location.href= contextPath + "/user/setPermSet?userId="+obj.attr("data-id");+"&ids="+ids+"&juid="+juid;
		}
		$(function(){
			$(document).delegate('#fn-btn-search','click',function() {
				reload("data-table");
		 	});
		   $(document).delegate('.edit','click',function() {
			   var userid = $(this).attr("data-id");
			   location.href= contextPath + '/user/edit' + '?userId=' + userid+"&juid="+juid;
		   });
		   $(document).delegate('.stop','click',function() {
			   var userid = $(this).attr("data-id");
			   $.confirm("确定要停用用户["+userid+"]吗?",function(ok){
				   if(ok){
					   location.href= contextPath + '/user/logout' + '?userId=' + userid+"&juid="+juid;
				   }
			   });
		   });
		   $(document).delegate('.start','click',function() {
			   var userid = $(this).attr("data-id");
			   $.confirm("确定要激活用户["+userid+"]吗?",function(ok){
				   if(ok){
					   location.href= contextPath + '/user/activate' + '?userId=' + userid+"&juid="+juid;
				   }
			   });
		   });
		   $(document).delegate('.init-password','click',function() {
			   var userid = $(this).attr("data-id");
			   $.confirm("确定要重置用户["+userid+"]的密码吗?",function(ok){
				   if(ok){
					   location.href= contextPath + '/user/initPwd' + '?userId=' + userid+"&juid="+juid;
				   }
			   });
		   });
		   $(document).delegate('.view-permset','click',function() {
			   var userId = $(this).attr("data-id");
			   ztree_modal("checkbox",contextPath+"/permset/viewPermSetTree?userId="+userId,$(this),"setPerm");
		   });
		   $(document).delegate('#fn-btn-add','click',function() {
			   location.href = contextPath + '/view/system/user/add.jsp?juid='+juid;
		   });
		});
	</script>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">系统管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/system/user/list.jsp">用户管理</a>
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
		                        <label class="control-label col-sm-1">用户名称</label>
		                        <div class="col-sm-3">
		                        	<cs:input class="form-control" maxlength="20" name="userName" renderId="data-table"/>
		                        </div>
		                        <label class="control-label col-sm-1">真实姓名</label>
		                         <div class="col-sm-3">
		                        	<cs:input class="form-control" maxlength="20" name="trueName" renderId="data-table"/>
		                        </div>
		                        <label class="control-label col-sm-1">用户类型</label>
		                        <div class="col-sm-3">
		                        	<cs:select class="form-control chosen" dicField="_user_type" name="userType" allowBlank="true"/>
		                        </div>
		                    </div>
	                    	<div class="form-group">
		                        <label class="control-label col-sm-1">是否启用</label>
		                        <div class="col-sm-3">
		                        	<cs:select class="form-control chosen" dicField="_is" name="userStatus" allowBlank="true"/>
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
		           		<cs:table id="data-table" class="table table-striped table-bordered responsive" onrender="${path }/user/list">
		           			<cs:column dataField="userId" name="用户ID"/>
		           			<cs:column dataField="userName" name="用户名称"/>
		           			<cs:column dataField="trueName" name="真实姓名"/>
		           			<cs:column dataField="userStatus" name="是否启用" type="dict" format="_is"/>
		           			<cs:column dataField="createTime" name="修改时间" type="date" format="YYYY-MM-DD"/>
		           			<cs:column dataField="userId" name="操作" renderFn="operator"/>
		           		</cs:table>
		           </div>
		       </div>
	       </div>
       </div>
	</div>
</body>
</html>
