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
<body>
	<script type="text/javascript">
		function operator(data, type, full, meta){
			var html = '';
	    	html += ' <a href="'+ contextPath +'/division/detail?id='+data+'">查看</a>';
	    	html += ' <a href="'+ contextPath +'/division/edit?id='+data+'">修改</a>';
	    	html += ' <a class="assign" data-id="'+data+'" href="javascript:;">分配人员</a>';
	    	html += ' <a class="runOnce" data-id="'+data+'" href="javascript:;">跑一次</a>';
	    	return	data=html;
		}
		function setRule(zTree, nodes, obj){
			var ids = "";
			if(nodes!=null&&nodes.length!=0){
				for(var i=0;i<nodes.length;i++){
					if(!nodes[i].isParent && !nodes[i].isHidden){
						ids += nodes[i].id+",";
					}
				}
			} 
			if(ids == ""){
				$.alert("您没有为该规则设置任何催收员.");
				return false;
			}
			location.href= contextPath + "/division/setUser?id="+obj.attr("data-id")+"&ids="+ids+"&juid="+juid;
		}
		$(function(){
			$(document).delegate('#fn-btn-search','click',function() {
				reload("data-table");
		 	});
			$(document).delegate('#fn-btn-add','click',function() {
				location.href="${path}/view/division/auto/add.jsp?juid="+juid;
		 	});
			$(document).delegate('.assign','click',function() {
				var id = $(this).attr("data-id");
			    ztree_modal("checkbox",contextPath+"/division/userTree?id="+id,$(this),"setRule");
			});
			$(document).delegate('.runOnce','click',function() {
		    	var id = $(this).attr("data-id");
		    	$.confirm("跑一次?",function(ok){
		    		if(ok){
		    			location.href = contextPath + '/division/run?id='+id;
		    		}
		    	});
		    });
		});
	</script>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">分单管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/division/auto/list.jsp">分单管理</a>
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
		                        <label class="control-label col-sm-1">规则名称</label>
		                        <div class="col-sm-3">
		                        	<cs:input class="form-control" maxlength="20" name="name" renderId="data-table"/>
		                        </div>
		                        <label class="control-label col-sm-1">是否有效</label>
		                         <div class="col-sm-3">
		                        	<cs:select class="form-control chosen" dicField="_is" name="status" allowBlank="true"/>
		                        </div>
		                    </div>
		                     <div class="form-group">
			                     <div class="col-sm-12">
				                    <p class="center-block">
				                        <a href="#" class="btn btn-primary btn-mini" id="fn-btn-search"><i class="glyphicon glyphicon-search"></i> 查询</a>
				                        <a href="#" class="btn btn-primary btn-mini" id="fn-btn-add"><i class="glyphicon glyphicon-plus"></i> 新增</a>
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
		           		<cs:table id="data-table" class="table table-striped table-bordered responsive" onrender="${path }/division/list">
		           			<cs:column dataField="name" name="规则名称"/>
		           			<cs:column dataField="type" name="规则类型" type="dict" format="_division_type"/>
		           			<cs:column dataField="status" name="是否有效" type="dict" format="_is"/>
		           			<cs:column dataField="depend" name="分单依赖" type="dict" format="_division_depend"/>
		           			<cs:column dataField="min" name="最小值"/>
		           			<cs:column dataField="max" name="最大值"/>
		           			<cs:column dataField="remark" name="备注"/>
		           			<cs:column dataField="userName" name="创建人"/>
		           			<cs:column dataField="createTime" name="创建时间" type="date" format="YYYY-MM-DD"/>
		           			<cs:column dataField="id" renderFn="operator" name="操作"/>
		           		</cs:table>
		           </div>
		       </div>
	       </div>
       </div>
	</div>
</body>
</html>
