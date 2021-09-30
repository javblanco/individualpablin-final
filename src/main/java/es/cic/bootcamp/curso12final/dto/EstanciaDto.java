package es.cic.bootcamp.curso12final.dto;

import java.util.Objects;
import javax.persistence.Column;
import es.cic.bootcamp.curso12final.model.TipoEstancia;

public class EstanciaDto {

	private Long id;

	// Los campos de tipo-estancia
	private Long idTipoEstancia;
	private String nombreTipoEstancia;
	private TipoEstancia tipoEstancia;

	private int puerta;

	private int planta;

	private int plazas; //TODO CORREGIR A PLAZAS

	private int superficie;

	private String nombre;
	
	private boolean minibar; 		//TODO MOSTRAR EN FORMA DE ICONITOS
	private boolean aireacondicionado;
	private boolean parking;
	private boolean jacuzzi;

	@Column(columnDefinition = "boolean default true")
	private boolean disponible;

	private String complementos;
	
	public EstanciaDto() {
		super();
	}
	
	

	public EstanciaDto(Long id, Long idTipoEstancia, String nombreTipoEstancia, TipoEstancia tipoEstancia, int puerta,
			int planta, int plazas, int superficie, String nombre, boolean minibar, boolean aireacondicionado,
			boolean parking, boolean jacuzzi, boolean disponible, String complementos) {
		super();
		this.id = id;
		this.idTipoEstancia = idTipoEstancia;
		this.nombreTipoEstancia = nombreTipoEstancia;
		this.tipoEstancia = tipoEstancia;
		this.puerta = puerta;
		this.planta = planta;
		this.plazas = plazas;
		this.superficie = superficie;
		this.nombre = nombre;
		this.minibar = minibar;
		this.aireacondicionado = aireacondicionado;
		this.parking = parking;
		this.jacuzzi = jacuzzi;
		this.disponible = disponible;
		this.complementos = complementos;
	}


	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdTipoEstancia() {
		return idTipoEstancia;
	}



	public void setIdTipoEstancia(Long idTipoEstancia) {
		this.idTipoEstancia = idTipoEstancia;
	}



	public String getNombreTipoEstancia() {
		return nombreTipoEstancia;
	}



	public void setNombreTipoEstancia(String nombreTipoEstancia) {
		this.nombreTipoEstancia = nombreTipoEstancia;
	}



	public TipoEstancia getTipoEstancia() {
		return tipoEstancia;
	}



	public void setTipoEstancia(TipoEstancia tipoEstancia) {
		this.tipoEstancia = tipoEstancia;
	}



	public int getPuerta() {
		return puerta;
	}



	public void setPuerta(int puerta) {
		this.puerta = puerta;
	}



	public int getPlanta() {
		return planta;
	}



	public void setPlanta(int planta) {
		this.planta = planta;
	}



	public int getPlazas() {
		return plazas;
	}



	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}



	public int getSuperficie() {
		return superficie;
	}



	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public boolean isMinibar() {
		return minibar;
	}



	public void setMinibar(boolean minibar) {
		this.minibar = minibar;
	}



	public boolean isAireacondicionado() {
		return aireacondicionado;
	}



	public void setAireacondicionado(boolean aireacondicionado) {
		this.aireacondicionado = aireacondicionado;
	}



	public boolean isParking() {
		return parking;
	}



	public void setParking(boolean parking) {
		this.parking = parking;
	}



	public boolean isJacuzzi() {
		return jacuzzi;
	}



	public void setJacuzzi(boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}



	public boolean isDisponible() {
		return disponible;
	}



	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}



	public String getComplementos() {
		return complementos;
	}



	public void setComplementos(String complementos) {
		this.complementos = complementos;
	}



	@Override
	public String toString() {
		return "EstanciaDto [id=" + id + ", idTipoEstancia=" + idTipoEstancia + ", nombreTipoEstancia="
				+ nombreTipoEstancia + ", tipoEstancia=" + tipoEstancia + ", puerta=" + puerta + ", planta=" + planta
				+ ", plazas=" + plazas + ", superficie=" + superficie + ", nombre=" + nombre + ", minibar=" + minibar
				+ ", aireacondicionado=" + aireacondicionado + ", parking=" + parking + ", jacuzzi=" + jacuzzi
				+ ", disponible=" + disponible + ", complementos=" + complementos + "]";
	}

	@Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EstanciaDto other = (EstanciaDto) obj;
        return Objects.equals(id, other.id) ;
    }

	
}
