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
<script type="text/javascript">
	$(function(){
		var companyCode = "${dc.companyCode}";
		if(companyCode && companyCode != undefined){
			$("input[name='companyCode']").attr("readonly","true");
			$("#fn-form-save").attr("action","${path}/dealercompany/update?juid="+juid);
		}
 		$("#fn-btn-save").click(function(){
 			validate();
			if($(".error").length!=0){
				return false;
			}
			var code = $("input[name='companyCode']").val();
			if(code.length != 5){
				$("input[name='companyCode']").fieldError("必须输入五位数字.")
				return false;
			}
			if(!(companyCode && companyCode != undefined)){
				$.ajax({
					  type: 'POST',
					  url: '${pageContext.request.contextPath}/dealercompany/check',
					  data:{"companyCode":$("input[name='companyCode']").val()},
					  success: function(data){
						  if(data.responseCode == 1){
					 			$("#fn-form-save").submit();
						  } else {
							  $.alert(data.responseMsg);
						  }
					  },
					  dataType: 'json'
				});
			} else {
				$("#fn-form-save").submit();
			}
 		});
	});
</script>
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
	            <a href="#">经销商维护</a>
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
			<div id="amTree" class="ztree">
			</div>
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
		           		<form id="fn-form-save" class="form-horizontal" method="post" action="${path}/dealercompany/save">
		                    <div class="form-group">
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">单位编码<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
			                        	<cs:input type="int" class="form-control required" name="companyCode" maxlength="5" value="${dc.companyCode }"></cs:input>
			                        </div>
		                        </div>
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">单位名称<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
		                       	 		<input type="text" class="form-control required" name="companyName" maxlength="20" value="${dc.companyName }">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">账户类型<i class="glyphicon glyphicon-star red"></i></label>
			                         <div class="col-sm-7">
			                         	<cs:select class="form-control chosen required" name="accountType" value="${dc.accountType }" dicField="_account_type" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">单位类型<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
			                        	<cs:select class="form-control chosen required" name="companyType" value="${dc.companyType }" dicField="_dealer_type" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">所在省份<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
			                        	<cs:select class="form-control chosen required" id="province" name="province" value="${dc.province }" type="region" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">所在城市<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
			                        	<cs:select class="form-control chosen required" name="city" value="${dc.city }" type="region" allowBlank="true" provinceId="province" initProvinceValue="${dc.province }"></cs:select>
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">信贷申请单序号</label>
			                        <div class="col-sm-7">
		                       	 		<input type="text" class="form-control" name="appNo" maxlength="20" value="${dc.appNo }">
			                        </div>
		                        </div>
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">是否是VIP</label>
			                        <div class="col-sm-7">
			                        	<cs:select class="form-control chosen" name="isVip" value="${dc.isVip }" dicField="_is" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">销售区域<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
			                        	<cs:select class="form-control chosen required" name="saleArea" value="${dc.saleArea }" dicField="_sale_area" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡户名<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
		                       	 		<input type="text" class="form-control required" name="accountName" maxlength="30" value="${dc.accountName }">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">单位银行账户证件号码<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
		                       	 		<input type="text" class="form-control required" name="accountIdno" maxlength="50" value="${dc.accountIdno }">
			                        </div>
		                        </div>
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡开户行<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
		                       	 		<input type="text" class="form-control required" name="accountBank" maxlength="30" value="${dc.accountBank }">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡所在省<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
			                        	<cs:select class="form-control chosen required" id="bankProvince" name="bankProvince" value="${dc.bankProvince }" type="region" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡所在市<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
			                        	<cs:select class="form-control chosen required" name="bankCity" value="${dc.bankCity }" type="region" allowBlank="true" provinceId="bankProvince" initProvinceValue="${dc.bankProvince }"></cs:select>
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡开户支行<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
		                       	 		<input type="text" class="form-control required" name="accountSubBank" maxlength="50" value="${dc.accountSubBank }">
			                        </div>
		                        </div>
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">银行卡卡号<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
		                       	 		<input type="text" class="form-control required" name="accountNo" maxlength="30" value="${dc.accountNo }">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">备注</label>
			                        <div class="col-sm-7">
			                        	<textarea rows="3" name="remarks" class="form-control autogrow" maxlength="50">${dc.remarks }</textarea>
			                        </div>
		                        </div>
		                   </div>
		                   <div class="form-group">
				                <div class="col-sm-12" style="margin-top:10px;">
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
