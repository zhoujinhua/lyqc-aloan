<%@page import="com.rdfs.core.bean.UserDto"%>
<%@page import="com.rdfs.core.utils.AuthUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/common.tld" prefix="cs"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", path);
request.setAttribute("basePath", basePath);
String juid = request.getParameter("juid");
request.setAttribute("juid", juid);
UserDto user = AuthUtil.getUserDto(juid);
request.setAttribute("user", user);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
    <head>
        <title>欢迎界面 - []</title>
        <jsp:include page="/view/common/head.jsp"></jsp:include>
    </head>
    <script type="text/javascript">
    	function set_title(type,headline){
    		$("#type-headline").html("[<cs:label value='"+type+"' type='dict' format='_announce_type'></cs:label>] "+headline);
    	}
    	function view_announce(id){
    		$("#iframe-view-single").attr("src","${path}/announcement/viewSingle?id="+id+"&juid=${juid}");
    	}
    	/* $(function(){
    		var taskSize;
    		var finishSize;
		   $.ajax({
			   type: 'POST',
			   url: contextPath + '/task/list',
			   data:{},
			   success: function(data){
				   taskSize = data.recordsTotal;
				   $("#pre-task-size").html(taskSize);
				   $("#pre-task-size").siblings(".notification").html(taskSize);
			   },
			   dataType: 'json'
		   });
		   $.ajax({
			   type: 'POST',
			   url: contextPath + '/task/finlist',
			   data:{},
			   success: function(data){
					finishSize = data.recordsTotal;
					$("#fin-task-size").html(finishSize);
					$("#fin-task-size").siblings(".notification").html(finishSize);
			   },
			   dataType: 'json'
		   });
    		$(".view-task").click(function(){
    			if(taskSize == "0"){
    				return false;
    			}
    			set_title("待办","我的任务");
    			$("#iframe-view-single").attr("src","${path}/view/param/task/approval_PBOC.jsp");
    		});
    		$(".view-finish").click(function(){
    			if(finishSize == "0"){
    				return false;
    			}
    			set_title("已办","我的已办");
    			$("#iframe-view-single").attr("src","${path}/view/param/task/finlist.jsp");
    		});
    	}); */
    </script>
    <body>
    	<div class="ch-container">
    		<div class="row" style="padding-top:25px;">
    			<div class="col-sm-6 col-sm-6 col-xs-12">
    				<ul class="">
                        <li>
                            <a href="#">
                                <img src="${path }/static/image/welcome.gif" alt="Usman" class="" style="float:left;margin-right:15px;padding:1px;"></a>
                            <br><strong>欢迎，<a href="#">${user.trueName }</a><br>
                            	登录的用户名：<span class="label-success label label-default"> ${user.userName }</span><br>
                            	当前登录的IP：<span class="label-success label label-default"> ${user.clientIp }</span><br>
                            	当前登录时间：<span class="label-success label label-default"> ${user.loginTime }</span>
                            	</strong>
                        </li>
                    </ul>
			    </div>
			    <div class="col-sm-3 col-sm-3 col-xs-6">
			        <a title="" class="well top-block view-task" href="#">
			            <i class="glyphicon glyphicon-envelope red"></i>
			            <div>我的任务</div>
			            <div id="pre-task-size">${taskSize }</div>
			            <span class="notification red">${taskSize }</span>
			        </a>
			    </div>
			    <div class="col-sm-3 col-sm-3 col-xs-6">
			        <a title="" class="well top-block view-finish" href="#">
			            <i class="glyphicon glyphicon-star green"></i>
			
			            <div>我的已办</div>
			            <div id="fin-task-size">${finishSize }</div>
			            <span class="notification green">${finishSize }</span>
			        </a>
			    </div>
    		</div>
    		<div class="row">
		        <div class="box col-sm-8">
		            <div class="box-inner">
		                <div data-original-title="" class="box-header well">
		                    <h2><i class="glyphicon glyphicon-volume-up"></i><span id="type-headline"></span></h2>
		                    <div class="box-icon">
		                        <a class="btn btn-minimize btn-round btn-default" href="#"><i class="glyphicon glyphicon-chevron-up"></i></a>
		                    </div>
		                </div>
		                <div class="box-content">
		                    <div class="row">
		                        <div class="col-sm-12">
						        	<iframe src="${path }/announcement/viewSingle?juid=${juid }" id="iframe-view-single" style="width: 100%;height: 72%;border:none;" frameborder="0"></iframe>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
		
		        <div class="box col-sm-4">
		            <div class="box-inner">
		                <div data-original-title="" class="box-header well">
		                    <h2><i class="glyphicon glyphicon-th"></i> 公告列表</h2>
		                    <div class="box-icon">
		                        <a class="btn btn-minimize btn-round btn-default" href="#"><i class="glyphicon glyphicon-chevron-up"></i></a>
		                    </div>
		                </div>
		                <div class="box-content">
		                    <div class="row">
		                        <div class="col-sm-12">
		                        	<jsp:include page="/view/system/announcement/myList.jsp"></jsp:include>
		                        	<%-- <iframe src="${path }/view/system/announcement/myList.jsp?juid=${juid}" style="width: 100%;height: 72%;border:none;" frameborder="0"></iframe> --%>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
    		</div>
    	</div>
    </body>
</html>