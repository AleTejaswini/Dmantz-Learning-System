package com.learningsystem.Dmantz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningsystem.Dmantz.enums.TopicNames;
import com.learningsystem.Dmantz.model.Chapter;
import com.learningsystem.Dmantz.model.Topics;

public interface TopicRepository extends JpaRepository<Topics,Integer>{

	List<Topics> findByTopicNames(TopicNames topicnames);
	
	List<Topics> findByChapter(Chapter chapter);
}
