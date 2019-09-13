package com.demo.continent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class Demo {
	
	@GetMapping("/message")
	public String getMessage()
	{
		return "Hello Ripu";
	}

}
