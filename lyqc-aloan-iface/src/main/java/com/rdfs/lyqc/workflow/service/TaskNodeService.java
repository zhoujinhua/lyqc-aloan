package com.rdfs.lyqc.workflow.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.workflow.entity.CwProcessInfo;
import com.rdfs.lyqc.workflow.entity.CwTaskNode;

public interface TaskNodeService extends HibernateService {

	/**
	 * 获取流程定义的起始节点
	 * @param processInfo 流程定义
	 * @return
	 */
	CwTaskNode getStartNode(CwProcessInfo processInfo);

	/**
	 * 获取流程定义的结束节点
	 * @param processInfo 流程定义
	 * @return
	 */
	CwTaskNode getEndNode(CwProcessInfo processInfo);
}
