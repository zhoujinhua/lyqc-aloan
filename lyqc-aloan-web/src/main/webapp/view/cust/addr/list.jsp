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
	<h4 class="bottom-line">地址信息</h4>
	<cs:table id="addr-table" class="table table-striped table-bordered responsive" onrender="${path }/cust/addrList?appCode=${appInfo.appCode }">
		<cs:column dataField="appCode" name="申请编号"/>
		<cs:column dataField="contactType" name="客户类型"/>
		<cs:column dataField="phone.relativeType" name="与主贷人关系"/>
		<cs:column dataField="phone.contactName" name="客户姓名"/>
		<cs:column dataField="addr" name="地址信息"/>
		<cs:column dataField="addrValid" name="是否有效" type="dict" format="_is"/>
		<cs:column dataField="addrRemark" name="备注信息"/>
		<cs:column dataField="dataSource" name="数据来源" type="dict" format="_is"/>
		<cs:column dataField="remarkOperator" name="录入人员"/>
		<cs:column dataField="remarkTime" name="备注时间" type="date" format="YYYY-MM-DD"/>
	</cs:table>
</body>
</html>
