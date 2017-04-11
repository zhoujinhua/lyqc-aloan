package com.rdfs.lyqc.shouc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfs.framework.core.utils.AuthUtil;
import com.rdfs.framework.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.framework.workflow.service.WorkflowService;
import com.rdfs.lyqc.dianc.entity.DhOverdueDetail;
import com.rdfs.lyqc.shouc.entity.DhClocarReg;
import com.rdfs.lyqc.shouc.service.ClocarRegService;

@Service
public class ClocarRegServiceImpl extends HibernateServiceSupport implements ClocarRegService {

	@Autowired
	private WorkflowService workflowService;
	
	@Override
	public void saveReg(DhClocarReg reg) {
		reg.setCollStaff(AuthUtil.getCurrentUserDto().getUserName());
		reg.setRemarkTime(new Date());
		saveEntity(reg);
		
		String status = workflowService.getNextRoute(reg.getId()+"", "shouche", null);
		//workflowService.completeTask(reg.getId(), flowName, action);
		
		DhOverdueDetail detail = getEntityByCode(DhOverdueDetail.class, reg.getAppCode(), true);
		detail.setClocarReqDate(new Date());
		
	}

}
