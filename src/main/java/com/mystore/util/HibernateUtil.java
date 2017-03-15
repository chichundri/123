package com.mystore.util;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// loads configuration and mappings
			Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
			configuration.addAnnotatedClass(com.mystore.entities.Productcategory.class);
			configuration.addAnnotatedClass(com.mystore.entities.Option.class);
			configuration.addAnnotatedClass(com.mystore.entities.Optiongroup.class);
			configuration.addAnnotatedClass(com.mystore.entities.Order.class);
			configuration.addAnnotatedClass(com.mystore.entities.Orderdetail.class);
			configuration.addAnnotatedClass(com.mystore.entities.ProdSubcategory.class);
			configuration.addAnnotatedClass(com.mystore.entities.Product.class);
			configuration.addAnnotatedClass(com.mystore.entities.Productoption.class);
			configuration.addAnnotatedClass(com.mystore.entities.User.class);
			
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
	public static void main(String[] args) {
		//how to use
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
		
		
	}
}