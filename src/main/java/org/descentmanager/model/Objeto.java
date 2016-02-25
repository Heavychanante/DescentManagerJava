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

import org.hibernate.annotations.Type;

/**
 * Entidad que representa la tabla Objeto de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "objeto")
public class Objeto {

	// ATRIBUTOS //

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "tipo", length = 100)
	private String tipo;

	@Column(name = "precio", nullable = false)
	private Integer precio = 0;

	@Column(name = "descripcion", nullable = false, length = 1000)
	private String descripcion;

	@Column(name = "manos", nullable = false)
	private Integer manos = 1;

	@Column(name = "a_distancia", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean aDistancia;

	@ManyToOne
	@JoinColumn(name = "fichero_id")
	private Fichero fichero;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public Objeto() {
		super();
	}

	public Objeto(String nombre, String tipo, Integer precio, String descripcion, Integer manos, Boolean aDistancia) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.manos = manos;
		this.aDistancia = aDistancia;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getManos() {
		return manos;
	}

	public void setManos(Integer manos) {
		this.manos = manos;
	}

	public Boolean getaDistancia() {
		return aDistancia;
	}

	public void setaDistancia(Boolean aDistancia) {
		this.aDistancia = aDistancia;
	}

	public Fichero getFichero() {
		return fichero;
	}

	public void setFichero(Fichero fichero) {
		this.fichero = fichero;
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
