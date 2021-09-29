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
		this.puerta = numPuerta;
		this.plazas = capacidadMaxHabitantes;
		this.superficie = metrosCuadrados;
		this.minibar = miniBar;
		this.aireacondicionado = aireAcondicionado;
		this.parking = parking;
		this.jacuzzi = jacuzzi;
		this.disponible = disponible;
		this.complementos = listaComplementosExtras;
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
		return puerta;
	}

	public void setNumPuerta(int numPuerta) {
		this.puerta = numPuerta;
	}

	public int getNumPlanta() {
		return planta;
	}

	public void setNumPlanta(int numPlanta) {
		this.planta = numPlanta;
	}

	public int getCapacidadMaxHabitantes() {
		return plazas;
	}

	public void setCapacidadMaxHabitantes(int capacidadMaxHabitantes) {
		this.plazas = capacidadMaxHabitantes;
	}

	public int getMetrosCuadrados() {
		return superficie;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.superficie = metrosCuadrados;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isMiniBar() {
		return minibar;
	}

	public void setMiniBar(boolean miniBar) {
		this.minibar = miniBar;
	}

	public boolean isAireAcondicionado() {
		return aireacondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireacondicionado = aireAcondicionado;
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
		return complementos;
	}

	public void setListaComplementosExtras(String listaComplementosExtras) {
		this.complementos = listaComplementosExtras;
	}
	
	

	@Override
	public String toString() {
		return "EstanciaDto [id=" + id + ", idTipoEstancia=" + idTipoEstancia + ", nombreTipoEstancia="
				+ nombreTipoEstancia + ", tipoEstancia=" + tipoEstancia + ", numPuerta=" + puerta + ", numPlanta="
				+ planta + ", capacidadMaxHabitantes=" + plazas + ", metrosCuadrados="
				+ superficie + ", nombre=" + nombre + ", miniBar=" + minibar + ", aireAcondicionado="
				+ aireacondicionado + ", parking=" + parking + ", jacuzzi=" + jacuzzi + ", disponible=" + disponible
				+ ", listaComplementosExtras=" + complementos + "]";
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
