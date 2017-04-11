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
			
			$("#fn-reg-save").click(function(){
				validateForm("fn-shouc-form");
				if($(".error").length!=0){
	        		$.alert("存在校验失败的表单项,请查看.");
	        		return false;
	        	}
				$.ajax({
					  type: 'POST',
					  url: '${pageContext.request.contextPath}/shouc/saveReg',
					  data: $("#fn-shouc-form").serialize(),
					  success: function(data){
						  if(data.responseCode == 1){
							  reload("collection-table");
							  $("#fn-shouc-close").click();
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
		<h4 class="modal-title" id="myModalLabel">收车登记</h4>
	</div>
	<form method="post" class="form-horizontal" id="fn-shouc-form">
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
		<div class="form-group">
			<label class="control-label col-sm-1">催收备注</label>
			<div class="col-sm-3">
				<textarea rows="" cols="" name="collRemark" maxlength="1000" class="form-control autogrow" style="min-height:56px;"></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-1">申请原因<i class="glyphicon glyphicon-star red"></i></label>
			<div class="col-sm-3">
				<textarea rows="" cols="" name="requestReason" maxlength="1000" class="form-control autogrow required" style="min-height:56px;"></textarea>
			</div>
		</div>
	</form>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="fn-shouc-save">保存</button>
		<button type="button" class="btn btn-default" data-dismiss="modal" id="fn-shouc-close">关闭</button>
	</div>
</body>
</html>
