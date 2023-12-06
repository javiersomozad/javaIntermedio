package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.persistence.IProductDAO;
import com.example.demo.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDAO productDAO;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	@Override
	public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
		// TODO Auto-generated method stub
		return productDAO.findByPriceInRange(minPrice, maxPrice);
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productDAO.save(product);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		productDAO.deleteById(id);

	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return productDAO.findById(id);
	}

}
