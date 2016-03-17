package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad que representa la tabla Aventura de la base de datos
 * 
 * @author Hugo
 *
 */
@Entity
@Table(name = "aventura")
public class Aventura {

	// ATRIBUTOS //

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;
}
