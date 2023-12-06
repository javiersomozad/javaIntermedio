package com.example.demo.persistence.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.entities.Product;
import com.example.demo.persistence.IProductDAO;

@Component
public class ProductDAOImpl implements IProductDAO {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
		// TODO Auto-generated method stub
		return productRepository.findProductByPriceInRange(minPrice, maxPrice);
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

}
