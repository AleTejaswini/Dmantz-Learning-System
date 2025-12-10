package com.learningsystem.Dmantz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningsystem.Dmantz.enums.TopicNames;
import com.learningsystem.Dmantz.model.Chapter;
import com.learningsystem.Dmantz.model.Topic;

public interface TopicRepository extends JpaRepository<Topic,Integer>{

	List<Topic> findByTopicname(TopicNames topicNames);
	
	List<Topic> findByChapter(Chapter chapter);
}
