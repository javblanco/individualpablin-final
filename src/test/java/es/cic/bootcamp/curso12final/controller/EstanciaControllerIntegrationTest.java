package es.cic.bootcamp.curso12final.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.cic.bootcamp.curso12final.dto.EstanciaDto;
import es.cic.bootcamp.curso12final.helper.EstanciaHelper;
import es.cic.bootcamp.curso12final.model.Estancia;
import es.cic.bootcamp.curso12final.model.TipoEstancia;
import es.cic.bootcamp.curso12final.repository.EstanciaRepository;
import es.cic.bootcamp.curso12final.repository.TipoEstanciaRepository;



@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EstanciaControllerIntegrationTest {

	
	@Autowired
	private MockMvc mvc;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired 
	private EstanciaRepository estanciaRepository;
	
	@Autowired
	private TipoEstanciaRepository tipoEstanciaRepository;
	
	@Autowired
	private EstanciaHelper estanciaHelper;
	
	@Autowired
	private ObjectMapper mapper;
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	private Estancia generarEstancia() {
		Estancia e = new Estancia();
		
		e.setPuerta(005);
		e.setPlanta(5);
		e.setPlazas(10);
		e.setSuperficie(250);
		e.setNombre("Dicaprio");
		e.setMinibar(true);
		e.setAireacondicionado(true);
		e.setParking(false);
		e.setJacuzzi(true);
		e.setComplementos("Terraza exterior privada");
		
		return e;
	}
	
	private EstanciaDto generarEstanciaDto() {
		EstanciaDto eDto = new EstanciaDto();
		
		eDto.setPuerta(005);
		eDto.setPlanta(5);
		eDto.setPlazas(10);
		eDto.setSuperficie(250);
		eDto.setNombre("Dicaprio");
		eDto.setMinibar(true);
		eDto.setAireacondicionado(true);
		eDto.setParking(false);
		eDto.setJacuzzi(true);
		eDto.setComplementos("Terraza exterior privada");
		
		return eDto;
		
	}
	
	private TipoEstancia generarTipoEstancia() {
		TipoEstancia tE = new TipoEstancia();
		
		tE.setNombre("Vip presidencial");
		tE.setDescripcion("Suit impresionante en lo alto del hotel, con acceso a helipuerto");
		
		return tE;
	}
	
	
	@Test
	void testCrear() throws Exception {
		Estancia estanciaResultado = generarEstancia();

		TipoEstancia tipoEst = new TipoEstancia();
		tipoEst.setNombre("Suit Capricho");
		
		entityManager.persist(tipoEst);
		entityManager.flush();
		
		estanciaResultado.setTipoEstancia(tipoEst);
		
		EstanciaDto dto = generarEstanciaDto();
		dto.setIdTipoEstancia(tipoEst.getId());
		
		MockHttpServletRequestBuilder request =
				post("/estancia")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(dto));
		
		
		MvcResult result = mvc.perform(request)
						   .andDo(print())
						   .andExpect(status().isCreated())
						   .andReturn();
		
		String content = result.getResponse().getContentAsString();
		
		Long idEstanciaResultado = Long.parseLong(content);
		
		Estancia estanciaEnBBDD = entityManager.find(Estancia.class, idEstanciaResultado);
		
		assertNotNull(estanciaEnBBDD.getTipoEstancia(), "El tipo no se ha asociado correctamente con la estancia");
		
		
		assertThat(estanciaEnBBDD)
		.usingRecursiveComparison()
		.ignoringFields("id")
		.isEqualTo(estanciaResultado);
				
	}
	
	@Test
	void testListar() throws Exception {
		Estancia estancia = generarEstancia();
		Estancia estancia1 = generarEstancia();
		
		estanciaRepository.saveAll(List.of(estancia, estancia1));
		
		MockHttpServletRequestBuilder request = get("/estancia")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		String respuesta = mapper.writeValueAsString(estanciaHelper.entityListToDtoList(List.of(estancia, estancia1)));
		
		respuesta = respuesta.substring(1, respuesta.length()-1);
		
		MvcResult result = mvc.perform(request)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
		.andReturn();
		
		String resultado = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		assertTrue(resultado.contains(respuesta), "Error en el listado de estancias, no son los esperados");
	}
	
	@Test
	void testModificar() throws Exception {
		Estancia estancia = generarEstancia();
		
		estanciaRepository.save(estancia);
		
		Estancia estanciaModificar = generarEstancia();
		estanciaModificar.setId(estancia.getId());
		estanciaModificar.setNombre("Basica");
		
		String body = mapper.writeValueAsString(estanciaHelper.entityToDto(estancia));
		
		MockHttpServletRequestBuilder request = put("/estancia")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(body);
		
		MvcResult result = mvc.perform(request)
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		Estancia resultado = estanciaRepository.findById(estancia.getId()).get();
		
		assertEquals(estanciaModificar, resultado, "El registro no se ha modificado correctamente.");

	}
	
	@Test
	void testBorrar() throws Exception {
		Estancia estancia = generarEstancia();
		
		Estancia estanciaABorrar = estanciaRepository.save(estancia);
		
		MockHttpServletRequestBuilder request = delete("/estancia/{id}", estanciaABorrar.getId())
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		mvc.perform(request)
		.andDo(print())
		.andExpect(status().isOk());
		
		
		Optional<Estancia> estanciaEnBBDD = estanciaRepository.findById(estanciaABorrar.getId());
		
		assertTrue(estanciaEnBBDD.isEmpty(), "No se ha borrado el registro");
	}

	@Test
	void testLeer() throws Exception {
		Estancia estancia = generarEstancia();

		estanciaRepository.save(estancia);

		MockHttpServletRequestBuilder request = get("/estancia/{id}", estancia.getId()).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		mvc.perform(request).andDo(print()).andExpect(status().isOk());
	}
	
	
	
	
	
}
