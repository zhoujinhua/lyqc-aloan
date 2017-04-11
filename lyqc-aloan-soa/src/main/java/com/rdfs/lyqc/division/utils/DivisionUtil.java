package com.rdfs.lyqc.division.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rdfs.framework.core.spring.SpringContextBeanFactory;
import com.rdfs.lyqc.common.constant.Constants;
import com.rdfs.lyqc.dianc.entity.DhOverdueDetail;
import com.rdfs.lyqc.dianc.service.OverdueDetailService;
import com.rdfs.lyqc.division.entity.DhDivisionRule;
import com.rdfs.lyqc.division.entity.DhDivisionUser;
import com.rdfs.lyqc.division.service.DivisionRuleService;
import com.rdfs.lyqc.system.entity.SyUser;

public class DivisionUtil {

	private static OverdueDetailService overdueDetailService = SpringContextBeanFactory.getBean("overdueDetailServiceImpl");
	private static DivisionRuleService divisionRuleService = SpringContextBeanFactory.getBean("divisionRuleServiceImpl");
	static List<DhOverdueDetail> overdueDetails = new ArrayList<>();
	static int i = 0;
	
	
	public static void control(){
		List<DhDivisionRule> divisionRules = divisionRuleService.getInitList(com.rdfs.framework.core.contants.Constants.IS.YES);
		if(divisionRules!=null && !divisionRules.isEmpty()){
			for(DhDivisionRule divisionRule : divisionRules){
				runSingle(divisionRule);
			}
		}
	}
	
	public static void runSingle(DhDivisionRule rule){
		List<DhDivisionUser> divisionUsers = rule.getDivisionUsers();
		if(divisionUsers!=null && !divisionUsers.isEmpty()){
			List<SyUser> userList = new ArrayList<>();
			for(DhDivisionUser divisionUser : divisionUsers){
				userList.add(divisionUser.getUser());
			}
			Collections.shuffle(userList);
			i = 0;
			division(rule, userList, 0, 300);
			if(overdueDetails!=null && !overdueDetails.isEmpty()){
				overdueDetailService.updateOverdueDetail(overdueDetails, Constants.ASSIGN_TYPE.AUTO);
				overdueDetails.clear();
			}
		}
	}
	
	public static void division(DhDivisionRule rule, List<SyUser> userList, int start, int limit){
		List<?> list = overdueDetailService.getPreDivisionList(rule, start, limit);
		if(list!=null && !list.isEmpty()){
			for(Object obj : list){
				String appCode = String.valueOf(obj);
				
				DhOverdueDetail overdueDetail = new DhOverdueDetail();
				overdueDetail.setAppCode(appCode);
				overdueDetail.setCollPhoneOperator(userList.get(i).getUserId());
				overdueDetail.setCollPhoneOperatorName(userList.get(i).getTrueName());
				overdueDetails.add(overdueDetail);
				if(i == userList.size()-1){
					i = 0;
				} else {
					i ++;
				}
				if(overdueDetails.size() >= 300){
					overdueDetailService.updateOverdueDetail(overdueDetails, Constants.ASSIGN_TYPE.AUTO);
					overdueDetails.clear();
				}
			}
			start += 1;
			division(rule, userList, start, limit);
		}
	}
}
