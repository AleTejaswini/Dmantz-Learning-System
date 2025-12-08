package com.learningsystem.Dmantz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningsystem.Dmantz.enums.CourseNames;
import com.learningsystem.Dmantz.enums.SubjectAreaNames;
import com.learningsystem.Dmantz.model.Course;
import com.learningsystem.Dmantz.model.SubjectArea;


@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{
	List<Course> findByCoursename(CourseNames courseNames);
	
	List<Course> findBySubjectarea(SubjectArea subjectarea);
}
