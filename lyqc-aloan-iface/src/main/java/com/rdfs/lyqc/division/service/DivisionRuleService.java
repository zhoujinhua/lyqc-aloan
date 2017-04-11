package com.rdfs.lyqc.division.service;

import java.util.List;

import com.rdfs.framework.core.bean.TreeDto;
import com.rdfs.framework.hibernate.service.HibernateService;
import com.rdfs.lyqc.division.entity.DhDivisionRule;

public interface DivisionRuleService extends HibernateService {

	void saveRule(DhDivisionRule rule);

	List<TreeDto> formatUserTree(DhDivisionRule rule) throws Exception;

	void updateUserSet(DhDivisionRule rule, String[] split);

	List<DhDivisionRule> getInitList(String status);

	DhDivisionRule getInitRule(DhDivisionRule rule);

	void updateUserSet(String userId, String appCodes);

}
