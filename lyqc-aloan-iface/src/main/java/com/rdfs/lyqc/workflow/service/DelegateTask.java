package com.rdfs.lyqc.workflow.service;

import com.rdfs.lyqc.workflow.entity.CwNodeEvent;

public interface DelegateTask {

	String getBusinessKey();
	
	String getEventName();
	
	CwNodeEvent getNodeEvent();
	
	String getAssigenee();
	
}
