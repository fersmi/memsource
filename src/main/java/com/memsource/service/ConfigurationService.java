package com.memsource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memsource.model.Configuration;

@Service
public class ConfigurationService implements IConfigurationService {

	private static final Long CONFIGURATION_ID = 1L;

	@Autowired
	private IConfigurationRepository configurationRepository;

	@Override
	public Configuration getConfiguration() {
		return configurationRepository.findOne(CONFIGURATION_ID);
	}

	@Override
	public void persist(Configuration configuration) {
		if (configuration.getId() == null) {
			configuration.setId(CONFIGURATION_ID);
		}

		configurationRepository.save(configuration);
	}

}