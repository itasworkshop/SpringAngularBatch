package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.dao.StudentDao;
import com.mysite.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	
	StudentDao studentDao;

	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> findAll() {		
		return studentDao.findAll();
	}

}
