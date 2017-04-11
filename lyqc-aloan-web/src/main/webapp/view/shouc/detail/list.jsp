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
	<h4 class="bottom-line">电话催收信息</h4>
	<cs:table id="collection-table" class="table table-striped table-bordered responsive" onrender="${path }/dianc/list?appCode=${appInfo.appCode }">
		<cs:column dataField="appCode" name="申请编号"/>
		<cs:column dataField="contactInfo.proppserName" name="客户姓名"/>
		<cs:column dataField="collRemark" name="催收备注"/>
		<cs:column dataField="weekRemark" name="周总结"/>
		<cs:column dataField="collStaff" name="登记人员"/>
		<cs:column dataField="remarkTime" name="处理时间" type="date" format="YYYY-MM-DD"/>
	</cs:table>
</body>
</html>
