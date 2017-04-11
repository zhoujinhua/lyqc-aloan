package com.rdfs.lyqc.division.service.impl;

import org.springframework.stereotype.Service;

import com.rdfs.framework.core.utils.RdfsUtils;
import com.rdfs.framework.core.utils.StringUtils;
import com.rdfs.framework.hibernate.bean.Page;
import com.rdfs.framework.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.division.entity.DhDivisionLog;
import com.rdfs.lyqc.division.service.DivisionLogService;

@Service
public class DivisionLogServiceImpl extends HibernateServiceSupport implements DivisionLogService{

	@Override
	public Page pageList(DhDivisionLog log, Page page) {
		String hql = "from DhDivisionLog where 1=1 ";
		if(log!=null){
			if(!StringUtils.isBlank(log.getAppCode())){
				hql += " and appCode like '%" + log.getAppCode() + "%'";
			}
			if(!StringUtils.isBlank(log.getUserId())){
				hql += " and userId = '" + log.getUserId() + "'";
			}
			if(log.getAssignDate()!=null){
				hql += " and date_format(assignDate, '%Y-%m-%d') = '" + RdfsUtils.date2String(log.getAssignDate(), "YYYY-MM-DD");
			}
		}
		hql += " order by assignDate desc";
		return pageList(page, hql);
	}

}
