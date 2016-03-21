package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.descentmanager.model.pk.AventuraPartidaPk;

/**
 * Entidad que representa la tabla AventuraPartida de la base de datos
 * 
 * @author Hugo
 *
 */
@Entity
@Table(name = "aventura_partida")
public class AventuraPartida {

	// ATRIBUTOS //

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "aventuraId", column = @Column(name = "aventura_id")),
			@AttributeOverride(name = "partidaId", column = @Column(name = "partida_id")), })
	private AventuraPartidaPk id;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public AventuraPartida() {
			super();
		}

	// MÉTODOS

	public AventuraPartidaPk getId() {
		return id;
	}

	public void setId(AventuraPartidaPk id) {
		this.id = id;
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
