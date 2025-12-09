package com.learningsystem.Dmantz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningsystem.Dmantz.Exceptions.DuplicateValuesException;
import com.learningsystem.Dmantz.Exceptions.ResourceNotFoundException;
import com.learningsystem.Dmantz.model.Chapter;
import com.learningsystem.Dmantz.model.Course;
import com.learningsystem.Dmantz.model.SubjectArea;
import com.learningsystem.Dmantz.repository.ChapterRepository;
import com.learningsystem.Dmantz.repository.CourseRepository;
import com.learningsystem.Dmantz.repository.SubjectAreaRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courserepository;
	
	@Autowired
	private ChapterRepository chapterrepository;
	@Autowired
	private SubjectAreaRepository subjectarearepository;
	
	public Course addCourse(Course course) {
		List<Course> names = courserepository.findByCoursename(course.getCoursename());
		if (names.isEmpty()) {
			SubjectArea subjectarea = course.getSubjectarea();
			int subjectareaID = subjectarea.getSubjectId();
			SubjectArea completesubjectarea = subjectarearepository.findById(subjectareaID)
					.orElseThrow(() -> new ResourceNotFoundException("SubjectArea with id: "+subjectareaID+" not found"));
			course.setSubjectarea(completesubjectarea);
			return courserepository.save(course);
		}
		throw new DuplicateValuesException("Course with " + course.getCoursename() + " already exists");
}
	
	public Course getcourse(int courseid) {
		Course course = courserepository.findById(courseid)
				.orElseThrow(() -> new ResourceNotFoundException("Course with id: "+courseid+" not found"));
		return course;
	}
	
	public List<Course> getcourses(){
		return courserepository.findAll();
	}
	
	
	public void deletecourse(int courseId) {
		Course course = courserepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course with id: "+courseId+" not found"));
		List<Chapter> chapters = chapterrepository.findByCourse(course);
		chapterrepository.deleteAll(chapters);
		courserepository.delete(course);
	}
	
	
	public Course updatecourse(int courseId,Course updatedcourse) {
		Course existingcourse = courserepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course with id: "+courseId+" not found"));
		List<Course> names = courserepository.findByCoursename(updatedcourse.getCoursename());
		if (names.isEmpty()) {
			SubjectArea subjectarea = existingcourse.getSubjectarea();
			int subjectareaID = subjectarea.getSubjectId();
			SubjectArea completesubjectarea = subjectarearepository.findById(subjectareaID)
					.orElseThrow(() -> new ResourceNotFoundException("SubjectArea with id: "+subjectareaID+" not found"));
			existingcourse.setSubjectarea(completesubjectarea);
			existingcourse.setCoursename(updatedcourse.getCoursename());
			return  courserepository.save(existingcourse);
		}
		throw new DuplicateValuesException("Course with " + updatedcourse.getCoursename() + " already exists");
	}
	
}
