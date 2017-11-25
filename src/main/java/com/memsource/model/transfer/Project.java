package com.memsource.model.transfer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

	private String name;
	private String status;
	private String sourceLang;
	private List<String> targetLangs;

}
