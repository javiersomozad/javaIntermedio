package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManytomanyApplication implements CommandLineRunner {
	
	@Autowired
	NewspaperRepository newspaperRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		  System.out.println("All: " + newspaperRepository.findAll());
		  newspaperRepository.deleteById(1L);
		  
		  Newspaper newspaper = new Newspaper();
		  newspaper.setName("Spring Gazette");
		  
		  newspaper.getSubscriptors().add(new Subscriptor());
		  newspaper.getSubscriptors().add(new Subscriptor());
		  
//		  newspaperRepository.save(newspaper);
		  
		  System.out.println("All: " + newspaperRepository.findAll());
		
	}

}
