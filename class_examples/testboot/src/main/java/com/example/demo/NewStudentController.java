package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/students")
public class NewStudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewStudent(@RequestParam(value = "name") String name) {
		
		StudentNew st = new StudentNew();
		st.setName(name);
		
		studentRepository.save(st);
		return name+ " saved successfully.";
		
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<StudentNew> getStudents() {
		return studentRepository.findAll();
	}
	

}
