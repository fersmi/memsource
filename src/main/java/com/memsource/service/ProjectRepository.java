package com.memsource.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.memsource.model.transfer.Project;
import com.memsource.model.transfer.Token;

@Repository
public class ProjectRepository implements IProjectRepository {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Token getToken(String url) {
		return restTemplate.getForObject(url, Token.class);
	}

	@Override
	public List<Project> findAll(String url) {
		ResponseEntity<Project[]> responseEntity = restTemplate.getForEntity(url, Project[].class);
		return Arrays.asList(responseEntity.getBody());
	}

}
