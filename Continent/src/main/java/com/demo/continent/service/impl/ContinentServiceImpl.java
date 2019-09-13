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
	public Countries getCountriesInContinent(int continentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFlagOfACountry(int countryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
