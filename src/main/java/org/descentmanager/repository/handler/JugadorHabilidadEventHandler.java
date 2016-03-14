package org.descentmanager.repository.handler;

import org.descentmanager.model.JugadorHabilidad;
import org.descentmanager.repository.JugadorHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(JugadorHabilidad.class)
public class JugadorHabilidadEventHandler {

	@Autowired
	private JugadorHabilidadRepository jugadorHabilidadRepository;

	@HandleBeforeCreate
	public void handleJugadorHabilidadSave(JugadorHabilidad jugadorHabilidad) {
		JugadorHabilidad existe = jugadorHabilidadRepository.findOne(jugadorHabilidad.getId());
		if (existe != null) {
			Integer cantidad = existe.getCantidad();
			if (cantidad == null) {
				cantidad = 0;
			}
			jugadorHabilidad.setCantidad(cantidad + 1);
		} else {
			jugadorHabilidad.setCantidad(1);
		}
	}

}
