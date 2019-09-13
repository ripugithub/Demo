package com.demo.continent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.continent.model.Continent;
import com.demo.continent.repository.CountryRepo;

@Service
public class CountryService {
	
	private CountryRepo countryRepo;

	public CountryService(CountryRepo countryRepo) {
		super();
		this.countryRepo = countryRepo;
	}
	
	 public Iterable<Continent> list() {
	        return countryRepo.findAll();
	    }

	
	public Continent save(Continent continent) {
        return countryRepo.save(continent);
    }
	
	  public void save(List<Continent> continents) {
		  countryRepo.saveAll(continents);
	    }
	  
	  
}
