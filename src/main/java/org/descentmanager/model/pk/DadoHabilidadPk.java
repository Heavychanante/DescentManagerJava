package org.descentmanager.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que representa la clave primaria compuesta de la tabla DadoHabilidad
 * 
 * @author Hugo
 * 
 */
@Embeddable
public class DadoHabilidadPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador del dado */
	@Column(name = "dado_id")
	private Integer dadoId;

	/** Identificador de la habilidad */
	@Column(name = "habilidad_id")
	private Integer habilidadId;

	public DadoHabilidadPk() {
		super();
	}

	public DadoHabilidadPk(Integer dadoId, Integer habilidadId) {
		this.dadoId = dadoId;
		this.habilidadId = habilidadId;
	}

	public Integer getDadoId() {
		return dadoId;
	}

	public void setDadoId(Integer dadoId) {
		this.dadoId = dadoId;
	}

	public Integer getHabilidadId() {
		return habilidadId;
	}

	public void setHabilidadId(Integer habilidadId) {
		this.habilidadId = habilidadId;
	}

	@Override
	public String toString() {
		return dadoId.toString() + "-" + habilidadId.toString();
	}
}