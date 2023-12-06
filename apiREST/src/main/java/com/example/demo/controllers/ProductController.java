package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controllers.dto.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.service.IProductService;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO produtDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .marker(product.getMaker())
                    .build();

            return ResponseEntity.ok(produtDTO);
        }

        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/findAll")
    private ResponseEntity<?> findAll() {
    	
    	List<ProductDTO> productList = productService.findAll()
    			.stream()
    			.map(product -> ProductDTO.builder()
    					.id(product.getId())
    					.name(product.getName())
    					.price(product.getPrice())
    					.marker(product.getMaker())
    					.build()).toList();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/findByPrice/{min},{max}")
    private ResponseEntity<?> findByPrice(@PathVariable Long min, @PathVariable Long max) {
    	
    	List<ProductDTO> productList = productService.findByPriceInRange(BigDecimal.valueOf(min), BigDecimal.valueOf(max))
    			.stream()
    			.map(product -> ProductDTO.builder()
    					.id(product.getId())
    					.name(product.getName())
    					.price(product.getPrice())
    					.marker(product.getMaker())
    					.build()).toList();
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {

        if (productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getMarker() == null) {
            return ResponseEntity.badRequest().build();
        }

        Product product = Product.builder()
                                 .id(productDTO.getId())
                                 .name(productDTO.getName())
                                 .price(productDTO.getPrice())
                                 .maker(productDTO.getMarker())
                                 .build();

        productService.save(product);
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){

        Optional<Product> productOptional = productService.findById(id);

        if(productOptional.isPresent()){
            Product product = productOptional.get();

            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setMaker(productDTO.getMarker());
            productService.save(product);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if(id != null){
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body("El parametro id se encuentra vacio");
    }
}