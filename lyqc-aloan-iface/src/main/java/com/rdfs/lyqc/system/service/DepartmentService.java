package com.rdfs.lyqc.system.service;

import java.util.List;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyDepartment;
import com.rdfs.lyqc.common.dto.TreeDto;

public interface DepartmentService extends HibernateService {

	void saveDepartment(SyDepartment department);

	List<TreeDto> genDeptTree() throws Exception;
}
