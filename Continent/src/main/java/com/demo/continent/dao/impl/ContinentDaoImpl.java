package com.demo.continent.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.continent.dao.ContinentDao;
import com.demo.continent.model.Continent;
import com.demo.continent.model.Countries;


@Transactional
@Repository
//@NamedNativeQuery(name="getAllContinents", query="Select * from continents",resultClass=Continent.class)
public class ContinentDaoImpl implements ContinentDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Continent> getAllContinents() {
		
		Query q = entityManager.createNamedQuery("getAllContinents", Continent.class);
		System.out.println("*******************"+q.getResultList().size());
		return q.getResultList();
		//return null;
		
		
	}

	@Override
	public List<Countries> getCountriesInContinent(int continentId) {
		//String hql = " from Countries where continent_id= :continentId ";
		Query q = entityManager.createNamedQuery("getCountriesPerContinent",Continent.class).setParameter("continentId", continentId);
		
		return q.getResultList();
		//return null;
		
	}

	@Override
	public String getFlagOfACountry(int countryId) {
		// TODO Auto-generated method stub
		return null;
	}
}
