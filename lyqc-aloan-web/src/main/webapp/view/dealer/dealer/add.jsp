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
    <title>渠道管理系统-门店管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<script type="text/javascript">
	$(function(){
		var dealerCode = "${dc.dealerCode}";
		if(dealerCode && dealerCode != undefined){
			$("input[name='dealerCode']").attr("readonly","readonly");
			var par = $("#company-code").parent();
			$("#company-code").remove();
			par.append("<input name='company.companyName' class='form-control' readonly='true' value='${dc.company.companyName}'>"+
					"<input name='company.companyCode' id='company-code' class='form-control' type='hidden' value='${dc.company.companyCode}'>");
			$("#fn-form-save").attr("action","${path}/dealer/update?juid="+juid);
		} else {
			$.ajax({
				  type: 'POST',
				  url: '${pageContext.request.contextPath}/dealercompany/listDC',
				  data:{},
				  success: function(data){
					  $.each(data.aaData,function(i){
							$("#company-code").append("<option value='"+data.aaData[i].companyCode+"'>"+data.aaData[i].companyName+"</option>");
					  });
					  $("#company-code").val($("#company-code").attr("value"));
					  $("#company-code").chosen({
					        no_results_text: "未发现匹配的字符串!",
					    	allow_single_deselect: true,
					    	width:"100%"
					  });
				  },
				  dataType: 'json'
			});
		}
 		$("#fn-btn-save").click(function(){
 			validate();
			if($(".error").length!=0){
				return false;
			}
			var code = $("input[name='dealerCode']").val();
			if(code.length !=8 ){
				$("input[name='dealerCode']").fieldError("必须输入八位数字.")
				return false;
			}
			var companyCode = $("#company-code").val();
			if(companyCode != code.substring(0,5)){
				$("input[name='dealerCode']").fieldError("门店编码的前五位必须和经销商代码相同.")
				return false;
			}
			if(!(dealerCode && dealerCode != undefined)){
				$.ajax({
					  type: 'POST',
					  url: '${pageContext.request.contextPath}/dealer/check',
					  data:{"dealerCode":$("input[name='dealerCode']").val()},
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
	            <a href="${path }/view/dealer/dealer/list.jsp">门店管理</a>
	        </li>
	        <li>
	            <a href="#">经销商门店维护</a>
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
			           <h2><i class="glyphicon glyphicon-edit"></i> 门店基本信息</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<form id="fn-form-save" class="form-horizontal" method="post" action="${path}/dealer/save">
		                    <div class="form-group">
		                    	<div class="col-sm-6">
			                        <label class="control-label col-sm-4">门店编码<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
			                        	<cs:input type="int" class="form-control required" name="dealerCode" maxlength="8" value="${dc.dealerCode }"></cs:input>
			                        </div>
		                        </div>
		                   		<div class="col-sm-6">
			                        <label class="control-label col-sm-4">门店名称<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
		                       	 		<input type="text" class="form-control dealer-name required" name="dealerName" value="${dc.dealerName }" maxlength="20">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">所属单位<i class="glyphicon glyphicon-star red"></i></label>
			                         <div class="col-sm-7">
		                        		<select class="form-control required" name="company.companyCode" id="company-code" data-placeholder="请选择所属单位" value="${dc.company.companyCode }">
			                        		<option class="empty" value="">--</option>
			                        	</select>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">账户类型<i class="glyphicon glyphicon-star red"></i></label>
			                         <div class="col-sm-7">
			                        	<cs:select class="form-control chosen required" name="accountType" value="${dc.accountType }" dicField="_account_type" allowBlank="true"></cs:select>
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
			                        <label class="control-label col-sm-4">门店类型<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
			                        	<cs:select class="form-control chosen required" name="dealerType" value="${dc.dealerType }" dicField="_dealer_type" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">销售区域<i class="glyphicon glyphicon-star red"></i></label>
			                        <div class="col-sm-7">
				                        <cs:select class="form-control chosen required" name="saleArea" value="${dc.saleArea }" dicField="_sale_area" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">收款账户姓名</label>
			                        <div class="col-sm-7">
				                        <input class="form-control rec-account-name" maxlength="30" name="recAccountName" value="${dc.recAccountName }">
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">收款账户证件号码</label>
			                        <div class="col-sm-7">
				                        <input class="form-control rec-account-card" maxlength="30" name="recAccountCard" value="${dc.recAccountCard }">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">收款开户银行</label>
			                        <div class="col-sm-7">
				                        <input class="form-control rec-account-bank2" maxlength="30" name="recAccountBank2" value="${dc.recAccountBank2 }">
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">收款开户行</label>
			                        <div class="col-sm-7">
				                        <input class="form-control rec-account-bank" maxlength="30" name="recAccountBank" value="${dc.recAccountBank }">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">收款开户行所在省份</label>
			                        <div class="col-sm-7">
				                        <cs:select class="form-control chosen required" id="bankProvince" name="bankProvince" value="${dc.bankProvince }" type="region" allowBlank="true"></cs:select>
			                        </div>
		                        </div>
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">收款开户行所在城市</label>
			                        <div class="col-sm-7">
				                        <cs:select class="form-control chosen required" name="bankCity" value="${dc.bankCity }" type="region" allowBlank="true" provinceId="bankProvince" initProvinceValue="${dc.bankProvince }"></cs:select>
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">收款借记卡号</label>
			                        <div class="col-sm-7">
				                        <input class="form-control rec-account-no" maxlength="30" name="recAccountNo" value="${dc.recAccountNo }">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                        <div class="col-sm-6">
			                        <label class="control-label col-sm-4">备注</label>
			                        <div class="col-sm-7">
			                        	<textarea rows="3" maxlength="100" class="form-control bank-remarks" name="remarks">${dc.remarks }</textarea>
			                        </div>
		                        </div>
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
