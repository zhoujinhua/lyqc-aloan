package com.rdfs.lyqc.dianc.service;

import java.util.List;

import com.rdfs.framework.hibernate.service.HibernateService;
import com.rdfs.lyqc.dianc.entity.DhOverdueDetail;
import com.rdfs.lyqc.division.entity.DhDivisionRule;

public interface OverdueDetailService extends HibernateService {

	List<?> getPreDivisionList(DhDivisionRule rule, int start, int limit);

	void updateOverdueDetail(List<DhOverdueDetail> overdueDetails, String assignType);
}
