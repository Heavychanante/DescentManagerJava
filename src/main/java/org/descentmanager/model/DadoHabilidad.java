package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.descentmanager.model.pk.DadoHabilidadPk;

/**
 * Entidad que representa la tabla DadoHabilidad de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "dado_habilidad")
public class DadoHabilidad {

	// ATRIBUTOS //

	@EmbeddedId
	@AttributeOverrides( {
		@AttributeOverride(name = "dadoId", column = @Column(name = "dado_id")),  
		@AttributeOverride(name = "habilidadId", column = @Column(name = "habilidad_id")),  
	})  
	private DadoHabilidadPk id;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public DadoHabilidad() {
		super();
	}

	// M�TODOS //

	public Timestamp getCreacion() {
		return creacion;
	}

	public DadoHabilidadPk getId() {
		return id;
	}

	public void setId(DadoHabilidadPk id) {
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
