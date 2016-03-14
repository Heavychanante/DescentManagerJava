package org.descentmanager.repository;

import java.util.List;

import org.descentmanager.model.JugadorHabilidad;
import org.descentmanager.model.pk.JugadorHabilidadPk;
import org.descentmanager.repository.projection.JugadorHabilidadProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "jugadorHabilidad", path = "jugadorHabilidad", excerptProjection = JugadorHabilidadProjection.class)
public interface JugadorHabilidadRepository extends PagingAndSortingRepository<JugadorHabilidad, JugadorHabilidadPk> {

	/**
	 * Método que devuelve el listado de habilidades pertenecientes a un jugador
	 * @param jugadorId Identificador de jugador
	 * @param pageable Paginable
	 * @return Listado de habilidades que pertenecen al jugador
	 */
	@RestResource(path = "findByJugador", rel = "findByJugador")
	List<JugadorHabilidad> findByIdJugadorId(@Param("jugadorId") Integer jugadorId);

	/**
	 * Método que devuelve el listado de objetos asignables (no pertenecientes) a un jugador
	 * @param jugadorId Identificador de jugador
	 * @param pageable Paginable
	 * @return Listado de objetos asignables al jugador
	 */
	@RestResource(path = "findByNotJugador", rel = "findByNotJugador")
	List<JugadorHabilidad> findByIdJugadorIdIsNot(@Param("jugadorId") Integer jugadorId);
}
