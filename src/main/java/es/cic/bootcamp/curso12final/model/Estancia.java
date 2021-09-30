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
	
	private String ref;
	
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


	public Estancia(Long id, TipoEstancia tipoEstancia, int puerta, int planta, int plazas, int superficie,
			String nombre, boolean minibar, boolean aireacondicionado, boolean parking, boolean jacuzzi,
			boolean disponible, String complementos) {
		super();
		this.id = id;
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

	
	public String getRef() {
		return ref;
	}



	public void setRef(String ref) {
		this.ref = ref;
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
		return "Estancia [id=" + id + ", tipoEstancia=" + tipoEstancia + ", puerta=" + puerta + ", planta=" + planta
				+ ", plazas=" + plazas + ", superficie=" + superficie + ", ref=" + ref + ", nombre=" + nombre
				+ ", minibar=" + minibar + ", aireacondicionado=" + aireacondicionado + ", parking=" + parking
				+ ", jacuzzi=" + jacuzzi + ", disponible=" + disponible + ", complementos=" + complementos + "]";
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
