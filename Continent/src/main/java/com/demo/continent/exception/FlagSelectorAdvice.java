package com.demo.continent.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FlagSelectorAdvice {

	
    @ExceptionHandler(ContinentNotFoundException.class)    
    public String continentNotFoundHandler(ContinentNotFoundException exception)
    {
    	return exception.getMessage();
    }

    @ExceptionHandler(CountryNotFoundException.class)    
    public String countriesNotFoundHandler(CountryNotFoundException exception)
    {
    	return exception.getMessage();
    }
    
}
