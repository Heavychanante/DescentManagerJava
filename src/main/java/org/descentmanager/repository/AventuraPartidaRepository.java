package org.descentmanager.repository;

import org.descentmanager.model.AventuraPartida;
import org.descentmanager.model.pk.AventuraPartidaPk;
import org.descentmanager.repository.projection.AventuraPartidaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "aventuraPartida", path = "aventuraPartida", excerptProjection = AventuraPartidaProjection.class)
public interface AventuraPartidaRepository extends PagingAndSortingRepository<AventuraPartida, AventuraPartidaPk> {

	/**
	 * Método que devuelve el listado partidas que utilizan una determinada aventura
	 * @param aventuraId Identificador de aventura
	 * @param pageable Paginable
	 * @return Listado de partidas con aventuraId asignado
	 */
	@RestResource(path = "findByAventura", rel = "findByAventura")
	Page<AventuraPartida> findByIdAventuraId(@Param("aventuraId") Integer aventuraId, Pageable pageable);

	/**
	 * Método que devuelve el listado de aventuras que pertenecen a una partida determinada
	 * @param partidaId Identificador de partida
	 * @param pageable Paginable
	 * @return Listado de aventuras asignadas a una partida
	 */
	@RestResource(path = "findByPartida", rel = "findByPartida")
	Page<AventuraPartida> findByIdPartidaId(@Param("partidaId") Integer partidaId, Pageable pageable);
}