package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Newspaper {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	
	 @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
//	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(name = "newspaper_subscriptor", 
	      joinColumns = @JoinColumn(name = "newspaper_id", 
	                    referencedColumnName = "id"), 
	      inverseJoinColumns = @JoinColumn(name = "subscriptor_id", 
	                       referencedColumnName = "id"))
	private List<Subscriptor> subscriptors = new ArrayList<Subscriptor>();
	 
	public Newspaper() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subscriptor> getSubscriptors() {
		return subscriptors;
	}

	public void setSubscriptors(List<Subscriptor> subscriptors) {
		this.subscriptors = subscriptors;
	}

	@Override
	public String toString() {
		return "Newspaper [id=" + id + ", name=" + name + ", subscriptors=" + subscriptors + "]";
//		return "Newspaper [id=" + id + ", name=" + name + "]";
	}

		
}
