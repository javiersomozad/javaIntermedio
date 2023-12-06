package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StarRepository extends CrudRepository<Star, Long> {
	List<Star> findByName(String name);
}
