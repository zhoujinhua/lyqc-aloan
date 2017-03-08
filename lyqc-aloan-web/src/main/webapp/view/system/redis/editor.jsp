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
<head>
    <title>催收大平台-缓存管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
    <script src="${path}/static/weblib/ace/js/ace.js" type="text/javascript" charset="utf-8"></script>
	<script src="${path}/static/weblib/beautify/beautify.js" type="text/javascript" charset="utf-8"></script>
	<style type="text/css" media="screen">
		body {
			overflow: hidden;
		}
		#editor {
			margin: 0;
			position: absolute;
			top: 0;
			bottom: 0;
			left: 0;
			right: 0;
		}
	</style>
</head>
<body>
	<pre id="editor"></pre>
	<script>
		//初始化代码编辑器
		var editor = ace.edit("editor");
		editor.setTheme("ace/theme/github");
		editor.getSession().setUseWrapMode(true);
		editor.setReadOnly(false);
		document.getElementById('editor').style.fontSize = '16px';
		
		//获取代码编辑器中的文本
		function getValue() {
			return editor.getValue();
		}
		
		//设置代码编辑器中的文本
		function setValue(code) {
			var val;
			try{
				//代码为json
				val = JSON.stringify(JSON.parse(code), null, 4);
				editor.session.setMode("ace/mode/json");
			}catch(e){
				val = code;
				editor.session.setMode("ace/mode/text");
			}
			editor.setValue(val);
		}
	</script>
</body>
</html>
