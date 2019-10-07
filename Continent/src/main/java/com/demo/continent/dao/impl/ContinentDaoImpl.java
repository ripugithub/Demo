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
public class ContinentDaoImpl implements ContinentDao {

	private final Logger logger = LoggerFactory.getLogger(ContinentDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Continent> getAllContinents() {

		Query q = entityManager.createNamedQuery("getAllContinents", Continent.class);
		logger.debug("*******************" + q.getResultList().size());
		return q.getResultList();

	}

	@Override
	public List<Countries> getCountriesInContinent(int continentId) {
		logger.debug("*******************Fetch the list of countries in a continent************************");
		Query q = entityManager.createNamedQuery("getCountriesPerContinent", Countries.class)
				.setParameter("continentId", continentId);

		return q.getResultList();

	}

	@Override

	public String getFlagOfACountry(String name) {

		logger.debug("*******************Fetch the flag of a countryt************************");
		String hql = "Select flag from Countries where name=:name";
		Query query = entityManager.createQuery(hql);
		query.setParameter("name", name);

		String flag = query.getSingleResult().toString();

		return flag;

	}

}
