package com.atmecs.many_to_many.crud_ops;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import com.atmecs.many_to_many.entity.Project_Details;
import com.atmecs.many_to_many.entity.Team_Details;

public class AddingDetails 
{
	@Test
	public void addDetails()
	{
		final Session session = com.atmecs.many_to_many.utility.HibernateUtility.getHibernateSession();
		try 
		{
			
			  Transaction transaction = session.beginTransaction();
			  
				Team_Details team_det1 = new Team_Details("SDET");
				Team_Details team_det2 = new Team_Details("SAPHO");

				Project_Details project_det1 = new Project_Details("Automation Testing");
				Project_Details project_det2 = new Project_Details("Developing Microapps");

				team_det1.addProject(project_det1);
				team_det1.addProject(project_det2);
				team_det2.addProject(project_det1);
				
				project_det1.addTeam(team_det1);
				project_det1.addTeam(team_det2);
				project_det2.addTeam(team_det2);
				
			session.save(team_det1);
			session.save(team_det2);
			transaction.commit();
		}
		finally 
		{
			session.close();
		}
	}
}
