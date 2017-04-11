package com.rdfs.lyqc.dianc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rdfs.framework.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.dianc.entity.DhOverdueDetail;
import com.rdfs.lyqc.dianc.service.OverdueDetailService;
import com.rdfs.lyqc.division.entity.DhDivisionLog;
import com.rdfs.lyqc.division.entity.DhDivisionRule;
import com.rdfs.lyqc.division.entity.DhDivisionUser;

@Service
public class OverdueDetailServiceImpl extends HibernateServiceSupport implements OverdueDetailService{
	
	@Override
	public List<?> getPreDivisionList(DhDivisionRule rule, int start, int limit) {
		List<DhDivisionUser> divisionUsers = rule.getDivisionUsers();
		StringBuffer sb = new StringBuffer();
		for(DhDivisionUser divisionUser : divisionUsers){
			sb.append("'" + divisionUser.getUser().getUserName() + "',");
		}
		
		String sql = "SELECT DD.APP_CODE FROM DH_OVERDUE_DETAIL DD INNER JOIN DM_APP_INFO DAI ON DD.APP_CODE = DAI.APP_CODE "
				+ "WHERE VEHDIS_STATUS <> '1' AND OVERDUE_TERMS > "+ rule.getMin() +" AND OVERDUE_TERMS <= "+ rule.getMax() +
				" AND COLL_PHONE_OPERATOR NOT IN ("+ sb.substring(0, sb.length()-1) +") ORDER BY DAI.DEALER_PROVINCE DESC";
		
		return getSqlList(sql, start, limit);
	}

	@Override
	public void updateOverdueDetail(List<DhOverdueDetail> overdueDetails, String assignType) {
		if(overdueDetails!=null && !overdueDetails.isEmpty()){
			for(DhOverdueDetail overdueDetail : overdueDetails){
				updateEntity(overdueDetail, "collPhoneOperator");
				DhDivisionLog log = new DhDivisionLog();
				log.setAppCode(overdueDetail.getAppCode());
				log.setAssignDate(new Date());
				log.setUserId(overdueDetail.getCollPhoneOperator());
				log.setUserName(overdueDetail.getCollPhoneOperatorName());
				log.setAssignType(assignType);
				saveEntity(log);
			}
		}
	}

}
