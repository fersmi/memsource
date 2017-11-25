package com.memsource.service;

import com.memsource.model.Configuration;

public interface IConfigurationService {

	Configuration getConfiguration();

	void persist(Configuration configuration);

}
