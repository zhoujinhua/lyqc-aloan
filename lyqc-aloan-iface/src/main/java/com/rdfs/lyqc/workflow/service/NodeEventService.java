package com.rdfs.lyqc.workflow.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.workflow.entity.CwNodeEvent;
import com.rdfs.lyqc.workflow.entity.CwTaskNode;

public interface NodeEventService extends HibernateService{

	/**
	 * 根据任务节点+动作找到指定的节点事件
	 * @param treeNode 任务节点
	 * @param action 事件
	 * @return
	 */
	CwNodeEvent getNodeEvent(CwTaskNode taskNode, String action);

}
