package com.example.demo.controllers.dto;

import java.util.List;

import com.example.demo.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarkerDTO {

	private Long id;
	private String name;
	private List<Product> productList;
}
