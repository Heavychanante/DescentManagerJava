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
 * Entidad que representa la tabla Habilidad de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "habilidad")
public class Habilidad {

	// ATRIBUTOS //

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "descripcion", nullable = false, length = 255)
	private String descripcion;

	@Column(name = "penalizacion", nullable = false)
	private Integer penalizacion = 0;

	@Column(name = "coste_experiencia", nullable = false)
	private Integer costeExperiencia = 0;

	@ManyToOne
	@JoinColumn(name = "clase_id")
	private Clase clase;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public Habilidad() {
		super();
	}

	public Habilidad(String nombre, String descripcion, Integer penalizacion, Integer costeExperiencia) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.penalizacion = penalizacion;
		this.costeExperiencia = costeExperiencia;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(Integer penalizacion) {
		this.penalizacion = penalizacion;
	}

	public Integer getCosteExperiencia() {
		return costeExperiencia;
	}

	public void setCosteExperiencia(Integer costeExperiencia) {
		this.costeExperiencia = costeExperiencia;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
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
