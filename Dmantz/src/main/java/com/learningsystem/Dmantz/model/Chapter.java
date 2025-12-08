package com.learningsystem.Dmantz.model;

import com.learningsystem.Dmantz.enums.ChapterNames;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chapterId;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 255)
	private ChapterNames chaptername;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	

	public ChapterNames getChaptername() {
		return chaptername;
	}

	public void setChaptername(ChapterNames chaptername) {
		this.chaptername = chaptername;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
