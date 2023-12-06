package com.example.demo;

import org.springframework.stereotype.Component;

// esta clase es un POJO

@Component
public class Pais {
	private String nombre;
	private String continente;
	
	// constructores
	public Pais() {
		
	}
		
	public Pais(String nombre, String continente) {
		this.nombre = nombre;
		this.continente = continente;
	}
	
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", continente=" + continente + "]";
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
}
