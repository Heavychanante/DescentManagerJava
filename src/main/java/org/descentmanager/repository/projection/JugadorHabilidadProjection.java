package org.descentmanager.repository.projection;

import java.sql.Timestamp;

import org.descentmanager.model.JugadorHabilidad;
import org.descentmanager.model.pk.JugadorHabilidadPk;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "jugadorHabilidadProjection", types = { JugadorHabilidad.class })
public interface JugadorHabilidadProjection {

	Timestamp getCreacion();
	JugadorHabilidadPk getId();
	Timestamp getModificacion();
	Integer getCantidad();

}
