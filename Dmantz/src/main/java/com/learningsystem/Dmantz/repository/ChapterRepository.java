package com.learningsystem.Dmantz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningsystem.Dmantz.enums.ChapterNames;
import com.learningsystem.Dmantz.model.Chapter;
import com.learningsystem.Dmantz.model.Course;

public interface ChapterRepository extends JpaRepository<Chapter,Integer>{

	List<Chapter> findByChaptername(ChapterNames chapterNames);
	
	List<Chapter> findByCourse(Course course);
}
