package com.demo.continent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.continent.exception.ContinentNotFoundException;
import com.demo.continent.model.Continent;
import com.demo.continent.model.Countries;
import com.demo.continent.repository.ContinentRepo;
import com.demo.continent.service.ContinentService;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

/**
 * @author Ripu
 *
 */
@RestController
@RequestMapping("/code")
public class ContinentController {

	private final Logger logger = LoggerFactory.getLogger(ContinentController.class);
	@Autowired
	private ContinentService continentService;
	@Autowired
	private ContinentRepo continentRepo;

	@GetMapping("/continents")
	public ResponseEntity<List<Continent>> getAllContinents() {
		logger.debug("---------------Fetching Continents-----------------");
		List<Continent> continentList = continentService.getAllContinents();
		
		if(continentList==null || continentList.size()==0)
		{
			throw new ContinentNotFoundException("No Continent found");
		}
		else {
		return new ResponseEntity<List<Continent>>(continentList, HttpStatus.OK);
		}

	}

	@GetMapping("/countries/{continentId}")
	public ResponseEntity<List<Countries>> getCountriesOfContinents(@PathVariable("continentId") Integer continentId) {
		logger.debug("---------------Fetching Countries within a continent-----------------");
		List<Countries> countryList = (List<Countries>) continentService.getCountriesInContinent(continentId);
		if(countryList==null || countryList.size()==0)
		{
			throw new ContinentNotFoundException("No Countries found");
		}
		else {
		return new ResponseEntity<List<Countries>>(countryList, HttpStatus.OK);
		}
		
	}

	@GetMapping("/countries/flag/{name}")
	public ResponseEntity<String> getFlagOfACountry(@PathVariable("name") String name) {

		logger.debug("---------------Fetching flag of a country-----------------");
		String flag = continentService.getFlagOfACountry(name);

		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}

}
