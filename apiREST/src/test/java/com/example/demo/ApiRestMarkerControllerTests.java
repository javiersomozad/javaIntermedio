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
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
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

//@SpringBootTest
//@SpringBootTest(properties = {"spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"})
@SpringBootTest(properties = "spring.datasource.url=jdbc:mysql://127.0.0.1/rest_api_db_test")
//@AutoConfigureTestDatabase
@AutoConfigureMockMvc
// @TestPropertySource(locations = "classpath:application.properties")
@Sql("/testdataset.sql")
class ApiRestMarkerControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void markeFindAll() throws Exception {

		this.mockMvc.perform(get("/api/marker/findAll")).andDo(print())
				.andExpectAll(status().isOk(),
							  jsonPath("$.length()").value(9),
							  jsonPath("$[0].id").value(1),
							  jsonPath("$[0].name").value("Asus"),
							  jsonPath("$[0].productList[0].id").value("6"));
	}

	@Test
	public void markerFind() throws Exception {

		this.mockMvc.perform(get("/api/marker/find/{id}", 6))
				.andDo(print()).andExpect(status().isOk())
				.andExpectAll(jsonPath("$.id").value(6),
							  jsonPath("$.name").value("Crucial"),
							  jsonPath("$.productList.length()").value("2"),
							  jsonPath("$.productList[0].id").value("2"),
							  jsonPath("$.productList[1].id").value("5")
						);
	}
	
	@Test
	public void markerFind1() throws Exception {

		this.mockMvc.perform(get("/api/marker/find/{id}", 4))
				.andDo(print())
				.andExpectAll(status().isOk(),content().string("{\"id\":4,\"name\":\"Samsung\",\"productList\":[{\"id\":3,\"name\":\"Disco SSD 1 TB\",\"price\":150.99}]}"));
	}
	
	@Test
	public void createMarker() throws Exception 
	{
		this.mockMvc.perform(post("/api/marker/save")
		      .content( "{\n"
		      		+ "    \"name\": \"Javier S.A.\",\n"
		      		+ "    \"productList\": [\n"
		      		+ "        {\n"
		      		+ "            \"name\": \"Producto 1\",\n"
		      		+ "            \"price\": 120.00\n"
		      		+ "        },\n"
		      		+ "        {\n"
		      		+ "            \"name\": \"producto 2\",\n"
		      		+ "            \"price\": 755.00\n"
		      		+ "        }\n"
		      		+ "    ]   \n"
		      		+ "}")
		      .contentType(MediaType.APPLICATION_JSON)
		      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isCreated());
	}
	
	@Test
	public void updateMarker() throws Exception 
	{
		this.mockMvc.perform(put("/api/marker/update/{id}", 2)
		      .content( "{\n"
		      		+ "    \"name\": \"prueba S.A.\"\n"
		      		+ "}")
		      .contentType(MediaType.APPLICATION_JSON)
		      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.content().string("Registro Actualizado"));
	}

	@Test
	public void deleteMarker() throws Exception 
	{
		this.mockMvc.perform(delete("/api/marker/delete/{id}", 1) )
	        .andExpect(status().isNoContent());
	}
	
}
