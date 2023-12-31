package com.example.demo;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends CrudRepository<Brand, Long> {
	List<Brand> findByName(String name);
    List<Brand> findByCountry(String country);
    
    
    @Query("select b from Brand b where b.name like :name")
    Stream<Brand> findByNameReturnStream(@Param("name") String name);
}
