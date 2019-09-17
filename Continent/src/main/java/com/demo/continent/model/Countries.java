package com.demo.continent.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "countries")
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedNativeQuery(name="getCountriesPerContinent", query="select * from countries where continent_id=:continentId",resultClass=Countries.class)
@NamedNativeQuery(name="getFlagOfACountry", query="select flag as countryFlag from countries where name=:name",resultClass=Countries.class)
public class Countries {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int country_id;
	  private String name;

      private String flag;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "continent_id" )  //adds the join column in the countries table for establishing the relationship between
   @JsonIgnore
   private Continent continent;

	public String getName() {
		return name;
	}

	

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}



	public Continent getContinent() {
		return continent;
	}



	public void setContinent(Continent continent) {
		this.continent = continent;
	}



	public Integer getCountry_id() {
		return country_id;
	}



	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}




	


	



	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
      
      
}
