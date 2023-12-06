package com.example.demo.controllers.dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.entities.Marker;
import com.example.demo.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

		private Long id;
		private String name;
		private BigDecimal price;
		private Marker marker;
}
