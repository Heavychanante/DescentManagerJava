package org.descentmanager.repository;

import org.descentmanager.model.Partida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "partidas", path = "partidas")
public interface PartidaRepository extends PagingAndSortingRepository<Partida, Integer> {

	/**
	 * Método que devuelve el listado de partidas pertenecientes a un jugador
	 * @return Listado de partidas
	 */
	@RestResource(path = "findByUsuarioOrderByCreacionDesc", rel = "findByUsuarioOrderByCreacionDesc")
	Page<Partida> findByUsuarioIdOrderByCreacionDesc(@Param("usuarioId") Integer usuarioId, Pageable pageable);
}