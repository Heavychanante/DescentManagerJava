package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.descentmanager.model.pk.DadoObjetoPk;

/**
 * Entidad que representa la tabla DadoObjeto de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "dado_objeto")
public class DadoObjeto {

	// ATRIBUTOS //

	@EmbeddedId
	@AttributeOverrides( {
		@AttributeOverride(name = "dadoId", column = @Column(name = "dado_id")),  
		@AttributeOverride(name = "objetoId", column = @Column(name = "objeto_id")),  
	})  
	private DadoObjetoPk id;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public DadoObjeto() {
		super();
	}

	// M�TODOS //

	public Timestamp getCreacion() {
		return creacion;
	}

	public DadoObjetoPk getId() {
		return id;
	}

	public void setId(DadoObjetoPk id) {
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
