package org.descentmanager.repository.projection;

import java.sql.Timestamp;

import org.descentmanager.model.JugadorObjeto;
import org.descentmanager.model.pk.JugadorObjetoPk;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "jugadorObjetoProjection", types = { JugadorObjeto.class })
public interface JugadorObjetoProjection {

	Timestamp getCreacion();
	JugadorObjetoPk getId();
	Timestamp getModificacion();

}
