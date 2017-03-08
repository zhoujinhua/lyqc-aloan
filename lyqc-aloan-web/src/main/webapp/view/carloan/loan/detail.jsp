<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/common.tld" prefix="cs"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<h4 class="bottom-line">融资信息</h4>
	<div class="form-group">
		<label class="control-label col-sm-1">还款频率</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.appCode}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">还款方式</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.proppserName}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">利率方式</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.loanTime}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">是否开票</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">固定值类型</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">GPS是否安装</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">融资期限</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.marriage}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">销售顾问</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">首付比例(%)</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">首付金额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">尾付比例(%)</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">尾付金额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">保证金比例(%)</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">保证金</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">保证金是否冲抵</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">保证金冲抵期数</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">手续费扣款方式</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">结算手续费率(%)</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">客户手续费率(一次性)</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">手续费金额(一次性)</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">是否贴息</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">贴息金额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">贴息固定值类型</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">补贴手续费</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">客户融资额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">每期客户租金</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">风控融资额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">风险融资额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
</body>
</html>
