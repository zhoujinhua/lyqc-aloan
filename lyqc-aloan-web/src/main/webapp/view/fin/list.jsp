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
	<h4 class="bottom-line">还款计划</h4>
	<cs:table id="addr-table" class="table table-striped table-bordered responsive" onrender="${path }/fin/list?appCode=${appInfo.appCode }">
		<cs:column dataField="appNo" name="申请编号"/>
		<cs:column dataField="repayNu" name="分期序号"/>
		<cs:column dataField="paymentDate" name="账单日" type="date" format="YYYY-MM-DD"/>
		<cs:column dataField="factPaymentDate" name="实际还款日期" type="date" format="YYYY-MM-DD"/>
		<cs:column dataField="repayment" name="月供"/>
		<cs:column dataField="principal" name="本金"/>
		<cs:column dataField="interest" name="利息"/>
		<cs:column dataField="fine" name="罚息"/>
		<cs:column dataField="feeOth" name="其它"/>
		<cs:column dataField="status" name="状态"/>
	</cs:table>
</body>
</html>
