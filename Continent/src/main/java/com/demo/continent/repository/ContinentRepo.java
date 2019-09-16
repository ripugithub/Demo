package com.demo.continent.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.continent.model.Continent;

public interface ContinentRepo extends CrudRepository<Continent, Long>{

}
