package com.myproject.springhello2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App{
	
    public static void main( String[] args ) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
    	
    	HelloStudent st = (HelloStudent) context.getBean("helloStudent");
    	System.out.println(st.getStudentName());
    }
    
}