package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Marker;

public interface IMarkerService {
	
	List<Marker> findAll();
	
	List<Marker> findByName(String name);
	
	Optional<Marker> findById(Long id);
	
	void save(Marker marker);
	
	void deleteById(Long id);
}
