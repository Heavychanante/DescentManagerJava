package org.descentmanager.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que representa la clave primaria compuesta de la tabla AventuraPartida
 * 
 * @author Hugo
 * 
 */
@Embeddable
public class AventuraPartidaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador de la aventura */
	@Column(name = "aventura_id")
	private Integer aventuraId;

	/** Identificador de la partida */
	@Column(name = "partida_id")
	private Integer partidaId;

	public AventuraPartidaPk() {
		super();
	}

	public AventuraPartidaPk(Integer aventuraId, Integer partidaId) {
		this.aventuraId = aventuraId;
		this.partidaId = partidaId;
	}

	public Integer getAventuraId() {
		return aventuraId;
	}

	public void setAventuraId(Integer aventuraId) {
		this.aventuraId = aventuraId;
	}

	public Integer getPartidaId() {
		return partidaId;
	}

	public void setPartidaId(Integer partidaId) {
		this.partidaId = partidaId;
	}

	@Override
	public String toString() {
		return aventuraId.toString() + "-" + partidaId.toString();
	}
}