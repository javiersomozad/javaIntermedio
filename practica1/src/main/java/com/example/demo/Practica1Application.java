package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practica1Application implements CommandLineRunner {
	
	@Autowired
	private Pais miPais;

	public static void main(String[] args) {
		SpringApplication.run(Practica1Application.class, args);
		System.out.println("Hola Mundo");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Se ha creado el Pais : " + miPais);
		
	}

}
