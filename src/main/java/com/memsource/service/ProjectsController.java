package com.memsource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memsource.model.transfer.Project;

@RestController
@RequestMapping("/api/projects")
public class ProjectsController {

	@Autowired
	private IProjectService projectService;

	@GetMapping
	public List<Project> getProjects() {
		return projectService.getProjects();
	}
}
