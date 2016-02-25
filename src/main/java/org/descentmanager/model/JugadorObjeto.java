package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.descentmanager.model.pk.JugadorObjetoPk;

/**
 * Entidad que representa la tabla JugadorObjeto de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "jugador_objeto")
public class JugadorObjeto {

	// ATRIBUTOS //

	@EmbeddedId
	@AttributeOverrides( {
		@AttributeOverride(name = "jugadorId", column = @Column(name = "jugador_id")),  
		@AttributeOverride(name = "objetoId", column = @Column(name = "objeto_id")),  
	})  
	private JugadorObjetoPk id;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public JugadorObjeto() {
		super();
	}

	// M�TODOS //

	public Timestamp getCreacion() {
		return creacion;
	}

	public JugadorObjetoPk getId() {
		return id;
	}

	public void setId(JugadorObjetoPk id) {
		this.id = id;
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
