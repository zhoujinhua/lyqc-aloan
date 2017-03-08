<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/common.tld" prefix="cs"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<h4 class="bottom-line">基本信息</h4>
	<div class="form-group">
		<label class="control-label col-sm-1">申请人姓名</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.proppserName}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">证件类型</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">证件号码</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">性别</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">出生日期</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.birth}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">手机号码</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.mobile}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">婚姻状况</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.marriage}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">年龄</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.age}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">电子邮箱</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.email}" class="form-control"/>
		</div>
	</div>
	<h4 class="bottom-line">职业信息</h4>
	<div class="form-group">
		<label class="control-label col-sm-1">单位名称</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">单位所在省份</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">单位所在城市</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">固定电话</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">企业性质</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">单位详细地址</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">所属行业</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">申请人职务</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">工作年限</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">税后年薪</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">其他税后年收入</label>
	</div>
	<h4 class="bottom-line">居住信息</h4>
	<div class="form-group">
		<label class="control-label col-sm-1">现居住地省份</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">现居住地城市</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">现居住地电话</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">现居住地详细地址</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">户籍地省份</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">户籍地城市</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">现居住地居住年限</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">户籍地详细地址</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
</body>
</html>
