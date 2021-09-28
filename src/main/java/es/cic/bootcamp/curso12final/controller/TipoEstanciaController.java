package es.cic.bootcamp.curso12final.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.bootcamp.curso12final.dto.TipoEstanciaDto;
import es.cic.bootcamp.curso12final.service.TipoEstanciaService;

@RestController
@RequestMapping("/tipoEstancia")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoEstanciaController {

	private static final Logger LOGGER = Logger.getLogger(TipoEstanciaController.class.getName());

	@Autowired
	private TipoEstanciaService tipoEstanciaService;

	@PostMapping
	public TipoEstanciaDto crear(@Valid @RequestBody TipoEstanciaDto tipoEstancia) {
		LOGGER.info("Recibida una solicitud para crear un tipo de estancia.");
		return tipoEstanciaService.crear(tipoEstancia);
	}

	@GetMapping
	public List<TipoEstanciaDto> listar() {
		LOGGER.info("Recibida una solicitud para listar tipos de estancia.");
		return tipoEstanciaService.listar();
	}

	@PutMapping
	public void modificar(@Valid @RequestBody TipoEstanciaDto tipoEstancia) {
		LOGGER.info("Recibida una solicitud para modificar un tipo de estancia.");
		tipoEstanciaService.modificar(tipoEstancia);
	}

	@GetMapping("/{id}")
	public TipoEstanciaDto leer(@PathVariable(required = true, name = "id") Long id) {
		LOGGER.info("Recibida una solicitud para leer un tipo de estancia.");
		return tipoEstanciaService.leer(id);
	}

	/*@DeleteMapping
	public void borrar(@PathVariable(required = true, name = "id") Long id) {
		LOGGER.info("Recibida una solicitud para borrar un tipo de estancia");
		tipoEstanciaService.borrar(id);
	}*/

	@PostMapping("/desactivar/{id}")
	public void darDeBaja(@PathVariable(required = true, name = "id") Long id) {
		LOGGER.info("Recibida una solicitud para desactivar un tipo de estancia");
		tipoEstanciaService.darDeBaja(id);
	}

	@PostMapping("/activar/{id}")
	public void darDeAlta(@PathVariable(required = true, name = "id") Long id) {
		LOGGER.info("Recibida una solicitud para activar un tipo de estancia");
		tipoEstanciaService.darDeAlta(id);
	}

}
