package com.memsource.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.memsource.model.Configuration;

@Controller
@Transactional
@RequestMapping("/")
public class ConfigurationController {

	@Autowired
	private IConfigurationService configurationService;

	@PostMapping("credentials")
	public ModelAndView update(@Valid Configuration configuration, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("credentials", "formErrors", result.getAllErrors());
		}
		configurationService.persist(configuration);
		redirect.addFlashAttribute("globalMessage", "Configuration successfully updated");
		return new ModelAndView("redirect:/credentials");
	}

	@GetMapping({ "/", "projects" })
	public String list() {
		return "projects";
	}

	@GetMapping("credentials")
	public ModelAndView edit() {
		Configuration configuration = configurationService.getConfiguration();
		if (configuration == null) {
			configuration = new Configuration();
		}
		return new ModelAndView("credentials", "configuration", configuration);
	}

}