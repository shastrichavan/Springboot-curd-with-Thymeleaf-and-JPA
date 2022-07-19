package com.shastri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Student_Details")
@AllArgsConstructor
@NoArgsConstructor


public class Student {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long studentid;
	@Column(name="Student_name")
	private String studentname;
	@Column(name="Student_dept")
	private String studentdept;
	@Column(name="Student_country")
	private String country;
	

}
