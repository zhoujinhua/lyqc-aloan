package com.rdfs.lyqc.workflow.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rdfs.core.contants.Constants;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.workflow.entity.CwRunTask;
import com.rdfs.lyqc.workflow.service.RunTaskService;

@Service
public class RunTaskServiceImpl extends HibernateServiceSupport implements RunTaskService {

	@Override
	public CwRunTask getRunTask(String businessKey, String flowName) {
		List<CwRunTask> runTasks = getList("from CwRunTask where businessKey = '" + businessKey + "' and processInfo.code = '" + flowName + "'"
				+ " and status = '" + Constants.IS.YES + "'");
		if(runTasks!=null && !runTasks.isEmpty()){
			return runTasks.get(0);
		}
		return null;
	}

}
