package com.mysite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysite.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/" ,method= RequestMethod.GET)
	public String showAll(Model model) {
		System.out.println(studentService.findAll());
		model.addAttribute("students",studentService.findAll() );
		return "student/list";
	}

}
