package org.descentmanager.repository.projection;

import java.sql.Timestamp;

import org.descentmanager.model.Clase;
import org.descentmanager.model.Jugador;
import org.descentmanager.model.Partida;
import org.descentmanager.model.Personaje;
import org.descentmanager.model.Rol;
import org.descentmanager.model.Usuario;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "jugadorProjection", types = { Jugador.class })
public interface JugadorProjection {

	Integer getId();
	Usuario getUsuario();
	Rol getRol();
	Personaje getPersonaje();
	Clase getClase();
	Partida getPartida();
	String getAlias();
	Integer getVida();
	Integer getAguante();
	Integer getOro();
	Integer getExperiencia();
	Boolean getProeza();
	Boolean getEnvenenado();
	Boolean getEnfermo();
	Boolean getAturdido();
	Boolean getInmovil();
	Timestamp getCreacion();
	Timestamp getModificacion();

}
