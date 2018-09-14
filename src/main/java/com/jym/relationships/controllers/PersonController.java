package com.jym.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jym.relationships.models.Person;
import com.jym.relationships.services.PersonService;

@Controller
public class PersonController {
	private final PersonService perServ;
	
	public PersonController(PersonService perServ) {
		this.perServ = perServ;
	}
	
	@RequestMapping("/persons/new")
	public String perNew(@Valid @ModelAttribute("persons") Person person) {
		return "newperson.jsp";
	}
	@RequestMapping(value="/create_person", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("persons") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/persons/new";
		}else {
			perServ.createPerson(person);
			return "redirect:/persons/new";
		}
	}
}
