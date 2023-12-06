package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebjpaApplication implements CommandLineRunner {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	NewsRepository miRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(WebjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("DATASOURCE = " + dataSource);
		
		miRepositorio.save(new News("titulo", "contenido"));
		miRepositorio.save(new News("titulo1", "contenido2"));
		miRepositorio.save(new News("titulo2", "contenido2"));
		
	}

}
