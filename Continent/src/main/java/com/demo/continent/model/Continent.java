package com.demo.continent.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "continents")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Continent {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer continent_id;

    private String continent;
	@OneToMany(mappedBy="continent")   //defines the mapping to be present in the countries table
    private List<Countries> countries = new ArrayList<>();
	
	 public Continent() {
			
		}

	public Integer getContinent_id() {
		return continent_id;
	}

	public void setContinent_id(Integer continent_id) {
		this.continent_id = continent_id;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public List<Countries> getCountries() {
		return countries;
	}

	public void setCountries(List<Countries> countries) {
		this.countries = countries;
	}
	 
}
