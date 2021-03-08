package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tasks 
{	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String tasksName;
	boolean status=true;
	public Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tasks(int id, String tasksName, boolean status) {
		super();
		this.id = id;
		this.tasksName = tasksName;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Tasks [id=" + id + ", tasksName=" + tasksName + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTasksName() {
		return tasksName;
	}
	public void setTasksName(String tasksName) {
		this.tasksName = tasksName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
