package org.descentmanager.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que representa la clave primaria compuesta de la tabla DadoObjeto
 * 
 * @author Hugo
 * 
 */
@Embeddable
public class DadoObjetoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador del dado */
	@Column(name = "dado_id")
	private Integer dadoId;

	/** Identificador del objeto */
	@Column(name = "objeto_id")
	private Integer objetoId;

	public DadoObjetoPk() {
		super();
	}

	public DadoObjetoPk(Integer dadoId, Integer objetoId) {
		this.dadoId = dadoId;
		this.objetoId = objetoId;
	}

	public Integer getDadoId() {
		return dadoId;
	}

	public void setDadoId(Integer dadoId) {
		this.dadoId = dadoId;
	}

	public Integer getObjetoId() {
		return objetoId;
	}

	public void setObjetoId(Integer objetoId) {
		this.objetoId = objetoId;
	}

}