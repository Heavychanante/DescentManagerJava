package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.descentmanager.model.pk.JugadorHabilidadPk;

/**
 * Entidad que representa la tabla JugadorHabilidad de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "jugador_habilidad")
public class JugadorHabilidad {

	// ATRIBUTOS //

	@EmbeddedId
	@AttributeOverrides( {
		@AttributeOverride(name = "jugadorId", column = @Column(name = "jugador_id")),  
		@AttributeOverride(name = "habilidadId", column = @Column(name = "habilidad_id")),  
	})  
	private JugadorHabilidadPk id;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public JugadorHabilidad() {
		super();
	}

	// M�TODOS //

	public Timestamp getCreacion() {
		return creacion;
	}

	public JugadorHabilidadPk getId() {
		return id;
	}

	public void setId(JugadorHabilidadPk id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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
