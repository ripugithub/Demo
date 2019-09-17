package com.demo.continent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.continent.dao.ContinentDao;
import com.demo.continent.model.Continent;
import com.demo.continent.model.Countries;
import com.demo.continent.service.ContinentService;


@Service
public class ContinentServiceImpl implements ContinentService {

	
	@Autowired
	private ContinentDao continentDao;
	
	@Override
	public List<Continent> getAllContinents() {
		return continentDao.getAllContinents();
	}

	@Override
	public List<Countries> getCountriesInContinent(int continentId) {
		
		return continentDao.getCountriesInContinent(continentId);
	}

	@Override
	public String getFlagOfACountry(String countryName) {
		
		return continentDao.getFlagOfACountry(countryName);
	}

}
