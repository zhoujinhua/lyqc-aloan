<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/common.tld" prefix="cs"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<h5 class="bottom-line">逾期信息</h5>
	<div class="form-group">
		<label class="control-label col-sm-1">逾期天数</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.appCode}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">平均逾期天数</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.proppserName}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">逾期区间</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.loanTime}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">逾期金额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">逾期期数</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">已还期数</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">融资期限</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.marriage}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">历史最高逾期天数</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">累计逾期天数</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">豁免天数</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">逾期状态</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">风险等级</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">五级分类</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">客户当前是否逾期</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">当前车龄</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">二手车红保书金额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">销售实际剩余本金</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">销售当期剩余本金</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">财务实际剩余本金</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">财务当期剩余本金</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">车辆处置评估金额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">车辆处置金额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">车辆回收通知信</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">电催状态</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">电催操作人员</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">诉讼状态</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">诉讼操作人员</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">诉讼申请日期</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">家访状态</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">家访操作人员</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">家访申请日期</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">收车状态</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">收车操作人员</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">收车申请日期</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">车辆处置状态</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">车辆处置操作人员</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">车辆处置申请日期</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">核销状态</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">核销操作人员</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">核销申请日期</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">核销金额</label>
		<div class="col-sm-3">
			<cs:label value="${appInfo.contactInfo.idType}" class="form-control"/>
		</div>
	</div>
</body>
</html>
