package org.descentmanager.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que representa la clave primaria compuesta de la tabla JugadorObjeto
 * 
 * @author Hugo
 * 
 */
@Embeddable
public class JugadorObjetoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador del jugador */
	@Column(name = "jugador_id")
	private Integer jugadorId;

	/** Identificador del objeto */
	@Column(name = "objeto_id")
	private Integer objetoId;

	public JugadorObjetoPk() {
		super();
	}

	public JugadorObjetoPk(Integer jugadorId, Integer objetoId) {
		this.jugadorId = jugadorId;
		this.objetoId = objetoId;
	}

	public Integer getJugadorId() {
		return jugadorId;
	}

	public void setJugadorId(Integer jugadorId) {
		this.jugadorId = jugadorId;
	}

	public Integer getObjetoId() {
		return objetoId;
	}

	public void setObjetoId(Integer objetoId) {
		this.objetoId = objetoId;
	}

}