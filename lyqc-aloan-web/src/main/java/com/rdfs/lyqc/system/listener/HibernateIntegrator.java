package com.rdfs.lyqc.system.listener;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  
 
@Service  
public class HibernateIntegrator {  
   
	/**
	 * 注册hibernate事件监听
	 */
	
   @Autowired  
   private AuditListener auditListener;  
 
   @Autowired  
   private SessionFactory sessionFactory;  
 
 
   @PostConstruct  
   public void registerListeners() {  
       EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(  
               EventListenerRegistry.class);  
       registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(auditListener);  
       registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(auditListener);  
       registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(auditListener);  
   }
 
}  