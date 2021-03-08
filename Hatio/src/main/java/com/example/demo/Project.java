package com.example.demo;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project 
{	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String projectName;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Tasks> list;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int id, String projectName, List<Tasks> list) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.list = list;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", list=" + list + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Tasks> getList() {
		return list;
	}
	public void setList(List<Tasks> list) {
		this.list = list;
	}
}
