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
<head>
    <title>催收大平台-公告管理</title>
    <%-- <jsp:include page="/view/common/head.jsp"></jsp:include> --%>
</head>
<body>
	<script type="text/javascript">
		function operator(data, type, full, meta){
			var html = '<a class="link view-announcement" data-id='+data+' href= "javascript:;"><i class="glyphicon glyphicon-eye-open"></i></a>';
	    	return	data=html;
		}
		function headline(data, type, full, meta){
			var html = '';
			if(full.isNew == '1'){
				html = data + '<span><img src="${path}/include/image/new.gif"></span></a>';
			} else {
				html = data + '</a>';
			}
			html = '<a class="link view-announcement" data-id='+full.id+' href= "javascript:;">'+html+'</a>';
			return html;
		}
		$(function(){
		   $(document).delegate('.view-announcement','click',function() {
			   var id = $(this).attr("data-id");
			   view_announce(id);
		   });
		   $("#data-table_info").css("text-align","left");
		   $("#data-table_paginate").css("text-align","right");
		});
	</script>
	<div class="ch-container" style="height:72%;background:#ffffff;">
		<cs:table id="data-table" class="table responsive" onrender="${path }/announcement/myList" style="font-size:12px;">
   			<cs:column dataField="headline" name="标题" renderFn="headline"/>
   			<cs:column dataField="postType" name="公告类型" type="dict" format="_announce_type"/>
   			<cs:column dataField="publishTime" name="发布时间" type="date" format="YYYY-MM-DD"/>
   			<cs:column dataField="id" renderFn="operator"/>
   		</cs:table>
  	</div>
</body>
</html>
