package com.atmecs.many_to_many.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.atmecs.many_to_many.entity.Project_Details;
import com.atmecs.many_to_many.entity.Team_Details;

public class HibernateUtility 
{
	public static Session getHibernateSession()
	{
		final SessionFactory factory = new Configuration().addAnnotatedClass(Team_Details.class)
				.addAnnotatedClass(Project_Details.class)
		        .configure("hibernate.cfg.xml").buildSessionFactory();
		
		final Session session = factory.openSession();
		
	    return session;
	}
}
