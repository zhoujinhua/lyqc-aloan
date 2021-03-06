package com.rdfs.lyqc.workflow.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import com.rdfs.core.contants.Constants;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.workflow.entity.CwProcessInfo;
import com.rdfs.lyqc.workflow.service.ProcessInfoService;

@Service
public class ProcessInfoServiceImpl extends HibernateServiceSupport implements ProcessInfoService {

	@Override
	public CwProcessInfo getLastProcess(String flowName){
		List<CwProcessInfo> list = getList(" from CwProcessInfo where code = '" + flowName + "' and status = '" + Constants.IS.YES + "' order by convert(version using GBK) desc");
		if(list!=null && !list.isEmpty()){
			CwProcessInfo processInfo = list.get(0);
			Hibernate.initialize(processInfo.getTaskNodes());
			return list.get(0);
		}
		return null;
	}
}
