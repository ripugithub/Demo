package com.demo.continent;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.continent.model.Continent;
import com.demo.continent.service.CountryService;


/**
 * @author Ripu
 *
 */
@SpringBootApplication
public class ContinentApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ContinentApplication.class, args);
	}
	
	
	
	@Bean
	CommandLineRunner runner(CountryService countryService){
	    return args -> {
			// Load JSON and read it to create tables in MYsql DB
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Continent>> typeReference = new TypeReference<List<Continent>>(){};
			String fileName = "json/continents.json";
	        ClassLoader classLoader = new ContinentApplication().getClass().getClassLoader();
	 
	        File inputStream = new File(classLoader.getResource(fileName).getFile());
			try {
				List<Continent> continents = mapper.readValue(inputStream,typeReference);				
				countryService.save(continents);
				
				System.out.println("Continents Saved!");
			} catch (IOException e){
				System.out.println("Unable to save continents: " + e.getMessage());
			}
	    };
	}
	
	 String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}

}
