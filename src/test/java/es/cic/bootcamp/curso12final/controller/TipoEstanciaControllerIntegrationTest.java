package es.cic.bootcamp.curso12final.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.cic.bootcamp.curso12final.helper.TipoEstanciaHelper;
import es.cic.bootcamp.curso12final.model.TipoEstancia;
import es.cic.bootcamp.curso12final.repository.TipoEstanciaRepository;


@SpringBootTest
@AutoConfigureMockMvc
public class TipoEstanciaControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TipoEstanciaRepository tipoEstanciaRepository;
	
	@Autowired
	private TipoEstanciaHelper tipoEstanciaHelper;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Test
	void testCrear() throws Exception {
		TipoEstancia tipoEstancia = generarTipoEstancia();
		String body = mapper.writeValueAsString(tipoEstanciaHelper.entityToDto(tipoEstancia));
		
		MockHttpServletRequestBuilder request = post("/tipoEstancia")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(body);
		
		MvcResult result = mvc.perform(request)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", notNullValue()))
				.andReturn();
		
		String resultado = result.getResponse().getContentAsString();
		
		JSONObject obj = new JSONObject(resultado);

		String respuesta = obj.getString("id");
		
		Long idResultado = Long.parseLong(respuesta);
		
		TipoEstancia tipoEstanciaResultado = 
				tipoEstanciaRepository.findById(idResultado).get();
		
		assertThat(tipoEstancia)
		.usingRecursiveComparison()
		.ignoringFields("id")
		.isEqualTo(tipoEstanciaResultado);
	}
	
	@Test
	void testListar() throws Exception {
		TipoEstancia tipoEstancia = generarTipoEstancia();
		TipoEstancia tipoEstancia1 = generarTipoEstancia1();

		tipoEstanciaRepository.saveAll(List.of(tipoEstancia, tipoEstancia1));
		
		MockHttpServletRequestBuilder request = get("/tipoEstancia")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		String respuesta = mapper.writeValueAsString(tipoEstanciaHelper.entityListToDtoList(List.of(tipoEstancia, tipoEstancia1)));
		
		respuesta = respuesta.substring(1, respuesta.length()-1);
		
		MvcResult result = mvc.perform(request)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
		.andReturn();
		
		String resultado = result.getResponse().getContentAsString();
		

		assertTrue(resultado.contains(respuesta), "El registro leido no es el esperado.");
	}
	
	@Test
	void testLeer() throws Exception {
		TipoEstancia tipo = tipoEstanciaRepository.save(new TipoEstancia("Holandesa", "Decorada con el 14."));
				MockHttpServletRequestBuilder request = get("/tipoEstancia/{id}", tipo.getId())
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		mvc.perform(request)
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	void testModificar() throws Exception {
		TipoEstancia tipoEstancia = generarTipoEstancia();
		
		tipoEstanciaRepository.save(tipoEstancia);
		
		TipoEstancia tipoEstanciaAModificar = generarTipoEstancia();
		tipoEstanciaAModificar.setId(tipoEstancia.getId());
		tipoEstanciaAModificar.setNombre("Presidencial");

		String body = mapper.writeValueAsString(tipoEstanciaHelper.entityToDto(tipoEstancia));
		
		MockHttpServletRequestBuilder request = put("/tipoEstancia")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(body);
		
		MvcResult result = mvc.perform(request)
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		TipoEstancia resultado = tipoEstanciaRepository.findById(tipoEstancia.getId()).get();
		
		assertEquals(tipoEstanciaAModificar, resultado, "El registro no se ha modificado correctamente.");

	}
	
	@Test
	void testDarDeBaja() throws Exception {
		TipoEstancia tipoEstancia = generarTipoEstancia();
		
		tipoEstanciaRepository.save(tipoEstancia);
		
		TipoEstancia tipoEstanciaADarDeBaja = generarTipoEstancia();
		tipoEstanciaADarDeBaja.setId(tipoEstancia.getId());
		tipoEstanciaADarDeBaja.setActivo(false);;

		String body = mapper.writeValueAsString(tipoEstanciaHelper.entityToDto(tipoEstancia));
		

		MockHttpServletRequestBuilder request = post("/tipoEstancia/desactivar/{id}",tipoEstancia.getId())
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(body);
		
		MvcResult result = mvc.perform(request)
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		TipoEstancia resultado = tipoEstanciaRepository.findById(tipoEstancia.getId()).get();
		
		assertEquals(tipoEstanciaADarDeBaja, resultado, "El registro no se ha dado de baja correctamente");

	}

	
	@Test
	void testDarDeAlta() throws Exception {
		TipoEstancia tipoEstancia = generarTipoEstancia1();
		
		tipoEstanciaRepository.save(tipoEstancia);
		
		TipoEstancia tipoEstanciaADarDeAlta = generarTipoEstancia1();
		tipoEstanciaADarDeAlta.setId(tipoEstancia.getId());
		tipoEstanciaADarDeAlta.setActivo(true);

		String body = mapper.writeValueAsString(tipoEstanciaHelper.entityToDto(tipoEstancia));
		

		MockHttpServletRequestBuilder request = post("/tipoEstancia/activar/{id}",tipoEstancia.getId())
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(body);
		
		MvcResult result = mvc.perform(request)
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		TipoEstancia resultado = tipoEstanciaRepository.findById(tipoEstancia.getId()).get();
		
		assertEquals(tipoEstanciaADarDeAlta, resultado, "El registro no se ha modificado correctamente.");

	}
	
	
	
	private TipoEstancia generarTipoEstancia1() {
		TipoEstancia tipoEstancia = new TipoEstancia();
		tipoEstancia.setActivo(false);
		tipoEstancia.setNombre("Africana");
		tipoEstancia.setDescripcion("Suit decorada como el desierto.");
		return tipoEstancia;
	}

	private TipoEstancia generarTipoEstancia() {
		TipoEstancia tipoEstancia = new TipoEstancia();
		tipoEstancia.setNombre("Africana");
		tipoEstancia.setDescripcion("Suit decorada como el desierto.");
		return tipoEstancia;
	}
}
