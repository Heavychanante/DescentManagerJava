package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.descentmanager.model.pk.CampaniaPartidaPk;

/**
 * Entidad que representa la tabla CampaniaPartida de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "campania_partida")
public class CampaniaPartida {

	// ATRIBUTOS //

	@EmbeddedId
	@AttributeOverrides( {
		@AttributeOverride(name = "campaniaId", column = @Column(name = "campania_id")),  
		@AttributeOverride(name = "partidaId", column = @Column(name = "partida_id")),  
	})  
	private CampaniaPartidaPk id;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public CampaniaPartida() {
		super();
	}

	// M�TODOS //

	public Timestamp getCreacion() {
		return creacion;
	}

	public CampaniaPartidaPk getId() {
		return id;
	}

	public void setId(CampaniaPartidaPk id) {
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
