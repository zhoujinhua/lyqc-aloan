package com.rdfs.lyqc.division.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfs.framework.core.bean.TreeDto;
import com.rdfs.framework.core.bean.UserDto;
import com.rdfs.framework.core.contants.Constants;
import com.rdfs.framework.core.utils.AuthUtil;
import com.rdfs.framework.core.utils.StringUtils;
import com.rdfs.framework.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.dianc.entity.DhOverdueDetail;
import com.rdfs.lyqc.dianc.service.OverdueDetailService;
import com.rdfs.lyqc.division.entity.DhDivisionRule;
import com.rdfs.lyqc.division.entity.DhDivisionUser;
import com.rdfs.lyqc.division.service.DivisionRuleService;
import com.rdfs.lyqc.system.entity.SyUser;
import com.rdfs.lyqc.system.entity.SyUserDepartment;
import com.rdfs.lyqc.system.service.UserService;

@Service
public class DivisionRuleServiceImpl extends HibernateServiceSupport implements DivisionRuleService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OverdueDetailService overdueDetailService;
	
	@Override
	public void saveRule(DhDivisionRule rule) {
		if(rule.getId()!=null){
			updateEntity(rule, "name", "type", "status", "depend", "min", "max", "remark");
		} else {
			UserDto userDto = AuthUtil.getCurrentUserDto();
			rule.setCreateTime(new Date());
			rule.setUserId(userDto.getUserId());
			rule.setUserName(userDto.getTrueName());
			saveEntity(rule);
		}
	}

	@Override
	public List<TreeDto> formatUserTree(DhDivisionRule rule) throws Exception {
		rule = getEntityById(DhDivisionRule.class, rule.getId(), true);
		List<SyUser> userList = new ArrayList<SyUser>();
		if(rule.getDivisionUsers()!=null && !rule.getDivisionUsers().isEmpty()){
			for(DhDivisionUser divisionUser : rule.getDivisionUsers()){
				userList.add(divisionUser.getUser());
			}
		}
		SyUser user = new SyUser(null, Constants.IS.YES);
		user.setUserDeparment(new SyUserDepartment("", null));
		return userService.formatUserTree(user, userList);
	}

	@Override
	public void updateUserSet(DhDivisionRule rule, String[] split) {
		rule = getEntityById(DhDivisionRule.class, rule.getId(), true);
		rule.getDivisionUsers().clear();
		for(String part : split){
			SyUser user = userService.getEntityByCode(SyUser.class, part, false);
			DhDivisionUser divisionUser = new DhDivisionUser();
			divisionUser.setRule(rule);
			divisionUser.setUser(user);
			rule.getDivisionUsers().add(divisionUser);
		}
	}

	@Override
	public List<DhDivisionRule> getInitList(String status) {
		DhDivisionRule rule = new DhDivisionRule();
		rule.setStatus(status);
		List<DhDivisionRule> divisionRules = getList(rule, "status");
		if(divisionRules!=null && !divisionRules.isEmpty()){
			for(DhDivisionRule divisionRule : divisionRules){
				Hibernate.initialize(divisionRule.getDivisionUsers());
				if(divisionRule.getDivisionUsers()!=null && !divisionRule.getDivisionUsers().isEmpty()){
					for(DhDivisionUser divisionUser : divisionRule.getDivisionUsers()){
						Hibernate.initialize(divisionUser.getUser());
					}
				}
			}
		}
		return divisionRules;
	}

	@Override
	public DhDivisionRule getInitRule(DhDivisionRule rule) {
		rule = getEntityById(DhDivisionRule.class, rule.getId(), true);
		if(rule.getDivisionUsers()!=null && !rule.getDivisionUsers().isEmpty()){
			for(DhDivisionUser divisionUser : rule.getDivisionUsers()){
				Hibernate.initialize(divisionUser.getUser());
			}
		}
		return rule;
	}

	@Override
	public void updateUserSet(String userId, String appCodes) {
		if(StringUtils.isBlank(userId)){
			throw new RuntimeException("未找到被指派的催收员.");
		}
		SyUser user = userService.getEntityByCode(SyUser.class, userId, false);
		if(StringUtils.isBlank(appCodes)){
			throw new RuntimeException("未选中申请单.");
		}
		List<DhOverdueDetail> overdueDetails = new ArrayList<>();
		for(String appCode : appCodes.split(",")){
			DhOverdueDetail overdueDetail = new DhOverdueDetail();
			overdueDetail.setAppCode(appCode);
			overdueDetail.setCollPhoneOperator(user.getUserId());
			overdueDetail.setCollPhoneOperatorName(user.getTrueName());
			overdueDetails.add(overdueDetail);
		}
		overdueDetailService.updateOverdueDetail(overdueDetails, com.rdfs.lyqc.common.constant.Constants.ASSIGN_TYPE.OPER);
	}
}
