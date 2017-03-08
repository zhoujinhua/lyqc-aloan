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
<body>
	<h4 class="bottom-line">电话信息</h4>
	<cs:table id="phone-table" class="table table-striped table-bordered responsive" onrender="${path }/cust/phoneList?appCode=${appInfo.appCode }">
		<cs:column dataField="appCode" name="申请编号"/>
		<cs:column dataField="contactType" name="客户类型"/>
		<cs:column dataField="relativeType" name="与主贷人关系"/>
		<cs:column dataField="contactName" name="客户姓名"/>
		<cs:column dataField="phoneNu" name="电话号码"/>
		<cs:column dataField="phoneStatus" name="电话状态"/>
		<cs:column dataField="dataSource" name="数据来源" type="dict" format="_is"/>
		<cs:column dataField="remarkOperator" name="录入人员"/>
		<cs:column dataField="remarkTime" name="备注时间" type="date" format="YYYY-MM-DD"/>
	</cs:table>
</body>
</html>
