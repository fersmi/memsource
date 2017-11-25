package com.memsource.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.memsource.model.Configuration;
import com.memsource.model.transfer.Project;
import com.memsource.model.transfer.Token;

@Service
public class ProjectService implements IProjectService {

	// TODO move to separate files with endpoints
	private static String PROJECTS_API_URL = "https://cloud.memsource.com/web/api/v3/project/list?token=";
	private static String TOKEN_API_URL = "https://cloud.memsource.com/web/api/v3/auth/login?userName=%s&password=%s";

	@Autowired
	private IProjectRepository projectRepository;

	@Autowired
	private IConfigurationService configurationService;

	@Override
	public List<Project> getProjects() {
		Configuration config = configurationService.getConfiguration();
		if (config == null || StringUtils.isEmpty(config.getUsername())) {
			return new ArrayList<>();
		}

		Token token = projectRepository
				.getToken(String.format(TOKEN_API_URL, config.getUsername(), config.getPassword()));

		return projectRepository.findAll(PROJECTS_API_URL + token != null ? token.getToken() : "");
	}

}
