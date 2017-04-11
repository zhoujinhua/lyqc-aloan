<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://javass.cn/common/" prefix="cs"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" id="myModalLabel">客户信息</h4>
	</div>
	<h5 class="bottom-line">基本信息</h5>
	<div class="form-group">
		<label class="control-label col-sm-1">姓名</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.proppserName}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">证件类型</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">证件号码</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">性别</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">出生日期</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.birth}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">与申请人关系</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.relativeType}" class="form-control"/>
		</div>
	</div>
	<h5 class="bottom-line">职业信息</h5>
	<div class="form-group">
		<label class="control-label col-sm-1">单位名称</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.marriage}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">从事行业</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.age}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">担保人职位</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.email}" class="form-control"/>
		</div>
	</div>
	<h5 class="bottom-line">地址、联系方式</h5>
	<div class="form-group">
		<label class="control-label col-sm-1">单位所在省份</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">单位所在城市</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">固定电话</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">单位详细地址</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">现居住地省份</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idNo}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">现居住地城市</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.sex}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">现居住地电话</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">现居住地详细地址</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">户籍地省份</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1">户籍地城市</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">电话</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.sex}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">户籍地详细地址</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idType}" class="form-control"/>
		</div>
	</div>
	<h5 class="bottom-line">收入信息</h5>
	<div class="form-group">
		<label class="control-label col-sm-1">税后年薪</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idType}" class="form-control"/>
		</div>
		<label class="control-label col-sm-1">其他税后年收入</label>
		<div class="col-sm-3">
			<cs:label value="${contactInfo.idNo}" class="form-control"/>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</body>
</html>
