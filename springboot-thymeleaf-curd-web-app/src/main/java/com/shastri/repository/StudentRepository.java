package com.shastri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shastri.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
