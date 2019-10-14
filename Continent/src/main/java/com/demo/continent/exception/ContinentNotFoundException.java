package com.demo.continent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContinentNotFoundException extends RuntimeException{

	public ContinentNotFoundException(String msg){
		super(msg);
	}
}
