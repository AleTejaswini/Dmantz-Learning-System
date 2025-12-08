package com.learningsystem.Dmantz.model;

import java.util.List;

import com.learningsystem.Dmantz.enums.SubjectAreaNames;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SubjectArea { //one
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;

	@Enumerated(EnumType.STRING)
	@Column(length = 255)
	private SubjectAreaNames subjectareaname;
	
	

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public SubjectAreaNames getSubjectareaname() {
		return subjectareaname;
	}

	public void setSubjectareaname(SubjectAreaNames subjectareaname) {
		this.subjectareaname = subjectareaname;
	}

}
