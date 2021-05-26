package com.mysite.dao;

import java.util.List;

import com.mysite.model.Student;

public interface StudentDao {
	
	List<Student> findAll();
	
	Student findById(Integer id);
	
	void save(Student st);
	void update(Student st);
	void delete(Student st);

}
