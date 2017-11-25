package com.memsource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Configuration {

	@Id
	private Long id;

	@Column(nullable = false)
	@NotBlank(message = "Username is required.")
	private String username;

	@Column(nullable = false)
	@NotBlank(message = "Password is required.")
	private String password;

}
