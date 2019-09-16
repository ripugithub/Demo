package com.demo.continent.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "continents")
@JsonIgnoreProperties(ignoreUnknown = true)

@NamedNativeQuery(name="getAllContinents", query="Select * from continents",resultClass=Continent.class)
@NamedNativeQuery(name="getCountriesPerContinent", query="select * from countries where continent_id=:continentId",resultClass=Continent.class)
public class Continent {

	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int continent_id;

    private String continent;
    @OneToMany(cascade = {CascadeType.ALL})   //defines the mapping to be present in the countries table
	@JoinColumn(name="continent_id")
    private Set<Countries> countries = new HashSet<Countries>();
	
	 public Continent() {
			
		}

	

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Set<Countries> getCountries() {
		return countries;
	}

	public void setCountries(Set<Countries> countries) {
		this.countries = countries;
	}

}
