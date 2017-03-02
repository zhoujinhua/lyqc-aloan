package com.rdfs.lyqc.workflow.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.workflow.entity.CwRunExecution;

public interface RunExecutionService extends HibernateService {

	/**
	 * 根据业务主键+流程代码+节点代码查找最近一次的提交记录
	 * @param businessKey 业务主键
	 * @param flowName 流程代码
	 * @param userIdentify 节点代码
	 * @return
	 */
	CwRunExecution getRunExecution(String businessKey, String flowName, String userIdentify);

}
