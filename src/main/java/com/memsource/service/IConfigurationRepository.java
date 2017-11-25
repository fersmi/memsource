package com.memsource.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memsource.model.Configuration;

interface IConfigurationRepository extends JpaRepository<Configuration, Long> {

}
