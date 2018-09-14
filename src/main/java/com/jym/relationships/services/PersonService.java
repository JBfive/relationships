package com.jym.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jym.relationships.models.Person;
import com.jym.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository perRepo;
	
	public PersonService(PersonRepository perRepo) {
		this.perRepo = perRepo;
	}
	
	public List<Person> allPersons() {
		return perRepo.findAll();
	}
	public Person createPerson(Person person) {
		return (Person) perRepo.save(person);
	}
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = perRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
}
