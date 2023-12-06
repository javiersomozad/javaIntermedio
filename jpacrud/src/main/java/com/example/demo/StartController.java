package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {
	
	@Autowired
	private StarRepository starsRepository;
	
	@RequestMapping("/stars")
	public String read(Model model) {
		model.addAttribute("stars", starsRepository.findAll());
		return "read";
	}
	
	@RequestMapping("/stars/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("star", starsRepository.findById(id).get());
		return "detail";
	}
	@RequestMapping("/stars/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		starsRepository.deleteById(id);
		return "forward:/stars";
	}
	@RequestMapping("/stars/create")
	public String Create(Model model) {
		Star miEstrella = new Star();
		System.out.println("la estrella es" + miEstrella);
		model.addAttribute("star", miEstrella);
		return "create";
	}
	
	@PostMapping("/stars/create")
	public String saveCreate(Star star) {
		System.out.println("creando la estrella : " +star);
		starsRepository.save(star);
		return "forward:/stars";
	}
	@RequestMapping("/stars/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		model.addAttribute("star", starsRepository.findById(id).get());
		return "update";
	}
	@PostMapping("/stars/update")
	public String saveUpdate(Star star) {
		System.out.println("modificando estrella ; " + star);
		starsRepository.save(star);
		return "forward:/stars";
	}
}
