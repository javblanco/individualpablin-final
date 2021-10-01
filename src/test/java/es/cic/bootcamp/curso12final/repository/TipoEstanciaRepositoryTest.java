package es.cic.bootcamp.curso12final.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import es.cic.bootcamp.curso12final.model.TipoEstancia;



@DataJpaTest
public class TipoEstanciaRepositoryTest {

	
	@Autowired
	private TipoEstanciaRepository tipoEstanciaRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testCrear() {
		
	TipoEstancia tipoEstancia = generarTipoEstancia();
	
	TipoEstancia resultado = tipoEstanciaRepository.save(tipoEstancia);
	entityManager.flush();

	assertNotNull(resultado.getId(), "La clave primaria no deberia ser nula");
	TipoEstancia tipoEstanciaEnBBDD = entityManager.find(TipoEstancia.class, resultado.getId());
	assertEquals(resultado, tipoEstanciaEnBBDD, "No se ha guardado el tipo de estancia");
	}
	
	@Test
	void testLeer() {
		TipoEstancia tipoEstanciaALeer = entityManager.persist(generarTipoEstancia());
		
		Optional<TipoEstancia> optional = tipoEstanciaRepository.findById(tipoEstanciaALeer.getId());
	
		if (optional.isPresent()) {
			TipoEstancia tipoEstanciaLeido = optional.get();
			
			assertEquals(tipoEstanciaALeer,tipoEstanciaLeido,"No se ha conseguido leer el tipo de estancia");
		}else {
			assertNull(optional,"La busqueda del tipo de estancia ha sido nula"	);
			}
	}
	
	@Test
	void testListar() {
		TipoEstancia tipoEstanciaALeer = tipoEstanciaRepository.save(generarTipoEstancia());
		
		TipoEstancia tipoEstanciaALeer2 =  tipoEstanciaRepository.save(generarTipoEstancia());
		
		List<TipoEstancia> listaTipoEstancia = List.of(tipoEstanciaALeer,tipoEstanciaALeer2);
		
		List<TipoEstancia> listaEnBBDD = new ArrayList<TipoEstancia>();
		
		tipoEstanciaRepository.findAll().forEach(listaEnBBDD::add);
		
		assertThat(listaEnBBDD.size())
		.isGreaterThanOrEqualTo(listaTipoEstancia.size());
		
	}
	
	@Test
	void testModificar() {
		TipoEstancia tipoEstanciaALeer = entityManager.persist(generarTipoEstancia());
		entityManager.flush();
		TipoEstancia tipoEstanciaEnBBDD = tipoEstanciaRepository.findById(tipoEstanciaALeer.getId()).get();
		
		tipoEstanciaEnBBDD.setDescripcion("Suite caprichosa");
		entityManager.flush();
		
		TipoEstancia tipoEstanciaTrasActualizar = entityManager.find(TipoEstancia.class , tipoEstanciaALeer.getId());
		
		assertEquals("Suite caprichosa",tipoEstanciaTrasActualizar.getDescripcion(),"No se ha actualizado");
		
	}
	
	@Test
	void testDarDeBaja() {
		TipoEstancia tipoEstanciaALeer = entityManager.persist(generarTipoEstancia());
		entityManager.flush();
		TipoEstancia tipoEstanciaBBDD = tipoEstanciaRepository.findById(tipoEstanciaALeer.getId()).get();
		
		tipoEstanciaBBDD.setActivo(false);
		entityManager.flush();
		
		TipoEstancia tipoEstanciaTrasActualizar = entityManager.find(TipoEstancia.class , tipoEstanciaALeer.getId());
		
		assertEquals(false,tipoEstanciaTrasActualizar.isActivo(),"No se ha dado de baja");
		
	}
	
	@Test
	void testDarDeAlta() {
		TipoEstancia tipoEstanciaALeer = entityManager.persist(generarTipoEstancia2());
		entityManager.flush();
		TipoEstancia tipoEstanciaEnBBDD = tipoEstanciaRepository.findById(tipoEstanciaALeer.getId()).get();
		
		tipoEstanciaEnBBDD.setActivo(true);
		entityManager.flush();
		
		TipoEstancia tipoEstanciaTrasActualizar = entityManager.find(TipoEstancia.class , tipoEstanciaALeer.getId());
		
		assertEquals(true,tipoEstanciaTrasActualizar.isActivo(),"No se ha dado de alta");
		
	}
	@Test
	void testBorrar() {
		TipoEstancia tipEstanciaABorrar = entityManager.persist(generarTipoEstancia());
		entityManager.flush();
		
		tipoEstanciaRepository.deleteById(tipEstanciaABorrar.getId());
		entityManager.flush();
		
		TipoEstancia tipoEstanciaTrasBorrar = entityManager.find(TipoEstancia.class ,tipEstanciaABorrar.getId());
		assertNull(tipoEstanciaTrasBorrar,"No se ha eliminado el tipo estancia");
		
	}
	
	
	private TipoEstancia generarTipoEstancia() {
		TipoEstancia tipoEstancia = new TipoEstancia();
		tipoEstancia.setNombre("Africa");
		tipoEstancia.setDescripcion("Suite mimosa.");
		return tipoEstancia;
	}
	private TipoEstancia generarTipoEstancia2() {
		TipoEstancia tipoEstancia = new TipoEstancia();
		tipoEstancia.setActivo(false);
		tipoEstancia.setNombre("Africa");
		tipoEstancia.setDescripcion("Suite mimosa.");
		return tipoEstancia;
	}

	
}
