package com.mysite.javaconfig;

public class TestJava8Intr implements TestInterface{

	public static void main(String[] args) {
		TestJava8Intr obj = new TestJava8Intr();
		obj.printMe("Rajesh");
		obj.printMe1("Raj");
		//TestJava8Intr.printMe2("Suraj");
		TestInterface.printMe2("Tom");

	}

	@Override
	public void printMe(String name) {
		System.out.println("Hey this is "+name);
		
	}
	
	public void printMe1(String name) {
		System.out.println("Hey this is your not so close friend "+name);
		
	}

}
