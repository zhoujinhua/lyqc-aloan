<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/common.tld" prefix="cs"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<script type="text/javascript">
		$(function(){
			$(".remark").click(function(){
				var id = $(this).parent().siblings(":hidden").val();
				var type = $(this).parent().siblings(":hidden").attr("data-type");
				$("#remark_modal").modal({
					remote : "${path}/cust/addRemark?appCode=${appInfo.appCode}&id="+id+"&contactType="+type
				});
			});

		    $("#remark_modal").on("hidden.bs.modal", function() {  
		        $(this).removeData("bs.modal");  
		    });  
			ztree_input("radio", contextPath + '/cust/custTree?appCode=${appInfo.appCode}&contactType=01', $("#prop"));
			ztree_input("radio", contextPath + '/cust/custTree?appCode=${appInfo.appCode}&contactType=02', $("#spouse"));
			ztree_input("radio", contextPath + '/cust/custTree?appCode=${appInfo.appCode}&contactType=03', $("#guar"));
		});
	</script>
	<h4 class="bottom-line">电话备注</h4>
	<div class="form-group">
		<label class="control-label col-sm-1">主贷人</label>
		<div class="col-sm-3">
			<div class="input-group">
				<cs:input class="form-control" id="prop" readonly="true"/>
				<input type="hidden" data-type="01">
				<span class="input-group-btn">
					<a href="javascript:;" class="btn btn-primary btn-sm remark"><i class="glyphicon glyphicon-plus-sign"></i></a>
				</span>
			</div>
		</div>
		<label class="control-label col-sm-1">配偶</label>
		<div class="col-sm-3">
			<div class="input-group">
				<cs:input class="form-control" id="spouse" readonly="true"/>
				<input type="hidden" data-type="02">
				<span class="input-group-btn">
					<a href="javascript:;" class="btn btn-primary btn-sm remark"><i class="glyphicon glyphicon-plus-sign"></i></a>
				</span>
			</div>
		</div>
		<label class="control-label col-sm-1">担保人</label>
		<div class="col-sm-3">
			<div class="input-group">
				<cs:input class="form-control" id="guar" readonly="true"/>
				<input type="hidden" data-type="03">
				<span class="input-group-btn">
					<a href="javascript:;" class="btn btn-primary btn-sm remark"><i class="glyphicon glyphicon-plus-sign"></i></a>
				</span>
			</div>
		</div>
	</div>

	<div class="modal fade" id="remark_modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document" style="width:80%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">电话备注</h4>
				</div>
				<div class="modal-body">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">保存</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
