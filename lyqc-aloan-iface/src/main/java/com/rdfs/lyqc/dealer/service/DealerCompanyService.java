package com.rdfs.lyqc.dealer.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.dealer.entity.SyDealerCompany;

public interface DealerCompanyService extends HibernateService {

	void saveDealerCompany(SyDealerCompany company);

	void updateDealerCompany(SyDealerCompany company);

}
