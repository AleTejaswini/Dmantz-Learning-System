package com.learningsystem.Dmantz.model;
import com.learningsystem.Dmantz.enums.CourseNames;
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
public class Course {//many
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CourseId;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 255)
	private CourseNames coursename;
	
	@ManyToOne
	@JoinColumn(name = "Subject_ID")
	private SubjectArea subjectarea;

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public SubjectArea getSubjectarea() {
		return subjectarea;
	}

	public void setSubjectarea(SubjectArea subjectarea) {
		this.subjectarea = subjectarea;
	}

	public CourseNames getCoursename() {
		return coursename;
	}

	public void setCoursename(CourseNames coursename) {
		this.coursename = coursename;
	}
	
}
