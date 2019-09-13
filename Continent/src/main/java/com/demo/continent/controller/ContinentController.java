package com.demo.continent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.continent.model.Continent;
import com.demo.continent.service.ContinentService;

@RestController
@RequestMapping("/code")
public class ContinentController {
	
	@Autowired
	private ContinentService continentService;
	
	
	@GetMapping("/continents")
	public ResponseEntity<List<Continent>> getAllContinents()
	{
		List<Continent> list = continentService.getAllContinents();
		
		return new ResponseEntity<List<Continent>>(list, HttpStatus.OK);
		
	}

}
