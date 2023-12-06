package com.example.demo.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.MarkerRepository;
import com.example.demo.entities.Marker;
import com.example.demo.persistence.IMarkerDAO;

@Component
public class MarkerDAOImpl implements IMarkerDAO {
	
	@Autowired
	private MarkerRepository markerRepository;

	@Override
	public List<Marker> findAll() {
		// TODO Auto-generated method stub
		return (List<Marker>) markerRepository.findAll();
	}

	@Override
	public List<Marker> findMarkerByName(String name) {
		// TODO Auto-generated method stub
		return markerRepository.findMarkerByName(name);
	}

	@Override
	public Optional<Marker> findById(Long id) {
		// TODO Auto-generated method stub
		return markerRepository.findById(id);
	}

	@Override
	public void save(Marker marker) {
		// TODO Auto-generated method stub
		markerRepository.save(marker);
	}

	@Override
	public void deleteById(Long id) {
		markerRepository.deleteById(id);
	}

}
