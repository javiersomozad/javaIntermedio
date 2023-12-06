package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Marker;
import com.example.demo.persistence.IMarkerDAO;
import com.example.demo.service.IMarkerService;

@Service
public class MarkerServiceImpl implements IMarkerService {
	
	@Autowired
	private IMarkerDAO markerDAO;

	@Override
	public List<Marker> findAll() {
		// TODO Auto-generated method stub
		return markerDAO.findAll();
	}

	@Override
	public List<Marker> findByName(String name) {
		// TODO Auto-generated method stub
		return markerDAO.findMarkerByName(name);
	}

	@Override
	public Optional<Marker> findById(Long id) {
		// TODO Auto-generated method stub
		return markerDAO.findById(id);
	}

	@Override
	public void save(Marker marker) {
		// TODO Auto-generated method stub
		markerDAO.save(marker);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		markerDAO.deleteById(id);

	}

}
