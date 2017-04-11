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
	<h4 class="bottom-line">审批历史</h4>
	<cs:table id="approval-table" class="table table-striped table-bordered responsive" onrender="${path }/appInfo/approvalList?appCode=${appInfo.appCode }">
		<cs:column dataField="appCode" name="申请编号"/>
		<cs:column dataField="flowName" name="审批流程"/>
		<cs:column dataField="status" name="状态"/>
		<cs:column dataField="type" name="审批结论"/>
		<cs:column dataField="remarks" name="审批备注"/>
		<cs:column dataField="userName" name="审批人"/>
		<cs:column dataField="approvalTime" name="审批时间" type="date" format="YYYY-MM-DD"/>
	</cs:table>
</body>
</html>
