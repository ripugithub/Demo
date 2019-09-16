package com.demo.continent.service;

import java.util.List;

import com.demo.continent.model.Continent;
import com.demo.continent.model.Countries;

public interface ContinentService {
	
	List<Continent> getAllContinents();
	List<Countries> getCountriesInContinent(int continentId);
	String getFlagOfACountry(int countryId);

}
