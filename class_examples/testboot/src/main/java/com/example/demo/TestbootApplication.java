package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestbootApplication.class, args);
	}
	
	@GetMapping("/hello1")
	public String helloBoot1() {
		return "Hello boot";
		
	}
	
	@GetMapping("/hello2")
	public String helloBoot2(@RequestParam(value = "name") String name) {
		return "Hello boot " + name;
		
	}

}
