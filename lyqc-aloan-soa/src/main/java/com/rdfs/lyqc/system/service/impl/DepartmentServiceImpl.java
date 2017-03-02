package com.rdfs.lyqc.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfs.core.contants.Constants;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.common.dto.TreeDto;
import com.rdfs.lyqc.system.entity.SyDepartment;
import com.rdfs.lyqc.system.service.DepartmentService;
import com.rdfs.lyqc.system.service.TreeService;

@Service
public class DepartmentServiceImpl extends HibernateServiceSupport implements DepartmentService {

	@Autowired
	private TreeService treeService;
	
	@Override
	public void saveDepartment(SyDepartment department) {
		department.setCrtTime(new Date());
		if(department.getParDepartment() == null || department.getParDepartment().getDepartmentId() == null){
			department.setParDepartment(null);
		}
		if(department.getDepartmentId()!=null){
			updateEntity(department, "parDepartment","departmentName","status","remark");
		} else {
			saveEntity(department);
		}
	}

	@Override
	public List<TreeDto> genDeptTree() throws Exception {
		String hql = "from SyDepartment where status = '" + Constants.IS.YES + "'";
		List<SyDepartment> list = getList(hql);
		List<TreeDto> treeList = treeService.getList(list, "departmentId", "departmentName", "parDepartment.departmentId", null);
		return treeList;
	}
}
