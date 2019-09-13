package com.demo.continent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "countries")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Countries {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer country_id;
	  private String name;

      private String flag;

   @ManyToOne
   @JoinColumn(name = "continent_id")  //adds the join column in the countries table for establishing the relationship between
   private Continent continent;

	public String getName() {
		return name;
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
