package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NewspaperRepository extends CrudRepository<Newspaper, Long> {
	 List<Newspaper> findByName(String name);
}
