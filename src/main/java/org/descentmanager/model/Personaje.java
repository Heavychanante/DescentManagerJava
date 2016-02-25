package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad que representa la tabla Personaje de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "personaje")
public class Personaje {

	// ATRIBUTOS //

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "capacidad", nullable = false)
	private String capacidad;

	@Column(name = "velocidad", nullable = false)
	private Integer velocidad;

	@Column(name = "vida", nullable = false)
	private Integer vida;

	@Column(name = "aguante", nullable = false)
	private Integer aguante;

	@Column(name = "defensa", nullable = false)
	private Integer defensa;

	@Column(name = "fuerza", nullable = false)
	private Integer fuerza;

	@Column(name = "conocimiento", nullable = false)
	private Integer conocimiento;

	@Column(name = "voluntad", nullable = false)
	private Integer voluntad;

	@Column(name = "percepcion", nullable = false)
	private Integer percepcion;

	@Column(name = "proeza", nullable = false)
	private String proeza;

	@ManyToOne
	@JoinColumn(name = "arquetipo_id")
	private Arquetipo arquetipo;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public Personaje() {
		super();
	}

	public Personaje(String nombre, String capacidad, Integer velocidad, Integer vida, Integer aguante,
					 Integer defensa, Integer fuerza, Integer conocimiento, Integer voluntad, Integer percepcion,
					 String proeza) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.velocidad = velocidad;
		this.vida = vida;
		this.aguante = aguante;
		this.defensa = defensa;
		this.fuerza = fuerza;
		this.conocimiento = conocimiento;
		this.voluntad = voluntad;
		this.percepcion = percepcion;
		this.proeza = proeza;
	}

	// M�TODOS //

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public Integer getAguante() {
		return aguante;
	}

	public void setAguante(Integer aguante) {
		this.aguante = aguante;
	}

	public Integer getDefensa() {
		return defensa;
	}

	public void setDefensa(Integer defensa) {
		this.defensa = defensa;
	}

	public Integer getFuerza() {
		return fuerza;
	}

	public void setFuerza(Integer fuerza) {
		this.fuerza = fuerza;
	}

	public Integer getConocimiento() {
		return conocimiento;
	}

	public void setConocimiento(Integer conocimiento) {
		this.conocimiento = conocimiento;
	}

	public Integer getVoluntad() {
		return voluntad;
	}

	public void setVoluntad(Integer voluntad) {
		this.voluntad = voluntad;
	}

	public Integer getPercepcion() {
		return percepcion;
	}

	public void setPercepcion(Integer percepcion) {
		this.percepcion = percepcion;
	}

	public String getProeza() {
		return proeza;
	}

	public void setProeza(String proeza) {
		this.proeza = proeza;
	}

	public Arquetipo getArquetipo() {
		return arquetipo;
	}

	public void setArquetipo(Arquetipo arquetipo) {
		this.arquetipo = arquetipo;
	}

	public Timestamp getCreacion() {
		return creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public Timestamp getModificacion() {
		return modificacion;
	}

	public void setModificacion(Timestamp modificacion) {
		this.modificacion = modificacion;
	}
}
