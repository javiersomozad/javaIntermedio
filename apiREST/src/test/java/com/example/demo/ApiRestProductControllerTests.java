package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controllers.dto.MarkerDTO;
import com.example.demo.entities.Marker;
import com.example.demo.entities.Product;

// @SpringBootTest
@SpringBootTest(properties = "spring.datasource.url=jdbc:mysql://127.0.0.1/rest_api_db_test")
@AutoConfigureMockMvc
// @TestPropertySource(locations = "classpath:application.properties")
@Sql("/testdataset.sql")
class ApiRestProductControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void productFindAll() throws Exception {

		this.mockMvc.perform(get("/api/product/findAll")).andDo(print())
				.andExpectAll(status().isOk(),
							  jsonPath("$.length()").value(11),
							  jsonPath("$[0].id").value(1),
							  jsonPath("$[0].name").value("Disco duro SATA3 1TB"),
							  jsonPath("$[0].price").value("86.99"),
							  jsonPath("$[0].marker.id").value("5"));
	}

	@Test
	public void productFind() throws Exception {

		this.mockMvc.perform(get("/api/product/find/{id}", 3))
				.andDo(print()).andExpect(status().isOk())
				.andExpectAll(jsonPath("$.id").value(3),
						  jsonPath("$.name").value("Disco SSD 1 TB"),
						  jsonPath("$.price").value(150.99),
						  jsonPath("$.marker.id").value(4)
						);
	}

	@Test
	public void productFindByPrice() throws Exception {

		this.mockMvc.perform(get("/api/product/findByPrice/{min},{max}",100,200)).andDo(print())
				.andExpectAll(status().isOk(),
						content().string("[{\"id\":2,\"name\":\""+
				"Memoria RAM DDR4 8GB\",\"price\":120.00,\"marker\""+
				":{\"id\":6,\"name\":\"Crucial\"}},{\"id\":3,\"name\""+
				":\"Disco SSD 1 TB\",\"price\":150.99,\"marker\":{\"id\""+
				":4,\"name\":\"Samsung\"}},{\"id\":4,\"name\":\"GeForce GTX 1050Ti\""+
				",\"price\":185.00,\"marker\":{\"id\":7,\"name\":\"Gigabyte\"}},{\""+
				"id\":11,\"name\":\"Impresora HP Laserjet Pro M26nw\",\"price\""+
				":180.00,\"marker\":{\"id\":3,\"name\":\"Hewlett-Packard\"}}]"));
	}

	@Test
	public void createProduct() throws Exception 
	{
		this.mockMvc.perform(post("/api/product/save")
		      .content( "{\n"
		      		+ "    \"name\": \"Producto de Javier\",\n"
		      		+ "    \"price\": 220.00,\n"
		      		+ "    \"marker\": {\n"
		      		+ "        \"id\": 6,\n"
		      		+ "        \"name\": \"Crucial\"\n"
		      		+ "    }\n"
		      		+ "}")
		      .contentType(MediaType.APPLICATION_JSON)
		      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isCreated());
	}
	
	@Test
	public void updateProduct() throws Exception 
	{
		this.mockMvc.perform(put("/api/product/update/{id}", 6)
		      .content( "{\n"
		      		+ "    \"id\": 6,\n"
		      		+ "    \"name\": \"producto de javier 2\",\n"
		      		+ "    \"price\": 300.00,\n"
		      		+ "    \"marker\": {\n"
		      		+ "        \"id\": 3\n"
		      		+ "    }\n"
		      		+ "}")
		      .contentType(MediaType.APPLICATION_JSON)
		      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.content().string("Registro Actualizado"));
	}

	@Test
	public void deleteProduct() throws Exception 
	{
		this.mockMvc.perform(delete("/api/product/delete/{id}", 1) )
	        .andExpect(status().isNoContent());
	}
	
}
