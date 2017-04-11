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
    <title>催收大平台-客户信息管理</title>
    <jsp:include page="/view/common/head.jsp"></jsp:include>
</head>
<body>
	<script type="text/javascript">
		function operator(data, type, full, meta){
			var html = '';
	    	html += '<input type="checkbox" class="_single" data-id="'+data+'">';
	    	return	data=html;
		}
		function setOper(zTree, nodes, obj){
			var codes = "";
			$("._single").each(function(){
				if($(this).context.checked){
        			var id = $(this).attr("data-id");
        			codes += id + ",";
				}
    		});
			codes = codes.substring(0, codes.length-1);
			var ids = "";
			if(nodes!=null&&nodes.length!=0){
				for(var i=0;i<nodes.length;i++){
					if(!nodes[i].isParent && !nodes[i].isHidden){
						ids += nodes[i].id+",";
					}
				}
			} 
			if(ids == ""){
				$.alert("请为选中的申请单设置指派催收员.");
				return false;
			}
			ids = ids.substring(0, ids.length-1);
			location.href= contextPath + "/oper/setOper?appCodes="+codes+"&userId="+ids+"&juid="+juid;
		}
		$(function(){
			$(document).delegate('#fn-btn-search','click',function() {
				reload("data-table");
		 	});
			$("._single").click(function(){
            	var flag = true;
            	$(document).delegate('._single','click',function() {
            		if(!$(this).context.checked) {
            			flag = false;
            			$("._all").prop("checked", false);
            			$(this).parent().parent().removeAttr("style");
            		}
            		else{
            			$(this).parent().parent().css("color","#F10D58");
            		}
            	});
            	if(flag) $("._all").prop("checked",true);
            });
			$(document).delegate('._all','click',function() {
            	if($(this).context.checked){
            		$("._single").each(function(){
            			$(this).prop("checked", true);
            			$(this).parent().parent().css("color","#F10D58");
            		});
            	} else {
            		$("._single").each(function(){
            			$(this).prop("checked", false);
            			$(this).parent().parent().removeAttr("style");
            		});
            	}
            });
			$("#oper_div").click(function(){
				var codes = "";
				$("._single").each(function(){
					if($(this).context.checked){
	        			var id = $(this).attr("data-id");
	        			codes += id + ",";
					}
        		});
				codes = codes.substring(0, codes.length-1);
				if(codes){
					ztree_modal("radio", contextPath + '/user/userTree', $("#oper_div"), "setOper");
				}
			});
			ztree_input("radio", contextPath + '/user/userTree', $("#coll-user"));
		});
	</script>
	<div class="ch-container">
	    <ul class="breadcrumb">
	        <li>
	            <a href="#">分单管理</a>
	        </li>
	        <li>
	            <a href="${path }/view/division/oper/list.jsp">手工分单</a>
	        </li>
	    </ul>
		<div class="row">
			<c:if test="${msg!=null && msg!=''}">
				<div class="col-md-12">
					<div class="alert alert-info alert-dismissible col-md-12" role="alert">
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					  ${msg }
					</div>
				</div>
			</c:if>
			<div class="box col-md-12">
			   	<div class="box-inner">
		      	   <div class="box-header well" data-original-title="">
			           <h2><i class="glyphicon glyphicon-edit"></i> 查询条件</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default"><i
			                       class="glyphicon glyphicon-chevron-up"></i></a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<form id="fn-search-form" class="form-horizontal" method="post" >
		                    <div class="form-group">
		                        <label class="control-label col-sm-1">申请编号</label>
		                        <div class="col-sm-3">
		                        	<cs:input type="hidden" name="isCurrOverdue" value="1" renderId="data-table"/>
		                        	<cs:input class="form-control" maxlength="20" name="appCode" renderId="data-table"/>
		                        </div>
		                        <label class="control-label col-sm-1">客户姓名</label>
		                         <div class="col-sm-3">
		                        	<cs:input class="form-control" maxlength="20" name="proppserName" renderId="data-table"/>
		                        </div>
		                        <label class="control-label col-sm-1">证件类型</label>
		                        <div class="col-sm-3">
		                        	<cs:select class="form-control chosen" dicField="_id_type" name="id_type" allowBlank="true"/>
		                        </div>
		                    </div>
	                    	<div class="form-group">
		                        <label class="control-label col-sm-1">证件号码</label>
		                        <div class="col-sm-3">
		                        	<cs:input class="form-control" maxlength="20" name="idno" renderId="data-table"/>
		                        </div>
		                        <label class="control-label col-sm-1">所在省</label>
		                        <div class="col-sm-3">
		                        	<cs:select class="form-control chosen" type="region" name="liveProvince" id="live-province" renderId="data-table" allowBlank="true"/>
		                        </div>
		                        <label class="control-label col-sm-1">所在城市</label>
		                        <div class="col-sm-3">
		                        	<cs:select class="form-control chosen" type="region" name="liveCity" provinceId="live-province" renderId="data-table" allowBlank="true"/>
		                        </div>
		                     </div>
	                    	<div class="form-group">
		                        <label class="control-label col-sm-1">手机号码</label>
		                        <div class="col-sm-3">
		                        	<cs:input class="form-control" maxlength="20" name="mobile" renderId="data-table"/>
		                        </div>
		                        <label class="control-label col-sm-1">逾期状态</label>
		                        <div class="col-sm-3">
		                        	<cs:select class="form-control chosen" dicField="_overdue_status" name="overdueStatus" allowBlank="true" renderId="data-table"/>
		                        </div>
		                        <label class="control-label col-sm-1">催收人员</label>
		                        <div class="col-sm-3">
		                        	<cs:input class="form-control" id="coll-user" readonly="true" name="collPhoneOperator" renderId="data-table"/>
		                        </div>
		                     </div>
		                     <div class="form-group">
			                     <div class="col-sm-12">
				                    <p class="center-block">
				                        <a href="#" class="btn btn-primary btn-mini" id="fn-btn-search"><i class="glyphicon glyphicon-search"></i> 查询</a>
				                    </p>
				                </div>
			                </div>
		                </form>
	               	</div>
		      	</div>
		    </div>
		</div>
	    <div class="row">
	    	<div class="box col-md-12">
		      	<div class="box-inner">
		      	   <div class="box-header well" data-original-title="">
			           <h2><i class="glyphicon glyphicon-th"></i> 查询结果</h2>
			           <div class="box-icon">
			               <a href="#" class="btn btn-minimize btn-round btn-default">
			               		<i class="glyphicon glyphicon-chevron-up"></i>
			               	</a>
			           </div>
			       </div>
		           <div class="box-content">
		           		<button class="btn btn-primary btn-sm" id="oper_div">手工分单</button>
		           		<cs:table id="data-table" class="table table-striped table-bordered responsive" onrender="${path }/appInfo/list">
		           			<cs:column dataField="appCode" name="<input type='checkbox' style='text-align:center' class='_all'>" renderFn="operator"/>
		           			<cs:column dataField="appCode" name="申请编号"/>
		           			<cs:column dataField="loanTime" name="放款日期" type="date" format="YYYY-MM-DD"/>
		           			<cs:column dataField="idType" name="证件类型" type="dict" format="_id_type"/>
		           			<cs:column dataField="idno" name="证件号码"/>
		           			<cs:column dataField="proppserName" name="客户姓名"/>
		           			<cs:column dataField="eachIssueAmount" name="每月租金"/>
		           			<cs:column dataField="loanPeriods" name="融资期限"/>
		           			<cs:column dataField="alreadyInstalls" name="已还期数"/>
		           			<cs:column dataField="alreadyInstalls" name="剩余本金"/>
		           			<cs:column dataField="overdueDays" name="逾期天数"/>
		           			<cs:column dataField="overdueRange" name="逾期区间"/>
		           			<cs:column dataField="dealerName" name="提报店面名称"/>
		           			<cs:column dataField="vehdisStatus" name="是否已收车" type="dict" format="_is"/>
		           			<cs:column dataField="collPhoneOperator" name="电催人员"/>
		           		</cs:table>
		           </div>
		       </div>
	       </div>
       </div>
	</div>
</body>
</html>
