package com.example.demo;

public class Student {
	
	private final long rollNo;
	private final String name;
	
	public Student(long rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}

	public long getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}	

}
