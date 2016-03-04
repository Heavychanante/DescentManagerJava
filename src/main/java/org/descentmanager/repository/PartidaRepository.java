package org.descentmanager.repository;

import org.descentmanager.model.Partida;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "partidas", path = "partidas")
public interface PartidaRepository extends PagingAndSortingRepository<Partida, Integer> {

}