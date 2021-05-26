package com.mysite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysite.model.Student;
import com.mysite.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/students" ,method= RequestMethod.GET)
	public String showAll(Model model) {
		System.out.println(studentService.findAll());
		model.addAttribute("students",studentService.findAll() );
		return "student/list";
	}
	
	@RequestMapping(value = "/students/{id}" ,method= RequestMethod.GET)
	public String showStudent(@PathVariable("id") int id, Model model) {
		System.out.println(studentService.findById(id));
		model.addAttribute("student",studentService.findById(id));
		return "student/show";
	}
	
	@RequestMapping(value = "/students" ,method= RequestMethod.POST)
	public String saveStudent(@ModelAttribute("studentForm") @Validated Student student,
			BindingResult result,Model Student, RedirectAttributes redirectAttributes) {
		studentService.save(student);
		
		return "redirect:/student/list";
		
	}

}
