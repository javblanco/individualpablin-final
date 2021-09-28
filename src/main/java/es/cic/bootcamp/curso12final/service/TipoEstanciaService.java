package es.cic.bootcamp.curso12final.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.cic.bootcamp.curso12final.dto.TipoEstanciaDto;
import es.cic.bootcamp.curso12final.exception.CreateEstanciaException;
import es.cic.bootcamp.curso12final.exception.CreateTipoEstanciaException;
import es.cic.bootcamp.curso12final.helper.TipoEstanciaHelper;
import es.cic.bootcamp.curso12final.model.TipoEstancia;
import es.cic.bootcamp.curso12final.repository.TipoEstanciaRepository;

@Service
@Transactional
public class TipoEstanciaService {

	@Autowired
	private TipoEstanciaRepository tipoEstanciaRepository;

	@Autowired
	private TipoEstanciaHelper tipoEstanciaHelper;

	public TipoEstanciaDto crear(@Valid TipoEstanciaDto tipoEstanciaDto) {
		if (tipoEstanciaDto.getId() != null) {
			throw new CreateTipoEstanciaException("No se puede modificar un tipo estancia, solo crear");
		}

		TipoEstancia tipoEstancia = tipoEstanciaHelper.dtoToEntity(tipoEstanciaDto);

		return tipoEstanciaHelper.entityToDto(tipoEstanciaRepository.save(tipoEstancia));
	}

	public List<TipoEstanciaDto> listar() {
		List<TipoEstancia> lista = new ArrayList<>();

		tipoEstanciaRepository.findAll().forEach(lista::add);

		return tipoEstanciaHelper.entityListToDtoList(lista);
	}

	public void modificar(@Valid TipoEstanciaDto tipoEstanciaDto) {
		if (tipoEstanciaDto.getId() == null) {
			throw new CreateTipoEstanciaException("No se puedo realizar la operación de modificar correctamente.");
		}

		TipoEstancia tipoEstancia = tipoEstanciaHelper.dtoToEntity(tipoEstanciaDto);

		tipoEstanciaHelper.entityToDto(tipoEstanciaRepository.save(tipoEstancia));
	}

	public TipoEstanciaDto leer(Long id) {
		Optional<TipoEstancia> optional = tipoEstanciaRepository.findById(id);

		if (optional.isPresent()) {
			return tipoEstanciaHelper.entityToDto(optional.get());
		} else {
			return null;
		}
	}

	public void darDeBaja(Long id) {
		Optional<TipoEstancia> optional = tipoEstanciaRepository.findById(id);
		TipoEstancia tipoEstancia = null;

		if (optional.isPresent()) {
			tipoEstancia = optional.get();
		} else {
			throw new CreateTipoEstanciaException("No se puedo realizar la operación de dar de baja correctamente.");
		}
		if (tipoEstancia.isActivo() == true) {
			tipoEstancia.setActivo(false);
		} else {
			throw new CreateTipoEstanciaException("ya estaba dado de baja");
		}
	}

	public void darDeAlta(Long id) {
		Optional<TipoEstancia> optional = tipoEstanciaRepository.findById(id);
		TipoEstancia tipoEstancia = new TipoEstancia();

		if (optional.isPresent()) {
			tipoEstancia = optional.get();
		} else {
			throw new CreateTipoEstanciaException("No se puedo realizar la operación de dar de alta correctamente.");
		}
		if (tipoEstancia.isActivo() == false) {
			tipoEstancia.setActivo(true);
		} else {
			throw  new CreateTipoEstanciaException("Ya estaba dado de alta el estancia");
		}
	}

	public void borrar(Long id) {
		// TODO Borrar un tipo solo y cuando no hay estancias con ese tipo de estancia
		// en uso.

	}

}
