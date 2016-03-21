package org.descentmanager.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidad que representa la tabla Clase de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "clase")
public class Clase {

	// ATRIBUTOS //

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "arquetipo_id")
	private Arquetipo arquetipo;

	@OneToMany(mappedBy = "clase")
	private Set<Habilidad> habilidades;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //
	public Clase() {
		super();
	}

	public Clase(String nombre) {
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

	public Set<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Set<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

}
