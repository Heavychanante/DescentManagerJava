package org.descentmanager.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que representa la clave primaria compuesta de la tabla JugadorHabilidad
 * 
 * @author Hugo
 * 
 */
@Embeddable
public class JugadorHabilidadPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador del jugador */
	@Column(name = "jugador_id")
	private Integer jugadorId;

	/** Identificador de la habilidad */
	@Column(name = "habilidad_id")
	private Integer habilidadId;

	public JugadorHabilidadPk() {
		super();
	}

	public JugadorHabilidadPk(Integer jugadorId, Integer habilidadId) {
		this.jugadorId = jugadorId;
		this.habilidadId = habilidadId;
	}

	public Integer getJugadorId() {
		return jugadorId;
	}

	public void setJugadorId(Integer jugadorId) {
		this.jugadorId = jugadorId;
	}

	public Integer getHabilidadId() {
		return habilidadId;
	}

	public void setHabilidadId(Integer habilidadId) {
		this.habilidadId = habilidadId;
	}

	@Override
	public String toString() {
		return jugadorId.toString() + "-" + habilidadId.toString();
	}
}