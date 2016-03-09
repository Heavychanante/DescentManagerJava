package org.descentmanager.repository.projection;

import java.sql.Timestamp;

import org.descentmanager.model.DadoHabilidad;
import org.descentmanager.model.pk.DadoHabilidadPk;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "dadoHabilidadProjection", types = { DadoHabilidad.class })
public interface DadoHabilidadProjection {

	Timestamp getCreacion();
	DadoHabilidadPk getId();
	Timestamp getModificacion();

}
