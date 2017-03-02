package com.rdfs.lyqc.workflow.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.workflow.entity.CwRunTask;

public interface RunTaskService extends HibernateService{

	CwRunTask getRunTask(String businessKey, String flowName);

}
