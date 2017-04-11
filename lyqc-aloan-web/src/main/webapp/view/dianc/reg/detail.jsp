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
			$("#fn-btn-dianc").click(function(){
				$("#dianc_modal").modal({
					remote : "${path}/dianc/addReg?appCode=${appInfo.appCode}"
				});
			});
			$("#fn-btn-shouc").click(function(){
				
			});
		});
	</script>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">电催管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/dianc/reg/list.jsp">电话催收登记</a>
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
			<div class="btn-bar">
			    <button type="button" class="btn btn-info btn-sm" id="fn-btn-dianc"><i class="glyphicon glyphicon-exclamation-sign"></i>电催登记</button>
			    <button type="button" class="btn btn-primary btn-sm" id="fn-btn-shouc"><i class="glyphicon glyphicon-road"></i>收车登记</button>
		    </div>
			<div class="box col-md-12">
			   	<div class="box-inner">
		      	   <div class="box-header well" data-original-title="">
			           <h2><i class="glyphicon glyphicon-edit"></i> 客户信息详情</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<ul class="nav nav-tabs" role="tablist">
					        <li role="presentation" class="active">
					            <a href="#home" aria-controls="home" role="tab"
					               data-toggle="tab">常用信息</a>
					        </li>
					        <li role="presentation">
					            <a href="#overdueinfo" aria-controls="overdueinfo" role="tab"
					               data-toggle="tab">催收信息</a>
					        </li>
					        <li role="presentation">
					            <a href="#custinfo" aria-controls="custinfo" role="tab"
					               data-toggle="tab">客户基本信息</a>
					        </li>
					        <li role="presentation">
					            <a href="#loaninfo" aria-controls="loaninfo" role="tab"
					               data-toggle="tab">融资信息</a>
					        </li>
					        <li role="presentation">
					            <a href="#annexinfo" aria-controls="annexinfo" role="tab"
					               data-toggle="tab">附件信息</a>
					        </li>
					    </ul>
						<div class="tab-content form-horizontal">
		                    <div class="tab-pane active" id="home">
		                        <jsp:include page="../../carloan/app/detail.jsp"></jsp:include>
		                        <jsp:include page="../../cust/remark/add.jsp"></jsp:include>
		                        <jsp:include page="../../cust/remark/list.jsp"></jsp:include>
		                        <jsp:include page="../../cust/phone/list.jsp"></jsp:include>
		                        <jsp:include page="../../cust/addr/list.jsp"></jsp:include>
		                        <jsp:include page="../../carloan/approval/list.jsp"></jsp:include>
		                    </div>
		                    <div class="tab-pane" id="overdueinfo">
		                        <jsp:include page="../../cust/overdue/detail.jsp"></jsp:include>
		                        <jsp:include page="../../dianc/detail/list.jsp"></jsp:include>
		                    </div>
		                    <div class="tab-pane" id="custinfo" class="hide">
		                    	<jsp:include page="../../carloan/prop/detail.jsp"></jsp:include>
		                    	<jsp:include page="../../carloan/guar/list.jsp"></jsp:include>
		                    	<jsp:include page="../../carloan/rela/list.jsp"></jsp:include>
		                    </div>
		                    <div class="tab-pane" id="loaninfo" class="hide">
		                    	<jsp:include page="../../carloan/loan/detail.jsp"></jsp:include>
		                    	<jsp:include page="../../fin/list.jsp"></jsp:include>
		                    </div>
		                    <div class="tab-pane" id="annexinfo" class="hide">
		                    	<jsp:include page="../../carloan/annex/list.jsp"></jsp:include>
		                    </div>
		                </div>
	               	</div>
		      	</div>
		    </div>
		</div>
	</div>
	<div class="modal fade" id="dianc_modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document" style="width:80%;">
			<div class="modal-content">
			</div>
		</div>
	</div>
</body>
</html>
