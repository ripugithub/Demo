package com.demo.continent.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.continent.controller.ContinentController;
import com.demo.continent.dao.ContinentDao;
import com.demo.continent.model.Continent;
import com.demo.continent.model.Countries;


@Transactional
@Repository
//@NamedNativeQuery(name="getAllContinents", query="Select * from continents",resultClass=Continent.class)
public class ContinentDaoImpl implements ContinentDao{

	private final Logger logger = LoggerFactory.getLogger(ContinentDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Continent> getAllContinents() {
		
		Query q = entityManager.createNamedQuery("getAllContinents", Continent.class);
		logger.debug("*******************"+q.getResultList().size());
		return q.getResultList();
		//return null;
		
		
	}

	@Override
	public List<Countries> getCountriesInContinent(int continentId) {
		//String hql = " from Countries where continent_id= :continentId ";
		Query q = entityManager.createNamedQuery("getCountriesPerContinent",Countries.class).setParameter("continentId", continentId);
		
		return q.getResultList();
		//return null;
		
	}

	@Override

    public String getFlagOfACountry(String name) {

           Query q = entityManager.createNamedQuery("getFlagOfACountry",Countries.class).setParameter("name", name);

           return q.getSingleResult().toString();

    }


}
