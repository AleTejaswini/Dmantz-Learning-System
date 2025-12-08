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

@Service
public class ChapterService {
	@Autowired
	private ChapterRepository chapterrepository;
	
	@Autowired
	private CourseRepository courserepository;
	
	public Chapter addchapter(Chapter chapter) {
		List<Chapter> names = chapterrepository.findByChaptername(chapter.getChaptername());
		if (names.isEmpty()) {
			Course course = chapter.getCourse();
			int courseID = course.getCourseId();
			Course completecourse = courserepository.findById(courseID)
					.orElseThrow(() -> new ResourceNotFoundException("Course with id: "+courseID+" not found"));
			chapter.setCourse(completecourse);
			return chapterrepository.save(chapter);
		}
		throw new DuplicateValuesException("Chapter with " + chapter.getChaptername() + " already exists");
	}
	
	
	public List<Chapter> getchapters() {
		return chapterrepository.findAll();
	}
	
	public Chapter getchapter(int chapterid) {
		Chapter chapter = chapterrepository.findById(chapterid)
				.orElseThrow(() -> new ResourceNotFoundException("Chapter with id: "+chapterid+" not found"));
		return chapter;
	}
	
	public void deletechapter(int chapterid) {
		Chapter chapter = chapterrepository.findById(chapterid)
				.orElseThrow(() -> new ResourceNotFoundException("Chapter with id: "+chapterid+" not found"));
		chapterrepository.delete(chapter);
	}
	
	public Chapter updatechapter(int chapterId,Chapter updatedchapter) {
		Chapter existingchapter = chapterrepository.findById(chapterId)
				.orElseThrow(() -> new ResourceNotFoundException("Chapter with id: "+chapterId+" not found"));
		List<Chapter> names = chapterrepository.findByChaptername(updatedchapter.getChaptername());
		if (names.isEmpty()) {
			Course course = existingchapter.getCourse();
			int courseID = course.getCourseId();
			Course completecourse = courserepository.findById(courseID)
					.orElseThrow(() -> new ResourceNotFoundException("Course with id: "+courseID+" not found"));
			existingchapter.setCourse(completecourse);
			existingchapter.setChaptername(updatedchapter.getChaptername());
			return  chapterrepository.save(existingchapter);
		}
		throw new DuplicateValuesException("Chapter with " + updatedchapter.getChaptername() + " already exists");
	}
	
	
}
