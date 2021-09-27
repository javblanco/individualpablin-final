package es.cic.bootcamp.curso12final.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Estancia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private TipoEstancia tipoEstancia;
	
	//Atributos principales
	@NotNull(message = "{!}-->DEBE RELLENAR EL CAMPO DE NUM PUERTA.")
	private int numPuerta ;
	
	@NotNull(message = "{!}-->DEBE RELLENAR EL CAMPO DE NUM PLANTA.")
	private int numPlanta ; 
	
	private String numEstancia ;
	
	@NotNull(message = "{!}-->DEBE RELLENAR EL CAMPO DE CAPACIDAD MÁX HABITANTES.")
	private int capacidadMaxHabitantes;
	
	@NotNull(message = "{!}-->DEBE RELLENAR EL CAMPO DE METROS CUADRADOS.")
	private int metrosCuadrados;
	
	//Atributo opcional
	private String nombre;
	
	//Complementos de la estancia
	private boolean miniBar;
	private boolean aireAcondicionado;
	private boolean parking;
	private boolean jacuzzi;
	
	//Disponibilidad
	@Column(columnDefinition = "boolean default true")
	private boolean disponible ;
	
	//Lista de campos libres como complementos extras
	private String listaComplementosExtras;
	
	
	public Estancia() {
		super();
	}

	public Estancia(Long id, TipoEstancia tipoEstancia, int numPuerta, int numPlanta, String nombre,
			boolean miniBar, boolean aireAcondicionado, boolean parking, boolean jacuzzi,
			String listaExtras) {
		super();
		this.id = id;
		this.tipoEstancia = tipoEstancia;
		this.numPuerta = numPuerta;
		this.numPlanta = numPlanta;
		this.numEstancia = calculadorNumeroEstancia(numPuerta, numPlanta);
		this.nombre = nombre;
		this.miniBar = miniBar;
		this.aireAcondicionado = aireAcondicionado;
		this.parking = parking;
		this.jacuzzi = jacuzzi;
		this.listaComplementosExtras = listaExtras;
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

	public String getNumEstancia() {
		return numEstancia;
	}

	public void setNumEstancia() {
		this.numEstancia = calculadorNumeroEstancia(this.numPuerta, this.numPlanta);
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

	public String getListaExtras() {
		return listaComplementosExtras;
	}

	public void setListaExtras(String listaExtras) {
		this.listaComplementosExtras = listaExtras;
	}


	@Override
	public String toString() {
		return "Estancia [id=" + id + ", tipoEstancia=" + tipoEstancia + ", numPuerta=" + numPuerta + ", numPlanta="
				+ numPlanta + ", numEstancia=" + numEstancia + ", nombre=" + nombre + ", miniBar=" + miniBar
				+ ", aireAcondicionado=" + aireAcondicionado + ", parking=" + parking + ", jacuzzi=" + jacuzzi
				+ ", disponible=" + disponible + ", listaExtras=" + listaComplementosExtras + "]";
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
	
	
	
	/**
	 * Pequeño metodo que aplica una logica sencilla de conversión. 
	 * Convierte dos int recibidos por parametros, en un string final.
	 * 
	 * Ejemplo:  numPuerta=603 numPlanta=6 -->  numEstancia "6-603"
	 * 
	 * @param numPuerta
	 * @param numPlanta
	 * @return numEstancia
	 */
	private String calculadorNumeroEstancia(int numPuerta, int numPlanta) {
		
		return String.valueOf(numPlanta) + "-" + String.valueOf(numPuerta);
		
	}
	
}
