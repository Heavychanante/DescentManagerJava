package org.descentmanager.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que representa la clave primaria compuesta de la tabla Campa�aPartida
 * 
 * @author Hugo
 * 
 */
@Embeddable
public class CampaniaPartidaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador de la campa�a */
	@Column(name = "campania_id")
	private Integer campaniaId;

	/** Identificador de la partida */
	@Column(name = "partida_id")
	private Integer partidaId;

	public CampaniaPartidaPk() {
		super();
	}

	public CampaniaPartidaPk(Integer campaniaId, Integer partidaId) {
		this.campaniaId = campaniaId;
		this.partidaId = partidaId;
	}

	public Integer getCampaniaId() {
		return campaniaId;
	}

	public void setCampaniaId(Integer campaniaId) {
		this.campaniaId = campaniaId;
	}

	public Integer getPartidaId() {
		return partidaId;
	}

	public void setPartidaId(Integer partidaId) {
		this.partidaId = partidaId;
	}

	@Override
	public String toString() {
		return campaniaId.toString() + "-" + partidaId.toString();
	}
}