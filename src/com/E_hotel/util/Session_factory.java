package com.E_hotel.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Session_factory implements ISession_factory {
	Configuration configuration = new Configuration();
	
	public  SessionFactory getFactory() {
		
			
			configuration.configure("hibernate.cfg.xml");

			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			return configuration.buildSessionFactory(serviceRegistry);
	}

}