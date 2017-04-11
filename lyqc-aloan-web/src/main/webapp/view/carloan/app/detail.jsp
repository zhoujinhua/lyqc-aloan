<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://javass.cn/common/" prefix="cs"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<h4 class="bottom-line">常用信息</h4>
	<div class="form-group">
		<label class="control-label col-sm-1">申请编号</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.appCode}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">客户姓名</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.proppserName}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">放款日期</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.loanTime}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">客户证件类型</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">客户证件号码</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">客户性别</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">婚姻状况</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.marriage}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">居住省</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">居住市</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">居住地址</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">贷款金额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">贷款期限</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">每月扣款日期</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">是否二手车</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">车辆类别</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">是否安装GPS</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">车辆品牌</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">车系</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">车型</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">颜色</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">车牌号</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">车架号</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">发动机号</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">GPS-SIM卡号</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">新车指导价</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">销售价</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">店面代码</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">店面名称</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">销售分区</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">区域负责人</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">融资专员</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">录单人姓名</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">录单人电话</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
	</div>
</body>
</html>
