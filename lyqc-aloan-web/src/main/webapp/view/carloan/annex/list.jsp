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
	<h4 class="bottom-line">附件信息</h4>
	<cs:table id="annex-table" class="table table-striped table-bordered responsive" onrender="${path }/appInfo/annexList?appCode=${appInfo.appCode }">
		<cs:column dataField="appCode" name="申请编号"/>
		<cs:column dataField="annexType" name="附件类型"/>
		<cs:column dataField="annexName" name="文件名"/>
		<cs:column dataField="remarks" name="备注"/>
		<cs:column dataField="userName" name="上传用户 "/>
		<cs:column dataField="createTime" name="上传时间 " type="date" format="YYYY-MM-DD"/>
	</cs:table>
</body>
</html>
