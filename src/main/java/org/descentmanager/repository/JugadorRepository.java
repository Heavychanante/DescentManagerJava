package org.descentmanager.repository;

import org.descentmanager.model.Jugador;
import org.descentmanager.repository.projection.JugadorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "jugadores", path = "jugadores", excerptProjection = JugadorProjection.class)
public interface JugadorRepository extends PagingAndSortingRepository<Jugador, Integer> {

	@RestResource(path = "findByPartida", rel = "findByPartida")
	Page<Jugador> findByPartidaId(@Param("partidaId") Integer partidaId, Pageable pageable);
}