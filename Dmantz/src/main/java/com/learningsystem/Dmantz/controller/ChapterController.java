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

import com.learningsystem.Dmantz.model.Chapter;
import com.learningsystem.Dmantz.service.ChapterService;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
	@Autowired
	private ChapterService chapterservice;
	
	@PostMapping("/addchapter")
	public Chapter addchapter(@RequestBody Chapter chapter) {
		return chapterservice.addchapter(chapter);
	}
	
	@GetMapping("/getchapter/{chapterID}")
	public Chapter getchapter(@PathVariable int chapterID) {
		return chapterservice.getchapter(chapterID);
	}
	
	@GetMapping("/getchapters")
	public List<Chapter> getchapters(){
		return chapterservice.getchapters();
	}
	
	
	@DeleteMapping("/deletechapter/{chapterId}")
	public void deletechapter(@PathVariable int chapterId) {
		chapterservice.deletechapter(chapterId);
	}
	
	@PutMapping("/updatechapter/{chapterId}")
	public Chapter updatechapter(@PathVariable int chapterId,@RequestBody Chapter chapter) {
		return chapterservice.updatechapter(chapterId, chapter);
	}
}
