package org.descentmanager.repository.projection;

import java.sql.Timestamp;

import org.descentmanager.model.AventuraPartida;
import org.descentmanager.model.pk.AventuraPartidaPk;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "aventuraPartidaProjection", types = { AventuraPartida.class })
public interface AventuraPartidaProjection {

	Timestamp getCreacion();
	AventuraPartidaPk getId();
	Timestamp getModificacion();

}
