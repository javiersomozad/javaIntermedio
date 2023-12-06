package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SimpleJpaApplication implements CommandLineRunner{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	TechnologyRepository technologyRepository;

	public static void main(String[] args) {
		SpringApplication.run(SimpleJpaApplication.class, args);
	}
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("DATASURCE = " + dataSource);
		
		technologyRepository.save(new Technology("Java",1991));
		technologyRepository.save(new Technology("Ruby",1998));
		technologyRepository.save(new Technology("JavaScript",1993));
		
		System.out.println("Muestra todos registros");
		
		for (Technology technology : technologyRepository.findAll()) {
			System.out.println(technology);
		}
		
		System.out.println("Muestra los registros de un año determinado");
		
		for (Technology technology : technologyRepository.findByCreationYear(1998)) {
			System.out.println(technology);
		}
		
		System.out.println("busca por nombre con stream:");
		
		technologyRepository.findByNameReturnStram("%Java%")
							.forEach(tech -> System.out.println(tech));
		
	}

}
