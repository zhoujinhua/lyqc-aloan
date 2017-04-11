package com.rdfs.lyqc.system.service;

import java.util.List;

import com.rdfs.framework.core.bean.TreeDto;
import com.rdfs.framework.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyDepartment;

public interface DepartmentService extends HibernateService {

	void saveDepartment(SyDepartment department);

	List<TreeDto> genDeptTree() throws Exception;
}
