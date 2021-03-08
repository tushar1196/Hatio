package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController 
{	
	@Autowired
	ProjectRepo prepo;
	@Autowired
	TasksRepo trepo;
	
	@RequestMapping("taskhome{id}")
	public String taskhome(@PathVariable int id, Model m)
	{	
		Project project=prepo.findById(id).get();
		m.addAttribute("project", project);
		return "tasklist.jsp";
	}
	
	@RequestMapping("addtask{id}")
	public String addtask(@PathVariable int id, Model m)
	{
//		System.out.println(id);
		Project project=prepo.findById(id).get();
		Tasks task=new Tasks();
//		System.out.println(project);
		m.addAttribute("project", project);
		m.addAttribute("task", task);
		return "addtask.jsp";
	}
	
	@RequestMapping("tasksave{id}")
	public String savetask(Tasks task, @PathVariable int id)
	{
//		System.out.println("i m in tasksave");
//		System.out.println(task);
//		System.out.println(id);
		Project project=prepo.findById(id).get();
		
		project.list.add(task);
		prepo.save(project);
		System.out.println(project);
		return "redirect:viewtask"+id;
		
	}
	@RequestMapping("viewtask{id}")
	public String viewtask(@PathVariable int id, Model m)
	{
		Project project=prepo.findById(id).get();
		m.addAttribute("project", project);
		return "tasklist.jsp";
	}
	
	@RequestMapping("projecthome")
	public String projecthome(Model m)
	{
		//Project project=new Project();
		List<Project> plist=prepo.findAll();
		m.addAttribute("plist", plist);
		return "projecthome.jsp";
	}
	
	@RequestMapping("projectadd")
	public String projectadd(Model m)
	{
		Project project=new Project();
		m.addAttribute("project", project);
		return "projectadd.jsp";
	}
	
	@RequestMapping("projectsave")
	public String projectsave(Project project)
	{	
		prepo.save(project);
		return"redirect:projecthome";
	}
	
	@RequestMapping("task{tid}close{pid}")
	public String taskclose(@PathVariable int tid, @PathVariable int pid)
	{
		Project project=prepo.findById(pid).get();
		for (Tasks t : project.list)
		{
			if(t.id==tid)
			{
				t.status=false;
			}
		}
		prepo.save(project);
		return "redirect:viewtask"+pid;
	}
	
	@RequestMapping("task{tid}delete{pid}")
	public String taskdelete(@PathVariable int tid, @PathVariable int pid)
	{
		Project project=prepo.findById(pid).get();
		Tasks t=null;
		for (Tasks task : project.list)
		{
			if(task.id==tid)
			{
				t=task;
			}
		}
		project.list.remove(t);
		prepo.save(project);
		return "redirect:viewtask"+pid;
	}
	
	
	
	
	
	
	
}
