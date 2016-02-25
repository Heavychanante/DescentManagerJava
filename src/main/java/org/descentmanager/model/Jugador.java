package org.descentmanager.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * Entidad que representa la tabla Jugador de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "jugador")
public class Jugador {

	// ATRIBUTOS //

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "personaje_id")
	private Personaje personaje;

	@ManyToOne
	@JoinColumn(name = "clase_id")
	private Clase clase;

	@ManyToOne
	@JoinColumn(name = "partida_id")
	private Partida partida;

	@Column(name = "alias", nullable = false)
	private String alias;

	@Column(name = "vida", nullable = false)
	private Integer vida;

	@Column(name = "aguante", nullable = false)
	private Integer aguante;

	@Column(name = "oro", nullable = false)
	private Integer oro;

	@Column(name = "experiencia", nullable = false)
	private Integer experiencia;

	@Column(name = "proeza", nullable = false, columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean proeza;

	@Column(name = "envenenado", nullable = false, columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean envenenado;

	@Column(name = "enfermo", nullable = false, columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enfermo;

	@Column(name = "aturdido", nullable = false, columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean aturdido;

	@Column(name = "inmovil", nullable = false, columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean inmovil;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public Jugador() {
		super();
	}

	// M�TODOS //

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public Integer getAguante() {
		return aguante;
	}

	public void setAguante(Integer aguante) {
		this.aguante = aguante;
	}

	public Integer getOro() {
		return oro;
	}

	public void setOro(Integer oro) {
		this.oro = oro;
	}

	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	public Boolean getProeza() {
		return proeza;
	}

	public void setProeza(Boolean proeza) {
		this.proeza = proeza;
	}

	public Boolean getEnvenenado() {
		return envenenado;
	}

	public void setEnvenenado(Boolean envenenado) {
		this.envenenado = envenenado;
	}

	public Boolean getEnfermo() {
		return enfermo;
	}

	public void setEnfermo(Boolean enfermo) {
		this.enfermo = enfermo;
	}

	public Boolean getAturdido() {
		return aturdido;
	}

	public void setAturdido(Boolean aturdido) {
		this.aturdido = aturdido;
	}

	public Boolean getInmovil() {
		return inmovil;
	}

	public void setInmovil(Boolean inmovil) {
		this.inmovil = inmovil;
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
