package es.cic.bootcamp.curso12final.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estancia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private TipoEstancia tipoEstancia;
	
	//Atributos principales
	private int puerta ;
	private int planta ; 

	private int plazas;
	
	private int superficie;
	
	private String nombre;
	
	//Complementos de la estancia
	private boolean minibar;
	private boolean aireacondicionado;
	private boolean parking;
	private boolean jacuzzi;
	
	//Disponibilidad
	@Column(columnDefinition = "boolean default true")
	private boolean disponible ;
	
	//Lista de campos libres como complementos extras
	private String complementos;
	
	
	public Estancia() {
		super();
	}

	public Estancia(Long id, TipoEstancia tipoEstancia, int numPuerta, int numPlanta, String nombre,
			boolean miniBar, boolean aireAcondicionado, boolean parking, boolean jacuzzi,
			String listaExtras) {
		super();
		this.id = id;
		this.tipoEstancia = tipoEstancia;
		this.puerta = numPuerta;
		this.planta = numPlanta;
		this.nombre = nombre;
		this.minibar = miniBar;
		this.aireacondicionado = aireAcondicionado;
		this.parking = parking;
		this.jacuzzi = jacuzzi;
		this.complementos = listaExtras;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getListaExtras() {
		return complementos;
	}

	public void setListaExtras(String listaExtras) {
		this.complementos = listaExtras;
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

	public String getListaComplementosExtras() {
		return complementos;
	}

	public void setListaComplementosExtras(String listaComplementosExtras) {
		this.complementos = listaComplementosExtras;
	}

	
	
	@Override
	public String toString() {
		return "Estancia [id=" + id + ", tipoEstancia=" + tipoEstancia + ", numPuerta=" + puerta + ", numPlanta="
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
        Estancia other = (Estancia) obj;
        return Objects.equals(id, other.id) ;
    }
	
}
