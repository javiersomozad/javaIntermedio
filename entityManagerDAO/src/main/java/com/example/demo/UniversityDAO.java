package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository
public class UniversityDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public University findById(Long universityId) {
		return entityManager.find(University.class, universityId);
	}
	
	public List<University> findAll() {
		String hql = "FROM University as atc1 ORDER BY atc1.id";
		return (List<University>) entityManager.createQuery(hql).getResultList();
	}
	
	public void add (University university) {
		entityManager.persist(university);
		entityManager.flush();
	}
	
	public void update (University university) {
		entityManager.persist(university);
		entityManager.flush();
	}

	public void delete (University university) {
		entityManager.remove(university);
		entityManager.flush();
	}
}
