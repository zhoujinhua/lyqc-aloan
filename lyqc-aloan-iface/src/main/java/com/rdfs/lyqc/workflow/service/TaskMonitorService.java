package com.rdfs.lyqc.workflow.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.workflow.entity.CwNodeEvent;
import com.rdfs.lyqc.workflow.entity.CwRunTask;

public interface TaskMonitorService extends HibernateService {

	void invoke(CwRunTask runTask, CwNodeEvent nodeEvent, String eventName) throws Exception;

}
