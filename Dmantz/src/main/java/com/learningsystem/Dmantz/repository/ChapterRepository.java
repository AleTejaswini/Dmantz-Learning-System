package com.learningsystem.Dmantz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningsystem.Dmantz.enums.ChapterNames;
import com.learningsystem.Dmantz.model.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter,Integer>{

	List<Chapter> findByChaptername(ChapterNames chapterNames);
}
