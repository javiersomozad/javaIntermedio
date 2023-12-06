package com.example.demo;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class OnetooneApplication implements CommandLineRunner{
	
	@Autowired
	BarRepository barRepository;
	
	@Autowired
	LicenseRepository licenseRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnetooneApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		License lincese = new License();
		
		System.out.println("muestra todos los registros");
		
		for (Bar bar1 : barRepository.findAll()) {
			System.out.println(bar1);
		}
		
		System.out.println("buscar bares por nombre");
		
		for (Bar bar1 : barRepository.findByName("Bar Buerto")) {
			System.out.println(bar1);
		}
		
		System.out.println("buscamos por licencia");
		
		lincese.setId(3L);
		System.out.println(barRepository.findByLicense(lincese));
		
		
		System.out.println("busqueda por fecha ");
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		for (License li : licenseRepository.findBySince(dateformat.parse("2008-01-12"))) {
			System.out.println(li);
		}
		
		System.out.println("busqueda por bar ");
		Bar bar = new Bar();
		bar.setId(1L);
		System.out.println(licenseRepository.findByBar(bar));
		
	}
	
	

}
