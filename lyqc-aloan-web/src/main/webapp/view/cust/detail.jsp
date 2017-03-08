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
    <title>催收大平台-客户信息管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">客户管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/cust/list.jsp">客户信息查询</a>
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
		                        <jsp:include page="../carloan/app/detail.jsp"></jsp:include>
		                        <jsp:include page="remark/add.jsp"></jsp:include>
		                        <jsp:include page="remark/list.jsp"></jsp:include>
		                        <jsp:include page="phone/list.jsp"></jsp:include>
		                        <jsp:include page="addr/list.jsp"></jsp:include>
		                        <jsp:include page="../carloan/approval/list.jsp"></jsp:include>
		                    </div>
		                    <div class="tab-pane" id="overdueinfo">
		                        <jsp:include page="overdue/detail.jsp"></jsp:include>
		                        <jsp:include page="../dianc/list.jsp"></jsp:include>
		                    </div>
		                    <div class="tab-pane" id="custinfo" class="hide">
		                    	<jsp:include page="../carloan/prop/detail.jsp"></jsp:include>
		                    </div>
		                    <div class="tab-pane" id="loaninfo" class="hide">
		                    	<jsp:include page="../carloan/loan/detail.jsp"></jsp:include>
		                    	<jsp:include page="../fin/list.jsp"></jsp:include>
		                    </div>
		                    <div class="tab-pane" id="annexinfo" class="hide">
		                    	<jsp:include page="../carloan/annex/list.jsp"></jsp:include>
		                    </div>
		                </div>
	               	</div>
		      	</div>
		    </div>
		</div>
	</div>
</body>
</html>
