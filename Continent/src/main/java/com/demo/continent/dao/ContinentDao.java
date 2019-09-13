package com.demo.continent.dao;

import java.util.List;

import com.demo.continent.model.Continent;
import com.demo.continent.model.Countries;

public interface ContinentDao {
	
	List<Continent> getAllContinents();
	Countries getCountriesInContinent(int continentId);
	String getFlagOfACountry(int countryId);
	

}
