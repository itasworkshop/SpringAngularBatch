package com.mysite.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnglishGuy {
	
	final private HelloService helloService;
	
	@Autowired
	public EnglishGuy(HelloService helloService) {
		this.helloService = helloService;
	}
	
	public void printHello() {
		System.out.println(helloService.sayHello());
	}

}
