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
		e.setPuerta(dto.getPuerta());
		e.setPlanta(dto.getPlanta());
		e.setPlazas(dto.getPlazas());
		e.setSuperficie(dto.getSuperficie());
		e.setNombre(dto.getNombre());
		e.setMinibar(dto.isMinibar());
		e.setAireacondicionado(dto.isAireacondicionado());
		e.setParking(dto.isParking());
		e.setJacuzzi(dto.isJacuzzi());
		e.setDisponible(dto.isDisponible());
		e.setComplementos(dto.getComplementos());

		if (tipoEstancia != null) {
			e.setTipoEstancia(tipoEstancia);
		}
		
		return e;

	}

	public EstanciaDto entityToDto(Estancia e) {
		
		EstanciaDto eDto = new EstanciaDto();
		
		eDto.setId(e.getId());
		eDto.setPuerta(e.getPuerta());
		eDto.setPlanta(e.getPlanta());
		eDto.setPlazas(e.getPlazas());
		eDto.setSuperficie(e.getSuperficie());
		eDto.setNombre(e.getNombre());
		eDto.setMinibar(e.isMinibar());
		eDto.setAireacondicionado(e.isAireacondicionado());
		eDto.setParking(e.isParking());
		eDto.setJacuzzi(e.isJacuzzi());
		eDto.setDisponible(e.isDisponible());
		eDto.setComplementos(e.getComplementos());

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
		if (dto.getComplementos() != null) {
			estancia.setComplementos(dto.getComplementos());
		}
		
		estancia.setPuerta(dto.getPuerta());
		estancia.setPlanta(dto.getPlanta());
		estancia.setPlazas(dto.getPlazas());
		estancia.setSuperficie(dto.getSuperficie());
		estancia.setMinibar(dto.isMinibar());
		estancia.setAireacondicionado(dto.isAireacondicionado());
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
