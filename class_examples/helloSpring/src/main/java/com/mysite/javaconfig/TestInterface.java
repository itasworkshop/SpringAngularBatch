package com.mysite.javaconfig;

public interface TestInterface {
	
	default void printMe1(String name) {
		System.out.println("He this is "+"ur friend " +name);
	}
	
	static void printMe2(String name){
		System.out.println("He this is "+"ur static friend " +name);
	}
	
	void printMe(String name);

}
