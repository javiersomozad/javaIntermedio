package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subscriptor {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;
		private String name;
		private String address;
		
		@ManyToMany(mappedBy = "subscriptors")
		private List<Newspaper> newspapers = new ArrayList<Newspaper>();
		
		public Subscriptor () {}

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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}


		@Override
		public String toString() {
			return "\n\tSuscriptor [id=" + id + ", name=" + name + ", address=" + address + "]";
		}

}
