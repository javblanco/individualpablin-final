package es.cic.bootcampt.curso12final.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.bootcamp.curso12final.dto.EstanciaDto;
import es.cic.bootcamp.curso12final.model.Estancia;
import es.cic.bootcamp.curso12final.model.TipoEstancia;
import es.cic.bootcamp.grupo03final.conversor.ProductoConversor;
import es.cic.bootcamp.grupo03final.repositorio.ProductoRepositorio;
import es.cic.bootcamp.grupo03final.repositorio.TipoProductoRepositorio;
import es.cic.bootcampt.curso12final.helper.EstanciaHelper;
import es.cic.bootcampt.curso12final.repository.EstanciaRepository;
import es.cic.bootcampt.curso12final.repository.TipoEstanciaRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EstanciaControllerTestIntegration {

	
	@Autowired
	private MockMvc mvc;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired 
	private EstanciaRepository EstanciaRepositorio;
	
	@Autowired
	private TipoEstanciaRepository tipoEstanciaRepositorio;
	
	@Autowired
	private EstanciaHelper estanciaHelper;
	
	@Autowired
	private ObjectMapper mapper;
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	private Estancia generarEstancia() {
		Estancia e = new Estancia();
		
		e.setNumPuerta(005);
		e.setNumPlanta(5);
		e.setCapacidadMaxHabitantes(10);
		e.setMetrosCuadrados(250);
		e.setNombre("Dicaprio");
		e.setMiniBar(true);
		e.setAireAcondicionado(true);
		e.setParking(false);
		e.setJacuzzi(true);
		e.setListaComplementosExtras("Terraza exterior privada");
		
		return e;
	}
	
	private EstanciaDto generarEstanciaDto() {
		EstanciaDto eDto = new EstanciaDto();
		
		eDto.setNumPuerta(005);
		eDto.setNumPlanta(5);
		eDto.setCapacidadMaxHabitantes(10);
		eDto.setMetrosCuadrados(250);
		eDto.setNombre("Dicaprio");
		eDto.setMiniBar(true);
		eDto.setAireAcondicionado(true);
		eDto.setParking(false);
		eDto.setJacuzzi(true);
		eDto.setListaComplementosExtras("Terraza exterior privada");
		
		return eDto;
		
	}
	
	private TipoEstancia generarTipoEstancia() {
		TipoEstancia tE = new TipoEstancia();
		
		tE.setNombre("Vip presidencial");
		tE.setDescripcion("Suit impresionante en lo alto del hotel, con acceso a helipuerto");
		
		return tE;
	}
	
	
	
	
	
}
