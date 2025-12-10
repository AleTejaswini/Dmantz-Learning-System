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


import com.learningsystem.Dmantz.model.Topic;
import com.learningsystem.Dmantz.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
	@Autowired
	private TopicService  topicservice;
	
	@PostMapping("/addtopic")
	public Topic addtopic(@RequestBody Topic topic) {
		return topicservice.addtopic(topic);
	}
	
	
	@GetMapping("/gettopic/{topicID}")
	public Topic gettopic(@PathVariable int topicID) {
		return topicservice.gettopic(topicID);
	}
	
	@GetMapping("/gettopics")
	public List<Topic> gettopics(){
		return topicservice.gettopics();
	}
	
	@PutMapping("/updatetopic/{topicId}")
	public Topic updatetopic(@PathVariable int topicId,@RequestBody Topic topic) {
		return topicservice.updatetopic(topicId, topic);
	}
	
	
	@DeleteMapping("/deletetopic/{topicId}")
	public void deletetopic(@PathVariable int topicId) {
		topicservice.deletetopic(topicId);
	}
	
	
}
