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
<body>
	<script type="text/javascript">
		function operator(data, type, full, meta){
			var html = '';
	    	html += ' <a class="link view" data-id='+data+' href= "javascript:;">查看</a>';
	    	return	data=html;
		}
		$(document).delegate('.view','click',function() {
		   var id = $(this).attr("data-id");
		   $("#rg_modal").modal({
				remote : "${path}/appInfo/viewRg?proppserId="+id
			});
	    });

	    $("#rg_modal").on("hidden.bs.modal", function() {  
	        $(this).removeData("bs.modal");  
	    });
	</script>
	<h4 class="bottom-line">联系人信息</h4>
	<cs:table id="rela-table" class="table table-striped table-bordered responsive" onrender="${path }/appInfo/rgList?appCode=${appInfo.appCode }&proppserType=03">
		<cs:column dataField="appCode" name="申请编号"/>
		<cs:column dataField="relativeType" name="与申请人关系"/>
		<cs:column dataField="proppserName" name="姓名"/>
		<cs:column dataField="mobile" name="电话"/>
		<cs:column dataField="liveProvince" name="居住省"/>
		<cs:column dataField="liveCity" name="居住城市"/>
		<cs:column dataField="liveAddr" name="居住地址"/>
		<cs:column dataField="proppserId" renderFn="operator" name="操作 "/>
	</cs:table>
	<div class="modal fade" id="rg_modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document" style="width:80%;">
			<div class="modal-content">
			</div>
		</div>
	</div>
</body>
</html>
