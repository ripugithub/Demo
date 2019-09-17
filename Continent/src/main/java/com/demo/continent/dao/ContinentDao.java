package com.demo.continent.dao;

import java.util.List;

import com.demo.continent.model.Continent;
import com.demo.continent.model.Countries;

public interface ContinentDao {
	
	List<Continent> getAllContinents();
	List<Countries> getCountriesInContinent(int continentId);
	String getFlagOfACountry(String name);
	

}
