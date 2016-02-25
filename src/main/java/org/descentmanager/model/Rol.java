package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad que representa la tabla Rol de la base de datos
 * 
 * @author Hugo
 *
 */
@Entity
@Table(name = "rol")
public class Rol {

	// ATRIBUTOS //

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public Rol() {
		super();
	}

	public Rol(String nombre) {
		this.nombre = nombre;
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
