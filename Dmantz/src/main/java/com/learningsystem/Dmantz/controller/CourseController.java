package com.learningsystem.Dmantz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningsystem.Dmantz.model.Course;
import com.learningsystem.Dmantz.model.SubjectArea;
import com.learningsystem.Dmantz.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseservice;
	
	@PostMapping("/addcourse")
	public Course addCourse(@RequestBody Course course) {
		return courseservice.addCourse(course);
	}
	
	@GetMapping("/getcourse/{courseID}")
	public Course getcourse(@PathVariable int courseID) {
		return courseservice.getcourse(courseID);
	}
	
	@GetMapping("/getcourses")
	public List<Course> getCourses(){
		return courseservice.getcourses();
	}
	
	
	@DeleteMapping("/deletecourse/{courseId}")
	public void deletecourse(@PathVariable int courseId) {
		courseservice.deletecourse(courseId);
	}
	
	@PutMapping("/updatecourse/{courseId}")
	public Course updatecourse(@PathVariable int courseId,@RequestBody Course course) {
		return courseservice.updatecourse(courseId, course);
	}
}
