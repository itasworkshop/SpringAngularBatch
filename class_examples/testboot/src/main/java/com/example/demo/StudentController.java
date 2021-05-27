package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/students")
	public Student getStudents(@RequestParam(value = "name") String name,@RequestParam(value = "rollNo") long rollNo) {
		Student st = new Student(rollNo,name);
		return st;
		
	}

}
