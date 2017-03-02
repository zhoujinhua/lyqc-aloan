package com.rdfs.lyqc.system.service;

import java.io.Serializable;
import java.util.List;

import com.rdfs.lyqc.common.dto.TreeDto;

public interface TreeService {

	<T extends Serializable> List<TreeDto> getList(List<T> list, String idField, String nameField, String pIdField, List<T> pList)
			throws Exception;

}
