package com.learningsystem.Dmantz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningsystem.Dmantz.Exceptions.DuplicateValuesException;
import com.learningsystem.Dmantz.Exceptions.ResourceNotFoundException;
import com.learningsystem.Dmantz.model.Chapter;
import com.learningsystem.Dmantz.model.Topic;
import com.learningsystem.Dmantz.repository.ChapterRepository;
import com.learningsystem.Dmantz.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicrepository;
	
	@Autowired
	private ChapterRepository chapterrepository;
	
	public Topic addtopic(Topic topic) {
		List<Topic> names = topicrepository.findByTopicname(topic.getTopicname());
		if (names.isEmpty()) {
			Chapter chapter = topic.getChapter();
			int chapterID = chapter.getChapterId();
			Chapter completechapter = chapterrepository.findById(chapterID)
					.orElseThrow(() -> new ResourceNotFoundException("Chapter with id: "+chapterID+" not found"));
			topic.setChapter(completechapter);
			return topicrepository.save(topic);
		}
		throw new DuplicateValuesException("Topic with " + topic.getTopicname() + " already exists");
	}
	
	
	public List<Topic> gettopics() {
		return topicrepository.findAll();
	}
	
	public Topic gettopic(int topicid) {
		Topic topic = topicrepository.findById(topicid)
				.orElseThrow(() -> new ResourceNotFoundException("Topic with id: "+topicid+" not found"));
		return topic;
	}
	
	
	public Topic updatetopic(int topicId,Topic updatedtopic) {
		Topic existingtopic =topicrepository.findById(topicId)
				.orElseThrow(() -> new ResourceNotFoundException("Topic with id: "+topicId+" not found"));
		List<Topic> names = topicrepository.findByTopicname(updatedtopic.getTopicname());
		if (names.isEmpty()) {
			Chapter chapter = existingtopic.getChapter();
			int chapterID = chapter.getChapterId();
			Chapter completechapter = chapterrepository.findById(chapterID)
					.orElseThrow(() -> new ResourceNotFoundException("Chapter with id: "+chapterID+" not found"));
			existingtopic.setChapter(completechapter);
			existingtopic.setTopicname(updatedtopic.getTopicname());
			return  topicrepository.save(existingtopic);
		}
		throw new DuplicateValuesException("Topic with " + updatedtopic.getTopicname() + " already exists");
	}
	
	
	public void deletetopic(int topicid) {
		Topic topic = topicrepository.findById(topicid)
				.orElseThrow(() -> new ResourceNotFoundException("Topic with id: "+topicid+" not found"));
		
		topicrepository.delete(topic);
	}
	
	
}
