package es.cic.bootcamp.curso12final.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import es.cic.bootcamp.curso12final.dto.EstanciaDto;
import es.cic.bootcamp.curso12final.service.EstanciaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estancia")
public class EstanciaController {
	
	private static final Logger LOGGER = Logger.getLogger(EstanciaController.class.getName());
	

	@Autowired
	private EstanciaService estanciaServicio;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Long create(@Valid @RequestBody EstanciaDto dto) {
		LOGGER.info("Recibida una request para crear una nueva estancia.");
		
		return estanciaServicio.create(dto);
		
	}
	
	@GetMapping
	public List<EstanciaDto> list() {
		LOGGER.info("Recibida una request para listar las  estancias.");
		
		return estanciaServicio.list();
		
	}
	
	@GetMapping("/{id}")
	public EstanciaDto read(@PathVariable(required = true, name = "id") Long id) {
		LOGGER.info("Recibida una request para leer una estancia");
		return estanciaServicio.read(id);
	}
	
	@PutMapping
	public void update(@Valid @RequestBody EstanciaDto dto) {
		LOGGER.info("Recibida una request para editar una estancia.");
		estanciaServicio.update(dto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true, name = "id") Long id) {
		LOGGER.info("Recibida una request para eliminar una estancia.");
		estanciaServicio.delete(id);
	}
	
}