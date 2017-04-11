package com.rdfs.lyqc.division.service;

import com.rdfs.framework.hibernate.bean.Page;
import com.rdfs.framework.hibernate.service.HibernateService;
import com.rdfs.lyqc.division.entity.DhDivisionLog;

public interface DivisionLogService extends HibernateService{

	Page pageList(DhDivisionLog log, Page page);

}
