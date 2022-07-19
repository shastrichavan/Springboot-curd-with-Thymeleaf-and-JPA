package com.shastri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shastri.model.Student;
import com.shastri.repository.StudentRepository;
@Service

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;

	
	public List<Student> getAllStudents() {
	
		
		return repository.findAll();
	}


	@Override
	public void saveStudent(Student student) {
		repository.save(student);
		
	}


	@Override
	public Student getStudentById(long studentid) {
		Optional<Student>op1=repository.findById(studentid);
		Student student=null;
		if(op1.isPresent())
		{
			student=op1.get();
		}
		else
		{
			throw new RuntimeException("Student not foound for id::"+studentid);
		}
		return student;
	}


	@Override
	public void deleteStudentById(long studentid) {
		this.repository.deleteById(studentid);
	}

}
