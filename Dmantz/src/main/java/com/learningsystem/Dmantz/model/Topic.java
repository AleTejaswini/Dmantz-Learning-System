package com.learningsystem.Dmantz.model;

import com.learningsystem.Dmantz.enums.TopicNames;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int topicId;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 255)
	private TopicNames topicname;
	
	@ManyToOne
	@JoinColumn(name = "chapter_id")
	private Chapter chapter;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public TopicNames getTopicname() {
		return topicname;
	}

	public void setTopicname(TopicNames topicname) {
		this.topicname = topicname;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	
	
	
}
