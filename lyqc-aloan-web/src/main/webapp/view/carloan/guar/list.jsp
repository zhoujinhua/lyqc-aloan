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
	<h4 class="bottom-line">担保人信息</h4>
	<cs:table id="guar-table" class="table table-striped table-bordered responsive" onrender="${path }/appInfo/rgList?appCode=${appInfo.appCode }&proppserType=02">
		<cs:column dataField="appCode" name="申请编号"/>
		<cs:column dataField="relativeType" name="与申请人关系"/>
		<cs:column dataField="proppserName" name="姓名"/>
		<cs:column dataField="mobile" name="电话"/>
		<cs:column dataField="liveProvince" name="居住省"/>
		<cs:column dataField="liveCity" name="居住城市"/>
		<cs:column dataField="liveAddr" name="居住地址"/>
		<cs:column dataField="proppserId" renderFn="operator" name="操作 "/>
	</cs:table>
</body>
</html>
