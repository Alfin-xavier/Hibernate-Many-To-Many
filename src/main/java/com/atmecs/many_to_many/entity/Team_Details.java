package com.atmecs.many_to_many.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team_Details 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
	private int t_id;
    
    @Column(name = "t_name")
	private String t_name;
	
	private Set<Project_Details> project_det = new HashSet<Project_Details>();

	public int getT_id() 
	{
		return t_id;
	}

	public void setT_id(int t_id) 
	{
		this.t_id = t_id;
	}

	public String getT_name() 
	{
		return t_name;
	}

	public void setT_name(String t_name) 
	{
		this.t_name = t_name;
	}

	public void addProject(Project_Details project_det)
	{
		this.project_det.add(project_det);
	}
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "employee",joinColumns = {@JoinColumn(name = "t_id")}, 
					inverseJoinColumns = {@JoinColumn(name = "p_id")})
	
	public Set<Project_Details> getProject_det() 
	{
		return project_det;
	}

	public void setProject_det(Set<Project_Details> project_det) 
	{
		this.project_det = project_det;
	}

	public Team_Details()
	{
 
	}

	public Team_Details(String t_name) 
	{
		this.t_name = t_name;
	}
	
}
