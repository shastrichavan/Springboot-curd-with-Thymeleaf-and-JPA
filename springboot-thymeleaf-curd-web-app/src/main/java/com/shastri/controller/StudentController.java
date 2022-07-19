package com.shastri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shastri.model.Student;
import com.shastri.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	//display list of student
	@GetMapping("/")
	public String homePage(Model model)
	{
		model.addAttribute("liststudent",studentservice.getAllStudents());
		System.out.println(studentservice.getAllStudents());
		return "index";
	}
	@GetMapping("/showStudentform")
	public String showStudentform(Model model)
	{
		//to create attribute to bind data
		Student student=new Student();
		model.addAttribute("student",student);
		return "addstudent";
	}
	@PostMapping("/saveStudent")
	public String saveStudentData(@ModelAttribute("student")Student student)
	{
		//save student data to database;
		studentservice.saveStudent(student);
		return "redirect:/";
		
	}
	@GetMapping("/showformUpdate{studentid}")	
	
	public String showformUpdate(@PathVariable(value="studentid")long studentid,Model model)
	{
		//get Student from service;
		Student student=studentservice.getStudentById(studentid);
		//To set student as modelattribute to pre populate the form
		model.addAttribute("student",student);		
		return "addstudent";
	}
	@GetMapping("/deletestudent{studentid}")
	public String deletestudent(@PathVariable(value="studentid")long studentid,Model model)
	{
		// call delete method 
		this.studentservice.deleteStudentById(studentid);
		return "redirect:/";
	}

}
