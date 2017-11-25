package com.memsource.service;

import java.util.List;

import com.memsource.model.transfer.Project;
import com.memsource.model.transfer.Token;

public interface IProjectRepository {

	public Token getToken(String url);

	public List<Project> findAll(String url);
}
