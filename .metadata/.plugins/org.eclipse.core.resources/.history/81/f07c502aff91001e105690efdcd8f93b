package com.example.demo.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.MarkerDTO;
import com.example.demo.entities.Marker;
import com.example.demo.service.IMarkerService;

@RestController
@RequestMapping("/api/marker")
public class MarkerController {
	
	@Autowired
	private IMarkerService markerService;
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Marker> markerOptional = markerService.findById(id);
		
		if(markerOptional.isPresent()) {
			Marker marker = markerOptional.get();
			MarkerDTO markerDTO = MarkerDTO.builder()
					.id(marker.getId())
					.name(marker.getName())
					.productList(marker.getProductList())
					.build();

			return ResponseEntity.ok(markerDTO);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
		
		List<MarkerDTO> markerDTOList = markerService.findAll()
				.stream()
				.map(marker -> MarkerDTO.builder()
						.id(marker.getId())
						.name(marker.getName())
						.productList(marker.getProductList())
						.build())
				.toList();
		return ResponseEntity.ok(markerDTOList);
				
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveMaker(@RequestBody MarkerDTO markerDTO) throws URISyntaxException {
		if (markerDTO.getName().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		
		Marker marker = Marker.builder()
				.name(markerDTO.getName())
				.build();
		marker.setProductList(markerDTO.getProductList()
				.stream()
				.map(p -> {p.setMaker(marker); return p;})
				.toList());
		markerService.save(marker);
		return ResponseEntity.created(new URI("/api/marker/save")).build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateMarker(@PathVariable Long id, @RequestBody MarkerDTO markerDTO) {
		Optional<Marker> markerOptional = markerService.findById(id);
		
		if(markerOptional.isPresent()) {
			Marker marker = markerOptional.get();
			marker.setName(markerDTO.getName());
			markerService.save(marker);
			return ResponseEntity.ok("Registro Actualizado");
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById (@PathVariable Long id) {
		
		if(id != null) {
			markerService.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.badRequest().body("El parametro id se encuentra vacio");
	}

}
