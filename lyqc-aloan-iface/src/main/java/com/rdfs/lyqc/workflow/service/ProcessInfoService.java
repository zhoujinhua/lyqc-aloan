package com.rdfs.lyqc.workflow.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.workflow.entity.CwProcessInfo;

public interface ProcessInfoService extends HibernateService{

	CwProcessInfo getLastProcess(String flowName);

}
