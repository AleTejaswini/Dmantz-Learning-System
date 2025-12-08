package com.learningsystem.Dmantz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningsystem.Dmantz.Exceptions.DuplicateValuesException;
import com.learningsystem.Dmantz.Exceptions.ResourceNotFoundException;
import com.learningsystem.Dmantz.model.Course;
import com.learningsystem.Dmantz.model.SubjectArea;
import com.learningsystem.Dmantz.repository.CourseRepository;
import com.learningsystem.Dmantz.repository.SubjectAreaRepository;

@Service
public class SubjectAreaService {
	@Autowired
	private SubjectAreaRepository subjectarearepository;
	
	@Autowired
	private CourseRepository courserepository;

	public SubjectArea addsubjectarea(SubjectArea subjectarea) {
		List<SubjectArea> names = subjectarearepository.findBySubjectareaname(subjectarea.getSubjectareaname());
		if (names.isEmpty()) {
			return subjectarearepository.save(subjectarea);
		}
		throw new DuplicateValuesException("SubjectArea with " + subjectarea.getSubjectareaname() + " already exists");

	}

	public SubjectArea getsubjectarea(int subjectareaid) {
		SubjectArea subjectarea = subjectarearepository.findById(subjectareaid)
				.orElseThrow(() -> new ResourceNotFoundException("SubjectArea with id: "+subjectareaid+" not found"));
		return subjectarea;
	}
	
	public List<SubjectArea> getsubjectareas(){
		return subjectarearepository.findAll();
	}
	
	public void deletesubjectarea(int subjectareaId) {
		SubjectArea subjectarea = subjectarearepository.findById(subjectareaId)
				.orElseThrow(() -> new ResourceNotFoundException("SubjectArea with id: "+subjectareaId+" not found"));
		List<Course> courses =courserepository.findBySubjectarea(subjectarea);
//		for(Course c:courses) {
//			c.setSubjectarea(null);
//		}
		courserepository.deleteAll(courses);
		subjectarearepository.delete(subjectarea);
	}
	
	public SubjectArea updatesubjectarea(int subjectareaId,SubjectArea updatedsubjectarea) {
		SubjectArea existingsubjectarea = subjectarearepository.findById(subjectareaId)
				.orElseThrow(() -> new ResourceNotFoundException("SubjectArea with id: "+subjectareaId+" not found"));
		List<SubjectArea> names = subjectarearepository.findBySubjectareaname(updatedsubjectarea.getSubjectareaname());
		if (names.isEmpty()) {
			existingsubjectarea.setSubjectareaname(updatedsubjectarea.getSubjectareaname());
			return  subjectarearepository.save(existingsubjectarea);
		}
		throw new DuplicateValuesException("SubjectArea with " + updatedsubjectarea.getSubjectareaname() + " already exists");
	}
	
	

}
