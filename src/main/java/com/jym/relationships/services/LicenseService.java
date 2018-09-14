package com.jym.relationships.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jym.relationships.models.License;
import com.jym.relationships.repositories.LicenseRepository;
import com.jym.relationships.repositories.PersonRepository;

@Service
public class LicenseService {
	private final LicenseRepository licRepo;
	private final PersonRepository perRepo;
	
	public LicenseService(LicenseRepository licRepo, PersonRepository perRepo) {
		this.licRepo = licRepo;
		this.perRepo = perRepo;
	}
	
	public License createLicense(License lic) {
		long count = licRepo.count()+1;
		lic.setNumber(String.format("%05d", count));
		
		System.out.println("We made it to Service");
		return (License) licRepo.save(lic);
	}
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licRepo.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
//	public List<License> getLicenses(){
//		return licRepo.findByArtistContaining(artist);
//	} needs more work on this one if we are going to use it
	
	 
}
