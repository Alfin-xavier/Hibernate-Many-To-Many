package com.atmecs.many_to_many.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
@Table(name = "project")
public class Project_Details 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int p_id;
	
	@Column(name = "p_name")
	private String p_name;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "employee",joinColumns = {@JoinColumn(name = "p_id")}, 
					inverseJoinColumns = {@JoinColumn(name = "t_id")})
	private List<Team_Details> team_det ;
	
	public Project_Details(String p_name) 
	{
		this.p_name = p_name;
	}

	public void addTeam(Team_Details team_det)
	{
		if(this.team_det==null)
			this.team_det = new ArrayList<>();
		this.team_det.add(team_det);
		//team_det.addProject(this);
		
	}
	
	public Project_Details() 
	{

	}

	public int getP_id()
	{
		return p_id;
	}

	public void setP_id(int p_id) 
	{
		this.p_id = p_id;
	}

	public String getP_name() 
	{
		return p_name;
	}

	public void setP_name(String p_name)
	{
		this.p_name = p_name;
	}

	public List<Team_Details> getTeam_det() 
	{
		return team_det;
	}

	public void setTeam_det(List<Team_Details> team_det)
	{
		this.team_det = team_det;
	}
	
	
	
}
