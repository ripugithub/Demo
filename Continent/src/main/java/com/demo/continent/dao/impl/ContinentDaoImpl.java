package com.demo.continent.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.continent.dao.ContinentDao;
import com.demo.continent.model.Continent;
import com.demo.continent.model.Countries;


@Transactional
@Repository
public class ContinentDaoImpl implements ContinentDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Continent> getAllContinents() {
		String hql = " from Continent";
		return entityManager.createQuery(hql).getResultList();
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
