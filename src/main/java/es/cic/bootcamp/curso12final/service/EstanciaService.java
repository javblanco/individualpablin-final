package es.cic.bootcamp.curso12final.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.cic.bootcamp.curso12final.dto.EstanciaDto;
import es.cic.bootcamp.curso12final.exception.CreateEstanciaException;
import es.cic.bootcamp.curso12final.helper.EstanciaHelper;
import es.cic.bootcamp.curso12final.model.Estancia;
import es.cic.bootcamp.curso12final.model.TipoEstancia;
import es.cic.bootcamp.curso12final.repository.EstanciaRepository;
import es.cic.bootcamp.curso12final.repository.TipoEstanciaRepository;

@Service
public class EstanciaService {
	
	@Autowired
	private EstanciaRepository estanciaRepository;
	
	@Autowired
	private TipoEstanciaRepository tipoEstanciaRepository;
	
	@Autowired
	private EstanciaHelper estanciaHelper;

	public Long create(@Valid EstanciaDto dto) {
		
		if (dto.getId() != null) {
			throw new CreateEstanciaException("No se puede modificar una estancia, solo crear");
		}

		Optional<TipoEstancia> optional = tipoEstanciaRepository.findById(dto.getIdTipoEstancia());

		TipoEstancia tipoEstancia = null;

		if (optional.isPresent()) {
			tipoEstancia = optional.get();
		}
		
		//Logica que calcula la referencia
		dto.setRef("["+dto.getPlanta()+"-"+dto.getPuerta()+"]");
		dto.setDisponible(true);//al crear se inicia con true

		Estancia resultado = estanciaRepository.save(estanciaHelper.dtoToEntity(dto, tipoEstancia));

		return resultado.getId();
	}

	public List<EstanciaDto> list() {
		
		List<Estancia> lista = new ArrayList<>();

		estanciaRepository.findAll().forEach(lista::add);

		List<EstanciaDto> listaDto = new ArrayList<>();

		lista.forEach(p -> listaDto.add(estanciaHelper.entityToDto(p)));

		return listaDto;
	}

	public EstanciaDto read(Long id) {
		
		Optional<Estancia> optional = estanciaRepository.findById(id);

		if (optional.isPresent()) {
			Estancia estancia = optional.get();
			return estanciaHelper.entityToDto(estancia);
		} else {
			return null;
		}
	}

	public void update(@Valid EstanciaDto dto) {
		
		Optional<Estancia> optional = estanciaRepository.findById(dto.getId());

		if (optional.isPresent()) {
			Estancia estancia = optional.get();

			//Logica que calcula la referencia
			dto.setRef("["+dto.getPlanta()+"-"+dto.getPuerta()+"]");

			Optional<TipoEstancia> tipoO = tipoEstanciaRepository.findById(dto.getIdTipoEstancia());
			TipoEstancia tipoEstancia = tipoO.get();
			
			//ACtualizar el tipo
			dto.setTipoEstancia(tipoEstancia);
			

			estanciaHelper.dtoToEntity(estancia, dto, dto.getTipoEstancia());
			estanciaRepository.save(estancia);
		}
		
	}

	public void delete(Long id) {
		estanciaRepository.deleteById(id);
	}
	
}
