package com.example.demo1.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${name}")
	private String name;
	
	@GetMapping("/home")
	public String display() {
		return name;
	}

}
