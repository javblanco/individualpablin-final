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

	private int numPuerta;

	private int numPlanta;

	private int capacidadMaxHabitantes;

	private int metrosCuadrados;

	private String nombre;
	
	private boolean miniBar;
	private boolean aireAcondicionado;
	private boolean parking;
	private boolean jacuzzi;

	@Column(columnDefinition = "boolean default true")
	private boolean disponible;

	private String listaComplementosExtras;
	
	public EstanciaDto() {
		super();
	}
	
	/**
	 * Contructor de EstanciaDto utilizado para recoger un objeto, procedente del front-end en la request.
	 * 
	 * @param id
	 * @param idTipoEstancia
	 * @param nombreTipoEstancia
	 * @param tipoEstancia
	 * @param numPuerta
	 * @param numPlanta
	 * @param capacidadMaxHabitantes
	 * @param metrosCuadrados
	 * @param miniBar
	 * @param aireAcondicionado
	 * @param parking
	 * @param jacuzzi
	 * @param disponible
	 * @param listaComplementosExtras
	 */
	public EstanciaDto(Long id, Long idTipoEstancia, String nombreTipoEstancia, TipoEstancia tipoEstancia,
			int numPuerta, int numPlanta, int capacidadMaxHabitantes, int metrosCuadrados,
			boolean miniBar, boolean aireAcondicionado, boolean parking, boolean jacuzzi, boolean disponible,
			String listaComplementosExtras) {
		super();
		this.id = id;
		this.idTipoEstancia = idTipoEstancia;
		this.nombreTipoEstancia = nombreTipoEstancia;
		this.tipoEstancia = tipoEstancia;
		this.numPuerta = numPuerta;
		this.capacidadMaxHabitantes = capacidadMaxHabitantes;
		this.metrosCuadrados = metrosCuadrados;
		this.miniBar = miniBar;
		this.aireAcondicionado = aireAcondicionado;
		this.parking = parking;
		this.jacuzzi = jacuzzi;
		this.disponible = disponible;
		this.listaComplementosExtras = listaComplementosExtras;
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

	public int getNumPuerta() {
		return numPuerta;
	}

	public void setNumPuerta(int numPuerta) {
		this.numPuerta = numPuerta;
	}

	public int getNumPlanta() {
		return numPlanta;
	}

	public void setNumPlanta(int numPlanta) {
		this.numPlanta = numPlanta;
	}

	public int getCapacidadMaxHabitantes() {
		return capacidadMaxHabitantes;
	}

	public void setCapacidadMaxHabitantes(int capacidadMaxHabitantes) {
		this.capacidadMaxHabitantes = capacidadMaxHabitantes;
	}

	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isMiniBar() {
		return miniBar;
	}

	public void setMiniBar(boolean miniBar) {
		this.miniBar = miniBar;
	}

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
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

	public String getListaComplementosExtras() {
		return listaComplementosExtras;
	}

	public void setListaComplementosExtras(String listaComplementosExtras) {
		this.listaComplementosExtras = listaComplementosExtras;
	}
	
	

	@Override
	public String toString() {
		return "EstanciaDto [id=" + id + ", idTipoEstancia=" + idTipoEstancia + ", nombreTipoEstancia="
				+ nombreTipoEstancia + ", tipoEstancia=" + tipoEstancia + ", numPuerta=" + numPuerta + ", numPlanta="
				+ numPlanta + ", capacidadMaxHabitantes=" + capacidadMaxHabitantes + ", metrosCuadrados="
				+ metrosCuadrados + ", nombre=" + nombre + ", miniBar=" + miniBar + ", aireAcondicionado="
				+ aireAcondicionado + ", parking=" + parking + ", jacuzzi=" + jacuzzi + ", disponible=" + disponible
				+ ", listaComplementosExtras=" + listaComplementosExtras + "]";
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
