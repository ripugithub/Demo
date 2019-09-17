package com.demo.continent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.continent.model.Continent;
import com.demo.continent.model.Countries;
import com.demo.continent.repository.ContinentRepo;
import com.demo.continent.service.ContinentService;

@RestController
@RequestMapping("/code")
public class ContinentController {
	
	@Autowired
	private ContinentService continentService;
	@Autowired
	private ContinentRepo continentRepo;
	
	
	@GetMapping("/continents")
	public ResponseEntity<List<Continent>> getAllContinents()
	{
		List<Continent> list = continentService.getAllContinents();
		
		//list.forEach(continent->System.out.println(continent.getContinent()));
		
		return new ResponseEntity<List<Continent>>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/countries/{continentId}")
	public ResponseEntity<List<Countries>> getCountriesOfContinents(@PathVariable("continentId") Integer continentId)
	{
		List<Countries> list = (List<Countries>) continentService.getCountriesInContinent(continentId);
		return new ResponseEntity<List<Countries>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/countries/flag/{name}")
    public ResponseEntity<String> getFlagOfACountry(@PathVariable("name") String name)
    {
		String flag = continentService.getFlagOfACountry(name);
		
           return new ResponseEntity<String>(flag,HttpStatus.OK);
    }
	
	

}
