package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/test")
	public String hello() {
		System.out.println("controller start");
		return "index";
		
	}

}
