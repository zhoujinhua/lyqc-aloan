package com.rdfs.lyqc.cust.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.rdfs.core.bean.UserDto;
import com.rdfs.core.contants.Constants;
import com.rdfs.core.utils.AuthUtil;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cust.entity.DhContactAddr;
import com.rdfs.lyqc.cust.entity.DhContactPhone;
import com.rdfs.lyqc.cust.entity.DhPhoneRemark;
import com.rdfs.lyqc.cust.service.PhoneRemarkService;

@Service
public class PhoneRemarkServiceImpl extends HibernateServiceSupport implements PhoneRemarkService {

	@Override
	public void savePhoneRemark(DhPhoneRemark remark, DhContactAddr addr) {
		DhContactPhone contactPhone = remark.getPhone();
		UserDto userDto = AuthUtil.getCurrentUserDto();
		String status = contactPhone.getPhoneStatus();
		if(contactPhone.getId() != null){
			contactPhone = getEntityById(DhContactPhone.class, contactPhone.getId(), true);
			contactPhone.setPhoneStatus(status);
		} else {
			contactPhone.setDataSource(Constants.IS.NO);
			contactPhone.setRemarkOperator(userDto.getUserName());
			contactPhone.setRemarkTime(new Date());
			saveEntity(contactPhone);
		}
		remark.setPhone(contactPhone);
		remark.setRemarkTime(new Date());
		remark.setCollecStaff(userDto.getUserName());
		saveEntity(remark);
		
		if(addr.getAddr()!=null){
			addr.setPhone(contactPhone);
			addr.setDataSource(Constants.IS.NO);
			saveEntity(addr);
		}
	}

}
