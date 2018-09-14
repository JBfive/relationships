package com.jym.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jym.relationships.models.License;
import com.jym.relationships.models.Person;
import com.jym.relationships.services.LicenseService;
import com.jym.relationships.services.PersonService;

@Controller

public class LicenseController {
	private final LicenseService licServ;
	private final PersonService perServ;
	
	public LicenseController(LicenseService licServ, PersonService perServ) {
		this.licServ = licServ;
		this.perServ = perServ;
	}
	@RequestMapping("/licenses/new")
	public String licNew(@Valid @ModelAttribute("licenses") License license, Model model) {
		model.addAttribute("personList", perServ.allPersons());
		return "newlicense.jsp";
	}
	@RequestMapping(value="/create_license", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("licenses") License license, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("We did NOT make it/controller");
			return "/licenses/new";
		} else {
			System.out.println("We made it in controller");
			licServ.createLicense(license);
			return "redirect:/licenses/new";
		}
	}
	@RequestMapping("/persons/{id}")
	public String display(@PathVariable("id") Long id, License license, Person person, Model model) {
		model.addAttribute("person", perServ.findPerson(id));
		model.addAttribute("license", licServ.findLicense(id));
		return "details.jsp";
	}
	
}
