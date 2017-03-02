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
    <title>渠道管理系统-经销商管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">经销商管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/dealer/company/list.jsp">经销商管理</a>
	        </li>
	        <li>
	            <a href="#">经销商查看</a>
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
			           <h2><i class="glyphicon glyphicon-edit"></i> 基本信息</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<div class="form-horizontal">
		                    <div class="form-group">
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">单位名称</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.companyName }"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">账户类型</label>
			                         <div class="col-sm-7">
			                         	<cs:label class="form-control text-show info" value="${dc.accountType }" type="dict" format="_account_type"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">所在省份</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.province }" type="region"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">所在城市</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.city }" type="region"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">单位类型</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.companyType }" type="dict" format="_dealer_type"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">信贷申请单序号</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.appNo }"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">是否是VIP</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.isVip }" type="dict" format="_is"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">销售区域</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.saleArea }" type="dict" format="_sale_area"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡户名</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.accountName }"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">单位银行账户证件号码</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.accountIdno }"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡开户行</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.accountBank }"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡开户支行</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.accountSubBank }"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡所在省</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.bankProvince }" type="region"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡所在市</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.bankCity }" type="region"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡卡号</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.accountNo }"/>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">备注</label>
			                        <div class="col-sm-7">
			                        	<cs:label class="form-control text-show info" value="${dc.remarks }"/>
			                        </div>
		                        </div>
		                    </div>
		               </div>
		           </div>
		       </div>
		   </div>
		</div>
	</div>
</body>
</html>
