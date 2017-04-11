package com.rdfs.lyqc.dianc.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.rdfs.framework.core.contants.Constants;
import com.rdfs.framework.core.utils.AuthUtil;
import com.rdfs.framework.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.dianc.entity.DhCollectionReg;
import com.rdfs.lyqc.dianc.entity.DhOverdueDetail;
import com.rdfs.lyqc.dianc.service.CollectionRegService;

@Service
public class CollectionRegServiceImpl extends HibernateServiceSupport implements CollectionRegService {

	@Override
	public void saveReg(DhCollectionReg reg) {
		reg.setCollStaff(AuthUtil.getCurrentUserDto().getUserName());
		reg.setIsCollReg(Constants.IS.YES);
		reg.setRemarkTime(new Date());
		reg.setProceStatus(Constants.IS.YES);
		saveEntity(reg);
		
		DhOverdueDetail detail = getEntityByCode(DhOverdueDetail.class, reg.getAppCode(), true);
		detail.setOverdueStatus(reg.getCollStatus());
		if(reg.getPromisedRepayDate() != null){
			detail.setPromisedRepayDate(reg.getPromisedRepayDate());
		}
	}

}
