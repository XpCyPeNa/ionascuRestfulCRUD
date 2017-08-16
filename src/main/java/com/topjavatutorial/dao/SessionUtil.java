package com.topjavatutorial.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class SessionUtil {

	private static SessionUtil instance = new SessionUtil();
	private SessionFactory sessionFactory;

	public static SessionUtil getInstance() {
		return instance;
	}

	//@SuppressWarnings("deprecation")
	private SessionUtil(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

	public static Session getSession() {
		Session session = getInstance().sessionFactory.openSession();

		return session;
	}
}
/*
 * sessionFactory = configuration.buildSessionFactory();
 * 
 * private static SessionFactory sessionFactory; private static ServiceRegistry
 * serviceRegistry;
 * 
 * public static SessionFactory createSessionFactory() { Configuration
 * configuration = new Configuration(); configuration.configure();
 * ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
 * configuration.getProperties()). buildServiceRegistry(); sessionFactory =
 * configuration.buildSessionFactory(serviceRegistry); return sessionFactory; }
 */