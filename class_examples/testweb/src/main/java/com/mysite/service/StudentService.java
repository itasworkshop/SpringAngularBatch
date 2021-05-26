package com.mysite.service;

import java.util.List;

import com.mysite.model.Student;

public interface StudentService {
	
	List<Student> findAll();
	
	Student findById(Integer id);
	
	void save(Student student);

}
