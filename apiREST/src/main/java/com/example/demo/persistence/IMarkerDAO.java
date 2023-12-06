package com.example.demo.persistence;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Marker;

public interface IMarkerDAO {
	
	List<Marker> findAll();
	
	List<Marker> findMarkerByName(String name);
	
	Optional<Marker> findById(Long id);
	
	void save(Marker marker);
	
	void deleteById(Long id);
}
