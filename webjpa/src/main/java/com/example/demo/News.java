package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String text;
	
	public News () {} 
	
	
	public News(String title, String text) {
		super();
		this.title = title;
		this.text = text;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", text=" + text + "]";
	}
}
