package es.cic.bootcamp.curso12final.helper;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.stereotype.Component;

import es.cic.bootcamp.curso12final.dto.TipoEstanciaDto;
import es.cic.bootcamp.curso12final.model.TipoEstancia;

@Component
public class TipoEstanciaHelper {

	public TipoEstanciaDto entityToDto(TipoEstancia tipoEstancia) {
		
		TipoEstanciaDto dto= new TipoEstanciaDto();
		
		dto.setId(tipoEstancia.getId());
		
		dto.setNombre(tipoEstancia.getNombre());
		dto.setDescripcion(tipoEstancia.getDescripcion());
		dto.setActivo(tipoEstancia.isActivo());
		
		return dto;
		
	}

	public TipoEstancia dtoToEntity(@Valid TipoEstanciaDto dto) {
		
		TipoEstancia tipoEstancia = new TipoEstancia();
		
		tipoEstancia.setId(dto.getId());
		tipoEstancia.setNombre(dto.getNombre());
		tipoEstancia.setDescripcion(dto.getDescripcion());
		tipoEstancia.setActivo(dto.isActivo());
		
		return tipoEstancia;
	}

	public List<TipoEstanciaDto> entityListToDtoList(List<TipoEstancia> listaTipoEestancia) {
		List<TipoEstanciaDto> lista = new ArrayList<>();
		
		listaTipoEestancia.forEach(
				tipoEstancia -> lista.add(this.entityToDto(tipoEstancia))
				);
		return lista;
	}

}
