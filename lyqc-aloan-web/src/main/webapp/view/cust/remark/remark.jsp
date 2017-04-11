<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://javass.cn/common/" prefix="cs"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<script type="text/javascript">
		$(function(){
			$(".chosen").each(function(){
				if($(this).is("select")){
					$(this).chosen({
					    no_results_text: "未发现匹配的字符串!",
						allow_single_deselect: true,
						width:"100%"
					});
				}
			});
			var id = "${phone.id}";
			if(!id){
				$(".new").addClass("required");
			}
			
			$("#fn-remark-save").click(function(){
				validateForm("fn-remark-form");
				if($(".error").length!=0){
	        		$.alert("存在校验失败的表单项,请查看.");
	        		return false;
	        	}
				$.ajax({
					  type: 'POST',
					  url: '${pageContext.request.contextPath}/cust/saveRemark',
					  data: $("#fn-remark-form").serialize(),
					  success: function(data){
						  if(data.responseCode == 1){
							  reload("remark-table");
							  $("#fn-remark-close").click();
						  }
					  },
					  dataType: 'json'
				});
			});
		});
	</script>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" id="myModalLabel">电话备注</h4>
	</div>
	<form action="${path }/cust/saveRemark" method="post" class="form-horizontal" id="fn-remark-form">
		<div class="form-group">
			<label class="control-label col-sm-1">申请编号</label>
			<div class="col-sm-3">
				<cs:label class="form-control" value="${vAppInfo.appCode }"/>
			</div>
			<label class="control-label col-sm-1">客户姓名</label>
			<div class="col-sm-3">
				<cs:label class="form-control" value="${vAppInfo.proppserName }"/>
			</div>
			<label class="control-label col-sm-1">催收员</label>
			<div class="col-sm-3">
				<cs:label class="form-control" value="${vAppInfo.collPhoneOperator }"/>
			</div>
		</div>
		<h5 class="bottom-line">电话信息</h5>
		<div class="form-group">
			<label class="control-label col-sm-1">电话类型</label>
			<div class="col-sm-3">
				<cs:label class="form-control" value="${phone.contactType }"/>
			</div>
			<label class="control-label col-sm-1">电话号码</label>
			<div class="col-sm-3">
				<cs:label class="form-control" value="${phone.phoneNu }"/>
			</div>
			<label class="control-label col-sm-1">联系人姓名</label>
			<div class="col-sm-3">
				<cs:label class="form-control" value="${phone.contactName }"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-1">电话状态<i class="glyphicon glyphicon-star red"></i></label>
			<div class="col-sm-3">
				<input type="hidden" name="phone.appCode" value="${vAppInfo.appCode }">
				<input type="hidden" name="appCode" value="${vAppInfo.appCode }">
				<input type="hidden" name="phone.contactType" value="${phone.contactType }">
				<input type="hidden" name="phone.id" value="${phone.id }">
				<cs:select class="form-control chosen required" name="phone.phoneStatus" dicField="_is" allowBlank="true"/>
			</div>
			<label class="control-label col-sm-1">新电话号码</label>
			<div class="col-sm-3">
				<cs:input class="form-control new" name="phone.phoneNu" type="phone.mobile" maxlength="20"/>
			</div>
			<label class="control-label col-sm-1">新联系人姓名</label>
			<div class="col-sm-3">
				<cs:input class="form-control new" name="phone.contactName" maxlength="30"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-1">与客户关系<i class="glyphicon glyphicon-star red"></i></label>
			<div class="col-sm-3">
				<cs:select class="form-control chosen required" name="phone.relativeType" dicField="_is" allowBlank="true"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-1">电话备注<i class="glyphicon glyphicon-star red"></i></label>
			<div class="col-sm-11">
				<textarea rows="" cols="" class="form-control autogrow required" style="min-height:56px;" name="phoneRemark"></textarea>
			</div>
		</div>
		<h5 class="bottom-line">地址信息</h5>
		<div class="form-group">
			<label class="control-label col-sm-1">地址信息</label>
			<div class="col-sm-7">
				<cs:input class="form-control" name="addr" value="${appInfo.appCode }"/>
			</div>
			<label class="control-label col-sm-1">是否有效</label>
			<div class="col-sm-3">
				<cs:select class="form-control chosen" name="addrValid" dicField="_is" allowBlank="true"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-1">地址备注</label>
			<div class="col-sm-11">
				<textarea rows="" cols="" name="addrRemark" class="form-control autogrow" style="min-height:56px;"></textarea>
			</div>
		</div>
	</form>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="fn-remark-save">保存</button>
		<button type="button" class="btn btn-default" data-dismiss="modal" id="fn-remark-close">关闭</button>
	</div>
</body>
</html>
