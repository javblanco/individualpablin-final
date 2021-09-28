package es.cic.bootcamp.curso12final.helper;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import es.cic.bootcamp.curso12final.dto.EstanciaDto;
import es.cic.bootcamp.curso12final.model.Estancia;
import es.cic.bootcamp.curso12final.model.TipoEstancia;

@Component
public class EstanciaHelper {

	public Estancia dtoToEntity(@Valid EstanciaDto dto, TipoEstancia tipoEstancia) {

		Estancia e = new Estancia();

		e.setId(dto.getId());
		e.setNumPuerta(dto.getNumPuerta());
		e.setNumPlanta(dto.getNumPlanta());
		e.setCapacidadMaxHabitantes(dto.getCapacidadMaxHabitantes());
		e.setMetrosCuadrados(dto.getMetrosCuadrados());
		e.setNombre(dto.getNombre());
		e.setMiniBar(dto.isMiniBar());
		e.setAireAcondicionado(dto.isAireAcondicionado());
		e.setParking(dto.isParking());
		e.setJacuzzi(dto.isJacuzzi());
		e.setDisponible(dto.isDisponible());
		e.setListaComplementosExtras(dto.getListaComplementosExtras());

		if (tipoEstancia != null) {
			e.setTipoEstancia(tipoEstancia);
		}
		
		return e;

	}

	public EstanciaDto entityToDto(Estancia e) {
		
		EstanciaDto eDto = new EstanciaDto();
		
		eDto.setId(e.getId());
		eDto.setNumPuerta(e.getNumPuerta());
		eDto.setNumPlanta(e.getNumPlanta());
		eDto.setCapacidadMaxHabitantes(e.getCapacidadMaxHabitantes());
		eDto.setMetrosCuadrados(e.getMetrosCuadrados());
		eDto.setNombre(e.getNombre());
		eDto.setMiniBar(e.isMiniBar());
		eDto.setAireAcondicionado(e.isAireAcondicionado());
		eDto.setParking(e.isParking());
		eDto.setJacuzzi(e.isJacuzzi());
		eDto.setDisponible(e.isDisponible());
		eDto.setListaComplementosExtras(e.getListaComplementosExtras());

		if (e.getTipoEstancia() != null) {
			eDto.setIdTipoEstancia(e.getTipoEstancia().getId());
			eDto.setTipoEstancia(e.getTipoEstancia());
		}
		
		
		return eDto;
	}

	public void dtoToEntity(Estancia estancia, @Valid EstanciaDto dto, TipoEstancia tipoEstancia) {
		
		if (dto.getId() != null) {
			estancia.setId(dto.getId());
		}
		if (dto.getNombre() != null) {
			estancia.setNombre(dto.getNombre());
		}
		if (dto.getTipoEstancia() != null) {
			estancia.setTipoEstancia(dto.getTipoEstancia());
		}
		if (dto.getListaComplementosExtras() != null) {
			estancia.setListaComplementosExtras(dto.getListaComplementosExtras());
		}
		
		
		estancia.setNumPuerta(dto.getNumPuerta());
		estancia.setNumPlanta(dto.getNumPlanta());
		estancia.setCapacidadMaxHabitantes(dto.getCapacidadMaxHabitantes());
		estancia.setMetrosCuadrados(dto.getMetrosCuadrados());
		estancia.setMiniBar(dto.isMiniBar());
		estancia.setAireAcondicionado(dto.isAireAcondicionado());
		estancia.setParking(dto.isParking());
		estancia.setJacuzzi(dto.isJacuzzi());
		estancia.setDisponible(dto.isDisponible());
		
	}

	public Object entityListToDtoList(List<Estancia> lestaEstancia) {
		
		List<EstanciaDto> lista = new ArrayList<>();

		lestaEstancia.forEach(p -> lista.add(this.entityToDto(p)));

		return lista;

	}
	
}
