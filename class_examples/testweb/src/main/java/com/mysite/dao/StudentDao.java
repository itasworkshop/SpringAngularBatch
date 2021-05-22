package com.mysite.dao;

import java.util.List;

import com.mysite.model.Student;

public interface StudentDao {
	
	List<Student> findAll();

}
