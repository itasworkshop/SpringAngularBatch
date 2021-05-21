package com.mysite.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class TestJavaConfig {
	
	@Bean
	HelloService helloServiceBean() {
		return new HelloService() {
			public String sayHello() {
				return "Good Evening, hello!";
			}
		};
	}
	

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(TestJavaConfig.class);
		
		GermanGuy obj1 = context.getBean(GermanGuy.class);
		obj1.printHello();
		
		EnglishGuy obj2 = context.getBean(EnglishGuy.class);
		obj2.printHello();

	}

}
