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
   function upload(obj, data){
	   console.log(data);
	   if(data.response.msg == "success"){
		   $(".modal").modal("hide");
		   $("#file-name").val(data.response.fileName);
	   } else {
		   $.alert(data.response.msg);
	   }
   }
  
	function setUser(zTree, nodes, obj) {
		var ids = "";
		var names = "";
		if (nodes != null && nodes.length != 0) {
			for (var i = 0; i < nodes.length; i++) {
				if (!nodes[i].isParent) {
					ids += nodes[i].id + ",";
					names += nodes[i].name + ",";
				}
			}
			$("#is-all-id").val(ids);
			$("#is-all-name").val(names);
		}
		$('.modal').map(function() {
		    $(this).modal('hide');
		});
	}
	$(function() {
		$("#fn-btn-save").click(function() {
			validate();
			if ($(".error").length != 0) {
				return false;
			}
			$("#fn-save-form").submit();
		});
		$("#is-attach,#is-all,#is-publish,#is-top").change(function() {
			var value = $(this).val();
			var id = $(this).attr("id");
			if (id != "is-all") {
				if (value == "1") {
					$("#" + id + "-area").removeClass("hide").show();
				} else {
					$("#" + id + "-area").addClass("hide").hide();
				}
			} else {
				if (value == "0") {
					$("#" + id + "-area").removeClass("hide").show();
				} else {
					$("#" + id + "-area").addClass("hide").hide();
				}
			}
		});
		$(".show-user").click(
				function() {
					var id = $("#_id").val();
					ztree_modal("checkbox", contextPath
							+ "/announcement/viewUserAjax?id=" + id, $(this),
							"setUser");
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
	            <a href="${path }/view/param/announcement/list.jsp">公告管理</a>
	        </li>
	        <li>
	            <a href="#">公告维护</a>
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
			<div id="userTree" class="ztree" >
			</div>
			<div class="box col-md-12">
			   	<div class="box-inner">
		      	   <div class="box-header well" data-original-title="">
			           <h2><i class="glyphicon glyphicon-edit"></i> 发布选项</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<form id="fn-save-form" class="form-horizontal" method="post" action="${path}/announcement/savePublish">
		                    <div class="form-group">
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">是否有附件<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-8">
					                   	<input type="hidden" name="id" value="${announcement.id }"	id="_id">
					                   	<cs:select class="form-control chosen required" name="isAttach" id="is-attach" value="${announcement.isAttach}" dicField="_is" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                        <div class="col-sm-6 hide" id="is-attach-area">
			                        <label class="control-label col-sm-4">附件上传<i class="glyphicon glyphicon-star red"></i></label>
			                         <div class="col-sm-8">
			                         	<cs:input type="file" class="form-control" value="${announcement.filename}" fileType="zip,jpg,pdf,gif,png" fileSize="3072" callback="upload" uploadUrl="${path }/announcement/upload?id=${announcement.id }"></cs:input>
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">是否发布<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-8">
					                   	<cs:select class="form-control chosen required" name="isPublish" id="is-publish" value="${announcement.isPublish}" dicField="_is" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                        <div class="col-sm-6 hide" id="is-publish-area">
			                        <label class="control-label col-sm-4">发布时间<i class="glyphicon glyphicon-star red"></i></label>
			                         <div class="col-sm-8">
			                         	<cs:input type="date" class="form-control" format="yyyy-mm-dd" name="publishTime" value="${announcement.publishTime }"></cs:input>
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">是否所有人<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-8">
					                   	<cs:select class="form-control chosen required" name="isAll" id="is-all" value="${announcement.isAll}" dicField="_is" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                        <div class="col-sm-6 hide" id="is-all-area">
			                        <label class="control-label col-sm-4">通知对象<i class="glyphicon glyphicon-star red"></i></label>
			                         <div class="col-sm-8">
			                         	<div class="input-group">
			                         		<input type="hidden" id="is-all-id" name="userIds" value="${announcement.userIds }">
			                         		<input class="form-control required" readonly id="is-all-name" name="userNames" value="${announcement.userNames }">
			                         		<span class="input-group-btn"><a href="#" class="btn btn-primary show-user"><i class="glyphicon glyphicon-sd-video"></i></a></span>
			                         	</div>
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">是否置顶<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-8">
					                   	<cs:select class="form-control chosen required" name="isTop" id="is-top" value="${announcement.isTop}" dicField="_is" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                    	<div class="col-sm-6 hide" id="is-top-area">
			                        <label class="control-label col-sm-4">置顶天数<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-8">
			                        	<cs:input type="int" name="topDay" maxlength="5" value="${announcement.topDay }" class="form-control required"></cs:input>
			                        </div>
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
