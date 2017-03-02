package com.rdfs.lyqc.workflow.service;

import com.rdfs.lyqc.workflow.entity.CwRunTask;

public interface TaskListener {

	void notify(CwRunTask task);
}
